package next.com_3_challenge_2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
  private static Random random = new Random();

  public static void main(String[] args) {
    //
    String[] names = {"GaUTam", "BoB", "annA", "Chirag", "MOhan", "ShIvA", "sukhI"};
    Arrays.setAll(names, i -> names[i].toUpperCase());

    // ------------------------------------------------
    // Make all name to upperCase

    System.out.println("==== To UpperCase ====");
    System.out.println(Arrays.toString(names));

    System.out.println("----------------------------------------");
    // ------------------------------------------------
    // Add Random Middle Intials

    List<String> backByArray = Arrays.asList(names);

    backByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
    System.out.println("==== Add Random Middle Intials ====");
    System.out.println(Arrays.toString(names));

    System.out.println("----------------------------------------");
    // -------------------------------------------------
    // Add Reversed firstName as LastName

    backByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
    System.out.println("==== Add Reversed Last Name ====");
    System.out.println(Arrays.toString(names));

    System.out.println("----------------------------------------");
  }

  public static char getRandomChar(char startChar, char lastChar) {
    return (char) random.nextInt((int) startChar, (int) lastChar + 1);
  }

  public static String getReversedName(String name) {
    return new StringBuilder(name).reverse().toString();
  }
}
