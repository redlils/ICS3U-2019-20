package me.Kaleb;

import me.Kaleb.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  
  private static final List<Command> commands = new ArrayList<>();
  
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
      if (!commandInput.startsWith("!")) {
        // Output invalid command message and start the process over again
        System.out.println("Invalid command!");
        continue;
      }
      
      // Loop through all registered command
      for (Command command : commands) {
        
        // Does the current command match the inputted command?
        if (commandInput.equalsIgnoreCase("!" + command.name)) {
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
  
  private static void registerCommands() {
  
  }
}
