package controller;

import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * FadeTransition - przezroczystosć
 * FillTransition - kolor,wypełnienie
 * PathTransition - ruch wzdłuż,wzwyż
 *  Rotate transition -obroty
 * ScaleTransition- skalowanie
 * StrokeTRansition- kolorlinii
 * TranslateTransition- przesuniecie
 * 
 * SequentialTransition złożenue sekwencyjne
 * ParallelTansition złożenie równległe
 */ 

public class MainWindowController {
	private Main main;
	private Stage primaryStage;
	
	@FXML private Group fish1;
	@FXML private Polygon fish1Tail;
	@FXML private Group fish2;
	@FXML private Polygon fish2Tail;
	@FXML private Group hookGroup;
	@FXML private Circle bubble1;
	@FXML private Circle bubble2;
	@FXML private Circle bubble3;
	@FXML private Group eyesGroup;
	@FXML private Group innerEyesGroup;
	
	public void setMain(Main main, Stage primaryStage){
		this.primaryStage=primaryStage;
		this.main=main;

	    TranslateTransition fish1TT = new TranslateTransition();
		fish1TT.setNode(fish1);
		fish1TT.setFromX(0);
		fish1TT.setDuration(Duration.seconds(5));
		fish1TT.setFromY(0);
		fish1TT.setByX(-250);
		fish1TT.setByY(0);
		fish1TT.setCycleCount(Animation.INDEFINITE);
		fish1TT.setAutoReverse(true);
		fish1TT.play();
		
		RotateTransition fish1RT = new RotateTransition();
		fish1RT.setNode(fish1Tail);
		fish1RT.setDuration(Duration.seconds(1));
		fish1RT.setFromAngle(260);
		fish1RT.setToAngle(280);
		fish1RT.setCycleCount(Animation.INDEFINITE);
		fish1RT.setAutoReverse(true);
		fish1RT.play();
		
		Path animationPath= new Path();
		MoveTo moveTo = new MoveTo(-200,50);
		CubicCurveTo sineCurve = new CubicCurveTo(
				
				200,-150, //first control point
				200, 150, //second control point
				700, 0   //finish point
				
				);
		
		animationPath.getElements().addAll(
				moveTo,
				sineCurve
				);
		PathTransition fish2PT = new PathTransition();
		fish2PT.setNode(fish2);
		fish2PT.setDuration(Duration.seconds(5));
		fish2PT.setPath(animationPath);
		fish2PT.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		fish2PT.setInterpolator(Interpolator.EASE_BOTH);
		fish2PT.setCycleCount(Animation.INDEFINITE);
//		fish2PT.setAutoReverse(true);
		fish2PT.play();
		
		RotateTransition fish2RT = new RotateTransition();
		fish2RT.setNode(fish2Tail);
		fish2RT.setDuration(Duration.seconds(1));
		fish2RT.setFromAngle(80);
		fish2RT.setToAngle(100);
		fish2RT.setCycleCount(Animation.INDEFINITE);
		fish2RT.setAutoReverse(true);
		fish2RT.play();
		
		TranslateTransition hookGroupTT = new TranslateTransition();
		hookGroupTT.setNode(hookGroup);
		hookGroupTT.setFromX(0);
		hookGroupTT.setDuration(Duration.seconds(10));
		hookGroupTT.setFromY(0);
		hookGroupTT.setByX(0);
		hookGroupTT.setByY(-100);
		hookGroupTT.setCycleCount(Animation.INDEFINITE);
		hookGroupTT.setAutoReverse(true);
		hookGroupTT.play();
		
		bubble1.setVisible(true);
		bubble2.setVisible(true);
		bubble3.setVisible(true);
		
//		BUBBLE 1 animation
		TranslateTransition bubble1TT = new TranslateTransition();
		bubble1TT.setNode(bubble1);
		bubble1TT.setDuration(Duration.seconds(1));
		bubble1TT.setByY(-100);
		bubble1TT.setCycleCount(Animation.INDEFINITE);
		bubble1TT.play();
		
		PauseTransition bubble1PT = new PauseTransition();
		bubble1PT.setDuration(Duration.millis(800));
		
		KeyFrame bubble1KF0 =new KeyFrame(
				Duration.millis(0),
				new KeyValue(bubble1.radiusProperty(),0)
				);
		
		KeyFrame bubble1KF1 =new KeyFrame(
				Duration.millis(1000),
				new KeyValue(bubble1.radiusProperty(),10),
				new KeyValue(bubble1.visibleProperty(),false)
				);
		
		Timeline bubble1Tl = new Timeline(bubble1KF0,bubble1KF1);
		SequentialTransition bubble1Seq = new SequentialTransition(bubble1PT,bubble1Tl);
		bubble1Seq.setCycleCount(Animation.INDEFINITE);
		bubble1Seq.play();
		
		
//		BUBBLE 2 animation
		
		TranslateTransition bubble2TT = new TranslateTransition();
		bubble2TT.setNode(bubble2);
		bubble2TT.setDuration(Duration.seconds(1));
		bubble2TT.setByY(-100);
		bubble2TT.setCycleCount(Animation.INDEFINITE);
		bubble2TT.play();
		
		PauseTransition bubble2PT = new PauseTransition();
		bubble2PT.setDuration(Duration.millis(400));
		
		KeyFrame bubble2KF0 =new KeyFrame(
				Duration.millis(0),
				new KeyValue(bubble2.radiusProperty(),0)
				);
		
		KeyFrame bubble2KF1 =new KeyFrame(
				Duration.millis(1000),
				new KeyValue(bubble2.radiusProperty(),10),
				new KeyValue(bubble2.visibleProperty(),false)
				);
		
		Timeline bubble2Tl = new Timeline(bubble2KF0,bubble2KF1);
		SequentialTransition bubble2Seq = new SequentialTransition(bubble2PT,bubble2Tl);
		bubble2Seq.setCycleCount(Animation.INDEFINITE);
		bubble2Seq.play();
		
//		BUBBLE 3 animation
		
		TranslateTransition bubble3TT = new TranslateTransition();
		bubble3TT.setNode(bubble3);
		bubble3TT.setDuration(Duration.seconds(1));
		bubble3TT.setByY(-100);
		bubble3TT.setCycleCount(Animation.INDEFINITE);
		bubble3TT.play();
		
		KeyFrame bubble3KF0 = new KeyFrame(
				Duration.millis(0),
				new KeyValue(bubble3.radiusProperty(),0)
				);
		
		KeyFrame bubble3KF1 =new KeyFrame(
				Duration.millis(1000),
				new KeyValue(bubble3.radiusProperty(),10),
				new KeyValue(bubble3.visibleProperty(),false)
				);
		
		Timeline bubble3Tl = new Timeline(bubble3KF0,bubble3KF1);
		bubble3Tl.setCycleCount(Animation.INDEFINITE);
		bubble3Tl.play();
		
//		Oczy
		KeyFrame eyesGroupKF0 =new KeyFrame(
				Duration.seconds(3),
				new KeyValue(eyesGroup.visibleProperty(),true)
				);		
		
		KeyFrame eyesGroupKF1 =new KeyFrame(
				Duration.seconds(1),
				new KeyValue(eyesGroup.visibleProperty(),false)
				);
		
		Timeline eyesGroupTl = new Timeline(eyesGroupKF0,eyesGroupKF1);
				eyesGroupTl.setCycleCount(Animation.INDEFINITE);
				eyesGroupTl.play();
				
		TranslateTransition innerEyesGroupTT = new TranslateTransition();
		innerEyesGroupTT.setNode(innerEyesGroup);
		innerEyesGroupTT.setDuration(Duration.millis(500));
		innerEyesGroupTT.setByX(-20);
		innerEyesGroupTT.setCycleCount(Animation.INDEFINITE);
		innerEyesGroupTT.setAutoReverse(true);
		innerEyesGroupTT.play();
		
	}
}