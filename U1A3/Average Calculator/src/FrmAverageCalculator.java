import javax.swing.*;

public class FrmAverageCalculator {
  private JPanel pnlMain;
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("FrmAverageCalculator");
    frame.setContentPane(new FrmAverageCalculator().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
