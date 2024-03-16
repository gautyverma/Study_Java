package a5_Functions;

import java.util.function.Function;

// interface function(T,R){
//    public R apply(T t);
// }
public class Main {
  public static void main(String[] args) {
    Function<String, Integer> strLength = s -> s.length();
    System.out.println("Advanced - " + strLength.apply("Advanced"));
  }
}
