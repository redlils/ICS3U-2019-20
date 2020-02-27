/*
    Created on 2020-02-27 at 3:29 PM
    Author: Kalcoder
*/

package me.Kaleb;

import javax.swing.*;

import java.awt.event.ActionEvent;

import static me.Kaleb.FrmMain.Constants.*;

public class FrmMain {
//  Auto-Generated form variables
  private JPanel panelMain;
  private JButton buttonCalculate;
  private JTextField txtDiameter;
  private JLabel lblSubtotal;
  private JLabel lblTaxes;
  private JLabel lblTotal;
  private JLabel lblFunMessage;
  
//  Add event listeners
  public FrmMain() {
    buttonCalculate.addActionListener(this::calculateButtonClicked);
  }
  
//  Main function
  public static void main(String[] args) {
    JFrame frame = new JFrame("Putrid Pizza");
    frame.setContentPane(new FrmMain().panelMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
//  Calculate button listener
  private void calculateButtonClicked(ActionEvent e) {
    int diameter;
    
//    Ensure that input is valid
    try {
      diameter = Integer.parseInt(txtDiameter.getText());
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(panelMain, INVALID_DIAMETER, "Invalid Diameter", JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (diameter <= 0) {
      JOptionPane.showMessageDialog(panelMain, INVALID_DIAMETER, "Invalid Diameter", JOptionPane.ERROR_MESSAGE);
      return;
    }
    
//    Set fun message based off of diameter
    if (diameter <= 15)
      lblFunMessage.setText("We are going to make you a cute little pizza!");
    else if (diameter >= 20 && diameter <= 40)
      lblFunMessage.setText("This will be delicious!");
    else if (diameter > 40)
      lblFunMessage.setText("Whoa, big pizza! You might need a truck to get this home!");
    else
      lblFunMessage.setText("");
    
//    Calculate and display subtotal, taxes, and grand total
    double subtotal = round((diameter * CHARGE_PER_CM) + PIZZA_CHARGE + RENT_CHARGE, 2);
    lblSubtotal.setText(String.format("$%s", subtotal));
    
    double taxes = round(subtotal * TAX, 2);
    lblTaxes.setText(String.format("$%s", taxes));
  
    lblTotal.setText(String.format("$%s", subtotal + taxes));
  }
  
//  Class containing constants
  static class Constants {
    final static double PIZZA_CHARGE = 0.75;
    final static double RENT_CHARGE = 0.99;
    final static double CHARGE_PER_CM = 0.50;
    final static double TAX = 0.13;
    
    final static String INVALID_DIAMETER = "The diameter that you have entered is invalid! Please check your diameter and try again!";
  }
  
//  Round function
// TODO: 2020-02-27 Remove when features/helpers is merged in favour of NumberUtils#round
  @Deprecated
  private static double round(double numberToRound, int decimalPlaces) {
    return Math.round(Math.pow(10, decimalPlaces) * numberToRound) / Math.pow(10, decimalPlaces);
  }
}
