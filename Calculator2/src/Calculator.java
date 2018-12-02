import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

/**
 * @version 1.34 2015-06-12
 * @author Cay Horstmann
 */
public class Calculator
{
	public static void main(String[] args)
	   {
	      EventQueue.invokeLater(() -> {
	         CalculatorFrame frame = new CalculatorFrame();
	         frame.setTitle("Calculator");
	         frame.setMinimumSize(new Dimension(320, 200));
	         frame.setMaximumSize(new Dimension(960, 600));
	         frame.addComponentListener(new ComponentAdapter() {
	           public void componentResized(ComponentEvent evt) {
	             Dimension size = frame.getSize();
	             Dimension min = frame.getMinimumSize();
	             Dimension max = frame.getMaximumSize();
	             if (size.getWidth() < min.getWidth()) {
	                 frame.setSize((int) min.getWidth(), (int) size.getHeight());
	             }
	             if (size.getHeight() < min.getHeight()) {
	                 frame.setSize((int) size.getWidth(), (int) min.getHeight());
	             }
	             if (size.getWidth() > max.getWidth()) {
	            	 frame.setSize((int) max.getWidth(), (int) size.getHeight());
	             }
		         if (size.getHeight() > max.getHeight()) {
		        	 frame.setSize((int) size.getWidth(), (int) max.getHeight());
		         }
	           }
	         });
	         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         frame.setVisible(true);
	         frame.setResizable(false);
	      });
	   }
}