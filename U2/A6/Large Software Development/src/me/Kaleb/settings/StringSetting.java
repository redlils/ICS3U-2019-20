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
  
  @Override
  public void setValue(String value) {
    this.value = value;
  }
}
