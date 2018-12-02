import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


class ZdaComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 200;
    public void paintComponent(Graphics g)  {
    	g.drawRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        g.drawString("Witamy na okienku", MESSAGE_X, MESSAGE_Y);
    }
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH,    DEFAULT_HEIGHT);
    }
}

public class SimpleSwingSample2 {
  ZdaComponent closeButton;
  void run() {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Pierwszy Przycisk");
      frame.setBounds(100, 100, 450, 300);          // nadaje rozmiar oknu
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      closeButton = new ZdaComponent();
      frame.getContentPane().add(closeButton);
      frame.pack();
      frame.setVisible(true);                  // pokaż onkno
    });
  }
  public static void main(String[] args) {
    new SimpleSwingSample2().run();
  }
}