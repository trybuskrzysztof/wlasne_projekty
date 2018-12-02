package application;
	
/**
 * 
 */
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * 
 * @author Damian Joniec 
 * 2017
 *
 */
public class Main extends Application {
	

	public static  double a;
	public static double  b;
	Path path;
	@Override
	
	
	
	
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.setPadding(new Insets(10));
		
			
			Group centerGroup = new Group();
			root.setCenter(centerGroup);
			
			
			
			Path path = new Path();
			
			path.setStrokeWidth(1);
		  
			
			
			//=======================================================================
			
			//IKONA I TYTY�
			primaryStage.setTitle("Wykres Damian_Joniec");
			//primaryStage.getIcons().add(new Image("parabola.jpg"));
			
			GridPane gridpaneTop = new GridPane();
			

			Label mainLabel = new Label("wykres funkcji f(x)= ax^2 +b");
			
			
			
			
			GridPane.setHalignment(mainLabel, HPos.RIGHT);
			gridpaneTop.add(mainLabel,0,0);
			root.setTop(gridpaneTop);
			
			mainLabel.setAlignment(Pos.CENTER);
			
		
			
			GridPane gridpane = new GridPane();
			gridpane.setPadding(new Insets(30,5,5,5));
			gridpane.setHgap(5); //odleg�o�� napisu od polatekstowego
			gridpane.setVgap(5); // odleg�o�� wierszy od siebie
			
			ColumnConstraints column1 = new ColumnConstraints(50);
			ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
			column2.setHgrow(Priority.ALWAYS);
			
			gridpane.getColumnConstraints().addAll(column1, column2);
						
			root.setLeft(gridpane);
			
			//podaj A
			Label labelA = new Label("podaj a: ");
			TextField textFieldA = new TextField();
			//podaj B					
			Label labelB= new Label("podaj b: ");
			TextField textFieldB = new TextField();
		
			
			//Rysuj
			Button btn2 = new Button();
			
			btn2.setText("  CZY��  ");
			btn2.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event2){
				System.out.println("Clicked2");

				path.getElements().clear();
			}
		});
			
			
			Button btn = new Button();
			btn.setText("  RYSUJ  ");
			btn.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					System.out.println("Clicked");
					
					
				try{
					 
					 
					 
					 a = Double.parseDouble(textFieldA.getText());
					 b = Double.parseDouble(textFieldB.getText());
				}catch(Exception ignored){};
				
			
					
					
					//10pkt 0 - 125
				
					LineTo lineTo1 = new LineTo();
					LineTo lineTo2 = new LineTo();
					LineTo lineTo3 = new LineTo();
					LineTo lineTo4 = new LineTo();
					LineTo lineTo5 = new LineTo();
					LineTo lineTo6 = new LineTo();
					LineTo lineTo7 = new LineTo();
					LineTo lineTo8 = new LineTo();
					LineTo lineTo9 = new LineTo();
					LineTo lineTo10 = new LineTo();
					
					//20pkt highprecize - 125-250
					LineTo lineTo11 = new LineTo();
					LineTo lineTo12 = new LineTo();
					LineTo lineTo13 = new LineTo();
					LineTo lineTo14 = new LineTo();
					LineTo lineTo15 = new LineTo();
					LineTo lineTo16 = new LineTo();
					LineTo lineTo17 = new LineTo();
					LineTo lineTo18 = new LineTo();
					LineTo lineTo19 = new LineTo();
					LineTo lineTo20 = new LineTo();
					LineTo lineTo21 = new LineTo();
					LineTo lineTo22 = new LineTo();
					LineTo lineTo23 = new LineTo();
					LineTo lineTo24 = new LineTo();
					LineTo lineTo25 = new LineTo();
					LineTo lineTo26 = new LineTo();
					LineTo lineTo27 = new LineTo();
					LineTo lineTo28 = new LineTo();
					LineTo lineTo29 = new LineTo();
					LineTo lineTo30 = new LineTo();
					LineTo lineTo31 = new LineTo();
					//20pkt highprecize + 250 - 375
					LineTo lineTo32 = new LineTo();
					LineTo lineTo33 = new LineTo();
					LineTo lineTo34 = new LineTo();
					LineTo lineTo35 = new LineTo();
					LineTo lineTo36 = new LineTo();
					LineTo lineTo37 = new LineTo();
					LineTo lineTo38 = new LineTo();
					LineTo lineTo39 = new LineTo();
					LineTo lineTo40 = new LineTo();
					LineTo lineTo41 = new LineTo();
					LineTo lineTo42 = new LineTo();
					LineTo lineTo43 = new LineTo();
					LineTo lineTo44 = new LineTo();
					LineTo lineTo45 = new LineTo();
					LineTo lineTo46 = new LineTo();
					LineTo lineTo47 = new LineTo();
					LineTo lineTo48 = new LineTo();
					LineTo lineTo49 = new LineTo();
					LineTo lineTo50 = new LineTo();
					LineTo lineTo51 = new LineTo();
					LineTo lineTo52 = new LineTo();
					//10pkt 375-500
					LineTo lineTo53 = new LineTo();
					LineTo lineTo54 = new LineTo();
					LineTo lineTo55 = new LineTo();
					LineTo lineTo56= new LineTo();
				
					//
					MoveTo moveTo = new MoveTo();
					
					
					Points.oblicz(0.0);
					//y=a(x-255)^2+b
