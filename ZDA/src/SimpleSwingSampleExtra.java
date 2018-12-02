import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SimpleSwingSampleExtra {
  JButton closeButton;
  class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      closeButton.setText("naciśnięto"); // a jak inne kontrolki?
    }
  }
  void run() {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Pierwszy Przycisk");
      frame.setBounds(100, 100, 450, 300);          // nadaje rozmiar oknu
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      closeButton = new JButton("jeszcze nie naciśnięto"); // tu ustawiamy
      closeButton.addActionListener(new ButtonListener());
      frame.getContentPane().add(closeButton);
      frame.setVisible(true);                  // pokaż onkno
    });
  }
  public static void main(String[] args) {
    new SimpleSwingSampleExtra().run();
  }
}