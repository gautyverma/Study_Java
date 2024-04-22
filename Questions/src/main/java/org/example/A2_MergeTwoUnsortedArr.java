package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Merging Two Unsorted Arrays into Single Sorted Array without Duplicates using Streams
 * */
public class A2_MergeTwoUnsortedArr {
  public static void main(String[] args) {
    Integer[] arr1 = {4, 6, 8, 4, 2, 1, 3, 6};
    Integer[] arr2 = {4, 8, 9, 7, 4, 8};
    List<Integer> collect =
        Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
            .sorted()
            .collect(Collectors.toList());
    System.out.println(collect.toString());
  }
}
