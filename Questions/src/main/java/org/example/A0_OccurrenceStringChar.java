package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Print number of occurrences of each character in a given string*/
public class A0_OccurrenceStringChar {
  public static void main(String[] args) {

    String name = "missisippi";
    System.out.println("--- Using HashMap ---");
    Map<Character, Integer> map = new HashMap<>();
    for (char item : name.toCharArray()) {
      map.put(item, map.getOrDefault(item, 0) + 1);
    }
    System.out.println(map.toString());
    // ----------------------------------------------------------
    System.out.println("--- Using Stream ---");
    // Using streams to count occurrences of each character
    Map<Character, Long> mapStream =
        name.chars() // Convert string to IntStream of characters
            .mapToObj(c -> (char) c) // Convert each character code to a char
            .collect(
                Collectors.groupingBy(
                    Function.identity(), // Group characters by identity (i.e., themselves)
                    Collectors.counting()));
    System.out.println(mapStream.toString());
    // ----------------------------------------------------------
    System.out.println(
        "--- Count occurrence of word Using Stream while list of string is given ---");
    List<String> list = Arrays.asList("abc", "def", "abc", "klmn");
    Map<String, Long> countWord =
        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(countWord.toString());

    // ----------------------------------------------------------
    List<String> stringList = List.of("hello", "world", "example");

    // Using streams to count occurrences of each character
    System.out.println(
        "--- Count occurrence of char Using Stream while list of string is given ---");
    Map<Character, Long> charCounts =
        stringList.stream() // Convert list to stream of strings
            .flatMap(
                str ->
                    str.chars()
                        .mapToObj(c -> (char) c)) // Flatten each string into a stream of characters
            .collect(
                Collectors.groupingBy(
                    Function.identity(), // Group characters by identity (i.e., themselves)
                    Collectors.counting())); // Count occurrences of each character
    System.out.println(charCounts.toString());
  }
}
