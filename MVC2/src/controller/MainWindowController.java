package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Person;

public class MainWindowController {
  private Main main;
  private Stage primaryStage;
  
  @FXML private TableView<Person> tableView;
  @FXML private TableColumn<Person,String> firstNameColumn;
  @FXML private TableColumn<Person,String> lastNameColumn;
  @FXML private TableColumn<Person,String> ageColumn;
  
  private ObservableList<Person> personList =
	FXCollections.observableArrayList();
  
  public void initialize(){
	firstNameColumn.setCellValueFactory(
	  new PropertyValueFactory<Person,String>("firstName")
	  );  
	lastNameColumn.setCellValueFactory(
	  new PropertyValueFactory<Person,String>("lastName")
	  );
	ageColumn.setCellValueFactory(
	  new PropertyValueFactory<Person,String>("age")
	  );
	
	tableView.getSelectionModel().
	           selectedItemProperty().addListener(
	    (ov, oldVal, newVal)->
	         System.out.println(
	    		newVal.getFirstName()+ " " +
	            newVal.getLastName() )
	  );
	
  }
  
  private void setTable(){
	  personList.add(new Person("Charlie","Brown","10"));
	  personList.add(new Person("Jan","Kowalski","20"));
	  personList.add(new Person("Homer","Simpson","40"));
	  personList.add(new Person("Stefan","Nowak","50"));
	  personList.add(new Person("Adam","Brown","15"));
  }
  
  public void setMain(Main main, Stage primaryStage){
	  this.main=main;
	  this.primaryStage=primaryStage;
	  setTable();
	  tableView.setItems(personList);
  }
  
  @FXML
  public void closeStage()
  {
	  primaryStage.close();
  }
}