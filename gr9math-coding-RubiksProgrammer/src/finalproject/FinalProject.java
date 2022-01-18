/* Name: Yash Joshi
 * Course: ICS 3U
 * Teacher: Mrs. McCafferey
 * Date: June 23, 2021
 * Description: This program is used to create a GUI-based application that encourages Grade 9 students to use 
 * 				coding skills to solve math problems (specifically relating to linear relations).
 */

package finalproject;

import java.io.IOException;

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

public class FinalProject extends Application {
	
	//create all the scenes
	Scene homeScene, menuScene, howToScene, levelScene;
	//Scene introVarScene, introIfScene, introLoopScene, mathScene, challengeScene, passScene, failScene;
	
	//create arrays that store intro scene title, description, and examples
	static String[] introSceneTitles = {"What are Variables?", "What are If Statements?", "What are Loops?"};
	static String[] introSceneDescripts = {"Variables are keywords that can represent something. For example, the "
										+ "word num could represent the number 1. In this game, to create a variable, "
										+ "you can call the var(name, value) command, which takes in 2 parameters, "
										+ "the name of the variable and the value you would like to give it. To reassign "
										+ "a variable to another value, you can use the varRe(name, newValue) command, "
										+ "which takes in the name of the variable you would like to reassign and the new "
										+ "value. You can also do math with variables. Since there is no reason to do "
										+ "math with variables if you are not assigning the value to anything, you should "
										+ "do the math in the value part of the var() or varRe() command. You can use + "
										+ "for addition, - for subtraction, * for multiplication, and / for division. \n\n"
										+ "Taking in Input: To take in input, you must simply call the input(name) method, "
										+ "which takes in the first line of input that hasn't been taken in already and "
										+ "assigns it to a variable of whatever name you set (enter this as parameter in "
										+ "the input command).\n\n"
										+ "Displaying Output: To display output, simply call the print(value) command, which can "
										+ "output any value or string (text), or multiple values (use a comma to separate each value "
										+ "if entering multiple values as parameter). \n\n"
										+ "NOTE: a semicolon is important after every command.", "ahfkdklelle", "adjkllllls"};
	static String[] introSceneExamples = {"Assigning Variables: var(age, 14);\nReassigning: varRe(age, 92);\nMathing: "
										+ "varRe(age, age-23*2);\nTaking Input: input(age);\nShowing Output: "
										+ "output(age, \" \", age + 1);", "Coming Soon", "Coming Soon"};
	
	//create arrays that store math scene title, description, and examples
	static String[] mathSceneTitles = {"Converting Rates", "Finding The Slope", "Solving the Line Equation",
										"A Point on a Line", "Slopes In Tables", "Slopes In Equations",
										"Graphing Until An X", "Graphing Until A Y"};
	static String[] mathSceneDescripts = {"Rates come in all different shpaes, sizes, and forms. A rate is a ratio "
										+ "between two different quantities or measures. It can be represented as a "
										+ "fraction or ratio. For example 46 kilometers/2 hours is a rate. A unit rate is"
										+ "a rate where the denominator (second quantity) is 1, so you are measuring "
										+ "the amount of the first quantity for every 1 of the second quantity. For "
										+ "example, 23 kilometers/hour is a unit rate. Many times, you might need to "
										+ "convert between different rates. For example you might need to convert "
										+ "between km/hour and m/s. To do this, you have to multiply be a conversion "
										+ "factor, which is a ratio between 2 different types of measurements used to "
										+ "measure the same thing (e.g. 1 km/1000 m or 3600 s/hour). If you multiple "
										+ "correctly, you can convert between rates.", 
										
										"Finding the slope of something means finding the rate of something. For that "
										+ "you have to do the rise/run or the change in y position/change in x position "
										+ "or, as an equation, it would be (y2 - y1)/(x2 - x1).",
										
										"The equation for a line is y = mx + b, where y is dependent variable, x "
										+ "is the independent variable, m is the slope, and b is the initial value "
										+ "or y-intercept. If you know any three of these variables, you can solve for "
										+ "the missing variable."};
	static String[] mathSceneExamples = {"Converting km/hour to m/s: \n23 km/hour * 1000 m/km * 1 hour/3600 s = "
									+ "6.388 m/s",
									
									"A plane, travels 50 km in 48 seconds. How fast is the plane going?\n55 km/48 s = "
									+ "1.15 km/s\n The plane is going at 1.15 km/s.",
									
									"A plane starts from 5 km away from the airport. It moves at a rate of 330 km/hour "
									+ "away from the airport. If it flies for 5 hours, how far will it get from the airport?"
									+ "\ny = mx + b\ny = (330 km/hour)(5 hours) + 5 km\ny = 1655 km"};
	
