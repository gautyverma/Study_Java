package a1_Lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Aakash");
    list.add("Gautam");
    list.add("Sarthak");
    list.add("Vinay");
    list.add("Harsh");
    // Print using for loop
    for (String item : list) {
      System.out.println(item);
    }
    System.out.println("---- Print using for loop using lambda operation ----");
    // Print using for loop using lambda operation
    list.forEach(item -> System.out.println(item));

  }
}
