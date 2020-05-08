package me.Kaleb.commands;

import me.Kaleb.Main;

/**
 * Represents a command that can be entered
 */
public abstract class Command {
  
  /**
   * The name of the command
   */
  public String name;
  
  /**
   * Constructor
   *
   * @param name The name of the command
   */
  public Command(String name) {
    this.name = name;
    Main.commands.add(this);
  }
  
  /**
   * Function called when the command is entered
   */
  public abstract void execute();
}
