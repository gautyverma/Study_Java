package a1_Lambda.Threads.Anonymous;

public class Main {
  public static void main(String[] args) {

    // With Anonymous Class
    Thread t =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                for (int i = 0; i < 5; i++) {
                  System.out.println("Child Thread - 1");
                }
              }
            });
    t.start();
    for (int i = 0; i < 5; i++) {
      System.out.println("Main Thread - 1");
    }
    System.out.println("---- Without Anonymous Class");
    // Without Anonymous Class
    Thread t2 =
        new Thread(
            () -> {
              for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread - 2");
              }
            });
    t2.start();
    for (int i = 0; i < 5; i++) {
      System.out.println("Main Thread - 2");
    }
  }
}
