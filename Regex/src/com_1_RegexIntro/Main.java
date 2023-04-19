package com_1_RegexIntro;

public class Main {
  public static void main(String[] args) {
    //
    /*
     * 1. Regex are case sensitive.
     * 2.
     * */
    String str = "I am Gautam, I work in IT industry.";
    System.out.println(str);
    String newStr = str.replaceAll("I", "Hello");
    System.out.println(newStr);

    String alphaNumeric = "abcdb1234asAad44634sbadbgthra";
    // "." -> matches any character

    System.out.println(alphaNumeric.replaceAll(".", "Y"));
    // "^" -> Boundry case -> "^abc" -> ^ define start point of regex to match.
    // Below method will only replace the matched part
    System.out.println(alphaNumeric.replaceAll("^abcd", "xxxx")); // -> xxx1234asad44634sadgthra

    // we will get false ,as it is matching the whole string.
    System.out.println(alphaNumeric.matches("^abcd"));

    // whole string is matched
    System.out.println("abcd".matches("^abcd"));

    // "$" -> matchs the end of the string - partially
    System.out.println(alphaNumeric.replaceAll("sadgthra$", "__THE END"));

    // "[]" -> all occurrence char inside square brackets will be replaced
    System.out.println(alphaNumeric.replaceAll("[asd]", "_"));

    // "[a][b]" -> all a followed by b will be replaced -> ab -> _
    System.out.println(alphaNumeric.replaceAll("[asd][b]", "_"));

    // "[^]" -> all occurrence of other char will be replaced expected the char inside square
    // brackets
    System.out.println(alphaNumeric.replaceAll("[^asd]", "_"));

    System.out.println(alphaNumeric.replaceAll("[abcd3456]", "_"));
    System.out.println(alphaNumeric.replaceAll("[a-d3-6]", "_"));

    // "(?i)" -> To ignore case sensitivity
    System.out.println(alphaNumeric.replaceAll("(?i)[a-d3-6]", "_"));

    // replace all the digits, we can also use "\\d"
    System.out.println(alphaNumeric.replaceAll("[0-9]", "_"));
    System.out.println(alphaNumeric.replaceAll("\\d", "_"));

    // replace all non-digits, we can also use "\\D"
    System.out.println(alphaNumeric.replaceAll("\\D", "_"));

    String hasWhiteSpace = " I have random blanks,\ta tab\t&\nalso new line \n.  ";
    System.out.println(hasWhiteSpace);

    // replacing all whitespaces \t \n "space"
    System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
    // replace \t \n
    System.out.println(hasWhiteSpace.replaceAll("[\t\n]", "_"));

    // -"\\S" - for all non-white space characters
    System.out.println(hasWhiteSpace.replaceAll("\\S", "x"));

    // -"\\w" -	A word character: [a-zA-Z_0-9]
    System.out.println(alphaNumeric.replaceAll("\\w", "_"));

    // -"\\W" -	A nod word character: [^a-zA-Z_0-9]
    System.out.println(hasWhiteSpace.replaceAll("\\W", "_"));

    // -"\\b" - a word boundary
    System.out.println(hasWhiteSpace.replaceAll("\\b", "_"));
    System.out.println(alphaNumeric.replaceAll("\\b", "_"));
  }
}
