import java.awt.event.*;
import javax.swing.*;

//import CalculatorPanel.CommandAction;

import java.awt.*;


public class GridBagLayoutTest {

	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable()
				{
				public void run(){
				
					FontFrame frame = new FontFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
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

class FontFrame extends JFrame{
	
	public FontFrame()
	{
		
		setTitle("ZDA Calculator");
		setSize(400,300);
		
		 result = 0;
	     lastCommand = "=";
	     start = true;
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		ActionListener reset = new ResetAction();
		
		//wyświetlacz 
		 display = new JButton("0");
	     display.setEnabled(false);
	     add(display, new GBC(0, 0,4,1).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
		//tworzenie przycisków
		
		//cyfry i kropka
		 button1 = new JButton("1");
	     button1.addActionListener(insert);
	     button1.setEnabled(enable);
	     add(button1, new GBC(0, 3).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     button2 = new JButton("2");
	     button2.addActionListener(insert);
	     button2.setEnabled(enable);
	     add(button2, new GBC(1, 3).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     button3 = new JButton("3");
	     button3.addActionListener(insert);
	     button3.setEnabled(enable);
	     add(button3, new GBC(2, 3).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     button4 = new JButton("4");
	     button4.addActionListener(insert);
	     button4.setEnabled(enable);
	     add(button4, new GBC(0, 2).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     button5 = new JButton("5");
	     button5.addActionListener(insert);
	     button5.setEnabled(enable);
	     add(button5, new GBC(1, 2).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     button6 = new JButton("6");
	     button6.addActionListener(insert);
	     button6.setEnabled(enable);
	     add(button6, new GBC(2, 2).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     button7 = new JButton("7");
	     button7.addActionListener(insert);
	     button7.setEnabled(enable);
	     add(button7, new GBC(0, 1).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     button8 = new JButton("8");
	     button8.addActionListener(insert);
	     button8.setEnabled(enable);
	     add(button8, new GBC(1, 1).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     button9 = new JButton("9");
	     button9.addActionListener(insert);
	     button9.setEnabled(enable);
	     add(button9, new GBC(2, 1).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     button0 = new JButton("0");
	     button0.addActionListener(insert);
	     button0.setEnabled(enable);
	     add(button0, new GBC(0, 4).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     buttonDoc = new JButton(".");
	     buttonDoc.addActionListener(insert);
	     buttonDoc.setEnabled(enable);
	     add(buttonDoc, new GBC(1, 4).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     //działania 
	      
	     buttonAdd = new JButton("+");
	     buttonAdd.addActionListener(command);
	     buttonAdd.setEnabled(enable);
	     add(buttonAdd, new GBC(3, 4).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     buttonSub = new JButton("-");
	     buttonSub.addActionListener(command);
	     buttonSub.setEnabled(enable);
	     add(buttonSub, new GBC(3, 3).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	     
	     buttonMult = new JButton("*");
	     buttonMult.addActionListener(command);
	     buttonMult.setEnabled(enable);
	     add(buttonMult, new GBC(3, 2).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	     
	     buttonDiv = new JButton("/");
	     buttonDiv.addActionListener(command);
	     buttonDiv.setEnabled(enable);
	     add(buttonDiv, new GBC(3, 1).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     buttonSign = new JButton("+/-");
	     buttonSign.addActionListener(command);
	     buttonSign.setEnabled(enable);
	     add(buttonSign, new GBC(2, 4).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     buttonSqrt = new JButton("sqrt");
	     buttonSqrt.addActionListener(command);
	     buttonSqrt.setEnabled(enable);
	     add(buttonSqrt, new GBC(4, 1).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     buttonProc = new JButton("%");
	     buttonProc.addActionListener(command);
	     buttonProc.setEnabled(enable);
	     add(buttonProc, new GBC(4, 2).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     buttonRes = new JButton("=");
	     buttonRes.addActionListener(command);
	     buttonRes.setEnabled(enable);
	     add(buttonRes, new GBC(4, 3,1,2).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	      
	     JButton buttonClear = new JButton("C");
	     buttonClear.addActionListener(reset);
	     add(buttonClear, new GBC(4, 0).setInsets(5).setWeight(1,1).setFill(GBC.BOTH));
	}
	

	/**
	 * dodaje przycisk
	 */


	   /**
	    * This action inserts the button action string to the end of the display text.
	    */
	   private class InsertAction implements ActionListener
	   {
	      public void actionPerformed(ActionEvent event)
	      {
	         String input = event.getActionCommand();
	         if (start)
	         {
	            display.setText("");
	            start = false;
	         }
	         display.setText(display.getText() + input);
	      }
	   }
	   private class CommandAction implements ActionListener
	   {
	      public void actionPerformed(ActionEvent event)
	      {
	         String command = event.getActionCommand();
	         
	       try{ 
	         if(command.equals("%"))
	         {
	        	 display.setText(""+
	        			 Double.parseDouble(display.getText())/(100)
	        	 );
	        	 
	         }
	         
	         if(command.equals("+/-"))
	         {
	        	 display.setText(""+
	        			 Double.parseDouble(display.getText())*(-1)
	        	 );
	        	 
	         }
	         if(command.equals("sqrt"))
	         {
	        	 display.setText(""+
	        			 
	        			 Math.sqrt(Double.parseDouble(display.getText()))
	        	 );
	        	 
	         }
	         if (start)
	         {
	            if (command.equals(""))
	            {
	            	//
	               display.setText("");
	               start = true;
	            }
	            else lastCommand = command;
	         }
	         else
	         {
	            calculate(Double.parseDouble(display.getText()));
	            lastCommand = command;
	            start = true;
	         }
	       
	        }
	       catch (NumberFormatException e){ 
	    	   display.setText("ERR");
	    	   disable(); }
	        // catch (TypWyjątku2 b){ Obsługa wyjątku b }
	         
	      }
	   }
	   private class ResetAction implements ActionListener
	   {
	      public void actionPerformed(ActionEvent event)
	      {
	    	 // String command = event.getActionCommand();
	    	  	display.setText("");
	    	  	result=0.0;
	    	  	lastCommand = "=";
	            start = false;
	            enableButtons();
	       //     
	           
	      }
	   }
	   public void calculate(double x)
	   {
	      if (lastCommand.equals("+")) result += x;
	      else if (lastCommand.equals("-")) result -= x;
	      else if (lastCommand.equals("*")) result *= x;
	      else if (lastCommand.equals("/")) result /= x;
	      //else if (lastCommand.equals("+/-")) result = -x;
	      //else if (lastCommand.equals("%")) result = (x/100);
	      
	      else if (lastCommand.equals("=")) result = x;
	      
	      
	      
	      
	      display.setText("" + result);
	   }
	   
	   public void disable()
	   {
		    enable= false;
		    button0.setEnabled(enable);
		    button1.setEnabled(enable);
		    button2.setEnabled(enable);
		    button3.setEnabled(enable);
		    button4.setEnabled(enable);
		    button5.setEnabled(enable);
		    button6.setEnabled(enable);
		    button7.setEnabled(enable);
		    button8.setEnabled(enable);
		    button9.setEnabled(enable);
		    buttonAdd.setEnabled(enable);
		    buttonSub.setEnabled(enable);
		    buttonMult.setEnabled(enable);
		    buttonDiv.setEnabled(enable);
		    buttonSqrt.setEnabled(enable);
		    buttonSign.setEnabled(enable);
		    buttonProc.setEnabled(enable);
		    buttonRes.setEnabled(enable);
		    buttonDoc.setEnabled(enable);
	   }
	   public void enableButtons()
	   {
		    enable= true;
		    button0.setEnabled(enable);
		    button1.setEnabled(enable);
		    button2.setEnabled(enable);
		    button3.setEnabled(enable);
		    button4.setEnabled(enable);
		    button5.setEnabled(enable);
		    button6.setEnabled(enable);
		    button7.setEnabled(enable);
		    button8.setEnabled(enable);
		    button9.setEnabled(enable);
		    buttonAdd.setEnabled(enable);
		    buttonSub.setEnabled(enable);
		    buttonMult.setEnabled(enable);
		    buttonDiv.setEnabled(enable);
		    buttonSqrt.setEnabled(enable);
		    buttonSign.setEnabled(enable);
		    buttonProc.setEnabled(enable);
		    buttonRes.setEnabled(enable);
		    buttonDoc.setEnabled(enable);
	   }
	   private JButton display;
	   
	   private JButton button0;
	   private JButton button1;
	   private JButton button2;
	   private JButton button3;
	   private JButton button4;
	   private JButton button5;
	   private JButton button6;
	   private JButton button7;
	   private JButton button8;
	   private JButton button9;
	   private JButton buttonAdd;
	   private JButton buttonSub;
	   private JButton buttonMult;
	   private JButton buttonDiv;
	   private JButton buttonSqrt;
	   private JButton buttonSign;
	   private JButton buttonProc;
	   private JButton buttonRes;
	   private JButton buttonDoc;
	   
	   private double result;
	   private String lastCommand;
	   private boolean start;
	   public boolean enable =true ;
	  
}
