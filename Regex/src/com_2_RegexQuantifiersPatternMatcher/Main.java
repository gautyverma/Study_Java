package com_2_RegexQuantifiersPatternMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    //
    String alphaNumeric = "abcdddddxahfijaf548611f384ad4g646awf1aw31dq3f43";

    System.out.println(alphaNumeric.replaceAll("^abcddddd", "_"));

    //    X?	X, once or not at all
    System.out.println(alphaNumeric.replaceAll("^a?", "_"));

    // "X{n}" ->	X, exactly n times
    System.out.println(alphaNumeric.replaceAll("^abcd{5}", "_"));

    // "X+" ->	X, one or more times
    System.out.println(alphaNumeric.replaceAll("^abcd+", "_"));

    // "X*" ->	X, zero or more times
    System.out.println(alphaNumeric.replaceAll("^abcd*", "_"));

    // "X{n,}" ->	X, at least n times
    // "X{n,m}" ->	X, at least n but not more than m times
    System.out.println(alphaNumeric.replaceAll("^abcd{2,7}", "_"));

    // <------- Pattern and Matcher ------->
    // a can be zero or more times
    Pattern pattern = Pattern.compile("a*b");
    Matcher matcher = pattern.matcher("aaaaaab");
    System.out.println(matcher.matches());
  }
}
