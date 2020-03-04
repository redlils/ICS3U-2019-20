package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MultipleChoiceQuiz {
  //<editor-fold desc="Auto-generated GUI components">
  private JPanel pnlMain; // Main panel
  private JTabbedPane tbPnlMain; // Tab panel
  
  //<editor-fold desc="Questions">
  private JPanel tabQuestions;
  
  private JPanel pnlQuestion1;
  private JTextField txtAnswer1;
  private JLabel lblQuestionResult1;
  
  private JPanel pnlQuestion2;
  private JTextField txtAnswer2;
  private JLabel lblQuestionResult2;
  
  private JPanel pnlQuestion3;
  private JTextField txtAnswer3;
  private JLabel lblQuestionResult3;
  
  private JPanel pnlQuestion4;
  private JTextField txtAnswer4;
  private JLabel lblQuestionResult4;
  
  private JPanel pnlQuestion5;
  private JTextField txtAnswer5;
  private JLabel lblQuestionResult5;
  //</editor-fold>
  
  //<editor-fold desc="Results">
  private JPanel tabResults;
  
  private JLabel lblResultsCorrect;
  private JLabel lblResultsIncorrect;
  private JLabel lblResultsMark;
  private JLabel lblResultsPercentage;
  //</editor-fold>
  
  private JButton btnSubmit;
  //</editor-fold>
  
  private final String[] ANSWERS = new String[] {
          "a",
          "b",
          "c",
          "d",
          "d"
  };
  
  private int correctAnswers;
  
  public MultipleChoiceQuiz() {
    btnSubmit.addActionListener(this::submitButtonClicked);
  }
  
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    JFrame frame = new JFrame("MultipleChoiceQuiz");
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    frame.setContentPane(new MultipleChoiceQuiz().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
  private void submitButtonClicked(ActionEvent actionEvent) {
    // Verify user input
    if (!verifyAnswers()) {
      JOptionPane.showMessageDialog(pnlMain, "One or more of your answers are inputted incorrectly! Please check your answers and try again!");
      return;
    }
    
    // Check answers against actual answers
    String[] inputtedAnswers = new String[] {
            txtAnswer1.getText(),
            txtAnswer2.getText(),
            txtAnswer3.getText(),
            txtAnswer4.getText(),
            txtAnswer5.getText()
    };
  
    JLabel[] resultLabels = new JLabel[] {
            lblQuestionResult1,
            lblQuestionResult2,
            lblQuestionResult3,
            lblQuestionResult4,
            lblQuestionResult5
    };
  
    for (int i = 0; i < inputtedAnswers.length; i++) {
      String inputtedAnswer = inputtedAnswers[i];
      String answer = ANSWERS[i];
      if (inputtedAnswer.equalsIgnoreCase(answer)) {
        correctAnswers++;
        resultLabels[i].setText("You got this question correct!");
      } else {
        resultLabels[i].setText("You got this question wrong. The correct answer was " + ANSWERS[i]);
      }
    }
    
    // Lock text fields & submit button
    txtAnswer1.setEnabled(false);
    txtAnswer2.setEnabled(false);
    txtAnswer3.setEnabled(false);
    txtAnswer4.setEnabled(false);
    txtAnswer5.setEnabled(false);
    btnSubmit.setEnabled(false);
    
    // Calculate and set required UI components in results tab
    lblResultsCorrect.setText(String.valueOf(correctAnswers));
    lblResultsIncorrect.setText(String.valueOf(ANSWERS.length - correctAnswers));
    lblResultsMark.setText(correctAnswers + "/" + ANSWERS.length);
    lblResultsPercentage.setText(NumberUtils.round((double) correctAnswers / ANSWERS.length * 100, 1) + "%");
    
    // Unlock results tab
    tbPnlMain.setEnabledAt(1, true);
  }
  
  private boolean verifyAnswers() {
    return (verifyAnswer(txtAnswer1.getText()) && verifyAnswer(txtAnswer2.getText()) && verifyAnswer(txtAnswer3.getText()) && verifyAnswer(txtAnswer4.getText()) && verifyAnswer(txtAnswer5.getText()));
  }
  
  private boolean verifyAnswer(String answer) {
    return (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("d"));
  }
}
