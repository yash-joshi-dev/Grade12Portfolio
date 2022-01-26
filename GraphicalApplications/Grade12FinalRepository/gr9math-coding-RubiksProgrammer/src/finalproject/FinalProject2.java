package finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FinalProject2 extends Application {
	
	//create all the scenes
	Scene  homeScene, menuScene, howToScene, levelScene;
	Scene introVarScene, introIfScene, introLoopScene, mathScene, challengeScene, passScene, failScene;
	
	public static void main(String[] args) {
		launch(args);
	}//end main
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//create all fonts used
		Font titleFont = new Font("Arial", 30);
		Font normalFont = new Font("Arial", 24);

		// also create the menu button
		MenuButton menuButton = menuButtonCreator(primaryStage, levelScene, howToScene);

		// create homeScene
		homeScene = homeSceneCreator(primaryStage, menuScene);

		// create menuScene
		menuScene = menuSceneCreator(primaryStage, levelScene, howToScene, titleFont);

		// create howToScene
		howToScene = howToSceneCreator(primaryStage, menuScene, menuButton, titleFont, normalFont);

		// create levelScene
		levelScene = levelSceneCreator(primaryStage, menuScene, introVarScene, introIfScene, introLoopScene, mathScene,
				menuButton, titleFont, normalFont);

		// setup stage
		primaryStage.setScene(homeScene);
		primaryStage.setTitle("Exploring Linear Relations");
		primaryStage.show();
		
	}//end start method

	/*
	 * Method Name: homeSceneCreator
	 * Description: Creates the home scene.
	 * Parameters: Stage primaryStage, Scene menuScene
	 * Returns: Scene homeScene
	 */
	public static Scene homeSceneCreator(Stage primaryStage, Scene menuScene) {
		
		//create title
		Label lblTitle = new Label("Exploring Linear Relations");
		lblTitle.setFont(new Font("Arial", 35));
		
		//create start button
		Button btnStart = new Button("Start");
		btnStart.setOnAction(e -> primaryStage.setScene(menuScene));
		
		//put controls in vbox
		VBox vbxHome = new VBox(50, lblTitle, btnStart);
		vbxHome.setMargin(lblTitle, new Insets(30, 10, 10, 10));
		vbxHome.setAlignment(Pos.BASELINE_CENTER);
		
		//create scene
		Scene homeScene = new Scene(vbxHome, 1000, 800);
		return homeScene;
	}

	/*
	 * Method Name: menuSceneCreator
	 * Description: Creates the menu scene.
	 * Parameters: Stage primaryStage, Scene levelScene, Scene howToScene, Font titleFont
	 * Returns: Scene menuScene
	 */
	public static Scene menuSceneCreator(Stage primaryStage, Scene levelScene, Scene howToScene, Font titleFont) {
		
		//create title
		Label lblMenu = new Label("Menu");
		lblMenu.setFont(titleFont);
		
		//create buttons
		Button btnSelectLevels = new Button("Select Levels");
		btnSelectLevels.setOnAction(e -> primaryStage.setScene(levelScene));
		
		Button btnHowTo = new Button("How To Play");
		btnHowTo.setOnAction(e -> primaryStage.setScene(howToScene));
		
		Button btnQuit = new Button("Quit");
		btnQuit.setOnAction(e -> {
			
			//add alert feature for quit button
			Alert quitAlert = new Alert(AlertType.CONFIRMATION);
			quitAlert.setTitle("Quit Confirmation");
			quitAlert.setHeaderText("Your about to quit!");
			quitAlert.setContentText("Are you sure you want to quit? Any progress will be lost.");
			
			//if ok clicked, close the window
			if(quitAlert.showAndWait().get() == ButtonType.OK) {
				primaryStage.close();
			}//end if
			
		});//end lambda
		
		//create vbox for controls
		VBox vbxMenu = new VBox(20, lblMenu, btnSelectLevels, btnHowTo, btnQuit);
		vbxMenu.setAlignment(Pos.BASELINE_CENTER);
		
		//create the scene
		Scene menuScene = new Scene(vbxMenu, 1000, 800);
		return menuScene;
	}

	/*
	 * Method Name: menuButtonCreator
	 * Description: Creates the menu button.
	 * Parameters: Stage primaryStage, Scene levelScene, Scene howToScene
	 * Returns: MenuButton menuButton
	 */
	public static MenuButton menuButtonCreator(Stage primaryStage, Scene levelScene, Scene howToScene) {
		
		//create menu options
		MenuItem levelOption = new MenuItem("Select Level");
		levelOption.setOnAction(e -> primaryStage.setScene(levelScene));
		
		MenuItem howToOption = new MenuItem("How To Play");
		howToOption.setOnAction(e -> primaryStage.setScene(howToScene));
		
		MenuItem quitOption = new MenuItem("Quit");
		quitOption.setOnAction(e -> {
			
			//add alert feature for quit button
			Alert quitAlert = new Alert(AlertType.CONFIRMATION);
			quitAlert.setTitle("Quit Confirmation");
			quitAlert.setHeaderText("Your about to quit!");
			quitAlert.setContentText("Are you sure you want to quit? Any progress will be lost.");
			
			//if ok clicked, close the window
			if(quitAlert.showAndWait().get() == ButtonType.OK) {
				primaryStage.close();
			}//end if
			
		});//end lambda
		
		//create menu button
		MenuButton menuButton = new MenuButton("Menu", null, levelOption, howToOption, quitOption);
		menuButton.setMinWidth(40);
		return menuButton;
	}

	/*
	 * Method Name: howToSceneCreator
	 * Description: Creates the how to play scene.
	 * Parameters: Stage primaryStage, Scene menuScene, MenuButton menuButton, Font titleFont, Font normalFont
	 * Returns: Scene howToScene
	 */
	public static Scene howToSceneCreator(Stage primaryStage, Scene menuScene, MenuButton menuButton, Font titleFont, Font normalFont) {

		//create title
		Label lblHowTo = new Label("How To Play");
		lblHowTo.setFont(titleFont);
				
		//add menu and title to Hbox
		AnchorPane ancrPnHowTo = new AnchorPane(lblHowTo, menuButton);
		ancrPnHowTo.setTopAnchor(lblHowTo, 0.0);
		ancrPnHowTo.setLeftAnchor(lblHowTo, 280.0);
		
		ancrPnHowTo.setTopAnchor(menuButton, 0.0);
		ancrPnHowTo.setRightAnchor(menuButton, 0.0);
		
		//create labels that tell user how to play
		Label lblHowLevels1 = new Label("Select Levels: Clicking this button on the menu will take"
				+ " you to the menu page. Here you can select to complete levels from three different"
				+ " coding topics: variables, if statements, and loops. Clicking on the first level"
				+ " for each topic will first take you to a page that will introduce the coding topic."
				+ " Then, by clicking next, you will be introduced to the math concept covered in the"
				+ " level. Finally, by clicking next again, you will be given a math challenge which"
				+ " you have to solve using any of the coding skills introduced to you before.");
		lblHowLevels1.setWrapText(true);
		lblHowLevels1.setFont(normalFont);
		
		Label lblHowLevels2 = new Label("Completing the Challenge: The challenge for each level will"
				+ " be given at the very top of the screen, under the title. Under that, some sample"
				+ " input and outputs will be given so that you can test your program to see if it works"
				+ " before actually submitting it. Below that, on the right, you will find the space to"
				+ " write your code. The 'Run' button will allow you to run your code to test it. The output"
				+ " to your code will be shown on the left side. The submit button will allow you to"
				+ " submit your code to check if it works against all the test cases (if it outputs the right"
				+ " answer for all problems). If you pass all the test cases, you can proceed to the next level"
				+ " Otherwise, you will have be given a hint on the testcases you didn't pass and you will have"
				+ " to try again.");
		lblHowLevels2.setWrapText(true);
		lblHowLevels2.setFont(normalFont);

		Label lblHowMenu = new Label("Menu Button: There will always be a menu button on the top"
				+ " right corner of your screen. You can use this to select levels, go back 'How to Play"
				+ " or even quit. Please note that if you click on any of the options, your current code"
				+ " will not be saved (all previous levels will be saved).");
		lblHowMenu.setWrapText(true);
		lblHowMenu.setFont(normalFont);
		
		//create back button
		Button btnMenuBack = new Button("Back");
		btnMenuBack.setOnAction(e -> primaryStage.setScene(menuScene));
		
		//put all controls/containers above in a vbox
		VBox vbxHowTo = new VBox(20, ancrPnHowTo, lblHowLevels1, lblHowLevels2, lblHowMenu, btnMenuBack);
		vbxHowTo.setMargin(lblHowLevels1, new Insets(10, 20, 10, 20));
		vbxHowTo.setMargin(lblHowLevels2, new Insets(10, 20, 10, 20));
		vbxHowTo.setMargin(lblHowMenu, new Insets(10, 20, 10, 20));
		
		//create the how to scene
		Scene howToScene = new Scene(vbxHowTo, 1000, 800);
		return howToScene;

	}

	/*
	 * Method Name: levelSceneCreator
	 * Description: Creates the level scene.
	 * Parameters:  Stage primaryStage, Scene menuScene, Scene introVarScene, Scene introIfScene,
	 * 				Scene introLoopScene, Scene mathScene, MenuButton menuButton, Font titleFont,
	 * 				Font normalFont
	 * Returns: Scene levelScene
	 */
	public static Scene levelSceneCreator(Stage primaryStage, Scene menuScene, Scene introVarScene, Scene introIfScene, Scene introLoopScene, Scene mathScene, MenuButton menuButton, Font titleFont, Font normalFont) {

		// create title
		Label lblLevels = new Label("Levels");

		// create Anchor Pane to store label and corner menu (use same button from
		// howToScene)
		AnchorPane ancrPnLevel = new AnchorPane(lblLevels, menuButton);
		ancrPnLevel.setTopAnchor(lblLevels, 0.0);
		ancrPnLevel.setLeftAnchor(lblLevels, 280.0);

		ancrPnLevel.setTopAnchor(menuButton, 0.0);
		ancrPnLevel.setRightAnchor(menuButton, 0.0);
		
		//create back button that goes to menu
		Button btnMenuBack = new Button("Back");
		btnMenuBack.setOnAction(e -> primaryStage.setScene(menuScene));

		// create the variable levels label and buttons
		Label lblVarLevels = new Label("Variables:");
		lblVarLevels.setMinSize(20, 50);

		Button btnVarLevel1 = new Button("Level 1");
		btnVarLevel1.setMinSize(20, 50);
		btnVarLevel1.setOnAction(e -> {
			primaryStage.setScene(introVarScene);
		});

		Button btnVarLevel2 = new Button("Level 2");
		btnVarLevel2.setMinSize(20, 50);
		btnVarLevel2.setOnAction(e -> {
			primaryStage.setScene(mathScene);
		});

		Button btnVarLevel3 = new Button("Level 3");
		btnVarLevel3.setMinSize(20, 50);
		btnVarLevel3.setOnAction(e -> {
			primaryStage.setScene(mathScene);
		});

		// create the if statement levels label and buttons
		Label lblIfLevels = new Label("If Statements:");
		lblIfLevels.setMinSize(20, 50);

		Button btnIfLevel1 = new Button("Level 1");
		btnIfLevel1.setMinSize(20, 50);
		btnIfLevel1.setOnAction(e -> {
			primaryStage.setScene(introIfScene);
		});

		Button btnIfLevel2 = new Button("Level 2");
		btnIfLevel2.setMinSize(20, 50);
		btnIfLevel2.setOnAction(e -> {
			primaryStage.setScene(mathScene);
		});

		Button btnIfLevel3 = new Button("Level 3");
		btnIfLevel3.setMinSize(20, 50);
		btnIfLevel3.setOnAction(e -> {
			primaryStage.setScene(mathScene);
		});

		// create the loops levels label and buttons
		Label lblLoopLevels = new Label("Loops:");
		lblLoopLevels.setMinSize(20, 50);

		Button btnLoopLevel1 = new Button("Level 1");
		btnLoopLevel1.setMinSize(20, 50);
		btnLoopLevel1.setOnAction(e -> {
			primaryStage.setScene(introLoopScene);
		});

		Button btnLoopLevel2 = new Button("Level 2");
		btnLoopLevel2.setMinSize(20, 50);
		btnLoopLevel2.setOnAction(e -> {
			primaryStage.setScene(mathScene);
		});

		// create a gridpane to put everything inside
		GridPane levelGrid = new GridPane();

		levelGrid.add(lblVarLevels, 0, 0);
		levelGrid.add(btnVarLevel1, 1, 0);
		levelGrid.add(btnVarLevel2, 2, 0);
		levelGrid.add(btnVarLevel3, 3, 0);

		levelGrid.add(lblIfLevels, 0, 1);
		levelGrid.add(btnIfLevel1, 1, 1);
		levelGrid.add(btnIfLevel2, 2, 1);
		levelGrid.add(btnIfLevel3, 3, 1);

		levelGrid.add(lblLoopLevels, 0, 2);
		levelGrid.add(btnLoopLevel1, 1, 2);
		levelGrid.add(btnLoopLevel2, 2, 2);

		levelGrid.setHgap(20);
		levelGrid.setVgap(20);

		// put title Hbox and levelGrid in a vbox
		VBox vbxLevels = new VBox(ancrPnLevel, levelGrid, btnMenuBack);
		vbxLevels.setMargin(levelGrid, new Insets(200, 0, 10, 370));

		// create the scene
		Scene levelScene = new Scene(vbxLevels, 1000, 800);
		return levelScene;
	}

	/*
	 * Method Name: challengeSceneCreator
	 * Description: Creates the challenge scene.
	 * Parameters: int level, MenuButton menuButton, String[] descriptions, String[] inputs, String[] outputs
	 * Returns: Scene challengeScene
	 */
	public static Scene challengeSceneCreator(int level, MenuButton menuButton, String[] descriptions, String[] inputs, String[] outputs) {
		//create public static scene above
		//create label for title
		Label title = new Label();
		
		//create title according to the topics in the level
		switch(level) {
			case 1: case 2: case 3:
				title.setText("Variables: Level" + level);
				break;
			case 4: case 5: case 6:
				title.setText("If Statements: Level" + (level - 3));
				break;
			case 7: case 8:
				title.setText("Loops: Level" + (level - 6));
				break;
		}
		
		//give title a large font
		title.setFont(new Font("Arial", 54));
		
		//create VBox for title and menu
		AnchorPane titleAnchor = new AnchorPane(title, menuButton);
		titleAnchor.setTopAnchor(title, 0.0);
		titleAnchor.setLeftAnchor(title, 280.0);
		
		titleAnchor.setTopAnchor(menuButton, 0.0);
		titleAnchor.setRightAnchor(menuButton, 0.0);
		
		//create a font for normal text and headings
		Font normalFont = new Font("Arial", 24);
		Font headingFont = new Font("Arial", 36);
		
		//create challenge title and description
		Label challengeTitle = new Label("Challenge: ");
		challengeTitle.setFont(headingFont);
				
		Label challengeDes = new Label(descriptions[level - 1]);
		challengeDes.setWrapText(true);
		challengeDes.setFont(normalFont);
		
		//create sample in and out title and labels
		Label sampleTitle = new Label("Sample In & Out");
		sampleTitle.setFont(headingFont);
		
		Label sampleIn = new Label(inputs[level - 1]);
		sampleIn.setWrapText(true);
		sampleIn.setFont(normalFont);
		
		Label sampleOut = new Label(outputs[level - 1]);
		sampleOut.setWrapText(true);
		sampleOut.setFont(normalFont);
		
		//put sample in and out beside each other in a HBox
		HBox inOutHBox = new HBox(sampleIn, sampleOut);
		
		//create "Write Code Here" label and run button
		Label codeHeading = new Label("Write Your Code Here");
		codeHeading.setFont(headingFont);
		
		Button btnRun = new Button("Run Code");
		btnRun.setFont(headingFont);
		btnRun.setOnAction(null);//later add what it does
		
		//create TextArea to write code
		TextArea userCode = new TextArea();
		userCode.setMinSize(500, 500);
		userCode.setFont(normalFont);
		
		//create "View Output" heading and submit button
		Label outputHeading = new Label("View Output");
		outputHeading.setFont(headingFont);
		
		Button btnSubmit = new Button("Submit Code");
		btnSubmit.setFont(headingFont);
		btnSubmit.setOnAction(null);//later add what this does
	
		//create Label to display the output
		Label codeOutput = new Label(null); //-----give this thiing anoutput
		codeOutput.setWrapText(true);
		codeOutput.setFont(normalFont);
		
		//create a gridPane to store everything store the six controls above
		GridPane functionGrid = new GridPane();
		functionGrid.add(codeHeading, 0, 0);
		functionGrid.add(btnRun, 1, 0);
		functionGrid.add(outputHeading, 2, 0);
		functionGrid.add(btnSubmit, 3, 0);
		functionGrid.add(userCode, 0, 1, 2, 1);
		functionGrid.add(codeOutput, 1, 1, 2, 1);
		
		//create VBox for everything above
		VBox challengeVBox = new VBox(titleAnchor, challengeTitle, challengeDes, sampleTitle, inOutHBox, functionGrid);
		
		//create scene
		Scene challengeScene = new Scene(challengeVBox, 1000, 1000);
		return challengeScene;
	}
	
}//end class
