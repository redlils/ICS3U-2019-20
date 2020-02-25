package me.Kaleb;

import java.io.BufferedReader;
import java.util.Scanner;

public class MainClass {
  
  public static double discount = 0;
  
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Welcome to the discount calculator!");
    System.out.print("Please enter the amount that you have spent: $");
    double amountSpent = reader.nextDouble();
    
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
  
    System.out.println();
    System.out.println("You spent $" + amountSpent + ", so you save " + discount + "% off of your purchase!");
    System.out.println("New total with discount: $" + (amountSpent - (amountSpent * discount)));
  }
  
}
