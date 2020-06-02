package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Main class for the "<b>Creating an Encryption Program</b>" assignment for <b>U3A3</b> of the <b>ICS3U</b> course.
 */
public class Main {
  /**
   * The main panel for the program
   */
  private JPanel pnlMain;
  
  /**
   * The text field that the user can input the message to be encrypted by reversing
   */
  private JTextField txtReverseEncryptMessage;
  /**
   * The button that the user can click to encrypt the message by reversing
   */
  private JButton btnReverseEncrypt;
  /**
   * The text field that displays the encrypted message by reversing
   */
  private JTextField txtReverseEncryptResult;
  
  /**
   * The text field that the user can input the message to be decrypted by reversing
   */
  private JTextField txtReverseDecryptMessage;
  /**
   * The button that the user can click to decrypt the message by reversing
   */
  private JButton btnReverseDecrypt;
  /**
   * The text field that displays the decrypted message by reversing
   */
  private JTextField txtReverseDecryptResult;
  
  /**
   * The text field that the user can rotation amount to use when encrypting/decrypting using ROT13
   */
  private JTextField txtROTAmount;
  
  /**
   * The text field that the user can input the message to be encrypted by ROT13
   */
  private JTextField txtROTEncryptMessage;
  /**
   * The button that the user can click to encrypt the message by ROT13
   */
  private JButton btnROTEncrypt;
  /**
   * The text field that the user can input the message to be encrypted by ROT13
   */
  private JTextField txtROTEncryptResult;
  
  /**
   * The text field that the user can input the message to be decrypted by ROT13
   */
  private JTextField txtROTDecryptMessage;
  /**
   * The button that the user can click to decrypt the message by ROT13
   */
  private JButton btnROTDecrypt;
  /**
   * The text field that the user can input the message to be decrypted by ROT13
   */
  private JTextField txtROTDecryptResult;
  
  /**
   * Constructor
   */
  public Main() {
    btnReverseEncrypt.addActionListener(this::reverseEncryptClicked);
    btnReverseDecrypt.addActionListener(this::reverseDecryptClicked);
    btnROTEncrypt.addActionListener(this::rotEncryptClicked);
    btnROTDecrypt.addActionListener(this::rotDecryptClicked);
  }
  
  /**
   * Main entry point for <b>Creating an Encryption Program</b>
   *
   * @param args The arguments passed by the program's executor
   *
   * @throws ClassNotFoundException If className in {@link UIManager#setLookAndFeel} does not identify a class that extends {@link LookAndFeel}
   * @throws UnsupportedLookAndFeelException If the {@link LookAndFeel} class could not be found using {@link UIManager#setLookAndFeel}
   * @throws InstantiationException If a new instance of the class couldn't be created using {@link UIManager#setLookAndFeel}
   * @throws IllegalAccessException If the class or initializer isn't accessible using {@link UIManager#setLookAndFeel}
   */
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    JFrame frame = new JFrame("Main");
    frame.setContentPane(new Main().pnlMain);
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
  /**
   * Method used for encrypting messages by reversing them
   *
   * @param e The event passed when clicking the encrypt button
   */
  private void reverseEncryptClicked(ActionEvent e) {
    // Convert the String into a char[]
    char[] encryptMessageChars = txtReverseEncryptMessage.getText().toCharArray();
    
    // Declare a variable for the reversed message
    String reversedMessage = "";
  
    // Loop through all the characters and reverse the order
    for (int i = encryptMessageChars.length - 1; i > -1; i--) {
      // Add the characters to the reversedMessage variable in reverse order
      reversedMessage += encryptMessageChars[i];
    }
  
    // Output the reversed message
    txtReverseEncryptResult.setText(reversedMessage);
  }
  
  /**
   * Method used for decrypting messages by reversing them
   *
   * @param e The event passed when clicking the decrypt button
   */
  private void reverseDecryptClicked(ActionEvent e) {
    // Convert the String into a char[]
    char[] decryptMessageChars = txtReverseDecryptMessage.getText().toCharArray();
  
    // Declare a variable for the reversed message
    String reversedMessage = "";
  
    // Loop through all the characters and reverse the order
    for (int i = decryptMessageChars.length - 1; i > -1; i--) {
      // Add the characters to the reversedMessage variable in reverse order
      reversedMessage += decryptMessageChars[i];
    }
  
    // Output the reversed message
    txtReverseDecryptResult.setText(reversedMessage);
  }
  
  /**
   * Method used for encrypting messages by using ROT13
   *
   * @param e The event passed when clicking the encrypt button
   */
  private void rotEncryptClicked(ActionEvent e) {
    // Convert the String into a char[]
    char[] encryptMessageChars = txtROTEncryptMessage.getText().toCharArray();
  
    // Declare 2 variables for the encrypted message and the rotation amount
    String encryptedMessage = "";
    int rotAmount;
  
    // Attempt to get the rotation amount from txtROTAmount
    try {
      rotAmount = Integer.parseInt(txtROTAmount.getText());
      
      // If the rotation amount is not between 1 and 26, throw an IllegalArgumentException to enter the catch and output an error message
      if (rotAmount < 1 || rotAmount > 25) throw new IllegalArgumentException();
    } catch (Exception exception) {
      // Show an error message if the try threw an error
      JOptionPane.showMessageDialog(pnlMain, "The rotation amount you have entered is invalid!");
      return;
    }
  
    // Loop through all the characters and encrypt them
    for (char c : encryptMessageChars) {
      // Handle uppercase letters
      if (c > 64 && c < 91) {
        // Change the current character based on the rotation amount
        c += rotAmount - (c + rotAmount > 90 ? 26 : 0);
      }
      // Handle lowercase letters
      else if (c > 96 && c < 123) {
        // Change the current character based on the rotation amount
        c += rotAmount - (c + rotAmount > 122 ? 26 : 0);
      }
  
      // Add the resulting character to the final encrypted message
      encryptedMessage += (char) c;
    }
  
    // Output the encrypted message
    txtROTEncryptResult.setText(encryptedMessage);
  }
  
  /**
   * Method used for decrypting messages by using ROT13
   *
   * @param e The event passed when clicking the decrypt button
   */
  private void rotDecryptClicked(ActionEvent e) {
    // Convert the String into a char[]
    char[] decryptMessageChars = txtROTDecryptMessage.getText().toCharArray();
    
    // Declare 2 variables for the decrypted message and the rotation amount
    String decryptedMessage = "";
    int rotAmount;
  
    // Attempt to get the rotation amount from txtROTAmount
    try {
      rotAmount = Integer.parseInt(txtROTAmount.getText());
      
      // If the rotation amount is not between 1 and 26, throw an IllegalArgumentException to enter the catch and output an error message
      if (rotAmount < 1 || rotAmount > 25) throw new IllegalArgumentException();
    } catch (Exception exception) {
      // Show an error message if the try threw an error
      JOptionPane.showMessageDialog(pnlMain, "The rotation amount you have entered is invalid!");
      return;
    }
  
    // Loop through all the characters and decrypt them
    for (char c : decryptMessageChars) {
      // Handle uppercase letters
      if (c > 64 && c < 91) {
        // Change the current character based on the rotation amount
        c -= rotAmount - (c - rotAmount < 65 ? 26 : 0);
      }
      // Handle lowercase letters
      else if (c > 96 && c < 123) {
        // Change the current character based on the rotation amount
        c -= rotAmount - (c - rotAmount < 97 ? 26 : 0);
      }
      
      // Add the resulting character to the final decrypted message
      decryptedMessage += c;
    }
    
    // Output the decrypted message
    txtROTDecryptResult.setText(decryptedMessage);
  }
}
