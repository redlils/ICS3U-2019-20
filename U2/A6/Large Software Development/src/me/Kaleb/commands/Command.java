package me.Kaleb.commands;

import me.Kaleb.Main;

public abstract class Command {
  
  public String name;
  
  public Command(String name) {
    this.name = name;
    Main.commands.add(this);
  }
  
  public abstract void execute();
}
