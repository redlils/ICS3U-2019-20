package me.Kaleb.commands;

import me.Kaleb.libs.UserMenuBuilder;
import me.Kaleb.settings.Setting;
import me.Kaleb.Settings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Command to change a specified setting
 */
public class SettingsCommand extends Command {
  
  /**
   * Constructor
   */
  public SettingsCommand() {
    super("settings", Arrays.asList("config", "options", "s"), "Changes a specified setting", "settings");
  }
  
  /**
   * Function called when the command is entered
   *
   * @param args The arguments passed to the command
   */
  @Override
  public void execute(String[] args) {
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
