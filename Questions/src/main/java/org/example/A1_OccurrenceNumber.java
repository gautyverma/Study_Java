package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Given an array of multiple values count the occurrences of values given in array.
 */
public class A1_OccurrenceNumber {
  public static void main(String[] args) {
    Integer[] arr = {8, 7, 2, 6, 7, 2, 8, 7, 9, 5, 1, 8, 2, 3, 1, 3};
    System.out.println("--- Count values using HashMap ---");
    Map<Integer, Integer> map1 = new HashMap<>();
    for (int item : arr) {
      map1.put(item, map1.getOrDefault(item, 0) + 1);
    }
    System.out.println(map1.toString());
    System.out.println("--- Count values using stream API ----");
    Map<Integer, Long> map2 =
        Arrays.stream(arr)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(map2.toString());

    // Count occurrences and sort by count
    System.out.println("--- Count occurrences and sort by count values ----");
    Map<Integer, Long> sortedOccurrences =
        Arrays.stream(arr)
            .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue,
                    LinkedHashMap::new));

    // Print the sorted occurrences
    sortedOccurrences.forEach(
        (value, count) -> System.out.println(value + " occurs " + count + " times"));
  }
}
/*

Let's delve deeper into the Collectors.groupingBy(Function.identity(), Collectors.counting()) expression:

        Collectors.groupingBy(): This collector is used to group elements based on a classifier function.
        It collects the elements of a stream into a Map,
        where the keys are the result of applying the classifier function to each element,
        and the values are lists of elements that share the same key.

        Function.identity(): In this context, Function.identity() serves as the classifier function.
        It returns the input element itself. So, when used in groupingBy(Function.identity()),
        it effectively groups elements based on their own values.
        For example, if you have a stream of integers [1, 2, 3, 1, 2, 3], using Function.identity() as the classifier will group them as {1=[1, 1], 2=[2, 2], 3=[3, 3]}.

        Collectors.counting(): This downstream collector is used to count the occurrences of elements within
        each group. It returns a count of elements in each group.

 */

/*
 Arrays.stream(array): This part converts the array array into a stream of elements. It utilizes

 Arrays.stream() method from the java.util.Arrays class, which is available in Java 8 to convert
arrays to streams.

 .collect(Collectors.groupingBy(x -> x, Collectors.counting())): Here, we collect the elements of
the stream into a map, grouping them by their values and counting the occurrences of each value.

The groupingBy() collector groups elements by the provided classifier function x -> x, which
essentially groups elements by their own value. Collectors.counting() is the downstream collector
used to count the occurrences of each value within the groups.

 .entrySet().stream(): After collecting the elements into a map, we obtain a stream of map
entries by calling entrySet() and then stream(). This stream represents each key-value pair in
the map as a Map.Entry.

 .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())): This line sorts the stream of map
entries (Map.Entry<Integer, Long>) based on the values (count numbers) in descending order. It
uses a lambda expression (e1, e2) -> e2.getValue().compareTo(e1.getValue()) as the comparator to
compare the values of each entry (e1 and e2) and sort them accordingly.


        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) ->
oldValue, LinkedHashMap::new)): Finally, we collect the sorted entries back into a map using
 Collectors.toMap().

We specify Map.Entry::getKey and Map.Entry::getValue as the key mapper and
value mapper functions, respectively, to extract the key and value from each entry. The
 (oldValue, newValue) -> oldValue is the merge function used to resolve conflicts if duplicate
keys are encountered. We specify LinkedHashMap::new as the map supplier to preserve the insertion
order while collecting the entries into the map.*/
