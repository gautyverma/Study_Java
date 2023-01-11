package com_2_FunctionalInterface_Predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
    Employee Gautam = new Employee("Gautam", 23);
    Employee Mohan = new Employee("Mohan", 29);
    Employee Shiva = new Employee("Shiva", 45);
    Employee Radha = new Employee("Radha", 31);

    List<Employee> empl = new ArrayList<>();
    empl.add(Gautam);
    empl.add(Mohan);
    empl.add(Shiva);
    empl.add(Radha);
    /*
    System.out.println("Employee Age > 30 - ");
    System.out.println("====================");
    empl.forEach(
        employee -> {
          if (employee.getAge() > 30) {
            System.out.println(employee.getName());
          }
        });
        */
    printEmpByAge(empl, "Employee over 30", employee -> employee.getAge() > 30);
    printEmpByAge(empl, "Employee under 30", employee -> employee.getAge() < 30);
    printEmpByAge(
        empl,
        "Employee under 25",
        new Predicate<Employee>() {
          @Override
          public boolean test(Employee employee) {
            return employee.getAge() < 25;
          }
        });
  }

  private static void printEmpByAge(
      List<Employee> empl, String empText, Predicate<Employee> ageCondition) {
    System.out.println("===========");
    System.out.println(empText);
    System.out.println("===========");
    empl.forEach(
        employee -> {
          if (ageCondition.test(employee)) {
            System.out.println(employee.getName());
          }
        });
  }
}
