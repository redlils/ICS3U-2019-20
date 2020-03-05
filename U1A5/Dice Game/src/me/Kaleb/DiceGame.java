/*
    Created on 2020-03-02 at 4:09 PM
    Author: Kalcoder
*/
package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

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
  private JLabel lblAccuracy;
  private JLabel lblAccuracyValue;
  private JButton btnRollMultiple;
  //endregion
  
  //region Counters
  int diceRolls;
  int correctGuesses;
  //endregion
  
//  Register listeners
  public DiceGame() {
    btnRoll.addActionListener(this::rollButtonClicked);
    btnRollMultiple.addActionListener(this::multipleRollClicked);
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
    int guess = verifyGuess();
    if (guess == -1) return;
  
    roll(1, guess);
  }
  
//    Allow for multiple rolls at once with one guess
  private void multipleRollClicked(ActionEvent actionEvent) {
//    Verify that guess is valid
    int guess = verifyGuess();
    if (guess == -1) return;
  
//    Ask user for amount of dice to roll
    String diceToRollRaw = JOptionPane.showInputDialog(pnlMain, "Please enter the amount of dice that you would like to roll at once", "Roll Dice", JOptionPane.QUESTION_MESSAGE);
    int diceToRoll = Integer.parseInt(diceToRollRaw);
    
//    Roll
    roll(diceToRoll, guess);
  }
  
  private int verifyGuess() {
    int guess;
    try {
      guess = Integer.parseInt(txtGuess.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(pnlMain, " Your guess is invalid, please try again!", "Invalid Guess", JOptionPane.ERROR_MESSAGE);
      return -1;
    }
    if (guess < 1 || guess > 6) {
      JOptionPane.showMessageDialog(pnlMain, " Your guess is invalid, please try again!", "Invalid Guess", JOptionPane.ERROR_MESSAGE);
      return -1;
    }
    return guess;
  }
  
//  Helper function for rolling dice
  private void roll(int diceToRoll, int guess) {
    int lastRoll = 0;
    
    for (int currentRoll = 1; currentRoll <= diceToRoll; currentRoll++) {
      diceRolls += 1; // Add roll to counter

      long seed = diceRolls * (correctGuesses + guess) * currentRoll;
      
//    Roll die
      lastRoll = new Random(seed).nextInt(6) + 1;  // Use variables for seed
  
      System.out.println("Seed = " + seed);
      System.out.println("lastRoll = " + lastRoll);
      
//    Add to correct guess if guess was correct
      if (lastRoll == guess) correctGuesses++;
    }
    
    lblRollResult.setText(lastRoll + "");
    lblCorrectValue.setText(correctGuesses + "");
    lblIncorrectValue.setText(diceRolls - correctGuesses + "");
    lblRollsValue.setText(diceRolls + "");
    lblAccuracyValue.setText(NumberUtils.round((double) correctGuesses / diceRolls * 100, 2) + "%");
  }
}