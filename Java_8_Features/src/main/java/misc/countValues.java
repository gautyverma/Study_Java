package misc;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Given an array of multiple values count the occurrences of values given in array using streams
 */
public class countValues {
  public static void main(String[] args) {
    Integer[] arr = {4, 5, 4, 8, 6, 2, 1, 1, 9, 9};
    Map<Integer, Long> mapOccur =
        Arrays.stream(arr).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    mapOccur.forEach((value, count) -> System.out.println(value + " - occurs times -" + count));

    System.out.println("-------------------------------------");
    Integer[] array = {1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 5};

    // Count occurrences and sort by count
    Map<Integer, Long> sortedOccurrences =
        Arrays.stream(array)
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

// Arrays.stream(array): This part converts the array array into a stream of elements. It utilizes

// Arrays.stream() method from the java.util.Arrays class, which is available in Java 8 to convert
// arrays to streams.

// .collect(Collectors.groupingBy(x -> x, Collectors.counting())): Here, we collect the elements of
// the stream into a map, grouping them by their values and counting the occurrences of each value.

// The groupingBy() collector groups elements by the provided classifier function x -> x, which
// essentially groups elements by their own value. Collectors.counting() is the downstream collector
// used to count the occurrences of each value within the groups.

// .entrySet().stream(): After collecting the elements into a map, we obtain a stream of map
// entries by calling entrySet() and then stream(). This stream represents each key-value pair in
// the map as a Map.Entry.
//
// .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())): This line sorts the stream of map
// entries (Map.Entry<Integer, Long>) based on the values (count numbers) in descending order. It
// uses a lambda expression (e1, e2) -> e2.getValue().compareTo(e1.getValue()) as the comparator to
// compare the values of each entry (e1 and e2) and sort them accordingly.
//

// .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) ->
// oldValue, LinkedHashMap::new)): Finally, we collect the sorted entries back into a map using
// Collectors.toMap(). We specify Map.Entry::getKey and Map.Entry::getValue as the key mapper and
// value mapper functions, respectively, to extract the key and value from each entry. The
// (oldValue, newValue) -> oldValue is the merge function used to resolve conflicts if duplicate
// keys are encountered. We specify LinkedHashMap::new as the map supplier to preserve the insertion
// order while collecting the entries into the map.
