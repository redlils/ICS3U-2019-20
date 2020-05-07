package me.Kaleb.commands;

import me.Kaleb.Main;

public class HelpCommand extends Command{
  
  public HelpCommand() {
    super("help");
  }
  
  @Override
  public void execute() {
    System.out.println("Here are all of the commands:");
    for (Command command : Main.commands) {
      System.out.println("!" + command.name);
    }
  }
}
