package next.com_1_Intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String firstName, String lastName){
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

  public static void main(String[] args) {
    //
      List<Person> people = new ArrayList<>(Arrays.asList(
              new Main.Person("Gautam","Verma"),
              new Person("Priyanka","Chopra"),
              new Person("Anushka","Shetty"),
              new Person("Allu","Arjun"),
              new Person("Ram","Singh"),
              new Person("Gabbar","Singh")
      ));

      // Using Anonymous Class
      var comparatorLastName = new Comparator<Person>(){
          @Override
          public int compare(Person o1, Person o2) {
              return o1.lastName().compareTo(o2.lastName());
          }
      };
      people.sort((comparatorLastName));
      System.out.println(people);
      System.out.println("============================================");

      System.out.println("<- Using Lambda Expression ->");
      people.sort((o1,o2)->{return o1.firstName.compareTo(o2.firstName);});
      System.out.println(people);
      System.out.println("============================================");

      System.out.println("<- using EnchancedComparator - comparator mixed ->");

      interface EnhancedComparator<T> extends Comparator<T>{
          int secondLevel(T o1, T o2);
      }

      var mixedComparator = new EnhancedComparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
              int result = o1.lastName.compareTo(o2.lastName);
              return result==0 ? secondLevel(o1,o2):result;
          }

          @Override
          public int secondLevel(Person o1, Person o2) {
              return o1.firstName.compareTo(o2.firstName);
          }
      };

      people.sort(mixedComparator);
      System.out.println(people);
      System.out.println("============================================");
      System.out.println("<- using Lambda Exp - comparator mixed ->");

      people.sort(new EnhancedComparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
              int result = o1.lastName.compareTo(o2.lastName);
              return result==0 ? secondLevel(o1,o2):result;
          }

          @Override
          public int secondLevel(Person o1, Person o2) {
              return o1.firstName.compareTo(o2.firstName);
          }
      });


  }

}
