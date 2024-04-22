package org.example;

import java.util.Arrays;

public class A9_RotateArrKStep {
  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    int k = 4;
    k = k % arr.length;
    reverse(arr, 0, arr.length - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, arr.length - 1);

    System.out.println(Arrays.toString(arr));
  }

  private static void reverse(Integer[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
}
