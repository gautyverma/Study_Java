package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class A5_MinLengthStrInArr {
  public static void main(String[] args) {
    String[] arr = {"Gautam", "Mohan", "Shiv"};
    int minLengthStr = Arrays.stream(arr).mapToInt(String::length).min().orElse(-1);
    System.out.println(minLengthStr);
    System.out.println("---------------------------------------------");
    // Find the minimum length and its corresponding value using streams
    Optional<String> minLengthString =
        Arrays.stream(arr)
            .min(Comparator.comparingInt(String::length)); // Find the string with minimum length

    // Check if the Optional is present and print the result
    minLengthString.ifPresent(
        minString ->
            System.out.println(
                "Minimum length string: " + minString + ", Length: " + minString.length()));
  }
}
