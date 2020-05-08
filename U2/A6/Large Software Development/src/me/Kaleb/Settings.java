package me.Kaleb;

import me.Kaleb.settings.Setting;

import java.util.ArrayList;
import java.util.List;

/**
 * All settings used by the program
 */
public class Settings {
  
  /**
   * The list of settings
   */
  public static List<Setting<?>> settings = new ArrayList<>();
  
  /**
   * Get a {@link Setting} from it's name
   *
   * @param name The name to search with
   * @return The {@link Setting} that was found
   */
  public static Setting<?> getSetting(String name) {
    for (Setting<?> setting : settings) {
      if (setting.getName().equalsIgnoreCase(name)) {
        return setting;
      }
    }
    return null;
  }
}
