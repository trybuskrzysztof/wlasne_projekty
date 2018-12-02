package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Person;

public class MainWindowController {
  private Main main;
  private Person person;
  
  @FXML private Button button;
  @FXML private TextField field;
  @FXML private Label label;
  
 public void setMain(Main main){
	 this.main=main;
	 person= new Person("Charlie");
 }
 
 @FXML
 public void handleButton(){
	System.out.println("Button pressed.");
	String text=field.getText();
	person.setFirstName(text);
	label.setText(person.getFirstName());
	field.clear();
 }
 
}