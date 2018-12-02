package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.Person;

public class MainWindowController {
  private Main main;
  private Stage primaryStage;
  private Person person;
  
  @FXML private TableView<Person> tableView;
  @FXML private TableColumn<Person,String> firstNameColumn;
  @FXML private TableColumn<Person,String> lastNameColumn;
  @FXML private TableColumn<Person,String> roomNumberColumn;
  @FXML private TableColumn<Person,String> hourBeginningColumn;
  @FXML private TableColumn<Person,String> hourEndColumn;
  
  @FXML private Button buttonAdd;
  @FXML private TextField firstNameField;
  @FXML private TextField lastNameField;
  @FXML private TextField roomNumberField;
  @FXML private TextField hourBeginningField;
  @FXML private TextField hourEndField;
  
  @FXML private Button buttonImport;
  @FXML private Button buttonExport;
  
  @FXML private Button buttonGenerate;
  @FXML private ImageView listaImage;
  
  @FXML private Button buttonClear;
  
  private ObservableList<Person> personList =
	FXCollections.observableArrayList();
  
  public void initialize(){
	firstNameColumn.setCellValueFactory(
	  new PropertyValueFactory<Person,String>("firstName")
	  );  
	
	lastNameColumn.setCellValueFactory(
	  new PropertyValueFactory<Person,String>("lastName")
	  );
	
	roomNumberColumn.setCellValueFactory(
	  new PropertyValueFactory<Person,String>("roomNumber")
	  );
	
	hourBeginningColumn.setCellValueFactory(
			  new PropertyValueFactory<Person,String>("hourBeginning")
			  );
	
	hourEndColumn.setCellValueFactory(
			  new PropertyValueFactory<Person,String>("hourEnd")
			  );
	
	tableView.getSelectionModel().
    	selectedItemProperty().addListener(
    			(ov, oldVal, newVal)->
    			System.out.println(
    					newVal.getRoomNumber())
    			);
	
  }
  
  /*
  private void setTable(){
	  personList.add(new Person("Charlie","Brown","10","12","14"));
	  personList.add(new Person("Jan","Kowalski","20","13","15"));
	  personList.add(new Person("Homer","Simpson","40","9","10"));
	  personList.add(new Person("Stefan","Nowak","50","2","12"));
	  personList.add(new Person("Adam","Brown","15","12","13"));
  }
  
  */
  public void setMain(Main main, Stage primaryStage){
	  this.main=main;
	  this.primaryStage=primaryStage;
	  //setTable();
	  tableView.setItems(personList);
	  person= new Person(" ");
  }

  public void addValue(){
	  personList.add(new Person(firstNameField.getText(),
			  					lastNameField.getText(),
			  					roomNumberField.getText(),
			  					hourBeginningField.getText(),
			  					hourEndField.getText()
			  					)
			  );

	  firstNameField.clear();
	  lastNameField.clear();
	  roomNumberField.clear();
	  hourBeginningField.clear();
	  hourEndField.clear();
  }
  //Import pliku
  public void listImport() {
	  String CsvFile = "C:\\Users\\trybusk\\Desktop\\lista.csv";
      String FieldDelimiter = ",";

      BufferedReader br;

      try {
          br = new BufferedReader(new FileReader(CsvFile));

          String line;
          while ((line = br.readLine()) != null) {
              String[] fields = line.split(FieldDelimiter, -1);

              Person person = new Person(fields[0], fields[1], fields[2],
                      fields[3], fields[4]);
              personList.add(person);

          }

      } catch (FileNotFoundException ex) {
	        ex.printStackTrace();
          
      } catch (IOException ex) {
	        ex.printStackTrace();
      }
  }
  
//zapis pliku  
 
  /*
  public void listExport(ActionEvent event) {
	  FileChooser fileChooser = new FileChooser();
      
      //Set extension filter
      FileChooser.ExtensionFilter extFilter = 
          new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
      fileChooser.getExtensionFilters().add(extFilter);
       
      //Show save file dialog
      File file = fileChooser.showSaveDialog(primaryStage);
       
      if(file != null){
          SaveFile(tableView.getText(), file);
      }
  }
	  */
  
  public void listExport() throws Exception {
	    Writer writer = null;
	    try {
	        File file = new File("C:\\Users\\trybusk\\Desktop\\lista.csv");
	        writer = new BufferedWriter(new FileWriter(file));
	        for (Person person : personList) {

	            String text = person.getFirstName() + ","
	            			+ person.getLastName() + ","
	            			+ person.getRoomNumber() + ","
	            			+ person.getHourBeginning() + ","
	            			+ person.getHourEnd() + "\n";

	            writer.write(text);
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    finally {
	        writer.flush();
	        writer.close();
	    } 
	}
  
  public void listClear() {
	  tableView.getItems().clear();
  	} 
  
  
}      