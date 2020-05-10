package me.Kaleb.commands;

import me.Kaleb.Main;

import java.util.List;

/**
 * Represents a command that can be entered
 */
public abstract class Command {
  
  /**
   * The name of the command
   */
  public String name;
  
  /**
   * The alternate names of the command
   */
  public List<String> aliases;
  
  /**
   * The description of the command
   */
  public String description;
  
  /**
   * The usage of the command
   */
  public String usage;
  
  /**
   * Constructor
   * @param name The name of the command
   * @param aliases The aliases of the command
   * @param description The description of the command
   * @param usage The usage of the command
   */
  public Command(String name, List<String> aliases, String description, String usage) {
    this.name = name;
    this.aliases = aliases;
    this.description = description;
    this.usage = usage;
    Main.commands.add(this);
  }
  
  /**
   * Function called when the command is entered
   * @param args The arguments passed to the command
   */
  public abstract void execute(String[] args);
}
