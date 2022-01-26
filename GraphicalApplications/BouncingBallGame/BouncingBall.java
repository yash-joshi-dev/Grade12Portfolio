package bouncing_ball;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class BouncingBall extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		//create ball
		Circle ball = new Circle(30, Color.BLUE);
		ball.relocate(300-ball.getRadius(), 100-ball.getRadius());
		
		//create shadow
		Ellipse shadow = new Ellipse(45, 15);
		shadow.relocate(300-shadow.getRadiusX(), 750 - shadow.getRadiusY());
		shadow.setFill(Color.BLACK);
		shadow.setOpacity(0.2);
		
		//create pane and scene
		Pane root = new Pane(shadow, ball);
		Scene scene = new Scene(root, 1900, 800, Color.TRANSPARENT);
		
		//set and show stage
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setTitle("Bouncing Ball");
		primaryStage.setScene(scene);
		primaryStage.show();
	
		
		//create the animation
		Timeline timeline = new Timeline (new KeyFrame(Duration.millis(10), 
				new EventHandler<ActionEvent>() {
			
			double g = 0.098;
			double oriXRad = shadow.getRadiusX();
			double oriYRad = shadow.getRadiusY();
			double dy = 0;
			double dx = 5;
			double shadowBottom = scene.getHeight() - 50;
			Bounds bounds = root.getBoundsInLocal();
			
			@Override
			public void handle(ActionEvent t) {
				ball.setLayoutY(ball.getLayoutY() + dy);
				ball.setLayoutX(ball.getLayoutX() + dx);
				dy += g;
				
				shadow.setLayoutX(ball.getLayoutX());
				shadow.setOpacity(ball.getLayoutY()/shadowBottom);
				shadow.setRadiusX(oriXRad - ball.getLayoutY()/shadowBottom * 30);
				shadow.setRadiusY(oriYRad - ball.getLayoutY()/shadowBottom * 10);
				
				if(ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius() - 50)) {
					dy = -dy + g;
				}
				if(ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()) || ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius())) {
					dx = -dx;
				}
				
				
			}
			
		}));
		
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

	}
	
//	public static void createBall
	
	public static void main(String[] args) {

		
		launch(args);

	}

}
