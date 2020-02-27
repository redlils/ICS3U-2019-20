import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAverageCalculator {
//  GUI Elements
  private JPanel pnlMain; // Main panel
  private JLabel lblSubtitle; // Subtitle
  
//  Grade labels/text fields
  private JLabel lblGrade1;
  private JTextField txtGrade1;
  private JLabel lblGrade2;
  private JTextField txtGrade2;
  private JLabel lblGrade3;
  private JTextField txtGrade3;
  private JLabel lblGrade4;
  private JTextField txtGrade4;
  
  private JButton btnCalculate; // Calculate button
  private JLabel lblGradeAverage; // Average label
  
//  Constructor called when GUI loads
  public FrmAverageCalculator() {
  
//    Runs when calculate button is clicked
    btnCalculate.addActionListener(actionEvent -> {
//      Run checks before calculating
//      Validate that all text fields are not blank
      if (txtGrade1.getText().equals("") || txtGrade2.getText().equals("") ||txtGrade3.getText().equals("") ||txtGrade4.getText().equals("")) {
//        Show error message and stop execution
        JOptionPane.showMessageDialog(pnlMain, "One or more of your grades have not been entered! Please check that you have inputted all your grades and try again!", "Grades entered incorrectly", JOptionPane.ERROR_MESSAGE);
        return;
      }
//      Create empty array to store grades
      double[] grades = new double[4];
//      Attempt to populate array with inputted grades
      try {
        grades[0] = Double.parseDouble(txtGrade1.getText());
        grades[1] = Double.parseDouble(txtGrade2.getText());
        grades[2] = Double.parseDouble(txtGrade3.getText());
        grades[3] = Double.parseDouble(txtGrade4.getText());
      } catch (NumberFormatException e) {
//        Show error message if a grade was not inputted properly and stop execution
        JOptionPane.showMessageDialog(pnlMain, "One or more of your grades was entered incorrectly! Please check that you have inputted all your grades as numbers and try again!", "Grades entered incorrectly", JOptionPane.ERROR_MESSAGE);
        return;
      }
      
      double average = 0; // Initialize average with placeholder value
  
//      Add all grades to average variable
      for (double grade : grades) {
        average += grade;
      }
      
//      Calculate average
      average /= grades.length;
      average = round(average, 1);
      
      lblGradeAverage.setText("Average: " + average); // Make average label reflect calculated average
    });
  }
  
//  Main entry point to GUI
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
//    Set the look and feel of the GUI to look like a native GUI instead of default Java Metal theme
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//    Generate GUI
    JFrame frame = new JFrame("Grade Average Calculator");
    frame.setContentPane(new FrmAverageCalculator().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
//  Helper function for rounding
  private double round(double numberToRound, @SuppressWarnings("SameParameterValue") int decimalPlaces) {
    double roundedNumber = numberToRound * Math.pow(10, decimalPlaces);
    roundedNumber = Math.round(roundedNumber);
    roundedNumber /= Math.pow(10, decimalPlaces);
    
    return roundedNumber;
  }
}
