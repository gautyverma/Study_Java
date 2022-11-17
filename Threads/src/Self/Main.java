package Self;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    MyThread myThread_obj = new MyThread();
    Thread thread_obj = new Thread(myThread_obj);
    thread_obj.start();
      for (int i = 0; i < 5; i++) {
//          Thread.yield();
        thread_obj.join();
          System.out.println("Inside - Main");
      }

  }
}

class MyThread implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Inside - Thread");
    }
  }
}
