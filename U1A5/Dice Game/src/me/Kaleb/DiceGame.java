/*
    Created on 2020-03-02 at 4:09 PM
    Author: Kalcoder
*/
package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DiceGame {
  //region Auto-generated GUI variables
  private JPanel pnlMain; // Main panel
  
//  Title and instruction labels
  private JLabel lblTitle;
  private JLabel lblInst1;
  private JLabel lblInst2;
  
//  User-input variables
  private JLabel lblGuess;
  private JFormattedTextField txtGuess;
  private JLabel lblRoll;
  private JButton btnRoll;
  private JLabel lblRollResult;
  
//  Extra information
  private JLabel lblRolls;
  private JLabel lblRollsValue;
  private JLabel lblCorrect;
  private JLabel lblCorrectValue;
  private JLabel lblIncorrect;
  private JLabel lblIncorrectValue;
  private JLabel lblPercentage;
  private JLabel lblPercentageValue;
  //endregion
  
  //region Counters
  int diceRolls;
  int correctGuesses;
  //endregion
  
//  Register listeners
  public DiceGame() {
    btnRoll.addActionListener(this::rollButtonClicked);
  }
  
//  Main function to load GUI
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    JFrame frame = new JFrame("DiceGame");
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    frame.setContentPane(new DiceGame().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
//  Runs when roll button is clicked
  private void rollButtonClicked(ActionEvent actionEvent) {
//    Verify that guess is valid
    int guess;
    try {
      guess = Integer.parseInt(txtGuess.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(pnlMain, " Your guess is invalid, please try again!", "Invalid Guess", JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (guess < 1 || guess > 6) {
      JOptionPane.showMessageDialog(pnlMain, " Your guess is invalid, please try again!", "Invalid Guess", JOptionPane.ERROR_MESSAGE);
      return;
    }
  }
}