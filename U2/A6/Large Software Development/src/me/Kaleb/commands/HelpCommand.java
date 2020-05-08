package me.Kaleb.commands;

import me.Kaleb.Main;
import me.Kaleb.Settings;

public class HelpCommand extends Command{
  
  /**
   * Constructor
   */
  public HelpCommand() {
    super("help");
  }
  
  /**
   * Function called when the command is entered
   */
  @Override
  public void execute() {
    System.out.println("Here are all of the commands:");
    for (Command command : Main.commands) {
      System.out.println(Settings.getSetting("prefix").getValue() + command.name);
    }
  }
}
