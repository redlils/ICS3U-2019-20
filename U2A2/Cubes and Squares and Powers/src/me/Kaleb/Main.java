package me.Kaleb;

import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Welcome to Cubes and Squares and Powers.");
    
    do {
      System.out.println("What would you like to do?");
      System.out.println();
      System.out.println("1... Find the value of a number squared");
      System.out.println("2... Find the value of a number cubed");
      System.out.println("3... Find the value of a number, to any power");
      System.out.println("4... Exit");
  
      int selection = Integer.parseInt(getInput(reader, "[1-4]", null));
      
      switch (selection) {
        case 1:
          getSquare(reader);
          break;
        case 2:
          getCube(reader);
          break;
        case 3:
          getPower(reader);
          break;
        case 4:
          System.out.println("Goodbye!");
          System.exit(0);
      }
    } while (true);
  }
  
  private static void getSquare(Scanner reader) {
    int numberToSquare = Integer.parseInt(getInput(reader, "\\d+", "Please enter the number you would like to square"));
    System.out.println(numberToSquare + " squared is " + Math.pow(numberToSquare, 2));
  }
  
  private static void getCube(Scanner reader) {
    int numberToCube = Integer.parseInt(getInput(reader, "\\d+", "Please enter the number you would like to cube"));
    System.out.println(numberToCube + " cubed is " + Math.pow(numberToCube, 3));
  }
  
  private static void getPower(Scanner reader) {
    int base = Integer.parseInt(getInput(reader, "\\d+", "Please enter the base of your power"));
    int exponent = Integer.parseInt(getInput(reader, "\\d+", "Please enter the exponent of your power"));
    System.out.println(base + " to the " + exponent + " is " + Math.pow(base, exponent));
  }
  
  /**
   * Gets an input from a Scanner
   *
   * @param reader The Scanner to use
   * @param validInput A RegEx pattern to define what values are accepted
   * @param prompt An optional prompt for the user
   * @return The valid input received from the provided Scanner
   */
  public static String getInput(Scanner reader, String validInput, String prompt) {
    if (prompt != null) System.out.print(prompt + ": ");
    
    while (!reader.hasNext(validInput)) {
      if (prompt != null) System.out.print(prompt + ": ");
      reader.next();
    }
    return reader.next();
  }
  
}
