package application;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// etykieta z napisem
			Label label = new Label("Hello world!");
			root.setLeft(label);
			
			Label jeden = new Label("Test jeden");
			root.setLeft(label);
			
			// kontener porzadkujacy elementy w pionie
			VBox left_vbox=new VBox(10);
			left_vbox.getChildren().add(label);
			left_vbox.getChildren().add(jeden);
			root.setLeft(left_vbox);
			
			//utworzenie kontenera typu Group
			Group center_group=new Group();
			root.setCenter(center_group);
			
			//dodawanie pola tekstowego 1
			TextField text1 = new TextField();
			text1.getStyleClass().add("my-field");
			text1.setLayoutX(10);
			text1.setLayoutY(10);
			center_group.getChildren().add(text1);
			
			//dodawanie pola tekstowego 2
			TextField text2 = new TextField();
			text2.getStyleClass().add("my-field");
			text2.setLayoutX(10);
			text2.setLayoutY(60);
			center_group.getChildren().add(text2);
			
			//przyciski radiowe
			RadioButton r1 = new RadioButton("1");
			r1.setUserData("Wybrano 1");
			RadioButton r2 = new RadioButton("2");
			r2.setUserData("Wybrano 2");
			ToggleGroup toggle_group=new ToggleGroup();
			r1.setToggleGroup(toggle_group);
			r2.setToggleGroup(toggle_group);
			
			// ustawia poczatkowa wartosc przyciskow radiowych
			toggle_group.selectToggle(r2);
			
			toggle_group.selectedToggleProperty().addListener(
					(ov,oldToggle,newToggle) ->
					{
					if (toggle_group.getSelectedToggle()!=null)
						{
						System.out.println(
						toggle_group.getSelectedToggle().getUserData().toString()
						);
						}
					}
					);
			
			VBox right_vbox=new VBox(10);
			right_vbox.getChildren().add(r1);
			right_vbox.getChildren().add(r2);
			root.setRight(right_vbox);
			
			//dodanie przycisku do okna dialogowego
			Button button1=new Button();
			button1.setId("my-button1");
			button1.setText("Click me!");			
			button1.setOnAction(
					event -> 
					{
					System.out.println("Button 1 clicked");
						// pobranie i wyswietlanie tekstu
					System.out.println(text1.getText());
					
					if (text1.getText().matches("[0-9]{3}-[0-9]{2}-[0-9]{2}"))
							{
							System.out.println("Wpisano nr tel w polu 1");
							Alert alert = new Alert(
									AlertType.CONFIRMATION,
									"Wpisano poprawny numer telefonu.");
							Optional<ButtonType> result=alert.showAndWait();
							if (result.isPresent() && result.get()==ButtonType.OK)
								System.out.println("Okno z komunikatem zakonczone powodzeniem");
							}
					if(text2.getText().matches("(JA|GK|BD|DS)\\d{2}[ZL]\\d{2}"))
							{
							String test=text2.getText().substring(2,4);
							int rok=Integer.parseInt(test);
							if (rok >=15 && rok <=20)
								System.out.println("Wpisano numer grupy");
							}
					if (toggle_group.getSelectedToggle()!=null)
							{
							System.out.println(
							toggle_group.getSelectedToggle().getUserData().toString()
							);
							}
					}
					);
			root.setBottom(button1);
			
			Button button2=new Button();
			button2.setText("Click me too!");			
			button2.setOnAction(
					event ->
					{
					System.out.println("Button 2 clicked");
					//utworzenie nowego okna
					Stage stage=new Stage();
					stage.setTitle("Dialog box");
					//korzen grafu sceny okna dialogowego
					BorderPane rootdlg=new BorderPane();
					stage.setScene(new Scene(rootdlg,200,100));
					
					Label msg = new Label("Okno dialogowe");
					rootdlg.setCenter(msg);
					
					stage.initOwner(primaryStage);
					stage.initModality(Modality.WINDOW_MODAL);
					stage.show();
					}
				);
			root.setBottom(button2);
			
			HBox bottom_hbox=new HBox(100);
			bottom_hbox.getChildren().add(button1);
			bottom_hbox.getChildren().add(button2);
			root.setBottom(bottom_hbox);
			
			//dorzucamy obrazek
			// Image test_image=new Image(getClass().getResourceAsStream("lenna256px.png"));
			Image test_image=new Image("http://galera.ii.pw.edu.pl/~zsz/javafx/img/lenna256px.png");
			ImageView test_image_view=new ImageView(test_image);
			root.setTop(test_image_view);
			
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
