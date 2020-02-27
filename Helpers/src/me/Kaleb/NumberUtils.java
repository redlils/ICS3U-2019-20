package me.Kaleb;

public class NumberUtils {
  
  public static double round(double numberToRound, int decimalPlaces) {
    return Math.round(Math.pow(10, decimalPlaces) * numberToRound) / Math.pow(10, decimalPlaces);
  }
  
}
