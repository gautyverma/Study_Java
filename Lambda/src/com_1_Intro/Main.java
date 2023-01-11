package com_1_Intro;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    /*    // Anonymous Class
     */
    /*
        new Thread(
                new Runnable() {
                  @Override
                  public void run() {
                    System.out.println("Running from Anonymus Class");
                  }
                })
            .start();
    */
    /*
        new Thread(
                () -> {
                  System.out.println("Running from Lambda Exp !!");
                  System.out.println("line 2");
                  System.out.println("line 3");
                })
            .start();
    */
    Employee Gautam = new Employee("Gautam", 23);
    Employee Mohan = new Employee("Mohan", 29);
    Employee Shiva = new Employee("Shiva", 45);
    Employee Radha = new Employee("Radha", 30);

    List<Employee> empl = new ArrayList<>();
    empl.add(Gautam);
    empl.add(Mohan);
    empl.add(Shiva);
    empl.add(Radha);

    /*
    Collections.sort(
    empl,
    new Comparator<Employee>() {
      @Override
      public int compare(Employee emp1, Employee emp2) {
        return emp1.getName().compareTo(emp2.getName());
      }
    });
    */
    /*
    Collections.sort(empl, (emp1, emp2) -> emp1.getAge().compareTo(emp2.getAge()));

    for (Employee employee : empl) {
      System.out.println(employee.getName());
    }
    UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
    String sillyString = doStringStuff(uc, empl.get(0).getName(), empl.get(1).getName());
    System.out.println(sillyString);
    */

    /*
    for (Employee emp : empl) {
      System.out.println(emp.getName());
      System.out.println(emp.getAge());
    }
    */
    // Upper code using lambda for each -
    empl.forEach(
        emp -> {
          System.out.println(emp.getName());
          System.out.println(emp.getAge());
        });

    System.out.println("*******************");

    /*
    for (Employee emp:empl){
      System.out.println(emp.getName());
      new Thread(()->{
        System.out.println(emp.getAge());
      }).start();
    }
    */
    /*
          // Upper code can also done as follows -
        for (int i = 0; i < empl.size(); i++) {
          Employee emp = empl.get(i);
          System.out.println(emp.getName());
          new Thread(
                  () -> {
                    System.out.println(emp.getAge());
                  })
              .start();
        }
    */

    //    AnotherClass anotherClass = new AnotherClass();
    //    String s = anotherClass.doSomething();
    //    System.out.println(s);
  }

  public static final String doStringStuff(UpperConcat uc, String s1, String s2) {
    return uc.upperAndConcat(s1, s2);
  }
}

class Employee {
  private String name;
  private Integer age;

  public Employee(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}

interface UpperConcat {
  public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
  public String doSomething() {

    /*
    //Using Anonymous Class
    System.out.println("Another Class's Name : "+getClass().getSimpleName());
    return Main.doStringStuff(
        new UpperConcat() {
          @Override
          public String upperAndConcat(String s1, String s2) {
            System.out.println("Anonymous Class's Name : "+getClass().getSimpleName());
            return s1.toUpperCase() + s2.toUpperCase();
          }
        },
        "GAUTAM",
        "VERMA");*/

    /*
        // Simple Lambda Expression
        UpperConcat uc =
            (s1, s2) -> {
              System.out.println("Lambda Expression class name's : " + getClass().getSimpleName());
              String res = s1.toUpperCase() + s2.toUpperCase();
              return res;
            };
    */
    /*
    // -> Anonymous Class
    UpperConcat uc =
        new UpperConcat() {
          @Override
          public String upperAndConcat(String s1, String s2) {
            return s1.toUpperCase() + s2.toUpperCase();
          }
        };
        */

    final int i = 1;

    UpperConcat uc =
        (s1, s2) -> {
          System.out.println("The lambda expression's class is " + getClass().getSimpleName());
          System.out.println("Value of i - " + i);
          return (s1.toUpperCase() + s2.toUpperCase());
        };

    System.out.println("Another Class's Name : " + getClass().getSimpleName());
    return Main.doStringStuff(uc, "GAUTAM", "VERMA");
  }

  public void printValue() {
    int num = 25;
    Runnable e =
        () -> {
          try {
            Thread.sleep(5000);
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }
          System.out.println("Num value - " + num);
        };
    new Thread(e).start();
  }
}
