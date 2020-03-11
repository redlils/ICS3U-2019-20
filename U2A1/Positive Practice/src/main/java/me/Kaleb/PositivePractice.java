/*
    Created on 2020-03-10 at 7:01 PM
    Author: Kalcoder
*/
package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class PositivePractice {
  private JButton btnGenerateQuote;
  private JLabel lblQuote;
  private JPanel pnlMain;
  
  public PositivePractice() {
    btnGenerateQuote.addActionListener(this::generateQuoteClicked);
  }
  
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    JFrame frame = new JFrame("PositivePractice");
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    frame.setContentPane(new PositivePractice().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
  private void generateQuoteClicked(ActionEvent actionEvent) {
    Random random = new Random();
    int quote = random.nextInt(8) + 1;
    switch (quote) {
      case 1:
        lblQuote.setText("Act as if what you do makes a difference. It does. - William James");
        break;
      case 2:
        lblQuote.setText("Success is not final, failure is not fatal: it is the courage to continue that counts. - Winston Churchill");
        break;
      case 3:
        lblQuote.setText("Never bend your head. Always hold it high. Look the world straight in the eye. - Helen Keller");
        break;
      case 4:
        lblQuote.setText("Believe you can and you're halfway there. - Theodore Roosevelt.");
        break;
      case 5:
        lblQuote.setText("No matter what you're going through, there's a light at the end of the tunnel. - Demi Lovato");
        break;
      case 6:
        lblQuote.setText("Life is like riding a bicycle. To keep your balance, you must keep moving. - Albert Einstein");
        break;
      case 7:
        lblQuote.setText("You do not find the happy life. You make it. - Camilla Eyring Kimball");
        break;
      case 8:
        lblQuote.setText("Sometimes you will never know the value of a moment, until it becomes a memory. - Dr. Seuss");
        break;
    }
  }
}
