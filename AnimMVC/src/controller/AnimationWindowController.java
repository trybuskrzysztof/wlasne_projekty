package controller;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationWindowController {
	private Stage animationWindowStage;
	private int animationNo;
	private Animation animation;
	@FXML private Rectangle rect;
	@FXML private Circle circle;
	public void setAnimationNo(int animationNo){
		this.animationNo=animationNo;
		
		if (animationNo <=1 && animationNo <=6){
			RotateTransition rt = new RotateTransition();
			rt.setNode(rect);
			rt.setDuration(Duration.seconds(10));
			rt.setFromAngle(0);
			rt.setToAngle(360);
			rt.setCycleCount(Animation.INDEFINITE);
			rt.setAutoReverse(true);
			
			animation = rt;
		}
		else if(animationNo ==2){
			TranslateTransition tt = new TranslateTransition();
			tt.setNode(rect);
			tt.setFromX(0);
			tt.setDuration(Duration.seconds(10));
			tt.setFromY(0);
			tt.setByX(200);
			tt.setByY(200);
			tt.setCycleCount(Animation.INDEFINITE);
			tt.setAutoReverse(true);
			animation=tt;
		}
		else if(animationNo == 3){
			Path animationPath= new Path();
			MoveTo moveTo = new MoveTo(0,50);
			CubicCurveTo sineCurve = new CubicCurveTo(
					
					200,-150, //first control point
					200, 150, //second control point
					400, 0   //finish point
					
					);
			
			animationPath.getElements().addAll(
					moveTo,
					sineCurve
					);
			PathTransition pt = new PathTransition();
			pt.setNode(rect);
			pt.setDuration(Duration.seconds(5));
			pt.setPath(animationPath);
			pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
			pt.setInterpolator(Interpolator.LINEAR); // zmiana prędkości w czasie
			
			animation=pt;
			
			
		}
		
		else if (animationNo == 4){
			TranslateTransition tt = new TranslateTransition();
				tt.setDuration(Duration.seconds(2));
				tt.setByX(400);
				
				ScaleTransition s1 =new ScaleTransition();
				
				s1.setDuration(Duration.millis(300));
				s1.setFromX(0.95);
				s1.setToX(1.05);
				s1.setFromY(1.05);
				s1.setToY(0.95);
				
				
				ScaleTransition s2 =new ScaleTransition();
				
				s2.setDuration(Duration.millis(300));
				s2.setFromX(1.05);
				s2.setToX(0.95);
				s2.setFromY(0.95);
				s2.setToY(1.05);
				
				PauseTransition  p1 = new PauseTransition();
				p1.setDuration(Duration.millis(1400));
				
				SequentialTransition seq1 = new SequentialTransition(s1,p1,s2);
				ParallelTransition par1 = new ParallelTransition(rect,tt,seq1);
				
				par1.setCycleCount(Animation.INDEFINITE);
				par1.setAutoReverse(true);
				
				animation=par1;
			}
		else if(animationNo==5){
			KeyFrame kf0 = new KeyFrame(    //klatka kluczowa
					Duration.seconds(10),
					new KeyValue(rect.arcWidthProperty(),0),
					new KeyValue(rect.arcHeightProperty(),0)
					);
			KeyFrame kf1 = new KeyFrame(    //klatka kluczowa
					Duration.seconds(0.5),
					new KeyValue(rect.arcWidthProperty(),15),
					new KeyValue(rect.arcHeightProperty(),17)
					);
			KeyFrame kf2 = new KeyFrame(    //klatka kluczowa
					Duration.seconds(1.5),
					new KeyValue(rect.arcWidthProperty(),60),
					new KeyValue(rect.arcHeightProperty(),60)
					);
			
			Timeline tl = new Timeline(kf0,kf1,kf2);
			tl.setCycleCount(Animation.INDEFINITE);
			animation =tl;
		}
			
		
	}
	
	public void animatedCircle(double x,double y){
		circle.setVisible(true);
		circle.setLayoutX(x);
		circle.setLayoutY(y);
		
//		System.out.println("f6 clicked");
		
		KeyFrame kf0 =new KeyFrame(
				
				Duration.millis(0),
				new KeyValue(circle.radiusProperty(),0)
				
				);
		
		KeyFrame kf1 =new KeyFrame(
				
				Duration.millis(1000),
				new KeyValue(circle.radiusProperty(),30),
				new KeyValue(circle.visibleProperty(),false)
				);
		
		
		Timeline tl2 = new Timeline(kf0,kf1);
		//tl2.setCycleCount(Animation.INDEFINITE);
		tl2.play();
	}
	
	
	
	
	public void setAnimationWindowStage (Stage animationWindowStage) {
		this.animationWindowStage=animationWindowStage;
		
		
	}
	
	@FXML public void paneMouseClicked(MouseEvent event){
		//if (animationNo==6){
			System.out.println("f6 clicked");
			animatedCircle(event.getX(),event.getY());
	//	}
	}
	
	
	@FXML 
	public void  closeAnimationWindow(){
		animationWindowStage.close();
	}
	
	@FXML 
	public void  playAnimation(){
		animation.play();
	}
	
	@FXML 
	public void pauseAnimation(){
		animation.pause();
	}
	
	@FXML 
	public void stopAnimation(){
		animation.stop();
	}
	
}
