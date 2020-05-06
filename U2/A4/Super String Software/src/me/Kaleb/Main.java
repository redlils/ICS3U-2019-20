package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main {
  // Auto-generated variables
  private JTextField txtLength;
  private JTextField txtCaps;
  private JTextField txtFourth;
  private JTextField txtIdenticalOne;
  private JTextField txtIdenticalTwo;
  private JTextField txtFindOne;
  private JTextField txtFindTwo;
  private JTextField txtSub;
  private JTextField txtReplace;
  private JButton btnLength;
  private JButton btnCaps;
  private JButton btnFourth;
  private JButton btnIdentical;
  private JButton btnFind;
  private JButton btnSub;
  private JButton btnReplace;
  private JLabel lblLength;
  private JLabel lblCaps;
  private JLabel lblFourth;
  private JLabel lblIdentical;
  private JLabel lblFind;
  private JLabel lblSub;
  private JLabel lblReplace;
  private JPanel pnlMain;
  
  // Constructor to register all event listeners
  public Main() {
    btnLength.addActionListener(this::lengthClicked);
    btnCaps.addActionListener(this::capsClicked);
    btnFourth.addActionListener(this::fourthClicked);
    btnIdentical.addActionListener(this::identicalClicked);
    btnFind.addActionListener(this::findClicked);
    btnSub.addActionListener(this::subClicked);
    btnReplace.addActionListener(this::replaceClicked);
  }
  
  // Main entry point
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    // Set look and feel
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    // Create and display the program
    JFrame frame = new JFrame("Main");
    frame.setContentPane(new Main().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
  // Event listener for when the length button is clicked
  private void lengthClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".+", txtLength.getText())) return; // Validate input with RegEx
    
    // Calculate and store length of inputted string
    int length = txtLength.getText().length();
    
    // Display length
    lblLength.setText(String.valueOf(length));
  }
  
  // Event listener for when the caps button is clicked
  private void capsClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".+", txtCaps.getText())) return; // Validate input with RegEx
    
    // Change inputted string to all caps
    String caps = txtCaps.getText().toUpperCase();
    
    // Display changed string
    lblCaps.setText(caps);
  }
  
  // Event listener for when the fourth button is clicked
  private void fourthClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".{4,}", txtFourth.getText())) return; // Validate input with RegEx
    
    // Retrieve and store the fourth character in the inputted string
    char fourth = txtFourth.getText().charAt(3);
    
    lblFourth.setText(String.valueOf(fourth));
  }
  
  // Event listener for when the identical button is clicked
  private void identicalClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".+", txtIdenticalOne.getText(), txtIdenticalTwo.getText())) return; // Validate input with RegEx
    
    // Store inputted Strings in variables
    String identicalOne = txtIdenticalOne.getText();
    String identicalTwo = txtIdenticalTwo.getText();
    
    // Display identicalOne.equals(identicalTwo) result
    lblIdentical.setText(String.valueOf(identicalOne.equals(identicalTwo)));
  }
  
  // Event listener for when the find button is clicked
  private void findClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".+", txtFindOne.getText(), txtFindTwo.getText())) return; // Validate input with RegEx
    
    // Store inputted Strings in variables
    String findText = txtFindOne.getText();
    String findChar = txtFindTwo.getText();
    
    // Display findText.contains(findChar)
    lblFind.setText(String.valueOf(findText.contains(findChar)));
  }
  
  // Event listener for when the substring button is clicked
  private void subClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".{8,}", txtSub.getText())) return; // Validate input with RegEx
    
    // Store inputted String in variable
    String sub = txtSub.getText();
    
    // Retrieve and display the 4th-6th characters from inputted String
    lblSub.setText(sub.substring(3, 6));
  }
  
  // Event listener for when the replace button is clicked
  private void replaceClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".*a+.*", txtReplace.getText())) return; // Validate input with RegEx
    
    // Store inputted String in variable
    String replace = txtReplace.getText();
    
    // Replace all "a" with "x" in inputted String and display result
    lblReplace.setText(replace.replace("a", "x"));
  }
  
  /**
   * Helper method for validating input
   *
   * @param validInput RegEx pattern for input matching
   * @param inputs The inputs to check against the entered RegEx pattern
   * @return If the given inputs were valid
   */
  @SuppressWarnings("BooleanMethodIsAlwaysInverted")
  private boolean validate(String validInput, String... inputs) {
    // Loop though inputted Strings
    for (String input : inputs) {
      // Match against validInput
      if (!input.matches(validInput)) {
        // If it failed, show an error message and return false
        JOptionPane.showMessageDialog(pnlMain, "You have invalid inputs! Please check to make sure that they are valid and try again!", "Invalid inputs", JOptionPane.ERROR_MESSAGE);
        return false;
      }
    }
    // Only reached if all inputs were valid
    return true;
  }
}
