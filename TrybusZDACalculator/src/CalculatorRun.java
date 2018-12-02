import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CalculatorRun {

	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable()
				{
				public void run(){
				
					CalcFrame frame = new CalcFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					/* 
					niestety w związku z bugiem 2 funkcje nie działają jak powinny
					frame.setMinimumSize(new Dimension(320, 200));
					frame.setMaximumSize(new Dimension(900, 600));
					*/
					//stąd dodałem do nich również .addComponentListener
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
				}
			});
	}
	
}

