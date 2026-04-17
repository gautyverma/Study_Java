package Year_2026.a1_ThreadsBasic;


public class a4_YieldJoinSleepThread {
  public static void main(String[] args) {
    Thread t1 = new Thread(new Task(), "HIGH");
    Thread t2 = new Thread(new Task(), "LOW");
    Thread t3 = new Thread(new Task(), "NORMAL");

    t1.setPriority(Thread.MAX_PRIORITY);
    t2.setPriority(Thread.MIN_PRIORITY);

    t1.start();
    t3.start();

    try {
      // 🔹 join: main waits for t1 to finish
      System.out.println("Main thread waiting for HIGH to finish...");
      t1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // t2 starts only after t1 completes
    t2.start();

    System.out.println(" ~~~ Main thread finished ~~~");
  }

  static class Task implements Runnable {
    @Override
    public void run() {
      for (int i = 1; i <= 3; i++) {
        System.out.println(
            Thread.currentThread().getName()
                + " | Priority: "
                + Thread.currentThread().getPriority()
                + " | Count: "
                + i);
        // 🔹 yield at i = 2
        if (i == 2) {
          System.out.println(
              " ---- " + Thread.currentThread().getName() + " is yielding..." + " ---- ");
          Thread.yield();
        }
        // 🔹 sleep at i = 3
        if (i == 3) {
          try {
            System.out.println("---- " + Thread.currentThread().getName() + " is sleeping ----");
            Thread.sleep(500); // 500 ms
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
