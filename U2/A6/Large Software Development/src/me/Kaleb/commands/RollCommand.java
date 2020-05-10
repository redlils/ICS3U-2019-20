package me.Kaleb.commands;

import me.Kaleb.NumberUtils;

import java.util.Random;
import java.util.Scanner;

public class RollCommand extends Command {
  
  private int correct;
  private int rolls;
  
  /**
   * Constructor
   */
  public RollCommand() {
    super("roll");
  }
  
  /**
   * Function called when the command is entered
   */
  @Override
  public void execute() {
    Scanner reader = new Scanner(System.in);
    System.out.print("Please enter what you think your next roll will be: ");
    
    while (!reader.hasNext("[1-6]")) {
      System.out.print("Please enter what you think your next roll will be: ");
      reader.next();
    }
    int guess = reader.nextInt();
    
    Random random = new Random();
    int roll = random.nextInt(6) + 1;
    
    rolls++;
    correct += guess == roll ? 1 : 0;
    
    System.out.println("You rolled a " + roll + "!");
    System.out.println("Your guess was " + (guess == roll ? "correct!" : "incorrect."));
    System.out.println("You have guessed a total of " + correct + " rolls correctly.");
    System.out.println("Your percentage of correctly guessed rolls is " + NumberUtils.round((double) correct / rolls, 3) * 100 + "%");
  }
}
