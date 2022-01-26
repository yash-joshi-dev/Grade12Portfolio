package reuseableobjects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TestingGameBoard extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		//create root pane
		Pane root = new Pane();
		
		//create gameboard
		GameBoard board = new GameBoard(4, 4, 400, 400, 50, 70, Color.PINK, Color.CORAL, true, true);
		
		root.getChildren().add(board.getBoardToDisplay());
		
		//create scene
		Scene scene = new Scene(root, 600, 600);
		
		//set stage
		primaryStage.setTitle("Testing Game Board");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}

	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
