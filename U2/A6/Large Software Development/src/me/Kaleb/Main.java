package me.Kaleb;

import me.Kaleb.commands.Command;
import me.Kaleb.commands.HelpCommand;

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
    
    // Register commands
    registerCommands();
    
    // Output welcome message
    System.out.println("welcome message");
    
    // Infinite loop
    while (true) {
      // Prompt for command
      System.out.print("Please enter a command (you can type !help to get a list of commands): ");
      
      // Get command from input
      commandInput = reader.nextLine();
  
      // Does the command start with the prefix
      if (!commandInput.startsWith(Settings.prefix)) {
        // Output invalid command message and start the process over again
        System.out.println("Invalid command!");
        continue;
      }
      
      // Loop through all registered command
      for (Command command : commands) {
        
        // Does the current command match the inputted command?
        if (commandInput.equalsIgnoreCase(Settings.prefix + command.name)) {
          // Execute the command (exit command will handle itself)
          command.execute();
          break;
        }
        
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
   * Function used to register every {@link me.Kaleb.commands.Command}
   * @see #commands
   */
  private static void registerCommands() {
    commands.add(new HelpCommand());
  }
}
