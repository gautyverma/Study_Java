package a3_DefaultMethods;

interface defaultMethod {
  default void display() {
    System.out.println("Default Method");
  }
}

public class Main implements defaultMethod {
  public static void main(String[] args) {
    Main obj = new Main();
    obj.display();
  }
}
