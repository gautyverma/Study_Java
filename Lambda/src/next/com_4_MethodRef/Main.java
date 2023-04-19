package next.com_4_MethodRef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

class PlainOld {
  private static int last_id = 1;
  private int id;

  public PlainOld() {
    id = PlainOld.last_id++;
    System.out.println("Creating a PlainOld Object: id=" + id);
  }
}

public class Main {
  public static void main(String[] args) {
    //
    List<String> list =
        new ArrayList<>(List.of("Anna", "Bob", "Chirag", "Deepak", "Evan", "Fab", "Gauty"));

    // Printing using method referencing
    list.forEach(System.out::println);

    //    calculator((a, b) -> a + b, 6, 8);
    calculator(Integer::sum, 6, 8);

    // Supplier<PlainOld> ref1 = () -> new PlainOld();
    Supplier<PlainOld> ref1 = PlainOld::new;
    // This is Constructor method reference

    PlainOld newPojo = ref1.get();


    System.out.println("---------------------------");
    System.out.println("Getting Array");
    PlainOld[] pojo1 = seedArray(PlainOld::new, 10);
    System.out.println("---------------------------");

    String s = "gautam";
    System.out.println((String) s.transform(String::toUpperCase));
  }

  private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
    T result = function.apply(value1, value2);
    System.out.println("Result of Operation: " + result);
  }

  private static PlainOld[] seedArray(Supplier<PlainOld> ref, int count) {
    PlainOld[] array = new PlainOld[count];
    Arrays.setAll(array, i -> ref.get());
    return array;
  }
}
