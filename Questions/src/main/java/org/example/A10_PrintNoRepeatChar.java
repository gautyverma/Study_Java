package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Write a program to print non-repeated values (O/P: J,V)
 * */
public class A10_PrintNoRepeatChar {
  public static void main(String[] args) {
    String name = "gautam";
    System.out.println("--- using hashMap ---");
    Map<Character, Integer> charCount = new HashMap<>();
    for (char item : name.toCharArray()) {
      charCount.put(item, charCount.getOrDefault(item, 0) + 1);
    }
    for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
      if (entry.getValue() == 1) {
        System.out.print(entry.getKey() + ",");
      }
    }
    System.out.println("--- Using Streams ---");
    // Convert the string to lowercase, split into characters, and convert to a stream
    name
        .chars()
        .mapToObj(ch -> (char) ch)
        .map(Character::toLowerCase)
        // Group the characters by count
        .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
        .entrySet()
        .stream()
        // Filter out characters with count > 1
        .filter(entry -> entry.getValue() == 1)
        // Print non-repeated characters
        .forEach(entry -> System.out.println(entry.getKey()));
  }
}
