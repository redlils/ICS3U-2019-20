package me.Kaleb;

import java.util.Scanner;

/**
 * Main class for the "<b>Data Validation and Testing Data</b>" assignment for <b>U3A1</b> of the <b>ICS3U</b> course.
 */
public class Main {
  
  /**
   * Prompts for each stage
   */
  static String[] stages = new String[] {
          "Please enter a string that is greater than 6 characters long.",
          "Please enter a string that contains at least one lowercase “a”.",
          "Please enter a string that is between 5 and 15 characters long and does not contain the letter “z”.",
          "Please enter an integer between 5 and 500.",
          "Please enter a negative integer.",
          "Please enter a positive, odd integer."
  };
  
  /**
   * Input {@link Validator}s for each stage
   */
  static Validator[] stageValidators = new Validator[] {
          stageOne -> stageOne.length() > 6,
          stageTwo -> stageTwo.contains("a"),
          stageThree -> stageThree.length() > 5 && stageThree.length() < 15 && !stageThree.contains("z"),
          stageFour -> {
            try {
              return Integer.parseInt(stageFour) >= 5 && Integer.parseInt(stageFour) <= 500;
            } catch (NumberFormatException e) {
              return false;
            }
          },
          stageFive -> {
            try {
              return Integer.parseInt(stageFive) < 0;
            } catch (NumberFormatException e) {
              return false;
            }
          },
          stageSix -> {
            try {
              return Integer.parseInt(stageSix) > 0 && Integer.parseInt(stageSix) % 2 == 1;
            } catch (NumberFormatException e) {
              return false;
            }
          }
  };
  
  /**
   * Main entry point for the program
   *
   * @param args The arguments passed by the executor
   */
  public static void main(String[] args) {
    // Initialize the Scanner to use for input
    Scanner reader = new Scanner(System.in);
    
    // Loop through every stage
    for (int stage = 0; stage < stages.length;) {
      
      // Print out the current stage prompt
      System.out.println(stages[stage]);
      
      // Get input
      String message = reader.nextLine();
      
      // Validate message using current stage validator
      if (!stageValidators[stage].validate(message)) {
        // If the message was invalid, output a message and loop the same stage
        System.out.println("Invalid message!");
      } else {
        // If the message was valid, increase stage by 1 to move on to the next stage if possible
        stage++;
      }
    }
  
    // Output congratulatory message when the user makes it past every stage
    System.out.println("Congratulations! You made it past every stage!");
  }
}
