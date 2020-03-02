/*
    Created on 2020-03-02 at 4:09 PM
    Author: Kalcoder
*/
package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DiceGame {
  //region Auto-generated GUI variables
  private static JPanel pnlMain; // Main panel
  
//  Title and instruction labels
  private static JLabel lblTitle;
  private static JLabel lblInst1;
  private static JLabel lblInst2;
  
//  User-input variables
  private static JLabel lblGuess;
  private static JFormattedTextField txtGuess;
  private static JLabel lblRoll;
  private static JButton btnRoll;
  private static JLabel lblRollResult;
  
//  Extra information
  private static JLabel lblRolls;
  private static JLabel lblRollsValue;
  private static JLabel lblCorrect;
  private static JLabel lblCorrectValue;
  private static JLabel lblIncorrect;
  private static JLabel lblIncorrectValue;
  private static JLabel lblPercentage;
  private static JLabel lblPercentageValue;
  //endregion
  
  //region Counters
  int diceRolls;
  int correctGuesses;
  //endregion
  
//  Register listeners
  public DiceGame() {
    btnRoll.addActionListener(DiceGame::rollButtonClicked);
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
  private static void rollButtonClicked(ActionEvent actionEvent) {
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