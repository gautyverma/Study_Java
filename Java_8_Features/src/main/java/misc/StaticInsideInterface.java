package misc;

interface staticInside {
  public static void display() {
    System.out.println("Static method inside interface");
  }
}

public class StaticInsideInterface implements staticInside {
  public static void main(String[] args) {
    staticInside.display();
  }
}
