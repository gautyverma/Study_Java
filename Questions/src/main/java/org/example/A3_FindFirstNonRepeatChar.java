package org.example;

import java.util.Optional;

/*
 * Finding the First Non-Repeated Character in a String using Stream Functions
 * */
public class A3_FindFirstNonRepeatChar {
  public static void main(String[] args) {
    String name = "statistics";
    Optional<Character> firstNonRepeatedChar =
        name.chars()
            .mapToObj(c -> (char) c)
            .filter(c -> name.indexOf(c) == name.lastIndexOf(c))
            .findFirst();
    firstNonRepeatedChar.ifPresent(System.out::println);
  }
}
