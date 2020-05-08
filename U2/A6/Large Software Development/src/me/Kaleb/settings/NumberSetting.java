package me.Kaleb.settings;

public class NumberSetting extends Setting<Number> {
  
  /**
   * Constructor
   *
   * @param name  The name of the setting
   * @param value The value of the setting
   */
  public NumberSetting(String name, Number value) {
    super(name, value);
  }
  
  public void setValue(String value) {
    this.value = Double.parseDouble(value);
  }
}
