package me.Kaleb;

/**
 * Interface for validating input
 */
public interface Validator {
  /**
   * Validates input
   *
   * @param message The input to validate
   * @return If the message was valid
   */
  boolean validate(String message);
}
