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
  
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JFrame frame = new JFrame("Main");
    frame.setContentPane(new Main().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
  private void maxClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtMaxOne.getText(), txtMaxTwo.getText())) return;
    
    int maxOne = Integer.parseInt(txtMaxOne.getText());
    int maxTwo = Integer.parseInt(txtMaxTwo.getText());
  
    lblMax.setText(String.valueOf(Math.max(maxOne, maxTwo)));
  }
  
  private void minClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtMinOne.getText(), txtMinTwo.getText())) return;
    
    int minOne = Integer.parseInt(txtMinOne.getText());
    int minTwo = Integer.parseInt(txtMinTwo.getText());
    
    lblMin.setText(String.valueOf(Math.min(minOne, minTwo)));
  }
  
  private void powerClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtPowerBase.getText(), txtPowerExponent.getText())) return;
    
    int powerBase = Integer.parseInt(txtPowerBase.getText());
    int powerExponent = Integer.parseInt(txtPowerExponent.getText());
  
    lblPower.setText(String.valueOf(Math.pow(powerBase, powerExponent)));
  }
  
  private void hypClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtHypOne.getText(), txtHypTwo.getText())) return;
    
    int hypOne = Integer.parseInt(txtHypOne.getText());
    int hypTwo = Integer.parseInt(txtHypTwo.getText());
  
    lblHyp.setText(String.valueOf(Math.hypot(hypOne, hypTwo)));
  }
  
  private void floorClicked(ActionEvent e) {
    if (!validate("[1-9]+\\.[1-9]+", txtFloor.getText())) return;
    
    double floor = Double.parseDouble(txtFloor.getText());
  
    lblFloor.setText(String.valueOf(Math.floor(floor)));
  }
  
  private void ceilClicked(ActionEvent e) {
    if (!validate("[1-9]+\\.[1-9]+", txtCeil.getText())) return;
  
    double ceil = Double.parseDouble(txtCeil.getText());
  
    lblCeil.setText(String.valueOf(Math.ceil(ceil)));
  }
  
  private void sqrtClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtSqrt.getText())) return;
  
    int sqrt = Integer.parseInt(txtSqrt.getText());
  
    lblSqrt.setText(String.valueOf(Math.sqrt(sqrt)));
  }
  
  private void radClicked(ActionEvent e) {
    if (!validate("[1-9]+", txtRad.getText())) return;
  
    int rad = Integer.parseInt(txtRad.getText());
  
    lblRad.setText(String.valueOf(Math.toRadians(rad)));
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