	//create arrays that store challenge scene description, sample in, sample out, and testcases
	static String[] challengeSceneDescripts = {"You will be given four values: i, j, k. The first, i, will be the "
											+ "the original rate. The second, j, will be the conversion factor for the "
											+ "first quantity (in the numerator) to the the required quantity (will be "
											+ "given as original q/required q. The third, k, will be the conversion factor "
											+ "for the quantity in the denominator of the original rate (same format as j). "
											+ "Your goal is to write code so that you convert the original rate to the "
											+ "required rate (as a unit rate, so only one number required)."};
	static String[] challengeSceneSampleIn = {"Where km/hour is converted to m/s:\n10/2\n1/1000\n1/3600"};
	static String[] challengeSceneSampleOut = {"\n2.77"};
		
	public static void main(String[] args) {
		launch(args);
	}//end main
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//create homeScene------------------------------------------------------HOME
		//create title
		Label lblTitle = new Label("Exploring Linear Relations");
		lblTitle.setFont(new Font("Arial", 54));
		
		//create start button
		Button btnStart = new Button("Start");
		btnStart.setFont(new Font("Arial", 40));
		btnStart.setOnAction(e -> primaryStage.setScene(menuScene));
		
		//put controls in vbox
		VBox vbxHome = new VBox(50, lblTitle, btnStart);
		vbxHome.setMargin(lblTitle, new Insets(30, 10, 10, 10));
		vbxHome.setAlignment(Pos.BASELINE_CENTER);
		
		//create scene
		homeScene = new Scene(vbxHome, 1000, 800);
		
		//create menuScene-------------------------------------------------------MENU
		//create title
		Label lblMenu = new Label("Menu");
		Font titleFont = new Font("Arial", 30);
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
		menuScene = new Scene(vbxMenu, 1000, 800);
		
		//create howToScene----------------------------------------------------HOW TO
		//create title
		Label lblHowTo = new Label("How To Play");
		lblHowTo.setFont(titleFont);
		
		//create a menu button and options for this specific scene--------------menu
		MenuItem levelOptionHowScene = new MenuItem("Select Level");
		levelOptionHowScene.setOnAction(e -> primaryStage.setScene(levelScene));
		
		MenuItem howToOptionHowScene = new MenuItem("How To Play");
		howToOptionHowScene.setOnAction(e -> primaryStage.setScene(howToScene));
		
