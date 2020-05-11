package me.Kaleb.settings;

import me.Kaleb.Settings;

/**
   * Represents a setting used by the program
   *
   * @param <T> The type of setting
   */
public abstract class Setting<T> {
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
    Settings.settings.add(this);
  }

  /**
   * Gets the name of the setting
   *
   * @return The name of the setting
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the value from the setting
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
  
    /**
     * Set the value of the setting via {@link String} input
     *
     * @param value The value to set
     */
  public abstract void setValue(String value);
}
