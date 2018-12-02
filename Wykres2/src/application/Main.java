package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	Label labError;
	BorderPane root;
	Path path;
	
	Label labPx1,labPx2,labPy1,labPy2;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Wykres funkcji kwadratowej - Agnieszka �widerska");
			
			//double scale = 0.1;
			
			Group wykres = new Group();
			
			int wykresSize = 420;  //musi byc podzielne przez 10 !!!
			int wykresSize2 = wykresSize/2;
			
			Rectangle rect = new Rectangle(0,0,wykresSize,wykresSize);
			rect.setFill(Color.WHITE);
			
			Line lineX = new Line(wykresSize2,10,wykresSize2,wykresSize-10);
			Line linX1 = new Line(wykresSize2-10,20,wykresSize2,10);
			Line linX2 = new Line(wykresSize2,10,wykresSize2+10,20);
			Label labX = new Label("X");
			labX.setLayoutX(wykresSize-30);
			labX.setLayoutY(wykresSize2+20);
			
			Line lineY = new Line(10,wykresSize2,wykresSize-10,wykresSize2);
			Line linY1 = new Line(wykresSize-20,wykresSize2-10,wykresSize-10,wykresSize2);
			Line linY2 = new Line(wykresSize-20,wykresSize2+10,wykresSize-10,wykresSize2);
			Label labY = new Label("Y");
			labY.setLayoutX(wykresSize2-20);
			labY.setLayoutY(30);
				
			wykres.getChildren().addAll(rect,lineX,linX1,linX2,labX,lineY,linY1,linY2,labY);
			
			//rysujemy skale na osiach:
			int space = (wykresSize-20)/10;
			
			for(int i=1;i<5;i++)
			{			
				Line linePx1 = new Line(wykresSize2+i*space,wykresSize2,wykresSize2+i*space,wykresSize2);
				Line linePx2 = new Line(wykresSize2-i*space,wykresSize2,wykresSize2-i*space,wykresSize2);
				Line linePy1 = new Line(wykresSize2,wykresSize2+i*space,wykresSize2,wykresSize2+i*space);
				Line linePy2 = new Line(wykresSize2,wykresSize2-i*space,wykresSize2,wykresSize2-i*space);
				
				linePx1.setStroke(Color.BLUE);
				linePx2.setStroke(Color.BLUE);
				linePy1.setStroke(Color.BLUE);
				linePy2.setStroke(Color.BLUE);
				
				linePx1.setStrokeWidth(3);   
				linePx2.setStrokeWidth(3);   
				linePy1.setStrokeWidth(3);   
				linePy2.setStrokeWidth(3);   

				wykres.getChildren().addAll(linePx1,linePy1,linePx2,linePy2);				
			}
			
			labPx1 = new Label("0.4");
			labPx2 = new Label("-0.4");
			labPy1 = new Label("-0.4");
			labPy2 = new Label("0.4");
			labPx1.setLayoutX(wykresSize2+2*space-10);
			labPx1.setLayoutY(wykresSize2+10);
			labPx2.setLayoutX(wykresSize2-2*space-15);
			labPx2.setLayoutY(wykresSize2+10);
			labPy1.setLayoutX(wykresSize2+10);
			labPy1.setLayoutY(wykresSize2+2*space-10);
			labPy2.setLayoutX(wykresSize2+10);
			labPy2.setLayoutY(wykresSize2-2*space-10);
			
			wykres.getChildren().addAll(labPx1,labPx2,labPy1,labPy2);

			
			path = new Path();
			path.setStrokeWidth(3);
			path.setStroke(Color.rgb(200, 100, 200));
			wykres.getChildren().add(path);
						
			root = new BorderPane();
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					
			Label lab1 = new Label("y = ");
			TextField textA = new TextField();
			textA.setMaxWidth(70);
			textA.setAlignment(Pos.CENTER);
			
			Label lab2 = new Label(" x^2 + ");
			TextField textB = new TextField();
			textB.setMaxWidth(70);
			textB.setAlignment(Pos.CENTER);

			textA.getStyleClass().add("myfield");        //styl w pliku .css
			textB.getStyleClass().add("myfield");

			
			Label lab3 = new Label("             ");	
			
			labError = new Label(" ");
			labError.getStyleClass().add("mylabError");
			
			Button btnRysuj = new Button();
			btnRysuj.setText("Rysuj funkcj�");
			btnRysuj.getStyleClass().add("mybtn");
			
			btnRysuj.setOnAction(
					event->
					{
				//rysuje funkcj�
						double a;
						double b;
						
						if(!textA.getText().isEmpty() && !textB.getText().isEmpty())
						{
							labError.setText(" ");
							a = Double.parseDouble(textA.getText());
							b = Double.parseDouble(textB.getText());
							//sprawdzic czy wartosci a i b sa liczbami
							
							rysuj(wykresSize, a, b);			
								
						}
						else
						{
							labError.setText("Wpisz poprawnie oba argumenty funkcji !!!");
						}
							
					}
							);
			
			HBox hBoxDane = new HBox(5,lab1,textA,lab2,textB,lab3,btnRysuj);
			hBoxDane.setAlignment(Pos.CENTER);
			
			Label lab0 = new Label("Funkcja kwadratowa:");			
			
			VBox vBoxDane = new VBox(10,lab0,hBoxDane);
			
			root.setTop(vBoxDane);
			
			root.setCenter(wykres);
			
			root.setBottom(labError);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rysuj(int wykresSize, double a, double b)
	{
		
		path.getElements().clear();
		
		double scale = 1.0;
		//w zaleznosci od b zmieniamy skale osi !!!
		//labPx1.setText("");
		if(Math.abs(b)<0.5)
		{
			labPx1.setText("0.4");
			labPx2.setText("-0.4");
			labPy1.setText("-0.4");
			labPy2.setText("0.4");
			scale=1.0; //????
		}
		else
		{
			if(Math.abs(b)<5)
			{
				labPx1.setText("4.0");
				labPx2.setText("-4.0");
				labPy1.setText("-4.0");
				labPy2.setText("4.0");
				scale=10.0; //????
			}
			else
			{
				if(Math.abs(b)<50)
				{
					labPx1.setText("40");
					labPx2.setText("-40");
					labPy1.setText("-40");
					labPy2.setText("40");
					scale=100.0; //????
				}
				else
					labError.setText("Zmniejsz argument b (poni�ej 50) !!!");
			}
		}

		if(labError.getText().equals(" "))
		{
			double realX = -scale;
			double realY;
						
			int wykresSize2 = wykresSize/2;
			double krok = scale/(wykresSize2-10);
			
			for(int x=10; x<=(wykresSize-10); x++)
			{
				realY = a*realX*realX + b;
				if(Math.abs(realY)<=scale)
				{
					//rysujemy
					int y;
					y = (int) (wykresSize2 - Math.round(realY/krok));
					if(path.getElements().isEmpty())
					{
						MoveTo moveTo = new MoveTo(x,y);
						path.getElements().add(moveTo);
					}
					else
					{
						LineTo lineTo = new LineTo(x,y);
						path.getElements().add(lineTo);
					}
				}
				realX += krok;
			}
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
