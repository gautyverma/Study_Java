package next.com_3_challenge_1;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
  public static void main(String[] args) {
    // ---------------------------------
    // Challenge 1 - Convert the given code to lambda exp
    // -------------------------------
    System.out.println("Challenge - 1");

    Consumer<String> printTheparts =
        new Consumer<String>() {
          @Override
          public void accept(String s) {
            String[] parts = s.split(" ");
            for (String part : parts) {
              System.out.println(part);
            }
          }
        };

    printTheparts.accept("Hi I am calling the consumer Interface");
    System.out.println("==============================================");

    Consumer<String> printWordsLambda =
        s -> {
          String[] parts = s.split(" ");
          for (String part : parts) {
            System.out.println(part);
          }
        };

    printWordsLambda.accept("Hi I am calling the Lambda Code");
    System.out.println("==============================================");

    Consumer<String> printWordsLambdaConcise =
        s -> {
          String[] parts = s.split(" ");
          Arrays.asList(parts).forEach(s1 -> System.out.println(s1));
        };
    printWordsLambdaConcise.accept("Hi I am calling the Concise Lambda nested Code");
    System.out.println("==============================================");

    // ----------------------------------
    // Challenge 2
    // ----------------------------------
    System.out.println("Challenge - 2");

    System.out.println(everySecondChar("GAUTAM"));
    System.out.println("==============================================");

    // We can also use Unary operator - UnaryOperator<String>
    Function<String, String> everySecondChar1 =
        source -> {
          StringBuilder returnVal = new StringBuilder();
          for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 0) {
              returnVal.append(source.charAt(i));
            }
          }
          return returnVal.toString();
        };
    System.out.println(everySecondChar1.apply("Gautam"));

    // ----------------------------------
    // Challenge -3
    // ----------------------------------
    System.out.println("Challenge - 3");

    // It is printing the odd number which are at index of even places.
    System.out.println(everySecondChar1.apply("1234567890"));
    System.out.println("==============================================");

    // Even Numbers
    Function<String, String> everySecondChar2 =
        source -> {
          StringBuilder returnVal = new StringBuilder();
          for (int i = 0; i < source.length(); i++) {

            if (source.charAt(i) % 2 == 0) {
              returnVal.append(source.charAt(i));
            }
          }
          return returnVal.toString();
        };
    System.out.println(everySecondChar2.apply("1234567890"));
    System.out.println("==============================================");

    // -----------------------------
    // Challenge - 4 & 5
    // ------------------------------
    System.out.println("Challenge - 4 & 5");
    // Challenge - 5 - Call the method we have made in challenge - 4
    System.out.println(everySecondCharLam(everySecondChar2, "1234567890"));
    System.out.println("==============================================");

    // -----------------------------
    // Challenge - 6 (Supplier)
    // -----------------------------
    System.out.println("Challenge - 6");

    String supExp = " I Love Java";
    Supplier<String> supplier = () -> supExp.replaceAll(" ", "");
    System.out.println(supplier.get());
  }

  // Returns only even place char word.
  public static String everySecondChar(String source) {
    StringBuilder returnVal = new StringBuilder();
    for (int i = 0; i < source.length(); i++) {
      if (i % 2 == 0) {
        returnVal.append(source.charAt(i));
      }
    }
    return returnVal.toString();
  }

  // Challenge - 4
  public static String everySecondCharLam(Function<String, String> func, String source) {
    return func.apply(source);
  }
}
