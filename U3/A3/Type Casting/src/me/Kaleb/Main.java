package me.Kaleb;

import java.util.Scanner;

public class Main {
  
  static String name;
  static char lastName;
  static int age;
  static String ageConfirmation;
  static double donationAmount;
  static String donationConfirmation;
  
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Thank you for choosing to donate to x charity!");
    System.out.println("We need a little bit of information before you can donate, however.");
  
    System.out.print("Please enter your name: ");
    name = reader.next();
  
    System.out.print("Please enter the first letter of your last name: ");
    lastName = reader.next().charAt(0);
    
    System.out.print("Please enter your age: ");
    age = reader.nextInt();
  
    System.out.print("Please confirm your age: ");
    ageConfirmation = String.valueOf(reader.nextInt());
  
    System.out.print("Please enter the amount you would like to donate: $");
    donationAmount = reader.nextDouble();
  
    System.out.print("Please confirm the amount you would like to donate: $");
    donationConfirmation = String.valueOf(reader.nextDouble());
  
    System.out.println("Thank you for donating to x charity! Here is the information you gave us:");
    System.out.println();
    System.out.println("First Name: " + name);
    System.out.println("First Letter of Last Name: " + String.valueOf(lastName));
    System.out.println("First Letter of Both Names: " + name.charAt(0) + " " + lastName);
    System.out.println("Age: " + (double) age);
    System.out.println("Age confirmation: " + Integer.parseInt(ageConfirmation));
    System.out.println("Donation amount: " + donationAmount);
    System.out.println("Donation amount confirmation: " + Double.parseDouble(donationConfirmation));
    System.out.println("Donation amount rounded: " + (int) donationAmount);
  }
}
