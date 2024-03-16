package a2_FunctionalInterface;

@FunctionalInterface
interface functionalInterface {
  int operation(int a, int b);
  //  int ops(); - Can't define other method
}

public class Main {
  private static int operate(int a, int b, functionalInterface fiObj) {
    return fiObj.operation(a, b);
  }

  public static void main(String[] args) {
    functionalInterface addOps = (int x, int y) -> x + y;
    functionalInterface multiOps = (int x, int y) -> x * y;

    System.out.println("Addition : " + Main.operate(2, 6, addOps));
    System.out.println("Multiplication : " + Main.operate(2, 6, multiOps));
  }
}
