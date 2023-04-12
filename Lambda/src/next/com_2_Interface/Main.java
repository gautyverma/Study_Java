package next.com_2_Interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class Main {
  public static void main(String[] args) {
    //
    List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));
    for (String s : list) {
      System.out.println(s);
    }
    // For-each using lambda expression
    System.out.println("===============");

    System.out.println("<- For-each using lambda expression -> 1");
    list.forEach(s -> System.out.println(s));

    // For-each using lambda expression
    System.out.println("===============");

    System.out.println("<- For-each using lambda body -> 2");
    list.forEach(
        (var myString) -> {
          char first = myString.charAt(0);
          System.out.println(myString + " means " + first);
        });

    int result = calulator((a, b) -> a + b, 5, 2);
    var result1 = calulator((a, b) -> a / b, 10.0, 2.5);
    var result2 = calulator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "gautam", "verma");
    System.out.println("=======================================");
    int result0 = calulator1((a, b) -> a + b, 5, 2);
    var result01 = calulator1((a, b) -> a / b, 10.0, 2.5);
    var result02 = calulator1((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "gautam", "verma");
    System.out.println("=======================================");
    //
    var coords =
        Arrays.asList(
            new double[] {47.2160, -95.2348},
            new double[] {29.5620, -99.1438},
            new double[] {16.7230, -79.7659});

    coords.forEach(s -> System.out.println(Arrays.toString(s)));

    // Consumer Interface
    BiConsumer<Double, Double> p1 =
        (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

    var firstPoint = coords.get(0);
    procesPoint(firstPoint[0], firstPoint[1], p1);

    System.out.println("=======================================");
    // Lambda exp on Consumer Interface
    coords.forEach(s -> procesPoint(s[0], s[1], p1));

    System.out.println("=======================================");
    // we have defined the nested lambda expression
    coords.forEach(
        s ->
            procesPoint(
                s[0], s[1], (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

    System.out.println("=======================================");
    // Predicate Interface
    list.removeIf(s -> s.equalsIgnoreCase("ALPHA"));
    list.forEach(s -> System.out.println(s));
  }

  // Using the Functional Interface that we have created
  public static <T> T calulator(Operation<T> function, T value1, T value2) {

    T result = function.operate(value1, value2);
    System.out.println("Result of Operation: " + result);
    return result;
  }

  // Using the pre defined interface inside Binary Operator
  public static <T> T calulator1(BinaryOperator<T> function, T value1, T value2) {

    T result = function.apply(value1, value2);
    System.out.println("Result of Operation: " + result);
    return result;
  }

  // Consumer Interface
  public static <T> void procesPoint(T t1, T t2, BiConsumer<T, T> consumer) {
    consumer.accept(t1, t2);
  }
}
