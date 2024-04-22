package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class A7_FindDuplicates {
  public static void main(String[] args) {
    Integer[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 9, 9, 8, 8, 1, 2, 6, 4, 7};
    Set<Integer> collect =
        Arrays.stream(arr)
            .filter(num -> Collections.frequency(List.of(arr), num) > 1)
            .collect(Collectors.toSet());
    System.out.println(collect.toString());

    System.out.println("Length of array : " + Arrays.stream(arr).count());
  }
}
