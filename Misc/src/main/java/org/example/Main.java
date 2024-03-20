package org.example;

/*
p1 -
  string - count of each character in that string
p2 -
    1 2 3 4
    1 2 3 4
    1 2 3 4
    1 2 3 4

    1 + 2 +3 + 4 = 10
    1 + 2 +3 + 4 = 10
    - 10+10 = 10

p3 - [1,1,1,5,1,1,1]
*/

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {

    /*
     String str = "asdhisf";
     Map<Character, Integer> map = new HashMap<>();
     char[] charArr = str.toCharArray();
     for (char item : charArr) {
       if (map.containsKey(item)) {
         map.put(item, map.get(item) + 1);
       } else {
         map.put(item, 1);
       }
     }
     System.out.println(map.toString());
    */

    //    int[][] matrix = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
    int[][] matrix1 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
    int d1 = 0;
    for (int i = 0; i < matrix1.length; i++) {
      d1 += matrix1[i][i];
    }
    System.out.println("d1 - " + d1);
    for (int i = 0; i < matrix1.length; i++) {
      d1 += matrix1[i][matrix1.length - i - 1];
    }
    System.out.println("d1 - " + d1);

    int[] arr = {1, 1, 1, 5, 1, 1, 1};
    System.out.println("Sum of left == Sum of Right:" + getIndex(arr));

    int i1 = 12321;
    int i2 = 123210;
    System.out.println("isPalindrome - " + isPalindrome(i1));
    System.out.println("isPalindrome - " + isPalindrome(i2));
  }

  private static boolean isPalindrome(int i1) {
    int rever = 0;
    int ori = i1;
    while (i1 > 0) {
      int digit = i1 % 10;
      rever = rever * 10 + digit;
      i1 /= 10;
    }
    return rever == ori;
  }

  private static int getIndex(int[] arr) {
    int left = 0, sum = 0;

    for (int item : arr) {
      sum += item;
    }
    for (int i = 0; i < arr.length; i++) {
      if (left == sum - arr[i] - left) {
        return i;
      }
      left += arr[i];
    }
    return -1;
  }
}
