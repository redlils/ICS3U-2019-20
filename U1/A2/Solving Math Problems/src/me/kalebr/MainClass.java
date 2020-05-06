package me.kalebr;

import java.util.Scanner;

public class MainClass {
  
  static Scanner inputScanner;
  
  public static void main(String[] args) {
    inputScanner = new Scanner(System.in);
    System.out.print("Hello! Welcome to Kaleb's Pythagorean Theorem Solver! Please enter what you would like to solve for (h: Hypotenuse, l: Leg): ");
    String selection = inputScanner.next();
    while (!selection.equalsIgnoreCase("h") && !selection.equalsIgnoreCase("l")) {
      System.out.println("That is not a valid command! You can type \"h\" to solve for the hypotenuse, or you can type \"l\" to solve for a leg: ");
      selection = inputScanner.next();
    }
    switch (selection.toLowerCase()) {
      case "h":
        solveForHypotenuse();
        break;
      case "l":
        solveForLeg();
        break;
    }
    inputScanner.close();
  }
  
  static void solveForLeg() {
    System.out.print("Please enter the length of the hypotenuse: ");
    double hypotenuse = inputScanner.nextDouble();
    System.out.print("Please enter the length of the leg: ");
    double leg = inputScanner.nextDouble();
  
    double result = Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(leg, 2));
    System.out.printf("The length of the leg is %f\n", result);
  }
  
  static void solveForHypotenuse() {
    System.out.print("Please enter the length of the first leg: ");
    double legA = inputScanner.nextDouble();
    System.out.print("Please enter the length of the second leg: ");
    double legB = inputScanner.nextDouble();
    
    double result = Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2));
    System.out.printf("The length of the hypotenuse is %f\n", result);
  }
  
}
