package org.example;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A6_FindEvenOdd {
  public static void main(String[] args) {
    Integer[] arr = {12, 8, 4, 8, 6, 4, 9, 1, 3, 4};
    Predicate<Integer> isEven = num -> num % 2 == 0;
    Predicate<Integer> isOdd = isEven.negate();
    System.out.println(
        "Even num list - "
            + Arrays.stream(arr).filter(isEven).sorted().collect(Collectors.toList()));
    System.out.println(
        "Odd num list - " + Arrays.stream(arr).filter(isOdd).collect(Collectors.toList()));
  }
}
