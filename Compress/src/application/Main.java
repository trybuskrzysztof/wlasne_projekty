package application;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,400,250);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//dodawanie pola tekstowego 1
			TextField text1 = new TextField();
			text1.setLayoutX(100);
			text1.setLayoutY(10);
			root.getChildren().add(text1);
			
			Button button1=new Button();
			button1.setText("Kopiuj");
			button1.setLayoutX(150);
			button1.setLayoutY(40);
			button1.setOnAction(
					event -> 
					{
						if (r1.getSelectedToggle(toggle_group))
						{
							text1.compress
						}
					}
					);
			root.getChildren().add(button1);
			
			//dodawanie pola tekstowego 2
			TextField text2 = new TextField();
			text2.setLayoutX(100);
			text2.setLayoutY(70);
			root.getChildren().add(text2);
			
			Button button2=new Button();
			button2.setText("Licz");
			button2.setLayoutX(20);
			button2.setLayoutY(150);
			button1.setOnAction(
					event -> 
			root.getChildren().add(button2));			
			
			RadioButton r1 = new RadioButton("Kompresuj");
			r1.setUserData("Wybrano 1");
			r1.setLayoutX(200);
			r1.setLayoutY(150);
			
			RadioButton r2 = new RadioButton("Dekompresuj");
			r2.setUserData("Wybrano 2");
			r2.setLayoutX(200);
			r2.setLayoutY(180);
			
			ToggleGroup toggle_group=new ToggleGroup();
			r1.setToggleGroup(toggle_group);
			r2.setToggleGroup(toggle_group);			
			// ustawia poczatkowa wartosc przyciskow radiowych
			toggle_group.selectToggle(r1);
			root.getChildren().add(r1);
			root.getChildren().add(r2);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String compress(String src){
		for (i=0, i)
	}
	
	public String decompress(String src){
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
