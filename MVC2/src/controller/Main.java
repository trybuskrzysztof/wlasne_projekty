package controller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		mainWindow();
	}
	
	public void mainWindow(){
		try {
			FXMLLoader loader=new FXMLLoader(
			  Main.class.getResource("/view/MainWindowView.fxml"));
			AnchorPane pane = loader.load();
			
			primaryStage.setMinWidth(500.00);
			primaryStage.setMinHeight(600.00);
			
			Scene scene=new Scene(pane);
			
			MainWindowController mainWindowController = loader.getController();
			mainWindowController.setMain(this, primaryStage);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}