package me.Kaleb.settings;

public class StringSetting extends Setting<String> {
  /**
   * Constructor
   *
   * @param name  The name of the setting
   * @param value The value of the setting
   */
  public StringSetting(String name, String value) {
    super(name, value);
  }
  
  /**
   * Set the value of the setting via {@link String} input
   *
   * @param value The value to set
   */
  @Override
  public void setValue(String value) {
    this.value = value;
  }
}
