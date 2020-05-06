package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main {
  // Auto-generated variables
  private JTextField txtMaxOne;
  private JTextField txtMaxTwo;
  private JTextField txtMinOne;
  private JTextField txtMinTwo;
  private JTextField txtPowerBase;
  private JTextField txtPowerExponent;
  private JTextField txtHypOne;
  private JTextField txtHypTwo;
  private JTextField txtFloor;
  private JTextField txtCeil;
  private JTextField txtSqrt;
  private JTextField txtRad;
  private JButton btnMax;
  private JButton btnMin;
  private JButton btnPower;
  private JButton btnHyp;
  private JButton btnFloor;
  private JButton btnCeil;
  private JButton btnSqrt;
  private JButton btnRad;
  private JLabel lblMax;
  private JLabel lblMin;
  private JLabel lblPower;
  private JLabel lblHyp;
  private JLabel lblFloor;
  private JLabel lblCeil;
  private JLabel lblSqrt;
  private JLabel lblRad;
  private JPanel pnlMain;
  
  // Constructor to register all event listeners
  public Main() {
    btnMax.addActionListener(this::maxClicked);
    btnMin.addActionListener(this::minClicked);
    btnPower.addActionListener(this::powerClicked);
    btnHyp.addActionListener(this::hypClicked);
    btnFloor.addActionListener(this::floorClicked);
    btnCeil.addActionListener(this::ceilClicked);
    btnSqrt.addActionListener(this::sqrtClicked);
    btnRad.addActionListener(this::radClicked);
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
  
  // Event listener for when the max button is clicked
  private void maxClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtMaxOne.getText(), txtMaxTwo.getText())) return; // Validate input with RegEx
    
    // Store inputted numbers in variables
    int maxOne = Integer.parseInt(txtMaxOne.getText());
    int maxTwo = Integer.parseInt(txtMaxTwo.getText());
  
    // Calculate max of two inputted numbers and display result
    lblMax.setText(String.valueOf(Math.max(maxOne, maxTwo)));
  }
  
  // Event listener for when the min button is clicked
  private void minClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtMinOne.getText(), txtMinTwo.getText())) return; // Validate input with RegEx
  
    // Store inputted numbers in variables
    int minOne = Integer.parseInt(txtMinOne.getText());
    int minTwo = Integer.parseInt(txtMinTwo.getText());
    
    // Calculate min of two inputted numbers and display result
    lblMin.setText(String.valueOf(Math.min(minOne, minTwo)));
  }
  
  // Event listener for when the power button is clicked
  private void powerClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtPowerBase.getText(), txtPowerExponent.getText())) return; // Validate input with RegEx
  
    // Store inputted numbers in variables
    int powerBase = Integer.parseInt(txtPowerBase.getText());
    int powerExponent = Integer.parseInt(txtPowerExponent.getText());
  
    // Calculate power of two inputted numbers and display result
    lblPower.setText(String.valueOf(Math.pow(powerBase, powerExponent)));
  }
  
  // Event listener for when the hypotenuse button is clicked
  private void hypClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtHypOne.getText(), txtHypTwo.getText())) return; // Validate input with RegEx
  
    // Store inputted numbers in variables
    int hypOne = Integer.parseInt(txtHypOne.getText());
    int hypTwo = Integer.parseInt(txtHypTwo.getText());
  
    // Calculate hypotenuse of two inputted numbers and display result
    lblHyp.setText(String.valueOf(Math.hypot(hypOne, hypTwo)));
  }
  
  // Event listener for when the floor button is clicked
  private void floorClicked(ActionEvent e) {
    if (!validate("[1-9]+\\.[1-9]+", txtFloor.getText())) return; // Validate input with RegEx
  
    // Store inputted double in variable
    double floor = Double.parseDouble(txtFloor.getText());
    
    // Calculate floor of the inputted number and display result
    lblFloor.setText(String.valueOf(Math.floor(floor)));
  }
  
  // Event listener for when the ceiling button is clicked
  private void ceilClicked(ActionEvent e) {
    if (!validate("[1-9]+\\.[1-9]+", txtCeil.getText())) return; // Validate input with RegEx
  
    // Store inputted double in variable
    double ceil = Double.parseDouble(txtCeil.getText());
  
    // Calculate ceil of the inputted number and display result
    lblCeil.setText(String.valueOf(Math.ceil(ceil)));
  }
  
  // Event listener for when the square root button is clicked
  private void sqrtClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtSqrt.getText())) return; // Validate input with RegEx
  
    // Store inputted number in variable
    int sqrt = Integer.parseInt(txtSqrt.getText());
  
    // Calculate sqrt of the inputted number and display result
    lblSqrt.setText(String.valueOf(Math.sqrt(sqrt)));
  }
  
  // Event listener for when the radians button is clicked
  private void radClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtRad.getText())) return; // Validate input with RegEx
  
    // Store inputted number in variable
    int rad = Integer.parseInt(txtRad.getText());
  
    // Calculate deg->radians of the inputted number and display result
    lblRad.setText(String.valueOf(Math.toRadians(rad)));
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
