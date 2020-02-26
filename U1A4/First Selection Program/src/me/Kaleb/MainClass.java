package me.Kaleb;

import java.io.BufferedReader;
import java.util.Scanner;

public class MainClass {
  
  public static double discount = 0;
  
  public static void main(String[] args) {
//    Create scanner and ask for user input
    Scanner reader = new Scanner(System.in);
    System.out.println("Welcome to the discount calculator!");
    System.out.print("Please enter the amount that you have spent: $");
//    Ensure that next input is a double
    while (!reader.hasNextDouble()) {
      System.out.println("The amount you have entered is invalid!");
      System.out.print("Please enter the amount that you have spent: $");
      reader.next();
    }
    
    double amountSpent = round(reader.nextDouble(), 2); // Get amount spent from input
    
//    Set discount based off of amount spent
    if (amountSpent >= 120) {
      discount = .40;
    } else if (amountSpent > 80) {
      discount = .30;
    } else if (amountSpent > 40) {
      discount = .20;
    } else if (amountSpent > 0) {
      discount = .10;
    } else {
      System.out.println("You have spent nothing, therefore you receive no discount!");
      return;
    }
    
//    Tell user what their discount is, as well as new total
    System.out.println();
    System.out.println("You spent $" + amountSpent + ", so you save " + (discount * 100) + "% off of your purchase!");
    System.out.println("New total with discount: $" + round(amountSpent - (amountSpent * discount), 2));
  }
  
//  Helper method for rounding
  private static double round(double numberToRound, int decimalPlaces) {
    return (Math.round(numberToRound * Math.pow(10, decimalPlaces))) / Math.pow(10, decimalPlaces);
  }
  
}
