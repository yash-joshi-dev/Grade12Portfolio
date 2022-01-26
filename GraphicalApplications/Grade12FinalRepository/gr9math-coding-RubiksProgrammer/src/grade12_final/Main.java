package grade12_final;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import finalproject.Array;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	
	//declare variables to store user screen height and width
	static Rectangle2D screenBounds = Screen.getPrimary().getBounds();
	static double screenHeight = screenBounds.getHeight();
	static double screenWidth = screenBounds.getWidth();
	
	//declare arraylist to store all topic problem sets and init it
	static ArrayList<ProblemSet> problemSets;
	
	//declare all starting scenes
	static Pane startScene = createStartScene();
	static Pane topicsScene = createTopicScene();
	static Pane howToScene;
	static Pane teacherScene;
	static Pane modificationScene;
	
	//declare the global scene
	static Scene mainScene = new Scene(startScene);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//set title, scene, and show stage
		primaryStage.setTitle("CodeMath by ArachneTechnologies");
		primaryStage.setScene(mainScene);
		primaryStage.setMaximized(true);
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
	}//end start

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Reads an array of integers (separated by a space) from a string and fills the array with the integers.
	 * @param line the string of integers
	 * @param array the array to fill
	 */
	public static void readArray(String line, double[] array) {
		
		String num = "";
		int counter = 0;
		for(int i = 0; i < line.length(); i++) {
			char c = line.toCharArray()[i];
			if(c != ' ') {
				num += c;
			}
			else {
				array[counter] = Double.parseDouble(num);
				num = "";
				counter++;
			}//end if
		}//end for
		
	}//end readArray
	
	/**
	 * Initializes the problem set array list by reading data from data file.
	 * @throws IOException 
	 */
	public static void initTables() throws IOException {
		
		//init file and buffered reader
		FileReader file = new FileReader("Data.txt");
		BufferedReader reader = new BufferedReader(file);
		
		//first read in first line containing number of topics and init problemSets array to that amount
		int topicNum = Integer.parseInt(reader.readLine());
		problemSets = new ArrayList<ProblemSet>();
		
		//iterate for each topic
		for(int i = 0; i < topicNum; i++) {
			
			//take in first line containing the topic's file name and create a new reader for that
			BufferedReader topicReader = new BufferedReader(new FileReader(reader.readLine()));
			
			//take in first line containing number of problems and next line containing topic
			int probNum = Integer.parseInt(topicReader.readLine());
			String topic = topicReader.readLine();
			
			//create an array list to store problems
			ArrayList<Problem> problems = new ArrayList<>();
			
			//iterate for each problem
			for(int j = 0; j < probNum; j++) {
				
				//first read the problem name
				String name = topicReader.readLine();
				
				//read problem description
				String description = topicReader.readLine();
				
				//read number of sample inputs and outputs and number of inputs and outputs per line
				int sampleNum = Integer.parseInt(topicReader.readLine());
				int inNum = Integer.parseInt(topicReader.readLine());
				int outNum = Integer.parseInt(topicReader.readLine());
				
				//read the names of the inputs and outputs
				String[] inNames = topicReader.readLine().split(" ");
				String[] outNames = topicReader.readLine().split(" ");
				
				//create 2d arrays to store sample ins and outs
				double[][] sampleIns = new double[sampleNum][inNum];
				double[][] sampleOuts = new double[sampleNum][outNum];
				
				//take in all sample ins and outs
				for(int k = 0; k < sampleNum; k++) {
					
					readArray(topicReader.readLine(), sampleIns[k]);
					readArray(topicReader.readLine(), sampleOuts[k]);
					
				}//end for
				
				//read number of testcases
				int caseNum = Integer.parseInt(topicReader.readLine());
				
				//create 2d array to store testcase ins and outs
				double[][] testIns = new double[caseNum][inNum];
				double[][] testOuts = new double[caseNum][outNum];
				
				//take in all testcase ins and outs
				for(int k = 0; k < sampleNum; k++) {
					
					readArray(topicReader.readLine(), testIns[k]);
					readArray(topicReader.readLine(), testOuts[k]);
					
				}//end for
				
				//finally, create the problem object and add to problems array list
				problems.add(new Problem(name, description, inNames, outNames, sampleIns, sampleOuts, testIns, testOuts));
				
			}//end problems for
			
			//create problemset object and add to problemSets array list
			problemSets.add(new ProblemSet(topic, problems));
			
		}//end topics for
		
	}//end initTables
	
	/**
	 * Creates the start scene for the application. This includes the title, student/teacher login buttons, and how to use button.
	 * @return the start scene.
	 */
	public static Pane createStartScene() {
		
		//create title label
		Label title = FX.createLabel("Welcome to Code Math!", Color.BLUEVIOLET, 80);
		
		//create student login button
		Button studentLogin = FX.createButton("Student →", Color.WHITE, 30, Color.LAWNGREEN);
		studentLogin.setOnMouseClicked(event -> mainScene.setRoot(topicsScene));
		
		//create teacher login button 
		Button teacherLogin = FX.createButton("Teacher →", Color.WHITE, 30, Color.CORNFLOWERBLUE);
		teacherLogin.setOnMouseClicked(event -> mainScene.setRoot(createTeacherScene()));
		
		//create how to button
		Button howTo = FX.createButton("How To", Color.WHITE, 30, Color.PURPLE);
		howTo.setOnMouseClicked(event -> mainScene.setRoot(howToScene));
		
		//create root vbox
		VBox root = new VBox(title, studentLogin, teacherLogin, howTo);
		
		//set margins
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setMargin(title, new Insets(30, 0, 20, 0));
		root.setMargin(studentLogin, new Insets(20, 0, 20, 0));
		root.setMargin(teacherLogin, new Insets(20, 0, 20, 0));
		root.setMargin(howTo, new Insets(20, 0, 20, 0));
		
		//create scene and return
		return root; //screenWidth, screenHeight);
		
	}//end createStartScene
	
	/**
	 * Creates the topics scene which displays a title and the list of topics. The topics list is scrollable.
	 * @return topics scene.
	 * @throws IOException 
	 */
	public static Pane createTopicScene() {
		
		//init the problemSets array
		try {
			initTables();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create title label
		Label title = FX.createLabel("Math Topics", Color.BLUE, 80);
		
		//create vbox to store topics
		VBox topicsList = new VBox();
		topicsList.setAlignment(Pos.BASELINE_CENTER);
		
		//iterate over topics array list
		for(int i = 0; i < problemSets.size(); i++) {
			
			//get reference to the problem set object
			ProblemSet problemSet = problemSets.get(i);
			
			//make a topic button that points to the topics respective problem set scene
			Button topicButton = FX.createButton(problemSet.getTopic(), Color.WHITE, 30, Color.CORNFLOWERBLUE);
			topicButton.setOnMouseClicked(event -> mainScene.setRoot(problemSet.generateScene()));
			
			//set button pref width
			topicButton.setPrefWidth(500);
			
			//add button to vbox
			topicsList.getChildren().add(topicButton);
			
			//set button margins
			topicsList.setMargin(topicButton, new Insets(20, 0, 20, 0));
			
		}//end for
		
		//create a scroll pane and wrap list vbox in it
		ScrollPane scrollingList = new ScrollPane(topicsList);
		scrollingList.setPrefHeight(screenHeight/2.0);
		scrollingList.setFitToWidth(true);
		
		//create back button
		Button backBtn = FX.createButton("Back", Color.WHITE, 30, Color.CHARTREUSE);
		backBtn.setOnMouseClicked(event -> mainScene.setRoot(startScene));
		
		//create vbox to store the topics list vbox and title (add margins for that too)
		VBox root = new VBox(title, scrollingList, backBtn);
		root.setAlignment(Pos.CENTER);
		root.setMargin(title, new Insets(20, 0, 50, 0));
		root.setMargin(scrollingList, new Insets(20, 0, 20, 0));
		root.setMargin(backBtn, new Insets(20, 0, 0, 0));
		
		return root;
		
	}//end createTopicScene
	
	/**
	 * Creates teacher scene to enter password.
	 * @return teacher scene.
	 */
	public static Pane createTeacherScene() {
		
		//create title label
		Label title = FX.createLabel("Teacher Login", Color.BLACK, 80);
		
		//create error message label (transparent at first)
		Label errorMessage = FX.createLabel("Incorrect password! Please try again!", Color.TRANSPARENT, 30);
		
		//create password label
		Label passLabel = FX.createLabel("Please enter admin password:", Color.BLACK, 30);
		
		//create password field and create actual password
		PasswordField passwordBox = new PasswordField();
		String password = "j";
		
		//create button to enter password
		Button enterBtn = FX.createButton("Enter", Color.BLACK, 30, Color.LIGHTBLUE);
		enterBtn.setOnMouseClicked(event -> {
			
			//if password is correct, proceed, else show refresh/show error message
			if(password.equals(passwordBox.getText())) {
				mainScene.setRoot(modificationScene);
			}
			else {
				errorMessage.setTextFill(Color.RED);
			}//end if
			
		});//end setOnMouseClickedEvent
		
		//create hbox to add password label, field, and button to
		HBox passRow = new HBox(passLabel, passwordBox, enterBtn);
		passRow.setAlignment(Pos.CENTER);
		passRow.setMargin(passLabel, new Insets(0, 20, 0, 0));
		passRow.setMargin(passwordBox, new Insets(0, 20, 0, 20));
		passRow.setMargin(enterBtn, new Insets(0, 0, 0, 20));
		
		//create back button
		Button backBtn = FX.createButton("Back", Color.WHITE, 30, Color.BLUE);
		backBtn.setOnMouseClicked(event -> mainScene.setRoot(startScene));
		
		//add all controls/layouts above to vbox
		VBox root = new VBox(title, errorMessage, passRow, backBtn);
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setMargin(title, new Insets(50, 0, 0, 0));
		root.setMargin(errorMessage, new Insets(10, 0, 10, 0));
		root.setMargin(passRow, new Insets(20, 0, 20, 0));
		root.setMargin(backBtn, new Insets(20, 0, 0, 0));
		
		return root;
		
	}//end createTeacherScene
	
}//end class
