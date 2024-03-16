package a4_Predicates;

import java.util.List;
import java.util.function.Predicate;

// interface Predicate<T>{
//    public boolean predicate(T t);
// }
public class Main {
  public static void main(String[] args) {
    // Basic
    Predicate<Integer> pred1 = object -> (object > 10);
    System.out.println(pred1.test(12));
    System.out.println(pred1.test(10));
    System.out.println(pred1.test(436));

    System.out.println("--- Predicate Joining ---");
    // and(),or() and negate()
    int[] arr = {1,2,3,4,5,6,7,8,9,10};

    Predicate<Integer> isEvenPred = object -> object % 2 == 0;
    Predicate<Integer> isOddPred = isEvenPred.negate();
    Predicate<Integer> isNumLess5 = object -> object<5;

    System.out.println("--> Even numbers :");
    display(isEvenPred, arr);

    System.out.println("\n" + "--> Odd numbers :");
    display(isOddPred, arr);

    System.out.println("\n" + "--> numbers less than 5:");
    display(isNumLess5,arr);

    System.out.println("\n" + "--> numbers less than 5 and are even");
    display(isNumLess5.and(isEvenPred),arr);

    System.out.println("\n" + "--> numbers less than 5 or numbers are odd");
    display(isNumLess5.or(isOddPred),arr);

  }

  public static void display(Predicate<Integer> pred, int[] arr) {
    for (int item : arr) {
      if (pred.test(item)) {
        System.out.print(item + " ");
      }
    }
  }
}
