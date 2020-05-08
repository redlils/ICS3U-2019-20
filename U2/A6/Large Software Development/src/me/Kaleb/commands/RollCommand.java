package me.Kaleb.commands;

import java.util.Random;

public class RollCommand extends Command {
  
  /**
   * Constructor
   *
   * @param name The name of the command
   */
  public RollCommand() {
    super("roll");
  }
  
  /**
   * Function called when the command is entered
   */
  @Override
  public void execute() {
    Random random = new Random();
    int roll = random.nextInt(6) + 1;
    System.out.println("You rolled a " + roll + "!");
  }
}
