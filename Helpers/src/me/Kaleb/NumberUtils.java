package me.Kaleb;

public class NumberUtils {
  
  /**
   * Round a double
   *
   * @param numberToRound The number to round
   * @param decimalPlaces The amount of decimal places to round to
   * @return The rounded number
   */
  public static double round(double numberToRound, int decimalPlaces) {
    return Math.round(Math.pow(10, decimalPlaces) * numberToRound) / Math.pow(10, decimalPlaces);
  }
  
}
