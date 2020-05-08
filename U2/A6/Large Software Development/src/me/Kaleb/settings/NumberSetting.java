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
  
  /**
   * Set the value of the setting via {@link String} input
   *
   * @param value The value to set
   */
  @Override
  public void setValue(String value) {
    this.value = Double.parseDouble(value);
  }
}