		MenuItem quitOptionHowScene = new MenuItem("Quit");
		quitOptionHowScene.setOnAction(e -> {
			
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
		//create menu method
		MenuButton howMenuButton = new MenuButton("Menu", null, levelOptionHowScene, howToOptionHowScene, quitOptionHowScene);
		howMenuButton.setMinWidth(40);
		//------------------------------------------------------------------end menu creation
		
		//add menu and title to Hbox
		AnchorPane ancrPnHowTo = new AnchorPane(lblHowTo, howMenuButton);
		ancrPnHowTo.setTopAnchor(lblHowTo, 0.0);
		ancrPnHowTo.setLeftAnchor(lblHowTo, 280.0);
		
		ancrPnHowTo.setTopAnchor(howMenuButton, 0.0);
		ancrPnHowTo.setRightAnchor(howMenuButton, 0.0);
		
		//create font for normal text
		Font normalFont = new Font("Arial", 24);
		
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
		Button btnHowBack = new Button("Back");
		btnHowBack.setOnAction(e -> primaryStage.setScene(menuScene));
		
		//put all controls/containers above in a vbox
		VBox vbxHowTo = new VBox(20, ancrPnHowTo, lblHowLevels1, lblHowLevels2, lblHowMenu, btnHowBack);
		vbxHowTo.setMargin(lblHowLevels1, new Insets(10, 20, 10, 20));
		vbxHowTo.setMargin(lblHowLevels2, new Insets(10, 20, 10, 20));
		vbxHowTo.setMargin(lblHowMenu, new Insets(10, 20, 10, 20));
		
		
		//create the how to scene
		howToScene = new Scene(vbxHowTo, 1000, 800);
	
		//create levelScene----------------------------------------------------LEVELS
		//create title
		Label lblLevels = new Label("Levels");
		lblLevels.setFont(titleFont);
		
		//create menu button and options for this specific scene--------------menu
		MenuItem levelOptionLevelScene = new MenuItem("Select Level");
		levelOptionLevelScene.setOnAction(e -> primaryStage.setScene(levelScene));
		
		MenuItem howToOptionLevelScene = new MenuItem("How To Play");
		howToOptionLevelScene.setOnAction(e -> primaryStage.setScene(howToScene));
		
		MenuItem quitOptionLevelScene = new MenuItem("Quit");
		quitOptionLevelScene.setOnAction(e -> {
			
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
		
		//create the actual button
		MenuButton levelMenuButton = new MenuButton("Menu", null, levelOptionLevelScene, howToOptionLevelScene, quitOptionLevelScene);
		levelMenuButton.setMinWidth(40);
		//------------------------------------------------------------------end menu creation
		
		//create Anchor Pane to store label and corner menu (use same button from howToScene)
		AnchorPane ancrPnLevel = new AnchorPane(lblLevels, levelMenuButton);
		ancrPnLevel.setTopAnchor(lblLevels, 0.0);
		ancrPnLevel.setLeftAnchor(lblLevels, 280.0);
		
		ancrPnLevel.setTopAnchor(levelMenuButton, 0.0);
		ancrPnLevel.setRightAnchor(levelMenuButton, 0.0);
		
		//create general menu button and options to input into the methods for the rest of the scenes---------menu
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
		
		//create the actual button
		MenuButton menuButton = new MenuButton("Menu", null, levelOption, howToOption, quitOption);
		menuButton.setMinWidth(40);
		//------------------------------------------------------------------end menu creation
		
		//create the variable levels label and buttons
		Label lblVarLevels = new Label("Variables:");
		lblVarLevels.setMinSize(20, 50);
		
		Button btnVarLevel1 = new Button("Level 1");
		btnVarLevel1.setMinSize(20, 50);
		btnVarLevel1.setOnAction(e -> {
			levelGenerator(1, 1, primaryStage, levelScene, menuButton);
		});
		
		Button btnVarLevel2 = new Button("Level 2");
		btnVarLevel2.setMinSize(20, 50);
		btnVarLevel2.setOnAction(e -> {
			levelGenerator(2, 2, primaryStage, levelScene, menuButton);
		});
		
		Button btnVarLevel3 = new Button("Level 3");
		btnVarLevel3.setMinSize(20, 50);
		btnVarLevel3.setOnAction(e -> {
			levelGenerator(3, 2, primaryStage, levelScene, menuButton);
		});
		
		//create the if statement levels label and buttons
		Label lblIfLevels = new Label("If Statements:");
		lblIfLevels.setMinSize(20, 50);
		
		Button btnIfLevel1 = new Button("Level 1");
		btnIfLevel1.setMinSize(20, 50);
		btnIfLevel1.setOnAction(e -> {
			levelGenerator(4, 1, primaryStage, levelScene, menuButton);
		});
		
		Button btnIfLevel2 = new Button("Level 2");
		btnIfLevel2.setMinSize(20, 50);
		btnIfLevel2.setOnAction(e -> {
			levelGenerator(5, 2, primaryStage, levelScene, menuButton);
		});
		
		Button btnIfLevel3 = new Button("Level 3");
		btnIfLevel3.setMinSize(20, 50);
		btnIfLevel3.setOnAction(e -> {
			levelGenerator(6, 2, primaryStage, levelScene, menuButton);
		});
		
		//create the loops levels label and buttons
		Label lblLoopLevels = new Label("Loops:");
		lblLoopLevels.setMinSize(20, 50);
		
		Button btnLoopLevel1 = new Button("Level 1");
		btnLoopLevel1.setMinSize(20, 50);
		btnLoopLevel1.setOnAction(e -> {
			levelGenerator(7, 1, primaryStage, levelScene, menuButton);
		});
		
		Button btnLoopLevel2 = new Button("Level 2");
		btnLoopLevel2.setMinSize(20, 50);
		btnLoopLevel2.setOnAction(e -> {
			levelGenerator(8, 2, primaryStage, levelScene, menuButton);
		});
		
		//create a gridpane to put everything inside
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
		
		//create back button
		Button btnLevelBack = new Button("Back");
		btnLevelBack.setOnAction(e -> primaryStage.setScene(menuScene));
		
		//put title Hbox and levelGrid in a vbox
		VBox vbxLevels = new VBox(ancrPnLevel, levelGrid, btnLevelBack);
		vbxLevels.setMargin(levelGrid, new Insets(200, 0, 10, 370));
		
		//create the scene
		levelScene = new Scene(vbxLevels, 1000, 800);
		
		//setup stage----------------------------------------------------STAGE
		primaryStage.setScene(homeScene);
		primaryStage.setTitle("Exploring Linear Relations");
		primaryStage.show();
		
	}//end start method
	
	/*
	 * Method Name: levelGenerator
	 * Description: Displays a level-related scene according to the level and case given.
	 * Parameters: int level, int whichScene, Stage primaryStage, Scene levelScene, MenuButton menuButton
	 * 			   Font titleFont, Font normalFont
	 * Returns: void
	 */
	public static void levelGenerator(int level, int whichScene, Stage primaryStage, Scene levelScene, MenuButton menuButton) {
		
		//create a title and normal font
		Font titleFont = new Font("Arial", 30);
		Font normalFont = new Font("Arial", 24);
		
		//create switch case statement for displaying right scene
		switch(whichScene) {
			case 1:
				Scene introScene = introSceneCreator(level, primaryStage, levelScene, menuButton, titleFont, normalFont);
				primaryStage.setScene(introScene);
				break;
			case 2:
				Scene mathScene = mathSceneCreator(level, primaryStage, levelScene, menuButton, titleFont, normalFont);
				primaryStage.setScene(mathScene);
				break;
			case 3:
				Scene challengeScene = challengeSceneCreator(level, primaryStage, levelScene, menuButton, titleFont, normalFont);
				primaryStage.setScene(challengeScene);
				break;
			case 4:
				primaryStage.setScene(levelScene);
			
		}//end switch case statement
		
	}//end levelGenerator method

	/*
	 * Method Name: introSceneCreator
	 * Description: Creates an intro to coding scene according to the level given.
	 * Parameters: int level, Stage primaryStage, Scene levelScene, MenuButton menuButton,
	 * 			   Font titleFont, Font normalFont
	 * Returns: Scene introScene
	 */
	public static Scene introSceneCreator(int level, Stage primaryStage, Scene levelScene, MenuButton menuButton, Font titleFont, Font normalFont) {
		
		//depending on the level entered, determine the right index to use to get info from arrays
		int index = 0;
		switch(level) {
			case 1:
				index = 0;
				break;
			case 4:
				index = 1;
				break;
			case 7:
				index = 2;
				break;
		}//end switch
		
		//create the title
		Label introTitle = new Label(introSceneTitles[index]);
		introTitle.setFont(titleFont);
		
		//create anchor pane with the title and the menu button
		AnchorPane ancrPnHeader = new AnchorPane(introTitle, menuButton);
		ancrPnHeader.setLeftAnchor(introTitle, 200.0);
		
		ancrPnHeader.setTopAnchor(menuButton, 0.0);
		ancrPnHeader.setRightAnchor(menuButton, 0.0);
		
		//create the description label
		Label descriptionHeader = new Label("Description:");
		descriptionHeader.setFont(titleFont);
		Label description = new Label(introSceneDescripts[index]);
		description.setFont(normalFont);
		description.setWrapText(true);
		
		//create the examples label
		Label examplesHeader = new Label("Examples:");
		examplesHeader.setFont(titleFont);
		Label examples = new Label(introSceneExamples[index]);
		examples.setFont(normalFont);
		examples.setWrapText(true);
		
		//create back button
		Button btnBack = new Button("Back");
		btnBack.setFont(normalFont);
		btnBack.setOnAction(e -> primaryStage.setScene(levelScene));
		
		//create next button
		Button btnNext = new Button("Next");
		btnNext.setFont(normalFont);
		btnNext.setOnAction(e -> levelGenerator(level, 2, primaryStage, levelScene, menuButton));
		
		//create anchor pane for back and next buttons
		AnchorPane ancrPnBackNext = new AnchorPane(btnBack, btnNext);
		ancrPnBackNext.setBottomAnchor(btnBack, 0.0);
		ancrPnBackNext.setLeftAnchor(btnBack, 0.0);
		
		ancrPnBackNext.setBottomAnchor(btnNext, 0.0);
		ancrPnBackNext.setRightAnchor(btnNext, 0.0);
		
		//put everything above in a vbox
		VBox vbxIntro = new VBox(ancrPnHeader, descriptionHeader, description, examplesHeader, examples, ancrPnBackNext);
		
		//create and return the scene
		Scene introScene = new Scene(vbxIntro, 1000, 800);
		return introScene;
		
	}//end introSceneCreator method

	/*
	 * Method Name: mathSceneCreator
	 * Description: Creates the intro to math concept scene according to the level.
	 * Parameters: int level, Stage primaryStage, Scene levelScene, MenuButton menuButton,
	 * 			   Font titleFont, Font normalFont
	 * Returns: Scene mathScene
	 */
	public static Scene mathSceneCreator(int level, Stage primaryStage, Scene levelScene, MenuButton menuButton, Font titleFont, Font normalFont) {
		
		//create the title
		Label mathTitle = new Label(mathSceneTitles[level-1]);
		mathTitle.setFont(titleFont);
		
		//create anchor pane with the title and the menu button
		AnchorPane ancrPnHeader = new AnchorPane(mathTitle, menuButton);
		ancrPnHeader.setLeftAnchor(mathTitle, 200.0);
		
		ancrPnHeader.setTopAnchor(menuButton, 0.0);
		ancrPnHeader.setRightAnchor(menuButton, 0.0);
		
		//create the description label
		Label descriptionHeader = new Label("Description:");
		descriptionHeader.setFont(titleFont);
		Label description = new Label(mathSceneDescripts[level-1]);
		description.setFont(normalFont);
		description.setWrapText(true);
		
		//create the examples label
		Label examplesHeader = new Label("Examples:");
		examplesHeader.setFont(titleFont);
		Label examples = new Label(mathSceneExamples[level-1]);
		examples.setFont(normalFont);
		examples.setWrapText(true);
		
		//create back button
		Button btnBack = new Button("Back");
		btnBack.setFont(normalFont);
		btnBack.setOnAction(e -> {
			
			//determine what was the last level and case
			int lastLevel;
			int lastCase;
			
			switch(level) {
				case 1: case 4: case 7:
					lastLevel = level;
					lastCase = 1;
					break;
				default:
					lastLevel = level - 1;
					lastCase = 3;
			}//end switch
			
			//display previous scene accordingly
			levelGenerator(lastLevel, lastCase, primaryStage, levelScene, menuButton);
			
		});//end lambda
		
		//create next button
		Button btnNext = new Button("Next");
		btnNext.setFont(normalFont);
		btnNext.setOnAction(e -> levelGenerator(level, 3, primaryStage, levelScene, menuButton));
		
		//create anchor pane for back and next buttons
		AnchorPane ancrPnBackNext = new AnchorPane(btnBack, btnNext);
		ancrPnBackNext.setBottomAnchor(btnBack, 0.0);
		ancrPnBackNext.setLeftAnchor(btnBack, 0.0);
		
		ancrPnBackNext.setBottomAnchor(btnNext, 0.0);
		ancrPnBackNext.setRightAnchor(btnNext, 0.0);
		
		//put everything above in a vbox
		VBox vbxMath = new VBox(ancrPnHeader, description, examples, ancrPnBackNext);
		
		//create and return the scene
		Scene mathScene = new Scene(vbxMath, 1000, 800);
		return mathScene;
	}//end mathSceneCreator

	/*
	 * Method Name: challengeSceneCreator
	 * Description: Creates the challenge scene according to the level.
	 * Parameters: int level, Stage primaryStage, Scene levelScene, MenuButton menuButton,
	 * 			   Font titleFont, Font normalFont
	 * Returns: Scene challengeScene
	 */
	public static Scene challengeSceneCreator(int level, Stage primaryStage, Scene levelScene, MenuButton menuButton, Font titleFont, Font normalFont) {
		
		//create label for title
		Label challengeTitle = new Label();
		
		//create title according to the topics in the level
		switch(level) {
			case 1: case 2: case 3:
				challengeTitle.setText("Variables: Level " + level);
				break;
			case 4: case 5: case 6:
				challengeTitle.setText("If Statements: Level " + (level - 3));
				break;
			case 7: case 8:
				challengeTitle.setText("Loops: Level " + (level - 6));
				break;
		}//end switch case statement
		
		//give title a large font
		challengeTitle.setFont(new Font("Arial", 54));
		
		//create anchor pane for title and menu
		AnchorPane titleAnchor = new AnchorPane(challengeTitle, menuButton);
		titleAnchor.setTopAnchor(challengeTitle, 0.0);
		titleAnchor.setLeftAnchor(challengeTitle, 280.0);
		
		titleAnchor.setTopAnchor(menuButton, 0.0);
		titleAnchor.setRightAnchor(menuButton, 0.0);
		
		//create challenge header and description
		Label challengeHeader = new Label("Challenge: ");
		challengeHeader.setFont(titleFont);
				
		Label challengeDes = new Label(challengeSceneDescripts[level - 1]);
		challengeDes.setWrapText(true);
		challengeDes.setFont(normalFont);
		
		//create sample in and out header and labels
		Label sampleHeader = new Label("Sample In & Out");
		sampleHeader.setFont(titleFont);
		
		Label sampleIn = new Label(challengeSceneSampleIn[level - 1]);
		sampleIn.setWrapText(true);
		sampleIn.setFont(normalFont);
		
		Label sampleOut = new Label(challengeSceneSampleOut[level - 1]);
		sampleOut.setWrapText(true);
		sampleOut.setFont(normalFont);
		
		//put sample in and out beside each other in a HBox
		HBox inOutHBox = new HBox(sampleIn, sampleOut);
		
		//create "Write Code Here" label
		Label codeHeading = new Label("Write Your Code Here");
		codeHeading.setFont(titleFont);
		
		//create TextArea to write code
		TextArea userCode = new TextArea();
		userCode.setMinSize(500, 500);
		userCode.setFont(normalFont);
		
		//create "View Output" heading and submit button
		Label outputHeading = new Label("View Output");
		outputHeading.setFont(titleFont);
		
		//create TextArea to enter any input
		TextArea codeInput = new TextArea("Please enter any input here first:");
		codeInput.setFont(normalFont);
		
		//create Label to display the output
		Label codeOutput = new Label(null);
		codeOutput.setWrapText(true);
		codeOutput.setFont(normalFont);
		
		//create the button to run the code
		Button btnRun = new Button("Run Code");
		btnRun.setFont(titleFont);
		btnRun.setOnAction(e -> {
			
			//use try catch while calling codeReader method to catch the IOException
			try {
				
				//first take in any inputs, if necessary
				String[] input = codeInput.getText().split("\n");
				input = Array.deleteStringElement(input, 0);
				
				//create output array to store output of codeReader method, combine into one string, and display
				String[] output = CodeCommands.codeReader(userCode.getText(), input);
				String joinedOutput = String.join("\n", output);
				codeOutput.setText(joinedOutput);
				
			} catch (IOException e1) {
				System.out.println("Error ocurred during external process.");
				e1.printStackTrace();
				
			}//end try catch
		});//end lambda
		
		//create submit button
		Button btnSubmit = new Button("Submit Code");
		btnSubmit.setFont(titleFont);
		btnSubmit.setOnAction(e -> {
			
			//use try catch while calling codeChecker method to catch the IOException
			try {
				
				//call code reader method and assign its return values to an Object[]
				Object[] codeInfo = CodeCommands.codeChecker(userCode.getText(), level);
				
				//if first element of array is null, display pass scene, otherwise cast the information from array
				//correctly and display fail scene
				if(codeInfo[0] == null) {
					primaryStage.setScene(passSceneCreator(level, primaryStage, levelScene, menuButton, titleFont, normalFont));
				}
				else {
					String[] inputs = (String[]) codeInfo[0];
					String[] outputs = (String[]) codeInfo[1];
					
					primaryStage.setScene(failSceneCreator(level, inputs, outputs, primaryStage, levelScene, menuButton, titleFont, normalFont));
				}//end if
			}
			catch (IOException e1) {
				System.out.println("Error ocurred during external process.");
				e1.printStackTrace();
				
			}//end try catch block
		});//end lambda

		
		//create a gridPane to store the six controls above
		GridPane functionGrid = new GridPane();
		functionGrid.add(codeHeading, 0, 0);
		functionGrid.add(btnRun, 1, 0);
		functionGrid.add(outputHeading, 2, 0);
		functionGrid.add(btnSubmit, 3, 0);
		functionGrid.add(userCode, 0, 1, 2, 2);
		functionGrid.add(codeInput, 2, 1, 2, 1);
		functionGrid.add(codeOutput, 2, 2, 2, 1);
		
		//create a back button
		Button btnBack = new Button("Back");
		btnBack.setFont(normalFont);
		btnBack.setOnAction(e -> levelGenerator(level, 2, primaryStage, levelScene, menuButton));
		
		//create VBox for everything above
		VBox challengeVBox = new VBox(titleAnchor, challengeHeader, challengeDes, sampleHeader, inOutHBox, functionGrid, btnBack);
		
		//create scene
		Scene challengeScene = new Scene(challengeVBox, 1000, 1000);
		
		return challengeScene;
	}//end challengeSceneCreator

	/*
	 * Method Name: passSceneCreator
	 * Description: Creates the pass scene according to the level.
	 * Parameters: int level, Stage primaryStage, Scene levelScene, MenuButton menuButton,
	 * 			   Font titleFont, Font normalFont
	 * Returns: Scene passScene
	 */
	public static Scene passSceneCreator(int level, Stage primaryStage, Scene levelScene, MenuButton menuButton,
			Font titleFont, Font normalFont) {
		
		//create label for title
		Label passTitle = new Label("You Passed!!");
		passTitle.setFont(titleFont);
		
		//create anchor pane for title and menu button
		AnchorPane ancrPnHeader = new AnchorPane(passTitle, menuButton);
		ancrPnHeader.setLeftAnchor(passTitle, 200.0);
		
		ancrPnHeader.setTopAnchor(menuButton, 0.0);
		ancrPnHeader.setRightAnchor(menuButton, 0.0);
		
		//create label for pass message
		Label passMessage = new Label("Great work!! You have passed level " + level + " of this game!! "
				+ "Press continue to go to the next level.");
		passMessage.setFont(normalFont);
		passMessage.setWrapText(true);
		
		//figure out the next case(1,2,3) to pass to levelGenerator
		int nextCase;
		switch(level) {
			case 3: case 6:
				nextCase = 1;
				break;
			case 8:
				nextCase = 4;
				break;
			default:
				nextCase = 2;
				break;
		}//end switch
		
		//create next level button
		Button btnNextLevel = new Button("Continue");
		btnNextLevel.setFont(titleFont);
		btnNextLevel.setOnAction(e -> levelGenerator(level + 1, nextCase, primaryStage, levelScene, menuButton));
		
		//create vbox to hold everything above
		VBox vbxPass = new VBox(ancrPnHeader, passMessage, btnNextLevel);
		vbxPass.setAlignment(Pos.BASELINE_CENTER);
		
		//create scene
		Scene passScene = new Scene(vbxPass, 1000, 800);
		return passScene;
		
	}//end passSceneCreator

	/*
	 * Method Name: failSceneCreator
	 * Description: Creates the fail scene according to the level.
	 * Parameters: int level, String[] inputs, String[] outputs, Stage primaryStage, Scene levelScene, MenuButton menuButton,
	 * 			   Font titleFont, Font normalFont
	 * Returns: Scene failScene
	 */
	public static Scene failSceneCreator(int level, String[] inputs, String[] outputs, Stage primaryStage,
			Scene levelScene, MenuButton menuButton, Font titleFont, Font normalFont) {
		
		//create label for title
		Label failTitle = new Label("You Failed!");
		failTitle.setFont(titleFont);
		
		//create anchor pane for title and menu button
		AnchorPane ancrPnHeader = new AnchorPane(failTitle, menuButton);
		ancrPnHeader.setLeftAnchor(failTitle, 200.0);
		
		ancrPnHeader.setTopAnchor(menuButton, 0.0);
		ancrPnHeader.setRightAnchor(menuButton, 0.0);
		
		//create label for fail message
		Label failMessage = new Label("Your code couldn't pass all of the testcases. Below, you can see what "
				+ "the test case input was and what your code outputted. Please try again.");
		failMessage.setWrapText(true);
		failMessage.setFont(normalFont);
		
		//create labels to show input and output
		Label input = new Label("Testcase Input: \n" + String.join("\n", inputs));
		input.setFont(normalFont);
		input.setWrapText(true);
		
		Label output = new Label("Your Code's Output: \n" + String.join("\n", outputs));
		output.setFont(normalFont);
		output.setWrapText(true);
		
		//create hbox for input and output labels
		HBox hbxInOut = new HBox(input, output);
		
		//create retry button
		Button btnRetry = new Button("Retry:");
		btnRetry.setFont(titleFont);
		btnRetry.setOnAction(e -> levelGenerator(level, 3, primaryStage, levelScene, menuButton));
		
		//create vbox to store all containers/controls above
		VBox vbxFail = new VBox(ancrPnHeader, failMessage, hbxInOut, btnRetry);
		vbxFail.setAlignment(Pos.BASELINE_CENTER);
		
		//create scene
		Scene failScene = new Scene(vbxFail, 1000, 800);
		return failScene;
		
	}//end failSceneCreator
	
}//end class
