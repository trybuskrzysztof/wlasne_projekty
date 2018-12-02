package application;
	
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,320,240,Color.WHITESMOKE);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setTitle("Load barcode");
			
			Text txt = new Text();
			txt.setLayoutX(110);
			txt.setLayoutY(130);
			txt.setText("Decoded Code39:");
			txt.getStyleClass().add("mytext");
			root.getChildren().add(txt);
			
			TextField txtFld = new TextField();
			txtFld.setLayoutX(55);
			txtFld.setLayoutY(140);
			txtFld.setPrefWidth(220);
			root.getChildren().add(txtFld);
			
			Button buttonLoad=new Button();
			buttonLoad.setText("Load");
			buttonLoad.setLayoutX(40);
			buttonLoad.setLayoutY(180);
			buttonLoad.setPrefWidth(60);
			buttonLoad.setPrefSize(80,50);
			buttonLoad.getStyleClass().add("mybutton");
			buttonLoad.setId("countfont");
			root.getChildren().add(buttonLoad);
			
            ImageView myImageView = new ImageView();
            myImageView.relocate(100, 30);
            root.getChildren().add(myImageView);
			
			EventHandler<ActionEvent> buttonLoadEventListener
			= new EventHandler<ActionEvent>(){
		         
                @Override
                public void handle(ActionEvent t) {
                    FileChooser fileChooser = new FileChooser();
                     
                    //Set extension filter
                    FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
                    FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
                    FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
                    fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterJPEG, extFilterPNG);
                      
                    //Show open file dialog
                    File file = fileChooser.showOpenDialog(null);
                    
                    try {
                        BufferedImage bufferedImage = ImageIO.read(file);
                        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                        myImageView.setImage(image);
                        
                    } catch (Exception ignored) {}
                }
            };
			buttonLoad.setOnAction(buttonLoadEventListener);
			
			Button buttonDecode=new Button();
			buttonDecode.setText("Decode");
			buttonDecode.setLayoutX(120);
			buttonDecode.setLayoutY(180);
			buttonDecode.setPrefSize(100,50);
			buttonDecode.getStyleClass().add("mybutton");
			buttonDecode.setId("countfont");
			root.getChildren().add(buttonDecode);
			buttonDecode.setOnAction(
					event -> {
						try {

						} catch (Exception ignored) {}
					});
			
			Button buttonClear=new Button();
			buttonClear.setText("Clear");
			buttonClear.setLayoutX(220);
			buttonClear.setLayoutY(180);
			buttonClear.setPrefWidth(60);
			buttonClear.setPrefSize(80,50);
			buttonClear.getStyleClass().add("mybutton");
			buttonClear.setId("countfont");
			root.getChildren().add(buttonClear);
			buttonClear.setOnAction(
					event -> {
				            txtFld.clear();
				            myImageView.setImage(null);
				        });
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	
}
