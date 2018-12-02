package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * FadeTransition - przezroczystosć
 * FillTransition - kolor,wypełnienie
 * PathTransition - ruch wzdłuż,wzwyż
 *  Rotate transition -obroty
 * ScaleTransition- skalowanie
 * StrokeTRansition- kolorlinii
 * TranslateTransition- przesuniecie
 * 
 * SequentialTransition złożenue sekwencyjne
 * ParallelTansition złożenie równległe
 */ 

public class MainWindowController {
	private Main main;
	private Stage primaryStage;
	
	public void setMain(Main main, Stage primaryStage){
		this.primaryStage=primaryStage;
		this.main=main;
	}
	
	@FXML 
	public void closeMainWindow()
	{
		primaryStage.close();
	}
	@FXML 
	public void imageViewClicked(MouseEvent event){
		System.out.println(event.getX()+"  "+event.getY());
		
		
		
		int animationNo;
		int row,col;
		
		double x,y;
		
		x=event.getX();
		y=event.getY();
		
		col= (int) (x/150.0);
		row= (int) (y/150.0);
		
		animationNo= (row*3) + col +1;
		//animationNo =1;
		
		
		
		
		
		animationWindow(animationNo);
		System.out.println("Wybrana animacja: "+ animationNo);
		
	}
	
	public void animationWindow(int animationNo){
		
		
		try{
		FXMLLoader loader = new FXMLLoader(
				
				Main.class.getResource("/view/AnimationWindowView.fxml"));//ładowacz zasobów , /view/-załadowany w pakage view
						
					
				AnchorPane animationPane = loader.load();
				Stage animationWindowStage=new Stage();
				animationWindowStage.setTitle("AnimationWindow");
				animationWindowStage.initModality(Modality.WINDOW_MODAL); //to okienko będzie oknem modalnym
				animationWindowStage.initOwner(primaryStage);
				animationWindowStage.setMinWidth(450);
				animationWindowStage.setMinHeight(490);
				
				Scene scene =new  Scene(animationPane);
				animationWindowStage.setScene(scene);
				AnimationWindowController controller = loader.getController();
				controller.setAnimationWindowStage(animationWindowStage);
				
				controller.setAnimationNo(animationNo);
				animationWindowStage.showAndWait();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
				
		}

	}
}
