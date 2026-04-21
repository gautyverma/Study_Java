package Year_2026.a1_ThreadsBasic;

public class a5_SynchornizationThreads {

  public static void main(String[] args) {

    Display d1 = new Display();
    Display d2 = new Display();

    // Same object (instance-level lock works)
    Thread t1 = new MyThread(d1, "Dhoni");
    Thread t2 = new MyThread(d1, "Virat");

    // Different object (only class-level lock works)
    Thread t3 = new MyThread(d2, "Rohit");

    t1.start();
    t2.start();
    t3.start();
  }

  static class MyThread extends Thread {
    Display display;
    String name;

    public MyThread(Display display, String name) {
      this.display = display;
      this.name = name;
    }

    @Override
    public void run() {

      display.instanceMethod(name); // instance lock
      display.blockMethod(name); // synchronized block (this)
      display.classMethod(name); // class lock
      display.classBlockMethod(name); // class-level block
    }
  }

  static class Display {

    // 🔹 1. Instance-level synchronization
    public synchronized void instanceMethod(String name) {
      System.out.println("Instance Method START: " + name);
      for (int i = 0; i < 3; i++) {
        System.out.println("Hello " + name);
      }
      System.out.println("Instance Method END: " + name);
    }

    // 🔹 2. Synchronized block (instance lock)
    public void blockMethod(String name) {
      synchronized (this) {
        System.out.println("Block Method START: " + name);
        for (int i = 0; i < 3; i++) {
          System.out.println("Hi " + name);
        }
        System.out.println("Block Method END: " + name);
      }
    }

    // 🔹 3. Class-level synchronization
    public static synchronized void classMethod(String name) {
      System.out.println("Class Method START: " + name);
      for (int i = 0; i < 3; i++) {
        System.out.println("Good Morning " + name);
      }
      System.out.println("Class Method END: " + name);
    }

    // 🔹 4. Class-level synchronized block
    public void classBlockMethod(String name) {
      synchronized (Display.class) {
        System.out.println("Class Block START: " + name);
        for (int i = 0; i < 3; i++) {
          System.out.println("Welcome " + name);
        }
        System.out.println("Class Block END: " + name);
      }
    }
  }
}
