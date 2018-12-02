import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class CalcFrame extends JFrame{
	private JButton textField;
	private JButton b0;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	
	private JButton bAdd;
	private JButton bSubtract;
	private JButton bMultiply;
	private JButton bDivide;
	private JButton bSqrt;
	private JButton bSign;
	private JButton bPercent;
	private JButton bEquals;
	private JButton bDot;
	   
	private double result;
    private String lastCommand;
	private boolean start;
	public boolean enable = true ;
	
	public CalcFrame()
	{
		setTitle("ZDA - Calculator");
		
		result = 0;
	    lastCommand = "=";
	    start = true;
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		ActionListener reset = new ResetAction();
		
	    textField = new JButton("0");
		textField.setEnabled(false);
		add(textField, new gbcMethods(0, 0, 4, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		
		JButton bClear = new JButton("C");
		bClear.addActionListener(reset);
		add(bClear, new gbcMethods(4, 0, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));		
	      
		b7 = new JButton("7");
		b7.addActionListener(insert);
		b7.setEnabled(enable);
		add(b7, new gbcMethods(0, 1, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		      
		b8 = new JButton("8");
		b8.addActionListener(insert);
		b8.setEnabled(enable);
		add(b8, new gbcMethods(1, 1, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		      
		b9 = new JButton("9");
		b9.addActionListener(insert);
		b9.setEnabled(enable);
		add(b9, new gbcMethods(2, 1, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		
		bDivide = new JButton("/");
		bDivide.addActionListener(command);
		bDivide.setEnabled(enable);
		add(bDivide, new gbcMethods(3, 1, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
	      
		bSqrt = new JButton("sqrt");
		bSqrt.addActionListener(command);
		bSqrt.setEnabled(enable);
		add(bSqrt, new gbcMethods(4, 1, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		
		b4 = new JButton("4");
		b4.addActionListener(insert);
		b4.setEnabled(enable);
		add(b4, new gbcMethods(0, 2, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		      
		b5 = new JButton("5");
		b5.addActionListener(insert);
		b5.setEnabled(enable);
		add(b5, new gbcMethods(1, 2, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		      
		b6 = new JButton("6");
		b6.addActionListener(insert);
		b6.setEnabled(enable);
		add(b6, new gbcMethods(2, 2, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		
		bMultiply = new JButton("*");
		bMultiply.addActionListener(command);
		bMultiply.setEnabled(enable);
		add(bMultiply, new gbcMethods(3, 2, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		 
		bPercent = new JButton("%");
		bPercent.addActionListener(command);
		bPercent.setEnabled(enable);
		add(bPercent, new gbcMethods(4, 2, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
			
		b1 = new JButton("1");
		b1.addActionListener(insert);
		b1.setEnabled(enable);
		add(b1, new gbcMethods(0, 3, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		      
		b2 = new JButton("2");
		b2.addActionListener(insert);
		b2.setEnabled(enable);
		add(b2, new gbcMethods(1, 3, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		      
		b3 = new JButton("3");
		b3.addActionListener(insert);
		b3.setEnabled(enable);
		add(b3, new gbcMethods(2, 3, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		
		bSubtract = new JButton("-");
		bSubtract.addActionListener(command);
		bSubtract.setEnabled(enable);
		add(bSubtract, new gbcMethods(3, 3, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		      
		b0 = new JButton("0");
		b0.addActionListener(insert);
		b0.setEnabled(enable);
		add(b0, new gbcMethods(0, 4, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		      
		bDot = new JButton(".");
		bDot.addActionListener(insert);
		bDot.setEnabled(enable);
		add(bDot, new gbcMethods(1, 4, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
	      
		bSign = new JButton("+/-");
		bSign.addActionListener(command);
		bSign.setEnabled(enable);
		add(bSign, new gbcMethods(2, 4, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		      
		bAdd = new JButton("+");
		bAdd.addActionListener(command);
		bAdd.setEnabled(enable);
		add(bAdd, new gbcMethods(3, 4, 1, 1).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
		      
		bEquals = new JButton("=");
		bEquals.addActionListener(command);
		bEquals.setEnabled(enable);
		add(bEquals, new gbcMethods(4, 3, 1, 2).setInsets(1).setWeight(1,1).setFill(gbcMethods.BOTH));
	
	}
	   private class InsertAction implements ActionListener
	   {
	      public void actionPerformed(ActionEvent event)
	      {
	         String input = event.getActionCommand();
	         if (start)
	         {
	            textField.setText("");
	            start = false;
	         }
	         textField.setText(textField.getText() + input);
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
	        	 textField.setText(""+
	        			 Double.parseDouble(textField.getText())/(100)
	        	 );
	         }
	         
	         if(command.equals("+/-"))
	         {
	        	 textField.setText(""+
	        			 Double.parseDouble(textField.getText())*(-1)
	        	 ); 
	         }
	         
	         if(command.equals("sqrt"))
	         {
	        	 textField.setText(""+	 
	        			 Math.sqrt(Double.parseDouble(textField.getText()))
	        	 );
	        	 
	         }
	         if (start)
	         {
	            if (command.equals(""))
	            {
	            	//
	               textField.setText("");
	               start = true;
	            }
	            else lastCommand = command;
	         }
	         else
	         {
	            calculate(Double.parseDouble(textField.getText()));
	            lastCommand = command;
	            start = true;
	         }
	       
	        }
	       catch (NumberFormatException e){ 
	    	   textField.setText("ERROR - press C button");
	    	   disable();
	    	   }
	      }
	   }
	   private class ResetAction implements ActionListener
	   {
	      public void actionPerformed(ActionEvent event)
	      {
	    	  	textField.setText("");
	    	  	result=0.0;
	    	  	lastCommand = "=";
	            start = false;
	            enableButtons();  
	      }
	   }
	   public void calculate(double x)
	   {
	      if (lastCommand.equals("+")) result += x;
	      else if (lastCommand.equals("-")) result -= x;
	      else if (lastCommand.equals("*")) result *= x;
	      else if (lastCommand.equals("/")) result /= x;	      
	      else if (lastCommand.equals("=")) result = x;
	      textField.setText("" + result);
	   }
	   
	   public void disable()
	   {
		    enable = false;
		    b0.setEnabled(enable);
		    b1.setEnabled(enable);
		    b2.setEnabled(enable);
		    b3.setEnabled(enable);
		    b4.setEnabled(enable);
		    b5.setEnabled(enable);
		    b6.setEnabled(enable);
		    b7.setEnabled(enable);
		    b8.setEnabled(enable);
		    b9.setEnabled(enable);
		    bAdd.setEnabled(enable);
		    bSubtract.setEnabled(enable);
		    bMultiply.setEnabled(enable);
		    bDivide.setEnabled(enable);
		    bSqrt.setEnabled(enable);
		    bSign.setEnabled(enable);
		    bPercent.setEnabled(enable);
		    bEquals.setEnabled(enable);
		    bDot.setEnabled(enable);
	   }
	   public void enableButtons()
	   {
		    enable = true;
		    b0.setEnabled(enable);
		    b1.setEnabled(enable);
		    b2.setEnabled(enable);
		    b3.setEnabled(enable);
		    b4.setEnabled(enable);
		    b5.setEnabled(enable);
		    b6.setEnabled(enable);
		    b7.setEnabled(enable);
		    b8.setEnabled(enable);
		    b9.setEnabled(enable);
		    bAdd.setEnabled(enable);
		    bSubtract.setEnabled(enable);
		    bMultiply.setEnabled(enable);
		    bDivide.setEnabled(enable);
		    bSqrt.setEnabled(enable);
		    bSign.setEnabled(enable);
		    bPercent.setEnabled(enable);
		    bEquals.setEnabled(enable);
		    bDot.setEnabled(enable);
	   }
}