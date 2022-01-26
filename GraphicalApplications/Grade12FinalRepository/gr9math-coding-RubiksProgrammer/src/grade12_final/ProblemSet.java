package grade12_final;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProblemSet {
	
	//search box is same for everything
	//need title, search box, scrollable problems
	
	//declare all private fields
	private String topic;
	private ArrayList<Problem> problems = new ArrayList<>();
	
	/**
	 * Empty constructor.
	 */
	public ProblemSet() {}
	
	/**
	 * Constructor to init private fields.
	 */
	public ProblemSet(String topic, ArrayList<Problem> problems) {
		
		this.topic = topic;
		this.problems = problems;
		
	}//end constructor
	
	/**
	 * Getter for topic.
	 * @return topic
	 */
	public String getTopic() {
		return this.topic;
	}
	
	/**
	 * Setter for topic.
	 * @param topic
	 */
	public void getTopic(String topic) {
		this.topic = topic;
	}
	
	/**
	 * Getter for problems
	 * @return array list containing all problem objects.
	 */
	public ArrayList<Problem> getProblems() {
		return this.problems;
	}
	
	/**
	 * Setter for problems.
	 * @param problems an array list containing all problem objects.
	 */
	public void setProblems(ArrayList<Problem> problems) {
		this.problems = problems;
	}
	
	/**
	 * Generates the scene to display the entire problem set for the topic.
	 */
	public Pane generateScene() {
		
		//create topic title
		Label title = FX.createLabel(this.topic, Color.BLACK, 80);
		
		//create problem list vbox
		VBox probList = new VBox();
		probList.setAlignment(Pos.BASELINE_CENTER);
		
		//create search bar label and text field
		Label searchLbl = FX.createLabel("Search by keyword:", Color.BLACK, 30);
		TextField searchField = new TextField();
		
		//create search button
		Button searchBtn = FX.createButton("Enter", Color.WHITE, 20, Color.BLUE);
		searchBtn.setOnMouseClicked(event -> {
			
			//clear topic list first
			probList.getChildren().clear();
			
			//create boolean flag to keep track if anything was added to topicList; also get keyword from search field
			boolean added = false;
			String keyword = searchField.getText().toLowerCase();
			
			//iterate through all problems, checking if their name contains the keyword; if it does display them only
			for(int i = 0; i < this.problems.size(); i++) {
				
				//store problem
				Problem problem = problems.get(i);
				
				if(problem.getName().toLowerCase().indexOf(keyword) != -1) {
					
					//turn on flag
					added = true;
					
					//create button with name of problem pointing to the problem scene
					Button probBtn = FX.createButton(problem.getName(), Color.WHITE, 30, Color.CORNFLOWERBLUE);
					probBtn.setMaxWidth(600);
					probBtn.setMinWidth(600);
					probBtn.setOnMouseClicked(e -> Main.mainScene.setRoot(problem.generateScene()));
					
					//add to problist
					probList.getChildren().add(probBtn);
					
				}//end if
				
			}//end for
			
			//if nothing was added, add error message
			if(!added) {
				
				Label error = FX.createLabel("Sorry, no problems matched your search! Please try again with a different keyword, or press "
											+ "enter again to view all the problems", Color.BLACK, 30);
				error.setWrapText(true);
				probList.getChildren().add(error);
				
			}//end if
			
		});//end mouse clicked event
		
		//create hbox for search label, field, and button
		HBox searchRow = new HBox(searchLbl, searchField, searchBtn);
		searchRow.setAlignment(Pos.CENTER);
		searchRow.setMargin(searchLbl, new Insets(0, 20, 0, 0));
		searchRow.setMargin(searchField, new Insets(0, 20, 0, 20));
		searchRow.setMargin(searchBtn, new Insets(0, 0, 0, 20));
		
		//add all the problems to the probList
		for(int i = 0; i < problems.size(); i++) {
			
			//store problem
			Problem problem = problems.get(i);
			
			//create button with name of problem pointing to the problem scene
			Button probBtn = FX.createButton(problem.getName(), Color.WHITE, 30, Color.CORNFLOWERBLUE);
			probBtn.setMaxWidth(600);
			probBtn.setMinWidth(600);
			probBtn.setOnMouseClicked(event -> Main.mainScene.setRoot(problem.generateScene()));
			
			//add to problist
			probList.getChildren().add(probBtn);
			
		}//end for
		
		//wrap prob list in scroll pane
		ScrollPane scrollableList = new ScrollPane(probList);
		scrollableList.setFitToWidth(true);
		scrollableList.setPrefHeight(Main.screenHeight/2.0);
		
		//create back button
		Button backBtn = FX.createButton("Back", Color.WHITE, 30, Color.AQUA);
		backBtn.setOnMouseClicked(event -> Main.mainScene.setRoot(Main.topicsScene));
		
		//create root vbox and add and format all above controls to it
		VBox root = new VBox(title, searchRow, scrollableList, backBtn);
		root.setAlignment(Pos.CENTER);
		root.setMargin(title, new Insets(50, 0, 20, 0));
		root.setMargin(searchRow, new Insets(20, 0, 10, 0));
		root.setMargin(scrollableList, new Insets(20, 0, 20, 0));
		root.setMargin(backBtn, new Insets(20, 0, 0, 0));
		
		return root;
		
	}//end generateScene

}//end class
