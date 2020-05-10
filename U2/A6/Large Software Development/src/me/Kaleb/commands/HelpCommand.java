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
    // Check if any commands were passed in
    if (args.length == 0) {
      // Print all of the commands
      System.out.println("Here are all of the commands:");
      for (Command command : Main.commands) {
        System.out.println(Settings.getSetting("prefix").getValue() + command.name);
      }
      return;
    }
  
    // Loop through every command
    for (Command command :
            Main.commands) {
      // If the command passed through the arguments is equal to the current command, output information about the command
      if (args[0].equalsIgnoreCase(command.name)) {
        System.out.println(Settings.getSetting("prefix").getValue() + command.name);
        System.out.println("-----------------------------");
        System.out.println("Description");
        System.out.println(command.description);
        System.out.println();
        System.out.println("Usage");
        System.out.println(Settings.getSetting("prefix").getValue() + command.usage);
        System.out.println();
        System.out.println("Aliases");
        String argsString = Arrays.toString(command.aliases.toArray());
        System.out.println(argsString.substring(1, argsString.length() - 1));
        System.out.println("-----------------------------");
        return;
      }
    }
    
    // This message will only be reached if the command passed through the arguments was not found
    System.out.println("One or more of your arguments are incorrect! Please try again!");
  }
}
