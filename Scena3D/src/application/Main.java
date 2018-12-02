package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Box box = new Box(100,100,100);
			box.setTranslateX(150);
			box.setTranslateY(0);
			box.setTranslateZ(400);
			
			Sphere sphere=new Sphere(50);
			sphere.setTranslateX(300);
			sphere.setTranslateY(-5);
			sphere.setTranslateZ(400);
			
			Cylinder cylinder = new Cylinder(40,120);
			cylinder.setTranslateX(500);
			cylinder.setTranslateY(-25);
			cylinder.setTranslateZ(600);
			
			PointLight light = new PointLight();
			light.setTranslateX(350);
			light.setTranslateY(100);
			light.setTranslateZ(300);
			
			PerspectiveCamera camera=new PerspectiveCamera(false);
			camera.setTranslateX(100);
			camera.setTranslateY(-50);
			camera.setTranslateZ(300);
			
			Group root = new Group(box,sphere,cylinder,light);
			Scene scene = new Scene(root,400,200,true);
			
			scene.setCamera(camera);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Scena 3D");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
