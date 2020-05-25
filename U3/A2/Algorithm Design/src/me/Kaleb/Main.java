package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Main class for the "<b>Algorithm Design</b>" assignment for <b>U3A2</b> of the <b>ICS3U</b> course.
 */
public class Main {
  private JPanel pnlMain;
  private JTextField txtFactorial;
  private JButton btnFactorial;
  private JLabel lblFactorial;
  private JTextField txtPrime;
  private JButton btnPrime;
  private JLabel lblPrime;
  private JTextField txtFib;
  private JButton btnFib;
  private JLabel lblFib;
  
  /**
   * Constructor
   */
  public Main() {
    btnFactorial.addActionListener(this::onFactorialClicked);
    btnPrime.addActionListener(this::onPrimeClicked);
    btnFib.addActionListener(this::onFibClicked);
  }
  
  /**
   * Main method for <b>Algorithm Design</b>
   *
   * @param args Arguments passed by the executor
   *
   * @throws ClassNotFoundException If className in {@link UIManager#setLookAndFeel} does not identify a class that extends {@link LookAndFeel}
   * @throws UnsupportedLookAndFeelException If the {@link LookAndFeel} class could not be found using {@link UIManager#setLookAndFeel}
   * @throws InstantiationException If a new instance of the class couldn't be created using {@link UIManager#setLookAndFeel}
   * @throws IllegalAccessException If the class or initializer isn't accessible using {@link UIManager#setLookAndFeel}
   */
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    JFrame frame = new JFrame("Main");
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    frame.setContentPane(new Main().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
  /**
   * Method called when the <b>factorial</b> button is clicked
   *
   * @param e The {@link ActionEvent} linked to the button click
   */
  public void onFactorialClicked(ActionEvent e) {
    // Attempt to parse text from txtFactorial to an integer
    try {
      // Calculate factorial with the parsed integer
      int factorial = factorial(Integer.parseInt(txtFactorial.getText()));
      
      // Set lblFactorial to factorial
      lblFactorial.setText(String.valueOf(factorial));
    } catch (NumberFormatException exception) {
      // Show dialog box saying input was invalid
      JOptionPane.showMessageDialog(pnlMain, "The number you have entered is invalid! Please try again!", "Invalid input", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  /**
   * Method called when the <b>prime</b> button is clicked
   *
   * @param e The {@link ActionEvent} linked to the button click
   */
  public void onPrimeClicked(ActionEvent e) {
    // Attempt to parse text from txtPrime to an integer
    try {
      // Determine if the parsed number is prime
      boolean isPrime = prime(Integer.parseInt(txtPrime.getText()));
      
      // Set lblPrime to the value of isPrime
      lblPrime.setText(String.valueOf(isPrime));
    } catch (NumberFormatException exception) {
      // Show dialog box saying input was invalid
      JOptionPane.showMessageDialog(pnlMain, "The number you have entered is invalid! Please try again!", "Invalid input", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  /**
   * Method called when the <b>fibonacci</b> button is clicked
   *
   * @param e The {@link ActionEvent} linked to the button click
   */
  public void onFibClicked(ActionEvent e) {
    // Attempt to parse text from txtFib to an integer
    try {
      // Calculate the number in the parsed position in the fibonacci sequence
      int fib = fibonacci(Integer.parseInt(txtFib.getText()));
      
      // Set lblFib to fib
      lblFib.setText(String.valueOf(fib));
    } catch (NumberFormatException exception) {
      // Show dialog box saying input was invalid
      JOptionPane.showMessageDialog(pnlMain, "The number you have entered is invalid! Please try again!", "Invalid input", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  /**
   * Helper function for calculating a factorial
   *
   * @param n The number to calculate the factorial of
   * @return The factorial of <b><code>n</code></b>
   */
  public int factorial(int n) {
    // Used to break out of recursion if we reach 1
    if (n == 1) return 1;
    
    // Return (n-1)! * n
    return factorial(n - 1) * n;
  }
  
  /**
   * Helper function for determining if a number is prime
   *
   * @param n The number to determine if it is prime
   * @return If <b><code>n</code></b> is prime
   */
  public boolean prime(int n) {
    // Loop through all numbers from n to n / 2
    for (int i = 2; i <= n / 2; i++) {
      // If the remainder of n / i is 0, this means the number is not prime
      if (n % i == 0) return false;
    }
    
    // If we make it out of the loop, that means there has been no return value, so the number is prime
    return true;
  }
  
  /**
   * Helper functioning for calculating the value of the number in the <b><code>n</code>th</b> position of the <a href="https://en.wikipedia.org/wiki/Fibonacci_number">Fibonacci Sequence</a>
   *
   * @param n The position of the fibonacci sequence
   * @return The calculated number at the <b><code>n</code>th</b> position
   */
  public int fibonacci(int n) {
    // Used to break out of recursion if we reach either 0 or 1
    if (n == 0) return 0;
    if (n == 1) return 1;
    
    // Return Xn-1 + Xn-2
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
