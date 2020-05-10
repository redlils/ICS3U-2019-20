package me.Kaleb;

import me.Kaleb.commands.*;
import me.Kaleb.settings.Setting;
import me.Kaleb.settings.StringSetting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Main class for the "<b>Large Software Development</b>" assignment for <b>U2A6</b> of the <b>ICS3U</b> course.
 */
public class Main {
  
  /**
   * The list of registered commands
   * @see #registerCommands()
   */
  public static final List<Command> commands = new ArrayList<>();
  
  /**
   * The main entry point of the program
   *
   * @param args Arguments provided by the executor
   */
  public static void main(String[] args) {
    // Create variables needed for the program
    Scanner reader = new Scanner(System.in);
    
    String commandInput;
    
    // Register settings
    registerSettings();
    
    // Register commands
    registerCommands();
    
    // Output welcome message
    System.out.println("welcome message");
    
    // Infinite loop
    //noinspection InfiniteLoopStatement
    while (true) {
      // Prompt for command
      System.out.print("Please enter a command (you can type " + Settings.getSetting("prefix").getValue() + "help to get a list of commands): ");
      
      // Get command from input
      commandInput = reader.nextLine();
  
      // Does the command start with the prefix
      if (!commandInput.startsWith((String) Settings.getSetting("prefix").getValue())) {
        // Output invalid command message and start the process over again
        System.out.println("Invalid command!");
        continue;
      }
      
      // Loop through all registered command
      for (Command command : commands) {
        
        // Does the current command match the inputted command?
        if (commandInput.startsWith(Settings.getSetting("prefix").getValue() + command.name)) {
          String[] commandArgs = commandInput.substring(((String) Settings.getSetting("prefix").getValue()).length() + command.name.length()).split(" +");
          // Execute the command (exit command will handle itself)
          command.execute(commandArgs);
          break;
        }
        boolean aliasFound = false;
        for (String alias :
                command.aliases) {
          if (commandInput.startsWith(Settings.getSetting("prefix").getValue() + alias)) {
            String[] commandArgs = commandInput.substring(((String) Settings.getSetting("prefix").getValue()).length() + alias.length()).split(" +");
            // Execute the command (exit command will handle itself)
            command.execute(commandArgs);
            aliasFound = true;
          }
        }
        
        if (aliasFound) break;
        
        // Is this the last item in the list?
        if (commands.size() - 1 == commands.indexOf(command)) {
          // Output invalid command message and start the process over again
          System.out.println("Invalid command!");
          break;
        }
      }
    }
  }
  
  /**
   * Functions used to register every {@link Setting}
   * @see Settings#settings
   * @see Setting
   */
  private static void registerSettings() {
    new StringSetting("prefix", "!");
  }
  
  /**
   * Function used to register every {@link me.Kaleb.commands.Command}
   * @see #commands
   * @see Command
   */
  private static void registerCommands() {
    new HelpCommand();
    new RollCommand();
    new SettingsCommand();
    new ExitCommand();
  }
}
