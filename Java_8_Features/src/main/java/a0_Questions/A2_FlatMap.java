package a0_Questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A2_FlatMap {
  public static void main(String[] args) {
    // Sample list of employees with multiple locations
    List<Emp> employees =
        Arrays.asList(
            new Emp(1, "Alice", 50000, Arrays.asList("New York", "London")),
            new Emp(2, "Bob", 60000, Arrays.asList("London", "Paris")),
            new Emp(3, "Charlie", 55000, Arrays.asList("New York", "Tokyo")),
            new Emp(4, "David", 70000, Arrays.asList("Tokyo", "Paris")),
            new Emp(5, "Eve", 45000, Arrays.asList("London", "New York")));

    // Get distinct locations
    List<String> distinctLocations =
        employees.stream()
            .flatMap(emp -> emp.getLocations().stream())
            .distinct()
            .collect(Collectors.toList());

    // Output distinct locations
    System.out.println("Distinct Locations:");
    distinctLocations.forEach(System.out::println);
  }
}

class Emp {
  private int id;
  private String name;
  private double salary;
  private List<String> locations;

  // Constructor
  public Emp(int id, String name, double salary, List<String> locations) {
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.locations = locations;
  }

  // Getters
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public List<String> getLocations() {
    return locations;
  }
}
