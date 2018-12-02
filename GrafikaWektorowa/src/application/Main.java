package application;
	
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,400,400, Color.GRAY);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Czerwona linia ciÄgĹa z okrÄgĹymi zakoĹczeniami
			Line redLine=new Line(10,10,200,10);
			redLine.setStroke(Color.RED);  //kolor linii
			redLine.setStrokeWidth(10);	   //szerokoĹÄ linii
			redLine.setStrokeLineCap(StrokeLineCap.ROUND);
										   //typ zakoĹczenia			
			root.getChildren().add(redLine);
			
			//Niebieska linia przerywana z okrÄgĹymi zakoĹczeniami
			Line blueLine=new Line(10,40,200,40);
			blueLine.setStroke(Color.BLUE);  //kolor linii
			blueLine.setStrokeWidth(2);	   //szerokoĹÄ linii
			blueLine.setStrokeLineCap(StrokeLineCap.BUTT);
										   //typ zakoĹczenia
			blueLine.getStrokeDashArray().addAll(30d,10d,5d,5d);
			blueLine.setStrokeDashOffset(20);
			root.getChildren().add(blueLine);
			
			//Suwak
			Slider slider=new Slider(0,100,0); //min,max,aktualna wartoĹÄ
			slider.setLayoutX(10);
			slider.setLayoutY(70);
			slider.setOrientation(Orientation.HORIZONTAL);
			root.getChildren().add(slider);
			
			blueLine.strokeDashOffsetProperty().bind(slider.valueProperty());
			
			//Cubic curve
			CubicCurve cubicCurve=new CubicCurve(
					50, //start x
					75, //start y
					80, //control1 x
					-25, //control1 y
					110, //conttol2 x
					175, //control2 y
					140, //end x
					75   //end y
					);
		    cubicCurve.setStrokeType(StrokeType.CENTERED);
		    cubicCurve.setStroke(Color.rgb(200, 100, 200));
		    cubicCurve.setStrokeWidth(3);
		    cubicCurve.setFill(Color.TRANSPARENT);
		    
			root.getChildren().add(cubicCurve);
		
		    //Rysowanie po ĹcieĹźce
			Path path=new Path();
			path.setStrokeWidth(3);
			
			MoveTo moveTo=new MoveTo(50,150);
			moveTo.setX(50);
			moveTo.setY(150);
			
			QuadCurveTo quadCurveTo=new QuadCurveTo();
			quadCurveTo.setX(150);
			quadCurveTo.setY(150);
			quadCurveTo.setControlX(100);
			quadCurveTo.setControlY(50);
			
			LineTo lineTo1=new LineTo(50,150);
			LineTo lineTo2=new LineTo(100,275);
			LineTo lineTo3=new LineTo(150,150);
			
			path.getElements().addAll(
					moveTo,
					quadCurveTo,
					lineTo1,
					lineTo2,
					lineTo3
					);
			path.setTranslateY(40);
			root.getChildren().add(path);
			
			//Elipsy
			Ellipse  bigCircle=new Ellipse(
					100,   //center x
					100,   //center y
					50,		//radius x
					36		//radius y
					);
			
			Ellipse  smallCircle=new Ellipse(
					100,   //center x
					100,   //center y
					17,		//radius x
					12		//radius y
					);
			
			//wyciÄcie jednego obiektu drugim obiektem
			Shape donut=Path.subtract(bigCircle, smallCircle);
			donut.setTranslateX(160);
			donut.setFill(Color.rgb(255, 200, 0));
			donut.setStroke(Color.BLACK);
			donut.setStrokeWidth(2);
			
			//efekt cienia
			DropShadow dropShadow = new DropShadow(
					5,  //radius
					12.0, //offset X
					12.0, //offset Y
					Color.rgb(150, 150, 150, 1)
					);
			donut.setEffect(dropShadow);
			root.getChildren().add(donut);
			
			//ProstokÄt z wypeĹnieniem gradientowym
			Rectangle roundRect=new Rectangle();
			roundRect.setX(50);
			roundRect.setY(50);
			roundRect.setWidth(100);
			roundRect.setHeight(70);
			//zaokraglenie brzegĂłw
			roundRect.setArcWidth(20);
			roundRect.setArcHeight(20);
			
			LinearGradient gradient1=new LinearGradient(
					70, //start x  
					70, //start y
					120, //end x
					100, //end y
					false, //proportional
					CycleMethod.REFLECT,
					new Stop(0f, Color.rgb(0, 255, 0)),
					new Stop(0.5f, Color.rgb(255, 0, 0)),
					new Stop(1f, Color.rgb(0, 0, 0))
					);
			roundRect.setFill(gradient1);
			
			roundRect.setTranslateX(
			  path.getBoundsInParent().getWidth() + 20);
			roundRect.setTranslateY(
			  donut.getBoundsInParent().getHeight() + 20);
			
			root.getChildren().add(roundRect);
			
			//wypeĹnienie radialne
			Ellipse ellipse1 = new Ellipse(200,300, 70,70);
			RadialGradient gradient2 = new RadialGradient(
					0,  //focus angle
					0,  //focus distance
					200, //center x
					300, //center y
					70,  //radius
					false, //proportional
					CycleMethod.NO_CYCLE,
					new Stop(0, Color.RED),
					new Stop(1, Color.BLUE)
					);
			ellipse1.setFill(gradient2);
			
            root.getChildren().add(ellipse1);		
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