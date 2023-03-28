package com_1_StaticNestedClasses;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Driver Code
    List<Employee> employees =
        new ArrayList<>(
            List.of(
                new Employee(1001, "Gautam", 2020),
                new Employee(1002, "Mohan", 2019),
                new Employee(1003, "Shiva", 2016),
                new Employee(1004, "Roro", 2018),
                new Employee(1004, "Ayappa", 2022)));

    // Using Specific different class
    var comparator = new EmployeeComparator<>();
    employees.sort(comparator);

    for (Employee emp : employees) {
      System.out.println(emp);
    }
    //
    System.out.println("===== Nested Class =====");
    // Using the Nested Class

    // Default sortType - "Name"
    employees.sort(new Employee.EmployeeComparator<>());
    for (Employee emp : employees) {
      System.out.println(emp);
    }
    System.out.println("======================");

    // Setting sortType - "yearStarted"
    employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
    for (Employee emp : employees) {
      System.out.println(emp);
    }
  }
}
