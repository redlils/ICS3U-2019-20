package me.Kaleb.commands;

import me.Kaleb.NumberUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Command to roll a die and try to guess what the result will be
 */
public class RollCommand extends Command {
  
  private int correct;
  private int rolls;
  
  /**
   * Constructor
   */
  public RollCommand() {
    super("roll", Arrays.asList("r"), "Roll a die and try to guess what the result will be.", "roll");
  }
  
  /**
   * Function called when the command is entered
   *
   * @param args The arguments passed to the command
   */
  @Override
  public void execute(String[] args) {
    // Ask for a guess
    Scanner reader = new Scanner(System.in);
    System.out.print("Please enter what you think your next roll will be: ");
    
    // Verify guess
    while (!reader.hasNext("[1-6]")) {
      System.out.print("Please enter what you think your next roll will be: ");
      reader.next();
    }
    int guess = reader.nextInt();
    
    // Generate a random roll from 1-6
    Random random = new Random();
    int roll = random.nextInt(6) + 1;
    
    // Increment rolls counter
    rolls++;
    // Increment correct counter if the guess was correct
    correct += guess == roll ? 1 : 0;
    
    // Output results and stats
    System.out.println("You rolled a " + roll + "!");
    System.out.println("Your guess was " + (guess == roll ? "correct!" : "incorrect."));
    System.out.println("You have guessed a total of " + correct + " rolls correctly.");
    System.out.println("Your percentage of correctly guessed rolls is " + NumberUtils.round((double) correct / rolls, 3) * 100 + "%");
  }
}
