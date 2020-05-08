package me.Kaleb.commands;

import me.Kaleb.libs.UserMenuBuilder;
import me.Kaleb.settings.Setting;
import me.Kaleb.Settings;

import java.util.Scanner;

public class SettingsCommand extends Command {
  
  public SettingsCommand() {
    super("settings");
  }
  
  @Override
  public void execute() {
    Scanner reader = new Scanner(System.in);
    UserMenuBuilder settingsMenuBuilder = new UserMenuBuilder()
            .setTitle("Modify a Setting")
            .setPrompt("Please select a setting to modify from the following list");
    for (Setting<?> setting : Settings.settings) {
      settingsMenuBuilder.addOption(setting.getName());
    }
    int settingSelection = settingsMenuBuilder.build().present();
    Setting<?> setting = Settings.settings.get(settingSelection);
  
    System.out.print("Please enter a new value for " + setting.getName() + ": ");
    setting.setValue(reader.nextLine());
    System.out.println("The setting " + setting.getName() + " now has a value of " + setting.getValue() + "!");
  }
}
