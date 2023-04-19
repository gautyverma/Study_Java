package com_1_IntroStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    //
    List<String> someBingoNumbers =
        Arrays.asList(
            "N40", "N36", "B12", "B6", "G53", "G49", "G60", "G50", "I26", "I17", "I29", "O71");
    // Task - print NBingo Numbers that are starting with "G" in sorted order.
    // Option 1 - Use of For loop and put if condition. ~ Can do easily

    // Option 2 - use foreach method and lambda exp in it.
    List<String> gNumbers = new ArrayList<>();

    someBingoNumbers.forEach(
        number -> {
          if (number.contains("G")) {
            gNumbers.add(number);
            //            System.out.println(number);
          }
        });
    gNumbers.sort(String::compareTo);
    //      gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
    System.out.println(gNumbers);
    System.out.println("------------------------------");
    // Option 3 - use of Stream
    System.out.println("--- Using Streams ---");

    someBingoNumbers.stream()
        .map(String::toUpperCase)
        .filter(s -> s.startsWith("G"))
        .sorted()
        .forEach(System.out::println);
  }
}
