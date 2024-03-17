package a7_StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
1. Configuration
    - filter()
    - map()
2. Processing
    - collect()
    - count()
    - sorted()
    - min() and max()
    - forEach()
    - toArray()
    - Stream.of()

*/
public class Main {
  public static void main(String[] args) {

    // --- collect ---
    System.out.println("--- collect ---");
    ArrayList<Integer> list1 = new ArrayList<>();
    for (int i = 1; i < 11; i++) {
      list1.add(i);
    }
    List<Integer> collect = list1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    System.out.println(collect);

    // --- collect & map ---
    System.out.println("--- collect & map ---");
    List<Integer> collectMap =
        list1.stream().filter(i -> i % 2 != 0).map(i -> i * i).collect(Collectors.toList());
    System.out.println(collectMap);

    // --- count ---
    System.out.println("--- count ---");
    long count = list1.stream().filter(i -> i % 2 == 0).count();
    System.out.println("Even number count : " + count);

    // --- sorting ---
    System.out.println("--- sorting ---");

    System.out.println("--- Custom sorting order ---");
    List<Integer> sortedCustomList =
        list1.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList());
    System.out.println(sortedCustomList);

    System.out.println("--- Natural sorting order ---");
    List<Integer> sortedNaturalList =
        sortedCustomList.stream().sorted().collect(Collectors.toList());
    System.out.println(sortedNaturalList);

    // --- Min and Max ---
    System.out.println("--- Min Value ---");
    Integer minInteger = list1.stream().min((s1, s2) -> s1.compareTo(s2)).get();
    System.out.println(minInteger);
    System.out.println(
        list1.stream().min((s1, s2) -> s2.compareTo(s1)).get()
            + " - If we change the compare values ift gives opposite result");

    System.out.println("--- Max Value ---");
    Integer maxInteger = list1.stream().max((s1, s2) -> s1.compareTo(s2)).get();
    System.out.println(maxInteger);

    // forEach - it does not return just do defined operation
    System.out.println("--- forEach ---");
    list1.stream().forEach(System.out::print);
    System.out.println();
    list1.stream().forEach(s -> System.out.print(s + ", "));
    System.out.println();

    // ToArray()
    System.out.println("--- ToArray ---");
    Integer[] array = list1.stream().toArray(Integer[]::new);
    System.out.println(array[0]);

    // Stream.of()
    System.out.println("--- Stream ---");
    Stream s = Stream.of(99999, 999, 999);
    s.forEach(System.out::println);
  }
}
