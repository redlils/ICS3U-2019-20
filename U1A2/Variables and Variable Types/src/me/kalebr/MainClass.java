package me.kalebr;

public class MainClass {
  
  public static void main(String[] args) {
    int length = 351;
    int height = 723;
    double area = length * height;
    boolean evenArea = area % 2 == 0;
    String outputString = "The area of a rectangle with a length of %d and a height of %d is %f. The resulting area is %s.";
    System.out.printf(outputString, length, height, area, (evenArea ? "even" : "not even"));
  }
  
}
