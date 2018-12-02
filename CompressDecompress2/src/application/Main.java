package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,320,240);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);
			
			//dodawanie pola tekstowego 1
			TextField text1 = new TextField();
			text1.setLayoutX(55);
			text1.setLayoutY(20);
			text1.setPrefWidth(220);
			root.getChildren().add(text1);
			
			//dodawanie pola tekstowego 2
			TextField text2 = new TextField();
			text2.setLayoutX(55);
			text2.setLayoutY(80);
			text2.setPrefWidth(220);
			root.getChildren().add(text2);
			
			Button button1=new Button();
			button1.setText("Kopiuj");
			button1.setLayoutX(140);
			button1.setLayoutY(50);
			root.getChildren().add(button1);
			button1.setOnAction(
					event -> {
						if (text2.getText() != null && !text2.getText().isEmpty()
							) {
							text1.setText(text2.getText());
							text2.clear();
						}
						else {
				            text1.setText("Please input text below");
				            text2.clear();
				        }
					});
			
			RadioButton r1 = new RadioButton("Kompresuj");
			r1.setLayoutX(170);
			r1.setLayoutY(150);
			
			RadioButton r2 = new RadioButton("Dekompresuj");
			r2.setLayoutX(170);
			r2.setLayoutY(180);
			
			ToggleGroup toggle_group=new ToggleGroup();
			r1.setToggleGroup(toggle_group);
			r2.setToggleGroup(toggle_group);			
			// ustawia poczatkowa wartosc przyciskow radiowych
			toggle_group.selectToggle(r1);
			root.getChildren().add(r1);
			root.getChildren().add(r2);
			toggle_group.selectedToggleProperty().addListener(
					
					(ov,oldToggle,newToggle) ->
						{						
						if(toggle_group.getSelectedToggle()!=null)
							System.out.println(
							toggle_group.getSelectedToggle().getUserData().toString()
						  );
						comp = toggle_group.getSelectedToggle().getUserData().toString();	
						}
					
					);
			
			Button button2=new Button();
			button2.setText("Licz");
			button2.setLayoutX(55);
			button2.setLayoutY(150);
			button2.setPrefSize(100,50);
			button2.setId("my-button1");
			root.getChildren().add(button2);
			button2.setOnAction(
					event -> {
						if (comp == "compres")
					 	{
						//encode(poletekstowe1.getText());
						text2.setText(compress(text1.getText()));
						
					 	}
					 //jeżeli zaznaczona dekompresja to dekompresuj
					 else if (comp == "decompres")
						{
							//decode("1W1B1W1B1W1B1W1B1W1B1W1B1W1B");
						 text2.setText(decompress(text1.getText()));
							
						}
					});
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static String compress(String str) {
	        StringBuffer dest = new StringBuffer();
	        for (int i = 0; i < str.length(); i++) {
	            int runLength = 1;
	            while (i+1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
	                runLength++;
	                i++;
	            }
	            dest.append(runLength);
	            dest.append(str.charAt(i));
	        }
	        return dest.toString();
	}
	public static String decompress(String str) {
        StringBuffer dest = new StringBuffer();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            matcher.find();
            while (number-- != 0) {
                dest.append(matcher.group());
            }
        }
        return dest.toString();
    }
	private String comp = "compres";
	
	public static void main(String[] args) {
		launch(args);
	}
}
