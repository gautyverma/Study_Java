package com_2_InnerClasses;

import com_1_StaticNestedClasses.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Driver Code
    // =====================================
    System.out.println("Store Members");
    List<StoreEmployee> storeEmployees =
        new ArrayList<>(
            List.of(
                new StoreEmployee(10019, "Jigen", 2019, "hisar"),
                new StoreEmployee(10020, "Kawaki", 2018, "hansi"),
                new StoreEmployee(10021, "Boruto", 2019, "hisar"),
                new StoreEmployee(10022, "Hima", 2020, "hansi"),
                new StoreEmployee(10023, "Shika", 2017, "hisar")));

    // We are using static nested class here
    System.out.println("== Using Static Nested class ==");
    var comparator = new Employee.EmployeeComparator<>();
    storeEmployees.sort(comparator);
    for (StoreEmployee emp : storeEmployees) {
      System.out.println(emp);
    }

    System.out.println("==========================");

    // For using inner nested class, we have to create object(var) of parent class and access the
    // inner class using that

    System.out.println("== Using Nested Inner class ==");

    /*
    var empGeneric = new StoreEmployee();
    var comparator1 = empGeneric.new StoreComparator<>();
    */
    // Other way to do above code is ->

    var comparator1 = new StoreEmployee().new StoreComparator<>();
    storeEmployees.sort(comparator1);

    for (StoreEmployee emp : storeEmployees) {
      System.out.println(emp);
    }
  }
}
