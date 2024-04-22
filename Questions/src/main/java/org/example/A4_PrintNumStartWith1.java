package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A4_PrintNumStartWith1 {
  public static void main(String[] args) {
    Integer[] arr = {11, 2, 4, 13, 18, 7, 101, 39, 15, 74, 3, 19, 7};
    List<Integer> list =
        Arrays.stream(arr)
            .filter(num -> String.valueOf(num).startsWith("1"))
            .collect(Collectors.toList());
    System.out.println(list.toString());
  }
}
