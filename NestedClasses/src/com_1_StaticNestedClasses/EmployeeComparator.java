package com_1_StaticNestedClasses;

import java.util.Comparator;

public class EmployeeComparator<T extends Employee> implements Comparator<Employee> {
  // As I didn't make getter and setter for yearStarted, I can't return "o1.yearStarted -
  // o2.yearStarted"
  // yearStarted is private member which I can't access here.

  /* <-- Will throw compile error -->
    @Override
    public int compare(Employee o1, Employee o2) {
      return o1.yearStarted - o2.yearStarted;
    }
  */
  // To OverCome the above problem we can make it a "static nested class".

  @Override
  public int compare(Employee o1, Employee o2) {
    return o1.getName().compareTo(o2.getName());
  }
}
