package org.example;

public class A8_DistCharStr {
  public static void main(String[] args) {
    String name = "mississippi";
    name.chars().distinct().forEach(c -> System.out.println((char) c));
  }
}
