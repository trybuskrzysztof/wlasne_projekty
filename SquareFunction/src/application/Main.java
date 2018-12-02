package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root=new Group();
			Scene scene = new Scene(root,500,600,Color.LIGHTGRAY);
			
			Label lblValueA=new Label("a:");
			lblValueA.setMinWidth(100);
			lblValueA.setAlignment(Pos.BOTTOM_RIGHT);
			
			TextField txtValueA=new TextField("1");
			txtValueA.setMinWidth(200);
			txtValueA.setMaxWidth(200);
			txtValueA.setPromptText("Wprowadź wartość 'a'");
			
			Label lblValueB=new Label("c:");
			lblValueB.setMinWidth(100);
			lblValueB.setAlignment(Pos.BOTTOM_RIGHT);
			
			TextField txtValueB=new TextField("0");
			txtValueB.setMinWidth(200);
			txtValueB.setMaxWidth(200);
			txtValueB.setPromptText("Wprowadź wartość 'c'");
			
			Label lblWzor1 = new Label("Wzór y =");
			Label lblWzor2 = new Label();
			Label lblWzor3 = new Label("x^2 +");
			Label lblWzor4 = new Label();
			
			HBox paneValueA = new HBox(20, lblValueA, txtValueA);
			paneValueA.setPadding(new Insets(5));
			paneValueA.setLayoutX(30);
			paneValueA.setLayoutY(10);
			
			HBox paneValueB = new HBox(20, lblValueB, txtValueB);
			paneValueB.setPadding(new Insets(5));
			paneValueB.setLayoutX(30);
			paneValueB.setLayoutY(40);
			
			HBox paneWzor = new HBox(5, lblWzor1, lblWzor2, lblWzor3, lblWzor4);
			paneWzor.setPadding(new Insets(2));
			paneWzor.setLayoutX(180);
			paneWzor.setLayoutY(70);
			
			lblWzor2.textProperty().bind(txtValueA.textProperty());
			lblWzor4.textProperty().bind(txtValueB.textProperty());
			
			root.getChildren().add(paneValueA);
			root.getChildren().add(paneValueB);
			root.getChildren().add(paneWzor);
			
			// osie
			Line xAxis=new Line(0,350,500,350);
			xAxis.setStroke(Color.BLACK);  //kolor linii
			xAxis.setStrokeWidth(1);	   //szerokoĹÄ linii
			xAxis.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xAxis);
			
			Line yAxis=new Line(250,100,250,600);
			yAxis.setStroke(Color.BLACK);  //kolor linii
			yAxis.setStrokeWidth(1);	   //szerokoĹÄ linii
			yAxis.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(yAxis);
			
			Label lblX = new Label("Oś X");
			lblX.setLayoutX(460);
			lblX.setLayoutY(350);			
			Label lblY = new Label("Oś Y");
			lblY.setLayoutX(255);
			lblY.setLayoutY(110);
			root.getChildren().add(lblX);
			root.getChildren().add(lblY);
			
			//axis labels
			Line xFive=new Line(300,340,300,360);
			xFive.setStroke(Color.BLACK);  //kolor linii
			xFive.setStrokeWidth(1);	   //szerokoĹÄ linii
			xFive.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xFive);
			Label lblXFive = new Label("5");
			lblXFive.setLayoutX(297);
			lblXFive.setLayoutY(323);
			root.getChildren().add(lblXFive);
			
			Line xTen=new Line(350,340,350,360);
			xTen.setStroke(Color.BLACK);  //kolor linii
			xTen.setStrokeWidth(1);	   //szerokoĹÄ linii
			xTen.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xTen);
			Label lblxTen = new Label("10");
			lblxTen.setLayoutX(345);
			lblxTen.setLayoutY(323);
			root.getChildren().add(lblxTen);
			
			Line xFifteen=new Line(400,340,400,360);
			xFifteen.setStroke(Color.BLACK);  //kolor linii
			xFifteen.setStrokeWidth(1);	   //szerokoĹÄ linii
			xFifteen.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xFifteen);
			Label lblxFifteen = new Label("15");
			lblxFifteen.setLayoutX(395);
			lblxFifteen.setLayoutY(323);
			root.getChildren().add(lblxFifteen);
			
			Line xTwenty=new Line(450,340,450,360);
			xTwenty.setStroke(Color.BLACK);  //kolor linii
			xTwenty.setStrokeWidth(1);	   //szerokoĹÄ linii
			xTwenty.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xTwenty);
			Label lblxTwenty = new Label("20");
			lblxTwenty.setLayoutX(445);
			lblxTwenty.setLayoutY(323);
			root.getChildren().add(lblxTwenty);
			
			/*
			Line xTwentyFive=new Line(500,340,500,360);
			xTwentyFive.setStroke(Color.BLACK);  //kolor linii
			xTwentyFive.setStrokeWidth(1);	   //szerokoĹÄ linii
			xTwentyFive.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xTwentyFive);
			Label lblxTwentyFive = new Label("25");
			lblxTwentyFive.setLayoutX(495);
			lblxTwentyFive.setLayoutY(323);
			root.getChildren().add(lblxTwentyFive);
			*/
			/*
			Line xmTwentyFive=new Line(0,340,0,360);
			xmTwentyFive.setStroke(Color.BLACK);  //kolor linii
			xmTwentyFive.setStrokeWidth(1);	   //szerokoĹÄ linii
			xmTwentyFive.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xmTwentyFive);
			Label lblxmTwentyFive = new Label("-25");
			lblxmTwentyFive.setLayoutX(5);
			lblxmTwentyFive.setLayoutY(323);
			root.getChildren().add(lblxmTwentyFive);
			*/
			
			Line xmTwenty=new Line(50,340,50,360);
			xmTwenty.setStroke(Color.BLACK);  //kolor linii
			xmTwenty.setStrokeWidth(1);	   //szerokoĹÄ linii
			xmTwenty.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xmTwenty);
			Label lblxmTwenty = new Label("-20");
			lblxmTwenty.setLayoutX(40);
			lblxmTwenty.setLayoutY(323);
			root.getChildren().add(lblxmTwenty);
			
			Line xmFifteen=new Line(100,340,100,360);
			xmFifteen.setStroke(Color.BLACK);  //kolor linii
			xmFifteen.setStrokeWidth(1);	   //szerokoĹÄ linii
			xmFifteen.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xmFifteen);
			Label lblxmFifteen = new Label("-15");
			lblxmFifteen.setLayoutX(90);
			lblxmFifteen.setLayoutY(323);
			root.getChildren().add(lblxmFifteen);
			
			Line xmTen=new Line(150,340,150,360);
			xmTen.setStroke(Color.BLACK);  //kolor linii
			xmTen.setStrokeWidth(1);	   //szerokoĹÄ linii
			xmTen.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xmTen);
			Label lblxmTen = new Label("-10");
			lblxmTen.setLayoutX(140);
			lblxmTen.setLayoutY(323);
			root.getChildren().add(lblxmTen);
			
			Line xmFive=new Line(200,340,200,360);
			xmFive.setStroke(Color.BLACK);  //kolor linii
			xmFive.setStrokeWidth(1);	   //szerokoĹÄ linii
			xmFive.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(xmFive);
			Label lblxmFive = new Label("-5");
			lblxmFive.setLayoutX(190);
			lblxmFive.setLayoutY(323);
			root.getChildren().add(lblxmFive);
			
			//y labels
			Line yFive=new Line(240,300,260,300);
			yFive.setStroke(Color.BLACK);  //kolor linii
			yFive.setStrokeWidth(1);	   //szerokoĹÄ linii
			yFive.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(yFive);
			Label lblyFive = new Label("5");
			lblyFive.setLayoutX(230);
			lblyFive.setLayoutY(290);
			root.getChildren().add(lblyFive);
			
			Line yTen=new Line(240,250,260,250);
			yTen.setStroke(Color.BLACK);  //kolor linii
			yTen.setStrokeWidth(1);	   //szerokoĹÄ linii
			yTen.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(yTen);
			Label lblyTen = new Label("10");
			lblyTen.setLayoutX(225);
			lblyTen.setLayoutY(240);
			root.getChildren().add(lblyTen);
			
			Line yFifteen=new Line(240,200,260,200);
			yFifteen.setStroke(Color.BLACK);  //kolor linii
			yFifteen.setStrokeWidth(1);	   //szerokoĹÄ linii
			yFifteen.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(yFifteen);
			Label lblyFifteen = new Label("15");
			lblyFifteen.setLayoutX(225);
			lblyFifteen.setLayoutY(190);
			root.getChildren().add(lblyFifteen);
			
			Line yTwenty=new Line(240,150,260,150);
			yTwenty.setStroke(Color.BLACK);  //kolor linii
			yTwenty.setStrokeWidth(1);	   //szerokoĹÄ linii
			yTwenty.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(yTwenty);
			Label lblyTwenty = new Label("20");
			lblyTwenty.setLayoutX(225);
			lblyTwenty.setLayoutY(140);
			root.getChildren().add(lblyTwenty);
			
			/*
			Line yTwentyFive=new Line(240,100,260,100);
			yTwentyFive.setStroke(Color.BLACK);  //kolor linii
			yTwentyFive.setStrokeWidth(1);	   //szerokoĹÄ linii
			yTwentyFive.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(yTwentyFive);
			Label lblyTwentyFive = new Label("25");
			lblyTwentyFive.setLayoutX(225);
			lblyTwentyFive.setLayoutY(90);
			root.getChildren().add(lblyTwentyFive);
			*/
			/*
			Line ymTwentyFive=new Line(240,600,260,600);
			ymTwentyFive.setStroke(Color.BLACK);  //kolor linii
			ymTwentyFive.setStrokeWidth(1);	   //szerokoĹÄ linii
			ymTwentyFive.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(ymTwentyFive);
			Label lblymTwentyFive = new Label("-25");
			lblymTwentyFive.setLayoutX(225);
			lblymTwentyFive.setLayoutY(590);
			root.getChildren().add(lblymTwentyFive);
			*/
			
			Line ymTwenty=new Line(240,550,260,550);
			ymTwenty.setStroke(Color.BLACK);  //kolor linii
			ymTwenty.setStrokeWidth(1);	   //szerokoĹÄ linii
			ymTwenty.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(ymTwenty);
			Label lblymTwenty = new Label("-20");
			lblymTwenty.setLayoutX(220);
			lblymTwenty.setLayoutY(540);
			root.getChildren().add(lblymTwenty);
			
			Line ymFifteen=new Line(240,500,260,500);
			ymFifteen.setStroke(Color.BLACK);  //kolor linii
			ymFifteen.setStrokeWidth(1);	   //szerokoĹÄ linii
			ymFifteen.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(ymFifteen);
			Label lblymFifteen = new Label("-15");
			lblymFifteen.setLayoutX(220);
			lblymFifteen.setLayoutY(490);
			root.getChildren().add(lblymFifteen);
			
			Line ymTen=new Line(240,450,260,450);
			ymTen.setStroke(Color.BLACK);  //kolor linii
			ymTen.setStrokeWidth(1);	   //szerokoĹÄ linii
			ymTen.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(ymTen);
			Label lblymTen = new Label("-10");
			lblymTen.setLayoutX(220);
			lblymTen.setLayoutY(440);
			root.getChildren().add(lblymTen);
			
			Line ymFive=new Line(240,400,260,400);
			ymFive.setStroke(Color.BLACK);  //kolor linii
			ymFive.setStrokeWidth(1);	   //szerokoĹÄ linii
			ymFive.setStrokeLineCap(StrokeLineCap.BUTT);
			root.getChildren().add(ymFive);
			Label lblymFive = new Label("-5");
			lblymFive.setLayoutX(225);
			lblymFive.setLayoutY(390);
			root.getChildren().add(lblymFive);
			
			//strzałki
			Path yArrow = new Path();
			yArrow.setStrokeWidth(1);
			MoveTo moveToyArrow = new MoveTo(240,110);
			LineTo lineToy1=new LineTo(250,100);
			LineTo lineToy2=new LineTo(260,110);
			yArrow.getElements().addAll(moveToyArrow,lineToy1,lineToy2);
			root.getChildren().add(yArrow);
			
			Path xArrow = new Path();
			xArrow.setStrokeWidth(1);
			MoveTo moveToxArrow = new MoveTo(490,340);
			LineTo lineTox1=new LineTo(500,350);
			LineTo lineTox2=new LineTo(490,360);
			yArrow.getElements().addAll(moveToxArrow,lineTox1,lineTox2);
			root.getChildren().add(xArrow);

			//rysuj
			Button bRysuj=new Button();
			bRysuj.setText("Rysuj");
			bRysuj.setLayoutX(400);
			bRysuj.setLayoutY(15);
			bRysuj.setPrefWidth(70);
			root.getChildren().add(bRysuj);
			
			Path path=new Path();
			
			bRysuj.setOnAction(
					event -> {
						try {
							//wykres
							
							path.setStrokeWidth(3);
							
							MoveTo moveTo=new MoveTo();
							moveTo.setX(100-(Double.parseDouble(txtValueA.getText())*-10));
							moveTo.setY(100);
							
							QuadCurveTo quadCurveTo=new QuadCurveTo();
							quadCurveTo.setX(400+(Double.parseDouble(txtValueA.getText())*-10));
							quadCurveTo.setY(100);
							quadCurveTo.setControlX(250);
							quadCurveTo.setControlY(600);
							
							path.getElements().addAll(
									moveTo,
									quadCurveTo
									);
							path.setTranslateY(Double.parseDouble(txtValueB.getText())*-10);
							root.getChildren().add(path);
						} catch (Exception ignored) {}
					});
			
			Button buttonClear=new Button();
			buttonClear.setText("Wyczyść");
			buttonClear.setLayoutX(400);
			buttonClear.setLayoutY(45);
			buttonClear.setPrefWidth(70);
			root.getChildren().add(buttonClear);
			buttonClear.setOnAction(
					event -> {
							path.getElements().clear();
				        });
					
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Wykres funkcji kwadratowej");
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch (Exception ignored) {}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}