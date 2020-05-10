package me.Kaleb.commands;

import me.Kaleb.Main;
import me.Kaleb.Settings;

import java.util.Arrays;

/**
 * Command to show a list of all commands or get detailed info on a command
 */
public class HelpCommand extends Command{
  
  /**
   * Constructor
   */
  public HelpCommand() {
    super("help", Arrays.asList("?", "h"), "Show a list of all commands or get detailed info on a command", "help [command]");
  }
  
  /**
   * Function called when the command is entered
   *
   * @param args The arguments passed to the command
   */
  @Override
  public void execute(String[] args) {
    System.out.println("Here are all of the commands:");
    for (Command command : Main.commands) {
      System.out.println(Settings.getSetting("prefix").getValue() + command.name);
    }
  }
}
