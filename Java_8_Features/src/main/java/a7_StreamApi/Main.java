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
  }
}
