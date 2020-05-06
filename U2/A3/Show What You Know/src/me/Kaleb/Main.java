package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main {
  // Auto-generated variables
  private JPanel pnlMain;
  private JButton btnDonate;
  private JTextField txtDonationCustom;
  private JRadioButton rbtnCustom;
  private JRadioButton rbtnDonationTen;
  private JRadioButton rbtnDonationFive;
  private JRadioButton rbtnDonationTwoFifty;
  private JRadioButton rbtnDonationOne;
  private JLabel lblDonationMessage;
  private JPanel pnlDonations;
  
  // Fields for handling selected donation amount
  final double[] DONATION_AMOUNTS = {1.0, 2.50, 5, 10};
  JRadioButton[] buttons;
  
  private final double TAX = 1.13; // Tax constant
  ButtonGroup donationGroup; // ButtonGroup for radio buttons
  
  // Initializer
  public Main() {
    // Add event listener for donate button
    btnDonate.addActionListener(this::donateClicked);
    
    // Initialize donationGroup and add radio buttons to buttons[]
    donationGroup = new ButtonGroup();
    buttons = new JRadioButton[] {rbtnDonationOne, rbtnDonationTwoFifty, rbtnDonationFive, rbtnDonationTen, rbtnCustom};
    
    // Add all radio buttons to donationGroup
    for (int i = 0; i < buttons.length; i++) {
      donationGroup.add(buttons[i]);
    }
  }
  
  // Auto-generated main method
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JFrame frame = new JFrame("Main");
    frame.setContentPane(new Main().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
  // Event handler for when donate button is clicked
  private void donateClicked(ActionEvent e) {
    // Declare and initialize required variables
    boolean donationSelected = false;
    boolean donationCustom = false;
    int index = -1;
    
    // Get currently selected donation amount
    for (int i = 0; i < buttons.length; i++) {
      JRadioButton currentButton = buttons[i];
      if (currentButton.isSelected()) {
        // Break from loop if the current button is selected
        donationSelected = true;
        
        // Handle custom donation differently
        if (currentButton.equals(rbtnCustom)) {
          donationCustom = true;
        } else {
          index = i;
        }
        break;
      }
    }
  
    // Declare donation amount
    double donationAmount;
    
    // Show error message if no radio button is selected
    if (!donationSelected) {
      JOptionPane.showMessageDialog(pnlMain, "Please select a donation amount!", "Donation amount not selected", JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    // Get custom amount entered
    if (donationCustom) {
      
      // Show error message if there is no amount entered
      if (txtDonationCustom.getText().equals("")) {
        JOptionPane.showMessageDialog(pnlMain, "Please enter a custom donation amount!", "Donation amount not entered", JOptionPane.ERROR_MESSAGE);
        return;
      }
      
      donationAmount = Double.parseDouble(txtDonationCustom.getText());
      
    // Get donation amount from DONATION_AMOUNTS loop from index provided from earlier
    } else {
      donationAmount = DONATION_AMOUNTS[index];
    }
    
    // Calculate tax and display donation message
    double total = NumberUtils.round(donationAmount * TAX, 2);
    lblDonationMessage.setText("Thank you for donating! Your total comes to " + total + "!");
  }
}
