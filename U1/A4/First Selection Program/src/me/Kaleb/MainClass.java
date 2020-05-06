package me.Kaleb;

import java.util.Scanner;

import static me.Kaleb.NumberUtils.*;

public class MainClass {
  
  public static double discount = 0; // Initialize discount with default value (using decimals for easier math)
  
  public static void main(String[] args) {
  
//    Create scanner and ask for user input
    Scanner reader = new Scanner(System.in);
    System.out.println("Welcome to the discount calculator!");
    System.out.print("Please enter the amount that you have spent: $");
    
//    Ensure that the user inputs a double
    while (!reader.hasNextDouble()) {
      System.out.println("The amount you have entered is invalid!");
      System.out.print("Please enter the amount that you have spent: $");
      reader.next();
    }
    
//    Get amount spent from input, round it, and store it in a variable
//    round() function located in separate module (Helpers)
//    Module accessible via GitHub: https://github.com/Kalcoder/ICS3U-2019-20/tree/master/Helpers
//    Function accessible via GitHub: https://github.com/Kalcoder/ICS3U-2019-20/tree/master/Helpers/src/me/Kaleb/NumberUtils.java
    double amountSpent = round(reader.nextDouble(), 2);
    
//    Check if user has spent anything
    if (amountSpent == 0 || amountSpent < 0) {
      System.out.println("You have spent nothing, therefore you receive no discount!");
      return;
    }
    
//    Set discount based off of amount spent
    if (amountSpent >= 120) {
      discount = .40;
    } else if (amountSpent > 80) {
      discount = .30;
    } else if (amountSpent > 40) {
      discount = .20;
    } else {
      discount = .10;
    }
    
//    Tell user what their discount is, as well as new total
    System.out.println();
    System.out.println("You spent $" + amountSpent + ", so you save " + (discount * 100) + "% off of your purchase!");
    System.out.println("New total with discount: $" + round(amountSpent - (amountSpent * discount), 2));
  }
}
