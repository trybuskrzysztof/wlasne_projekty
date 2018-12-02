package application;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main {

	public static void main(String[] args) {
		Bill electricBill=new Bill();

		electricBill.amountDueProperty().addListener(
				(ov, oldVal, newVal)->
				  System.out.println("Rachunek zmieniony.")
				);
		electricBill.setAmountDue(100.0);
		electricBill.setAmountDue(50.0);
	//=================================================
		
	IntegerProperty num1 = new SimpleIntegerProperty(1);
	IntegerProperty num2 = new SimpleIntegerProperty(1);
	IntegerProperty num3 = new SimpleIntegerProperty(3);
	IntegerProperty num4 = new SimpleIntegerProperty(4);
	
	//uĹźycie Fluent API
	NumberBinding sum= num1.add(num2);
	
	//uĹźycie klasy Bindings
	NumberBinding total=
			Bindings.add(num1.multiply(num2), 
					     num3.multiply(num4));
	
	System.out.println("sum before:   " + sum.getValue());
	System.out.println("total before: " + total.getValue());
	num1.set(2);
	System.out.println("sum after:    " + sum.getValue());
	System.out.println("total after:  "  + total.getValue());
	
	//=======================================================
	
	Bill bill1 = new Bill();
	Bill bill2 = new Bill();
	Bill bill3 = new Bill();
	
	NumberBinding totalBill = 
			Bindings.add(
			  bill1.amountDueProperty().add(bill2.amountDueProperty()),
			  bill3.amountDueProperty());
	
	totalBill.addListener(
			new InvalidationListener()
			{
				@Override public void invalidated(Observable o)
				{
					System.out.println("Binding invalid.");
				}
			}
			);
	
	bill1.setAmountDue(200.0);  //binding invalid
	bill2.setAmountDue(50.0);
	bill3.setAmountDue(100.0);
	System.out.println(totalBill.getValue()); //binding valid
	bill2.setAmountDue(1000.0);
	
	//=======================================================
	
		Bill bill4 = new Bill();
		Bill bill5 = new Bill();
		Bill bill6 = new Bill();
		
		NumberBinding totalBill2 = 
				Bindings.add(
				  bill4.amountDueProperty().add(bill5.amountDueProperty()),
				  bill6.amountDueProperty());
		
		totalBill2.addListener(
				new ChangeListener()
				{
					@Override public void changed(ObservableValue o,
							                     Object oldVal,
							                     Object newVal)
					{
						System.out.println("Binding changed.");
					}
				}
				);
		
		bill4.setAmountDue(200.0);  
		bill5.setAmountDue(50.0);
		bill6.setAmountDue(100.0);
		System.out.println(totalBill2.getValue()); 
		bill5.setAmountDue(1000.0);
	}

}