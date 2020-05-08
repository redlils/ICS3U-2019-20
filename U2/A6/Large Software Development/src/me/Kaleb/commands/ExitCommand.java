package me.Kaleb.commands;

import me.Kaleb.InputUtils;

import java.util.Scanner;

public class ExitCommand extends Command {
  
  /**
   * Constructor
   */
  public ExitCommand() {
    super("exit");
  }
  
  /**
   * Function called when the command is entered
   */
  @Override
  public void execute() {
    Scanner reader = new Scanner(System.in);
    boolean exit = InputUtils.confirm("Are you sure you wish to exit?", reader);
    if (exit) {
      System.out.println("Goodbye!");
      System.exit(0);
    }
  }
}
