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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import com.pqscan.barcodereader.BarCodeType;
import com.pqscan.barcodereader.BarcodeResult;
import com.pqscan.barcodereader.BarcodeScanner;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,320,240,Color.WHITESMOKE);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setTitle("Code39 Barcode Reader");
			
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
            
            Label myImageViewLabel1 = new Label();
            myImageViewLabel1.setText("Press 'Load' to import barcode image");
            myImageViewLabel1.setLayoutX(67);
            myImageViewLabel1.setLayoutY(45);
            myImageViewLabel1.setId("label");
            root.getChildren().add(myImageViewLabel1);
            
            Label myImageViewLabel2 = new Label();
            myImageViewLabel2.setText("Press 'Decode' to decrypt imported image");
            myImageViewLabel2.setLayoutX(60);
            myImageViewLabel2.setLayoutY(65);
            myImageViewLabel2.setId("label");
            root.getChildren().add(myImageViewLabel2);
            
            Label myImageViewLabel3 = new Label();
            myImageViewLabel3.setText("Press 'Clear' to erase barcode image and text");
            myImageViewLabel3.setLayoutX(52);
            myImageViewLabel3.setLayoutY(85);
            myImageViewLabel3.setId("label");
            root.getChildren().add(myImageViewLabel3);
			
			EventHandler<ActionEvent> buttonLoadEventListener
			= new EventHandler<ActionEvent>(){
		         
                @Override
                public void handle(ActionEvent t) {
                    FileChooser fileChooser = new FileChooser();
                     
                    FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
                    FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
                    FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
                    FileChooser.ExtensionFilter extFilterASPX = new FileChooser.ExtensionFilter("ASPX files (*.aspx)", "*.ASPX");
                    fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterJPEG, extFilterPNG, extFilterASPX);
                      
                    File file = fileChooser.showOpenDialog(null);
                    
                    try {
                        BufferedImage bufferedImage = ImageIO.read(file);
                        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                        myImageView.setImage(image);
                        myImageViewLabel1.setText("");
                        myImageViewLabel2.setText("");
                        myImageViewLabel3.setText("");
                       
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
							Image imageScan = myImageView.getImage();
							BufferedImage bufferedImageScan = SwingFXUtils.fromFXImage(imageScan, null);
				            BarcodeResult[] results = BarcodeScanner.Scan(
				            		bufferedImageScan				            		
				            		,
				            		BarCodeType.Code39);

				            for(int i = 0; i < results.length; i++)
				            {
				                txtFld.setText((results[i].getData()));
				            }
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
				            myImageViewLabel1.setText("Press 'Load' to import barcode image");
				            myImageViewLabel2.setText("Press 'Decode' to decrypt imported image");
				            myImageViewLabel3.setText("Press 'Clear' to erase barcode image and text");
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
