package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,320,240,Color.WHITESMOKE);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setTitle("Text compression / decompression");
			
			Text txt1 = new Text();
			txt1.setLayoutX(30);
			txt1.setLayoutY(25);
			txt1.setText("Please type in text to compress/decompress:");
			txt1.getStyleClass().add("mytext");
			root.getChildren().add(txt1);
						
			TextField text1 = new TextField();
			text1.setLayoutX(55);
			text1.setLayoutY(30);
			text1.setPrefWidth(220);
			root.getChildren().add(text1);
			
			Text txt2 = new Text();
			txt2.setLayoutX(110);
			txt2.setLayoutY(115);
			txt2.setText("Check the result:");
			txt2.getStyleClass().add("mytext");
			root.getChildren().add(txt2);
			
			TextField text2 = new TextField();
			text2.setLayoutX(55);
			text2.setLayoutY(120);
			text2.setPrefWidth(220);
			root.getChildren().add(text2);
			
			Button buttonMove=new Button();
			buttonMove.setText("Move ↑");
			buttonMove.setLayoutX(100);
			buttonMove.setLayoutY(65);
			buttonMove.setPrefWidth(60);
			buttonMove.getStyleClass().add("mybutton");
			root.getChildren().add(buttonMove);
			buttonMove.setOnAction(
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
			
			Button buttonClear=new Button();
			buttonClear.setText("Clear");
			buttonClear.setLayoutX(175);
			buttonClear.setLayoutY(65);
			buttonClear.setPrefWidth(60);
			buttonClear.getStyleClass().add("mybutton");
			root.getChildren().add(buttonClear);
			buttonClear.setOnAction(
					event -> {
							text1.clear();
				            text2.clear();
				        });
			
			RadioButton r1 = new RadioButton("Compress");
			r1.setLayoutX(170);
			r1.setLayoutY(160);
			r1.getStyleClass().add("mytext");
			
			RadioButton r2 = new RadioButton("Decompress");
			r2.setLayoutX(170);
			r2.setLayoutY(190);
			r2.getStyleClass().add("mytext");
			
			ToggleGroup toggle_group=new ToggleGroup();
			r1.setToggleGroup(toggle_group);
			r2.setToggleGroup(toggle_group);			

			toggle_group.selectToggle(r1);
			root.getChildren().add(r1);
			root.getChildren().add(r2);
			
			Button buttonCount=new Button();
			buttonCount.setText("Count");
			buttonCount.setLayoutX(55);
			buttonCount.setLayoutY(160);
			buttonCount.setPrefSize(100,50);
			buttonCount.getStyleClass().add("mybutton");
			buttonCount.setId("countfont");
			root.getChildren().add(buttonCount);
			buttonCount.setOnAction(
					event -> {
						try {
						if (r1.getToggleGroup().getSelectedToggle() != null)
							text2.setText(compress(text1.getText()));
						
						if (r2.getToggleGroup().getSelectedToggle() != null)
							text2.setText(decompress(text1.getText()));
						} catch (Exception ignored) {}
					});
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	static String compress(String str) {
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
	static String decompress(String str) {
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
