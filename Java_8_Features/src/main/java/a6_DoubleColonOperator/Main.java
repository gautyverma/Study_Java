package a6_DoubleColonOperator;

public class Main {
  public static void m1() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Child Thread - m1");
    }
  }

  public static void main(String[] args) {
    Runnable r1 =
        () -> {
          for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread - Lambda");
          }
        };
    Thread t1 = new Thread(r1);
    t1.start();
    for (int i = 0; i < 5; i++) {
      System.out.println("Main Thread - 1");
    }
    System.out.println("--- Method reference using (::) ---");
    Runnable r2 = Main::m1;
    Thread t2 = new Thread(r2);
    t2.start();
    for (int i = 0; i < 5; i++) {
      System.out.println("Main Thread - 2");
    }
    // -------------------------------------------------------------------------
    System.out.println("---- Constructor Reference using lambda----");
    Inter objInter1 = s -> new Child(s);
    objInter1.display("Lambda expression");

    System.out.println("---- Constructor Reference ----");
    Inter objInter2 = Child::new;
    objInter2.display("constructor reference");

    System.out.println("---- Method Reference ----");
    Child childObj = new Child();
    Inter objInter3 = childObj::display;
    objInter3.display(" method reference");
  }
}

interface Inter {
  void display(String str);
}

class Child implements Inter {
  private String str;

  public Child() {}

  public Child(String str) {
    this.str = str;
    System.out.println("Constructor Executed: " + str);
  }

  @Override
  public void display(String str) {
    System.out.println("Method Executed : " + str);
  }
}
