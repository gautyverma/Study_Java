package ArrayBlockingQueue;

import ProducerConsumer.ThreadColor;

import java.util.Random;
import java.util.concurrent.*;

import static ProducerConsumer.Main.EOF;

public class Main {
  public static final String EOF = "EOF";

  public static void main(String[] args) {

    ArrayBlockingQueue buffer = new ArrayBlockingQueue<String>(6);

    // Thread Pool implementation
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLUE);
    MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);
    MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);

    executorService.execute(producer);
    executorService.execute(consumer1);
    executorService.execute(consumer2);

    Future<String> future =
        executorService.submit(
            new Callable<String>() {
              @Override
              public String call() throws Exception {
                System.out.println("Running inside Callable method - Anonymous");
                return "Callable result";
              }
            });
    try {
      System.out.println(future.get());
    } catch (ExecutionException e) {
      System.out.println("ExecutionException");
    } catch (InterruptedException e) {
      System.out.println("InterruptedException");
    }
    executorService.shutdown();
  }
}

class MyProducer implements Runnable {
  private ArrayBlockingQueue<String> buffer;
  private String color;

  public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
    this.buffer = buffer;
    this.color = color;
  }

  public void run() {
    Random random = new Random();
    String[] nums = {"1", "2", "3", "4", "5"};

    for (String num : nums) {
      try {
        System.out.println(color + "Adding..." + num);
        buffer.put(num);
        Thread.sleep(1000);

      } catch (InterruptedException e) {
        e.printStackTrace();
        System.out.println("Producer was interrupted");
      }
    }
    System.out.println(color + "Adding EOF and exiting...");
    try {
      buffer.put("EOF");
    } catch (InterruptedException e) {
      System.out.println("InterruptedException : PRODUCER");
    }
  }
}

class MyConsumer implements Runnable {
  private ArrayBlockingQueue<String> buffer;
  private String color;

  public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
    this.buffer = buffer;
    this.color = color;
  }

  public void run() {
    while (true) {
      synchronized (buffer) {
        try {
          if (buffer.isEmpty()) {
            continue;
          }
          if (buffer.peek().equals(EOF)) {
            System.out.println(color + "Exiting");
            break;
          } else {
            System.out.println(color + "Removed " + buffer.take());
          }
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
