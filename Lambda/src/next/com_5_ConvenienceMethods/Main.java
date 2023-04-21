package next.com_5_ConvenienceMethods;

import java.util.function.Function;

// Chaining Lambda - aggregate functions
public class Main {
  public static void main(String[] args) {

    String name = "gautam";
    Function<String, String> uCase = String::toUpperCase;
    System.out.println(uCase.apply(name));

    Function<String, String> lastName = s -> s.concat(" Verma");
    Function<String, String> uCaseLastName = uCase.andThen(lastName);
    System.out.println(uCaseLastName.apply(name));
  }
}
