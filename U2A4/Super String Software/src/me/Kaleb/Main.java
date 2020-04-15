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
  
  public Main() {
    btnLength.addActionListener(this::lengthClicked);
    btnCaps.addActionListener(this::capsClicked);
    btnFourth.addActionListener(this::fourthClicked);
    btnIdentical.addActionListener(this::identicalClicked);
    btnFind.addActionListener(this::findClicked);
    btnSub.addActionListener(this::subClicked);
    btnReplace.addActionListener(this::replaceClicked);
  }
  
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JFrame frame = new JFrame("Main");
    frame.setContentPane(new Main().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
  private void lengthClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".+", txtLength.getText())) return;
    
    int length = txtLength.getText().length();
    
    lblLength.setText(String.valueOf(length));
  }
  
  private void capsClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".+", txtCaps.getText())) return;
    
    String caps = txtCaps.getText().toUpperCase();
    
    lblCaps.setText(caps);
  }
  
  private void fourthClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".{4,}", txtFourth.getText())) return;
    
    char fourth = txtFourth.getText().charAt(3);
    
    lblFourth.setText(String.valueOf(fourth));
  }
  
  private void identicalClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".+", txtIdenticalOne.getText(), txtIdenticalTwo.getText())) return;
    
    String hypOne = txtIdenticalOne.getText();
    String hypTwo = txtIdenticalTwo.getText();
    
    lblIdentical.setText(String.valueOf(hypOne.equals(hypTwo)));
  }
  
  private void findClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".+", txtFindOne.getText(), txtFindTwo.getText())) return;
    
    String findText = txtFindOne.getText();
    String findChar = txtFindTwo.getText();
    
    lblFind.setText(String.valueOf(findText.contains(findChar)));
  }
  
  private void subClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".{8,}", txtSub.getText())) return;
    
    String sub = txtSub.getText();
    
    lblSub.setText(sub.substring(3, 6));
  }
  
  private void replaceClicked(ActionEvent e) {
    //language=RegExp
    if (!validate(".*a+.*", txtReplace.getText())) return;
    
    String replace = txtReplace.getText();
    
    lblReplace.setText(replace.replace("a", "x"));
  }
  
  @SuppressWarnings("BooleanMethodIsAlwaysInverted")
  private boolean validate(String validInput, String... inputs) {
    for (String input : inputs) {
      if (!input.matches(validInput)) {
        JOptionPane.showMessageDialog(pnlMain, "You have invalid inputs! Please check to make sure that they are valid and try again!", "Invalid inputs", JOptionPane.ERROR_MESSAGE);
        return false;
      }
    }
    return true;
  }
}
