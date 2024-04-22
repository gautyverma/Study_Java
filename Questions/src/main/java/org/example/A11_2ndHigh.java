package org.example;

import java.util.Arrays;
import java.util.Collections;

/*
 * Program to find the 2nd highest number from the given array using Java streams
 * */
public class A11_2ndHigh {
  public static void main(String[] args) {
    Integer[] arr = {50, 46, 91, 89, 0, 14, 61, 90, 43, 170};
    Integer secondValue =
        Arrays.stream(arr)
            .sorted(Collections.reverseOrder())
            .distinct()
            .skip(1)
            .findFirst()
            .orElse(-1);
    System.out.println(secondValue);
  }
}
