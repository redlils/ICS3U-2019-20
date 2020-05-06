package me.Kaleb;

import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Kaleb's Counter");
    System.out.println("Welcome! Please select a counting option!");
    System.out.println("1... Count from 0 to 10 by 1");
    System.out.println("2... Count from 100 to 0 by 10");
    System.out.println("3... Count from 50 to 500 by 50");
    System.out.println("4... Count from 6000 to 1000 by 1000");
  
    int selection = Integer.parseInt(getInput(reader, "[1-4]", null));
    
    switch (selection) {
      case 1:
        System.out.println("You have chosen to count to 10 by 1, starting at 0.");
        for (int i = 0; i <= 10; i += 1) {
          System.out.println(i);
        }
        break;
      case 2:
        System.out.println("You have chosen to count to 0 by 10, starting at 100.");
        for (int i = 100; i >=0; i -= 10) {
          System.out.println(i);
        }
        break;
      case 3:
        System.out.println("You have chosen to count to 500 by 50, starting at 50.");
        for (int i = 50; i <= 500; i += 50) {
          System.out.println(i);
        }
        break;
      case 4:
        System.out.println("You have chosen to count to 1000 by 1000, starting at 6000.");
        for (int i = 6000; i >= 1000; i -= 1000) {
          System.out.println(i);
        }
        break;
    }
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
    if (prompt != null) {
      System.out.println(prompt);
    }
    
    while (!reader.hasNext(validInput)) {
      if (prompt != null) {
        System.out.println(prompt);
      }
      reader.next();
    }
    return reader.next();
  }
}
