package me.Kaleb.commands;

import me.Kaleb.Main;
import me.Kaleb.Settings;

public class HelpCommand extends Command{
  
  public HelpCommand() {
    super("help");
  }
  
  @Override
  public void execute() {
    System.out.println("Here are all of the commands:");
    for (Command command : Main.commands) {
      System.out.println(Settings.prefix + command.name);
    }
  }
}
