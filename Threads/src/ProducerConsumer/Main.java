package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static ProducerConsumer.Main.EOF;

public class Main {
  public static final String EOF = "EOF";

  public static void main(String[] args) {
    List<String> buffer = new ArrayList<String>();
    ReentrantLock bufferLock = new ReentrantLock();

    // Thread Pool implementation
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
    MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);
    MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);

    /*
      Normal way to do so without thread pool

      new Thread(producer).start();
      new Thread(consumer1).start();
      new Thread(consumer2).start();
    */
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

    // shutdown the executeService otherwise it will not terminate automatically
    executorService.shutdown();
  }
}

class MyProducer implements Runnable {
  private List<String> buffer;
  private String color;

  private ReentrantLock bufferLock;

  public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
    this.buffer = buffer;
    this.color = color;
    this.bufferLock = bufferLock;
  }

  public void run() {
    Random random = new Random();
    String[] nums = {"1", "2", "3", "4", "5"};

    for (String num : nums) {
      try {
        System.out.println(color + "Adding..." + num);
        //        synchronized (buffer) {   --1
        bufferLock.lock();
        try {
          buffer.add(num);
        } finally {
          bufferLock.unlock();
        }

        //        }   --1

        Thread.sleep(1000);

      } catch (InterruptedException e) {
        e.printStackTrace();
        System.out.println("Producer was interrupted");
      }
    }
    System.out.println(color + "Adding EOF and exiting...");
    //    synchronized (buffer) {   --1
    bufferLock.lock();
    try {
      buffer.add("EOF");
    } finally {
      bufferLock.unlock();
    }

    //    }   --1
  }
}

class MyConsumer implements Runnable {
  private List<String> buffer;
  private String color;
  private ReentrantLock bufferLock;

  public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
    this.buffer = buffer;
    this.color = color;
    this.bufferLock = bufferLock;
  }

  public void run() {
    int counter = 0;
    while (true) {

      //      synchronized (buffer) {   --1
      // Approach  - 1
      /*bufferLock.lock();
            try {
              if (buffer.isEmpty()) {
               // bufferLock.unlock();
                continue;
              }
              if (buffer.get(0).equals(EOF)) {
                System.out.println(color + "Exiting");
                //bufferLock.unlock();
                break;
              } else {
                //System.out.println(Thread.currentThread().getName());
                System.out.println(color + "Removed " + buffer.remove(0));
              }
            } finally {
              bufferLock.unlock();
            }
      */
      //      }   --1

      // Approach - 2
      if (bufferLock.tryLock()) {
        try {
          if (buffer.isEmpty()) {
            continue;
          }
          System.out.println(ThreadColor.ANSI_RED + "Counter value:" + counter);
          counter = 0;
          if (buffer.get(0).equals(EOF)) {
            System.out.println(color + "Exiting");
            break;
          } else {
            System.out.println(color + "Removed " + buffer.remove(0));
          }
        } finally {
          bufferLock.unlock();
        }
      } else {
        counter++;
      }
    }
  }
}
