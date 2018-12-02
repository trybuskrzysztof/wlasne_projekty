package controller;
	import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;



public class Main extends Application {
	
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();
	}
	
	//nowa metoda odpowiedzialna za główne okno programu
	
	public void mainWindow() {
	try {
		FXMLLoader loader = new FXMLLoader(
				
		Main.class.getResource("/view/MainWindowView.fxml"));//ładowacz zasobów , /view/-załadowany w pakage view
				
			
		AnchorPane pane = loader.load();
		primaryStage.setMinWidth(500.00);
		primaryStage.setMinHeight(600.00);
		
		MainWindowController mainWindowController = 
								loader.getController();
		mainWindowController.setMain(this,primaryStage);						
		
		
		//utworzenie obiektu sceny podając w konstruktorze główny węzeł sceny
		Scene scene = new Scene(pane); //graf sceny
		
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
