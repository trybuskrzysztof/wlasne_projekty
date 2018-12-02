import javax.swing.JFrame;

/**
 * A frame with a calculator panel.
 */
public class CalculatorFrame extends JFrame
{
   public CalculatorFrame()
   {
      add(new CalculatorPanel());
      pack();
   }
}