//					
					moveTo.setX(0);
					moveTo.setY(Points.oblicz(0.0));
					//  10
					lineTo1.setX(12.5);
					lineTo1.setY(Points.oblicz(12.5));
					
					lineTo2.setX(25);
					lineTo2.setY(Points.oblicz(25));
					
					lineTo3.setX(37.5);
					lineTo3.setY(Points.oblicz(37.5));
					
					lineTo4.setX(50);
					lineTo4.setY(Points.oblicz(50));
					
					lineTo5.setX(62.5);
					lineTo5.setY(Points.oblicz(62.5));
					
					lineTo6.setX(75);
					lineTo6.setY(Points.oblicz(75));
					
					lineTo7.setX(87.5);
					lineTo7.setY(Points.oblicz(87.5));
					
					lineTo8.setX(100);
					lineTo8.setY(Points.oblicz(100));
					
					lineTo9.setX(112.5);
					lineTo9.setY(Points.oblicz(112.5));
					
					lineTo10.setX(125);
					lineTo10.setY(Points.oblicz(125));
					// 18
					lineTo11.setX(131.25);
					lineTo11.setY(Points.oblicz(131.25));
					
					lineTo12.setX(137.5);
					lineTo12.setY(Points.oblicz(137.5));
					
					lineTo13.setX(143.75);
					lineTo13.setY(Points.oblicz(143.75));
					
					lineTo14.setX(150);
					lineTo14.setY(Points.oblicz(150));
					
					lineTo15.setX(156.25);
					lineTo15.setY(Points.oblicz(156.25));
					
					lineTo16.setX(162.5);
					lineTo16.setY(Points.oblicz(162.5));
					
					lineTo17.setX(168.75);
					lineTo17.setY(Points.oblicz(168.75));
					
					lineTo18.setX(175);
					lineTo18.setY(Points.oblicz(175));
					
					lineTo19.setX(181.25);
					lineTo19.setY(Points.oblicz(181.25));
					
					lineTo20.setX(187.5);
					lineTo20.setY(Points.oblicz(187.5));
					
					lineTo21.setX(193.75);
					lineTo21.setY(Points.oblicz(193.75));
					
					lineTo22.setX(206.25);
					lineTo22.setY(Points.oblicz(206.25));
					
					lineTo23.setX(212.5);
					lineTo23.setY(Points.oblicz(212.5));
					
					lineTo24.setX(225);
					lineTo24.setY(Points.oblicz(225));
					
					lineTo25.setX(231.25);
					lineTo25.setY(Points.oblicz(231.25));
					
					lineTo26.setX(237.5);
					lineTo26.setY(Points.oblicz(237.5));
					
					lineTo27.setX(243.75);
					lineTo27.setY(Points.oblicz(243.75));
					
					lineTo28.setX(250);
					lineTo28.setY(Points.oblicz(250));
					
					// next 18 high precise
					
					lineTo29.setX(256.5);
					lineTo29.setY(Points.oblicz(256.5));
					
					lineTo30.setX(262.5);
					lineTo30.setY(Points.oblicz(262.5));
					
					lineTo31.setX(268.5);
					lineTo31.setY(Points.oblicz(268.5));
					
					
					
					lineTo32.setX(275);
					lineTo32.setY(Points.oblicz(275));
					
					lineTo33.setX(281.25);
					lineTo33.setY(Points.oblicz(281.25));
					
					lineTo34.setX(287.5);
					lineTo34.setY(Points.oblicz(287.5));
					
					lineTo35.setX(293.75);
					lineTo35.setY(Points.oblicz(293.75));
					
					lineTo36.setX(300);
					lineTo36.setY(Points.oblicz(300));
					
					lineTo37.setX(306.25);
					lineTo37.setY(Points.oblicz(306.25));
					
					lineTo38.setX(312.5);
					lineTo38.setY(Points.oblicz(312.5));
					
					lineTo39.setX(318.75);
					lineTo39.setY(Points.oblicz(318.75));
					
					lineTo40.setX(325);
					lineTo40.setY(Points.oblicz(325));
					
					//
					lineTo41.setX(337.5);
					lineTo41.setY(Points.oblicz(337.5));
					
					lineTo42.setX(350);
					lineTo42.setY(Points.oblicz(350));
					//
					
					lineTo43.setX(356.25);
					lineTo43.setY(Points.oblicz(356.25));
					
					lineTo44.setX(362.5);
					lineTo44.setY(Points.oblicz(362.5));
					
					lineTo45.setX(368.75);
					lineTo45.setY(Points.oblicz(368.75));
					
					lineTo46.setX(375);
					lineTo46.setY(Points.oblicz(375));
					//
					//last 10
					
					lineTo47.setX(387.5);
					lineTo47.setY(Points.oblicz(387.5));
					
					lineTo48.setX(400);
					lineTo48.setY(Points.oblicz(400));
					
					lineTo49.setX(412.5);
					lineTo49.setY(Points.oblicz(412.5));
					
					lineTo50.setX(425);
					lineTo50.setY(Points.oblicz(425));
					
					lineTo51.setX(437.5);
					lineTo51.setY(Points.oblicz(437.5));
					
					lineTo52.setX(450);
					lineTo52.setY(Points.oblicz(450));
					
					
					lineTo53.setX(462.5);
					lineTo53.setY(Points.oblicz(462.5));
					
					lineTo54.setX(475);
					lineTo54.setY(Points.oblicz(475));
					
					lineTo55.setX(487.5);
					lineTo55.setY(Points.oblicz(487.5));
					
					lineTo56.setX(500);
					lineTo56.setY(Points.oblicz(500));
					
					
					// FINISH
					
				
					
					
				try{
					path.getElements().addAll(moveTo,
							lineTo1,lineTo2,lineTo3,lineTo4,lineTo5,lineTo6,lineTo7,lineTo8,lineTo9,lineTo10,
							lineTo11,lineTo12,lineTo13,lineTo14,lineTo15,lineTo16,lineTo17,lineTo18,lineTo19,lineTo20,
							lineTo21,lineTo22,lineTo23,lineTo24,lineTo25,lineTo26,lineTo27,lineTo28,lineTo29,lineTo30,lineTo31,
							lineTo32,lineTo33,lineTo34,lineTo35,lineTo36,lineTo37,lineTo38,lineTo39,lineTo40,lineTo41,lineTo42,
							lineTo43,lineTo44,lineTo45,lineTo46,lineTo47,lineTo48,lineTo49,lineTo50,lineTo51,lineTo52,lineTo53,lineTo54,lineTo55,
							lineTo56
							
							);
					centerGroup.getChildren().add(path);
				}catch(IllegalArgumentException e) { System.out.println("dodaje wykres do poprzedniego");}
					
					
				}
				
			});
		
		
			
			
			
			//dodawanie do siatki pytania o a
			GridPane.setHalignment(labelA, HPos.RIGHT);
			gridpane.add(labelA, 0, 0);
			
			//dodawanie do siatki pytania o b
			GridPane.setHalignment(labelB, HPos.RIGHT);
			gridpane.add(labelB, 0, 1);
			
			//dodawanie do siatki pola tekstowego a
			GridPane.setHalignment(textFieldA, HPos.LEFT);
			gridpane.add(textFieldA, 1,	0);
			
			//dodawanie do siatki pola tekstowego b
			GridPane.setHalignment(textFieldB, HPos.LEFT);
			gridpane.add(textFieldB, 1, 1);
			
			//dodawanie do siatki przycisku rysuj
			GridPane.setHalignment(btn, HPos.CENTER);
			gridpane.add(btn, 1, 2);
			
			GridPane.setHalignment(btn2, HPos.CENTER);
			gridpane.add(btn2, 1, 3);
			
			//PLOT========================================================================
			
		
			
			double defaultX =0.0;
			double defaultY =0.0;
			
			Line redLine = new Line(defaultX,250,500,250);
			Line vertLine = new Line(250,0,250,500);
			Line topLine = new Line(0,0,500,0);
			topLine.setStrokeWidth(2);
			Line leftLine = new Line(0,0,0,500);
			leftLine.setStrokeWidth(2);
			Line rightLine = new Line(500,0,500,500);
			rightLine.setStrokeWidth(2);
			Line bottomLine = new Line(0,500,500,500);
			bottomLine.setStrokeWidth(2);
			
			//oznaczenie Y
			Font serif = new Font("Serif",15);
			Text textY = new Text(-5,-5,"f(x)");
			textY.setFont(serif);
			//oznaczenie X
			Text textX = new Text(505,505,"x");
			textX.setFont(serif);
			//�rodek 0.0
			Text text0 = new Text(260,265,"0");
			text0.setFont(serif);
			
			centerGroup.getChildren().add(redLine);
			centerGroup.getChildren().add(vertLine);
			centerGroup.getChildren().add(topLine);
			centerGroup.getChildren().add(leftLine);
			centerGroup.getChildren().add(rightLine);
			centerGroup.getChildren().add(bottomLine);
			centerGroup.getChildren().add(textY);
			centerGroup.getChildren().add(textX);
			centerGroup.getChildren().add(text0);
			
			//dodawanie skali o� x
			
			Line minus4 = new Line(50,240,50,260);
			Text min4 = new Text(50,270,"-4");
			min4.setFont(serif);
			Line minus3 = new Line(100,240,100,260);
			Text min3 = new Text(100,270,"-3");
			min3.setFont(serif);
			Line minus2 = new Line(150,240,150,260);
			Text min2 = new Text(150,270,"-2");
			min2.setFont(serif);
			Line minus1 = new Line(200,240,200,260);
			Text min1 = new Text(200,270,"-1");
			min1.setFont(serif);
		
			Line plus1 = new Line(300,240,300,260);
			Text plu1 = new Text(305,270,"1");
			plu1.setFont(serif);
			Line plus2 = new Line(350,240,350,260);
			Text plu2 = new Text(355,270,"2");
			plu2.setFont(serif);
			
			Line plus3 = new Line(400,240,400,260);
			Text plu3 = new Text(405,270,"3");
			plu3.setFont(serif);
			Line plus4 = new Line(450,240,450,260);
			Text plu4 = new Text(455,270,"4");
			plu4.setFont(serif);
			
			//add text OX
			centerGroup.getChildren().add(min4);
			centerGroup.getChildren().add(min3);
			centerGroup.getChildren().add(min2);
			centerGroup.getChildren().add(min1);
			
			centerGroup.getChildren().add(plu4);
			centerGroup.getChildren().add(plu3);
			centerGroup.getChildren().add(plu2);
			centerGroup.getChildren().add(plu1);
			// add lines OX
			centerGroup.getChildren().add(minus4);
			centerGroup.getChildren().add(minus3);
			centerGroup.getChildren().add(minus2);
			centerGroup.getChildren().add(minus1);
			
			centerGroup.getChildren().add(plus1);
			centerGroup.getChildren().add(plus2);
			centerGroup.getChildren().add(plus3);
			centerGroup.getChildren().add(plus4);
			//dodawanie skali o� y
			
			Line plus1y = new Line(240,200,260,200);
			Text plu1y = new Text(265,200,"1");
			plu1y.setFont(serif);
			Line plus2y = new Line(240,150,260,150);
			Text plu2y = new Text(265,150,"2");
			plu2y.setFont(serif);
			Line plus3y = new Line(240,100,260,100);
			Text plu3y = new Text(265,100,"3");
			plu3y.setFont(serif);
			Line plus4y = new Line(240,50,260,50);
			Text plu4y = new Text(265,50,"4");
			plu4y.setFont(serif);
			
			centerGroup.getChildren().add(plu1y);
			centerGroup.getChildren().add(plu2y);
			centerGroup.getChildren().add(plu3y);
			centerGroup.getChildren().add(plu4y);
			
			
			Line minus4y = new Line(240,450,260,450);
			Text min4y = new Text(265,450,"-4");
			min4y.setFont(serif);
			Line minus3y = new Line(240,400,260,400);
			Text min3y = new Text(265,400,"-3");
			min3y.setFont(serif);
			Line minus2y = new Line(240,350,260,350);
			Text min2y = new Text(265,350,"-2");
			min2y.setFont(serif);
			Line minus1y = new Line(240,300,260,300);
			Text min1y = new Text(265,300,"-1");
			min1y.setFont(serif);
			
			centerGroup.getChildren().add(min4y);
			centerGroup.getChildren().add(min3y);
			centerGroup.getChildren().add(min2y);
			centerGroup.getChildren().add(min1y);
			
			centerGroup.getChildren().add(minus4y);
			centerGroup.getChildren().add(minus3y);
			centerGroup.getChildren().add(minus2y);
			centerGroup.getChildren().add(minus1y);
			
			centerGroup.getChildren().add(plus1y);
			centerGroup.getChildren().add(plus2y);
			centerGroup.getChildren().add(plus3y);
			centerGroup.getChildren().add(plus4y);
			
			
		
		
			//ENDOFPLOT=======
			

			
			//=======================================================================
			
			
			
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
