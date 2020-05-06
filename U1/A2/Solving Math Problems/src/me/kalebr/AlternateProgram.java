package me.kalebr;

import java.util.Scanner;

public class AlternateProgram {
  
  static Scanner inputScanner;
  
  public static void main(String[] args) {
    inputScanner = new Scanner(System.in);
    System.out.print("Hello! Welcome to Kaleb's area solver! Please enter in your rectangle's length: ");
    double length = inputScanner.nextDouble();
    System.out.print("Please enter in your rectangle's height: ");
    double height = inputScanner.nextDouble();
  
    System.out.println("The area is " + length * height);
  }
  
}
