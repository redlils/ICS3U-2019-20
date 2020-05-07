package me.Kaleb;

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
      if (setting.name.equalsIgnoreCase(name)) {
        return setting;
      }
    }
    return null;
  }
  
  /**
   * Represents a setting used by the program
   *
   * @param <T> The type of setting
   */
  public static class Setting<T> {
    /**
     * The name of the setting
     */
    String name;
    /**
     * The value of the setting
     */
    T value;
  
    /**
     * Constructor
     * @param name The name of the setting
     * @param value The value of the setting
     */
    public Setting(String name, T value) {
      this.name = name;
      this.value = value;
      settings.add(this);
    }
  
    /**
     * Get the value from the Setting
     *
     * @return The value of the setting
     */
    public T getValue() {
      return this.value;
    }
  
    /**
     * Set the value of the setting
     *
     * @param value The value to set
     */
    public void setValue(T value) {
      this.value = value;
    }
  }
}
