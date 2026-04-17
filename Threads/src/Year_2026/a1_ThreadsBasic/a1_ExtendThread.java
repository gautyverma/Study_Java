package Year_2026.a1_ThreadsBasic;

import Year_2026.ThreadColor;

/*
* Output possibility:

Running inside main thread class
Running inside main thread class
Running inside extended thread class
Running inside extended thread class
Running inside main thread class
Running inside main thread class
Running inside extended thread class
Running inside extended thread class
Running inside extended thread class

* */
public class a1_ExtendThread {
  public static void main(String[] args) {
    MyThread thread = new MyThread();
    thread.start();

    for (int i = 0; i < 5; i++) {
      System.out.println(ThreadColor.ANSI_PURPLE + "Running inside main thread class");
    }
    /*
    // No new thread will be created, run() will be executed just like normal method call.
          thread.run();
    */
  }

  static class MyThread extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        System.out.println(ThreadColor.ANSI_BLUE + "Running inside extended thread class");
      }
    }
  }
}
