package org.example;

import java.util.*;

/*
 * Java program to get book release year as a key
 * and list of books as a value from a list of Book objects
 * */
public class A12_BookProb1 {
  public static Map<Integer, List<String>> getBooksByReleaseYear(List<Book> books) {
    Map<Integer, List<String>> booksByReleaseYear = new HashMap<>();
    for (Book book : books) {
      int releaseYear = book.getReleaseYear();
      String name = book.getName();
      booksByReleaseYear.computeIfAbsent(releaseYear, k -> new ArrayList<>()).add(name);
    }
    return booksByReleaseYear;
  }

  public static void main(String[] args) {
    List<Book> books =
        Arrays.asList(
            new Book("Book1", 2000),
            new Book("Book2", 2000),
            new Book("Book3", 2001),
            new Book("Book4", 2002));
    Map<Integer, List<String>> booksByReleaseYear = getBooksByReleaseYear(books);
    System.out.println(booksByReleaseYear);
  }
}

class Book {
  private int releaseYear;
  private String name;

  public Book(String name, int releaseYear) {
    this.releaseYear = releaseYear;
    this.name = name;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
