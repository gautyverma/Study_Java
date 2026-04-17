package Year_2026.a1_ThreadsBasic;

import Year_2026.ThreadColor;

public class a2_ImplementsRunnable {
  public static void main(String[] args) {
    MyRunnable runnable = new MyRunnable();
    Thread thread = new Thread(runnable);
    thread.start();

    for (int i = 0; i < 5; i++) {
      System.out.println(ThreadColor.ANSI_PURPLE + "Running inside main thread class");
    }
  }

  static class MyRunnable implements Runnable {
    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        System.out.println(
            ThreadColor.ANSI_BLUE + "Running inside runnable implemented thread class");
      }
    }
  }
}
