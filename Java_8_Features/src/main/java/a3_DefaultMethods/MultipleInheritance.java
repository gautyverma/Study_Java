package a3_DefaultMethods;

interface left {
  default void display() {
    System.out.println("Default Method - left");
  }
}

interface right {
  default void display() {
    System.out.println("Default Method - right");
  }
}

public class MultipleInheritance implements left, right {
  public static void main(String[] args) {
    MultipleInheritance obj = new MultipleInheritance();
    obj.display();
  }

  @Override
  public void display() {
    System.out.println("Main override");
    left.super.display();
    right.super.display();
  }
}
