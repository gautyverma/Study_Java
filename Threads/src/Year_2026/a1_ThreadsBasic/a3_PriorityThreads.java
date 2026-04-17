package Year_2026.a1_ThreadsBasic;

/*

Expected output:

Thread Name: HighThread || Thread Priority: 10
Thread Name: NormalThread || Thread Priority: 5
Thread Name: LowThread || Thread Priority: 1


Create 3 Runnable objects → each holds a name & priority value
  HighThread (priority: 10)
  LowThread (priority: 1)
  NormalThread (priority: 5)

Wrap Runnables in Thread objects → t1, t2, t3
Start all threads → t1.start(), t2.start(), t3.start()
Each thread executes run() →
  Sets thread name via setName()
  Sets thread priority via setPriority()
  Prints name & priority

Output: 3 lines showing each thread's name and priority (execution order may vary due to thread scheduling)

Key Concept: Thread priorities hint to the JVM scheduler which thread should run first, but execution order isn't guaranteed.
*/

public class a3_PriorityThreads {
  public static void main(String[] args) {

    // Create Runnable objects
    MyRunnable r1 = new MyRunnable("HighThread", Thread.MAX_PRIORITY);
    MyRunnable r2 = new MyRunnable("LowThread", Thread.MIN_PRIORITY);
    MyRunnable r3 = new MyRunnable("NormalThread", Thread.NORM_PRIORITY);

    // Wrap them in Thread
    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    Thread t3 = new Thread(r3);

    // Start threads
    t1.start();
    t2.start();
    t3.start();
  }

  static class MyRunnable implements Runnable {

    private String name;
    private int priority;

    public MyRunnable(String name, int priority) {
      this.name = name;
      this.priority = priority;
    }

    @Override
    public void run() {
      Thread.currentThread().setName(name);
      Thread.currentThread().setPriority(priority);

      System.out.println(
          "Thread Name: "
              + Thread.currentThread().getName()
              + " || Thread Priority: "
              + Thread.currentThread().getPriority());
    }
  }
}
