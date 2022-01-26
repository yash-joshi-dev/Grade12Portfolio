package grade12_final;

import grade12_final.CodeBlockClasses.CodeBlock;
import grade12_final.CodeBlockClasses.OutputBlock;
import grade12_final.CodeBlockClasses.VarReassign;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Problem {
	
	static private int titleBarHeight = 75;
	static public CodeBlock selectedPiece = null;
	
	//declare all private fields
	private String name;
	private String description;
	private String[] inNames;
	private String[] outNames;
	private double[][] sampleIns;
	private double[][] sampleOuts;
	private double[][] testIns;
	private double[][] testOuts;
	private int sampleNum;
	private int testNum;
	private boolean justSelected = false;
	private CodeList codeList = new CodeList();
	
	/**
	 * Constructor to init all private fields.
	 * @param name
	 * @param description
	 * @param inNames
	 * @param outNames
	 * @param sampleIns
	 * @param sampleOuts
	 * @param testIns
	 * @param testOuts
	 */
	public Problem(String name, String description, String[] inNames, String[] outNames, double[][] sampleIns, double[][] sampleOuts, double[][] testIns, double[][] testOuts) {
		
		this.name = name;
		this.description = description;
		this.inNames = inNames;
		this.outNames = outNames;
		this.sampleIns = sampleIns;
		this.sampleOuts = sampleOuts;
		this.sampleNum = sampleIns.length;
		this.testIns = testIns;
		this.testOuts = testOuts;
		this.testNum = testIns.length;
		
//		System.out.println(this.toString());
		
	}//end constructor
	
	/**
	 * Getter for name.
	 * @return name.
	 */
	public String getName() {
		return this.name;
	}
	
//	public String toString() {
//		
//		Gson gson = new Gson();
//		return gson.toJson(this);
//		
//	}
	
	/**
	 * Generate vbox that holds problem name, description, sample ins, and sample outs.
	 * @return vbox of the left side of the scene.
	 */
	private VBox generateDescriptionVBox() {
		
		//create title label
		Label title = FX.createLabel(name, Color.BLUE, 50);
		title.setMinHeight(titleBarHeight);
		
		//create description label
		Label probDescription = FX.createLabel(description, Color.BLACK, 20);
		//ScrollPane scrollDescription = new ScrollPane(probDescription);
		
		//create the description and example vbox; wrap in scrolling pane later
		VBox descripExVbx = new VBox(probDescription);
//		descripExVbx.setAlignment(Pos.BASELINE_CENTER);
		descripExVbx.setMargin(probDescription, new Insets(30, 0, 30, 0));
		
		//create example labels and inputs and outputs and add all to vbox
		for(int i = 0; i < this.sampleNum; i++) {
			
			//example label
			Label exampleLbl = FX.createLabel("Example" + Integer.toString(i + 1), Color.BLACK, 30);
			
			//input and output text boxes and add to text flow//can do later do basic for now
			String inOutText = "Input: ";
			for(double num: this.sampleIns[i]) {
				inOutText += Double.toString(num) + " ";
			}
			inOutText += "\nOutput: ";
			for(double num: this.sampleOuts[i]) {
				inOutText += Double.toString(num) + " ";
			}
			Label inOutLbl = FX.createLabel(inOutText, Color.BLACK, 20);
			inOutLbl.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), new Insets(-5.0))));
			
			//add both to vbox
			descripExVbx.getChildren().addAll(exampleLbl, inOutLbl);
			descripExVbx.setMargin(exampleLbl, new Insets(20, 0, 20, 0));
			descripExVbx.setMargin(inOutLbl, new Insets(20, 0, 20, 0));
			
		}//end for
		
		//wrap description and example vbox in scroll pane
		ScrollPane scrollDescripEx = new ScrollPane(descripExVbx);
		scrollDescripEx.setPrefHeight(Main.screenHeight);
		scrollDescripEx.setFitToWidth(true);
		
		//create root vbox
		VBox leftRoot = new VBox(title, scrollDescripEx);
		leftRoot.setPrefWidth(Main.screenWidth * 0.40);
		leftRoot.setAlignment(Pos.CENTER);
//		leftRoot.setMargin(leftRoot, new Insets(0, 0, 20, 0));
		leftRoot.setMargin(scrollDescripEx, new Insets(0, 0, 0, 0));
		
		return leftRoot;
	}//end generateDescriptionVBox
	
	/**
	 * Generates the right coding and codeblocks section of the problem scene
	 * @return hbox containing all controls and layouts of coding section of problem scene.
	 */
	private HBox generateCodeHBox() {
		
		double scrollHeights = 0.70;
		
		//create title label and help button and put into an hbox
		Label title = FX.createLabel("Build Code Here: ", Color.LIGHTGREEN, 25);
		Button helpBtn = FX.createButton("Help", Color.WHITE, 20, Color.ORANGE);
		
//		helpBtn.setOnMouseClicked(event -> stack something ontop with info and can scroll);
		Region spaceBetween = new Region();
		spaceBetween.setPrefWidth(1);
		HBox codeTitleHbx = new HBox(title, spaceBetween, helpBtn);
		codeTitleHbx.setMaxHeight(titleBarHeight);
		codeTitleHbx.setHgrow(spaceBetween, Priority.ALWAYS);
		codeTitleHbx.setMargin(title, new Insets(30,0,0,0));
		codeTitleHbx.setMargin(helpBtn, new Insets(30,30,0,0));
		
		//create coding pane
		Pane codingPane = new Pane(codeList);
		codingPane.setPrefHeight(Main.screenHeight);
		codingPane.setPrefWidth(Main.screenWidth * 0.43);
		codingPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		//wrap coding pane in scroll pane
		ScrollPane scrollCode = new ScrollPane(codingPane);
		scrollCode.setPrefHeight(Main.screenHeight * scrollHeights);
		scrollCode.setFitToWidth(true);
		
		//put title bar and coding scroll pane in vbox
		VBox codeVbx = new VBox(codeTitleHbx, scrollCode);
//		codeVbx.setAlignment(Pos.CENTER);
		
		//----------------------------Code blocks vbox creation
		
		//create the VBox that contains list of all blocks; wrap in scrolling pane later
		VBox logicList = new VBox(createLogicList());
		logicList.setFillWidth(false);
		VBox blockList = new VBox(logicList);
		blockList.setOnMouseClicked(event -> {
			
			if(justSelected) justSelected = false;
			else {
				
				if(selectedPiece != null) this.selectedPiece.switchSelect();
				this.selectedPiece = null;
				codeList.hidePlacers();
			}
			
		});
		blockList.setPrefWidth(Main.screenWidth * 0.17);
		blockList.setPrefHeight(Main.screenHeight);
		blockList.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		//create logic and math button tabs
		boolean[] logic = {true};
		Button logicBtn = FX.createButton("Logic", Color.BLACK, 20, Color.WHITE);
		Button varBtn = FX.createButton("Math", Color.BLACK, 20, Color.LIGHTGRAY);
		Background white = new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5.0), new Insets(-5.0)));
		Background grey = new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5.0), new Insets(-5.0)));
		logicBtn.setOnMouseClicked(event -> {
			if(!logic[0]) {
				logicBtn.setBackground(white);
				varBtn.setBackground(grey);
				blockList.getChildren().clear();
				blockList.getChildren().addAll(logicList);
				logic[0] = true;
			}
		});
		varBtn.setOnMouseClicked(event -> {
			if(logic[0]) {
				logicBtn.setBackground(grey);
				varBtn.setBackground(white);
				blockList.getChildren().clear();
				blockList.getChildren().addAll(createVarList());
				logic[0] = false;
			}
		});
		
		//put math and logic buttons in a hbox
		HBox tabs = new HBox(logicBtn, varBtn);
		tabs.setMinHeight(titleBarHeight);
		tabs.setMargin(logicBtn, new Insets(30,0,0,0));
		tabs.setMargin(varBtn, new Insets(30,0,0,10));
		
		//wrap block list in scroll pane
		ScrollPane scrollBlocks = new ScrollPane(blockList);
		scrollBlocks.setPrefWidth(Main.screenWidth * 0.17);
		scrollBlocks.setPrefHeight(Main.screenHeight * scrollHeights);
		
		//create root vbox for all code block controls/layouts
		VBox codeBlocksVbx = new VBox(tabs, scrollBlocks);
		
		//--------------create root of all code stuff
		HBox codeRoot = new HBox(codeVbx, codeBlocksVbx);
		return codeRoot;
		
	}//end generateCodeHBox
	
	/**
	 * Creates list of math blocks.
	 * @return
	 */
	private VBox createVarList() {
		// TODO Auto-generated method stub
		return null;// new VBox(new OutputBlock(new String[] {"s", "k", "j"}).getBlock());
		
	}

	/**
	 * Creates the list of logic blocks
	 * @return
	 */
	private VBox createLogicList() {
		
		//create vbox to store the list
		VBox blockList = new VBox();
		
		//assign initial variables for code and create array storing all initial objects for code blocks section
		CodeBlock.setInitVars(this.inNames);
		CodeBlock[] initBlocks = {new OutputBlock(), new VarReassign()};
		
		//iterate through the initBlocks
		for(CodeBlock block: initBlocks) {
			
			//add the graphical block to the vbox and set margins
			Pane gblock = block.getBlock();
			blockList.getChildren().add(gblock);
			blockList.setMargin(gblock, new Insets(20, 0, 20, 20));
			
			//set what happens when mouse clicks this
			gblock.setOnMouseClicked(event -> {

				//if selected is not null || not equal to selected
				if(selectedPiece == null || !selectedPiece.equals(block)) {
					
					//switch colors of selected and past selected pieces if selected isn't null
					if(selectedPiece != null) selectedPiece.switchSelect();
					block.switchSelect();
					selectedPiece = block;
					codeList.showPlacers();
					
				}
				justSelected = true;
				
			});
			
		}
		
		return blockList;
	}
	
	/**
	 * Creates testing panel and combines it with the code panel of the problem scene.
	 * @return vbox containing all controls and layouts for right side of problem scene.
	 */
	private VBox generateRightSide() {
		
		//-------------------create testing panel
		
		
		//create header label, verdict label, and output label
		Label header = FX.createLabel("Code Output:", Color.BLACK, 30);
		Label verdict = new Label();
		verdict.setFont(new Font(30));
		Label output = new Label();
		output.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5.0), new Insets(-5.0))));
		
		//create space between
		Region spaceBetween = new Region();
		spaceBetween.setPrefWidth(1);
		
		//create run button
		Button runBtn = FX.createButton("Run Code", Color.WHITE, 20, Color.RED);
		runBtn.setOnMouseClicked(event -> {
			
			//first get all the code as a string create variable to store code output
			String code = codeList.getCode();
			String codeOut = "";
			
			//get the fullOutput of the code file (output and error string (if error generated))
			Object[] fullOutput = CodeFile.testCode(code, inNames, sampleIns, sampleOuts.length);
			String errorMessage = (String) fullOutput[1];
			
			//if there is not an error message, set output text to the output generated and determine if valid or not
			int passed = 1;
			
			if(errorMessage.equals("")) {
				double[][] codeOutput = (double[][]) fullOutput[0];
				for(int i = 0; i < codeOutput.length; i++) {
					codeOut += "Test " + Integer.toString(i) + ":";
					for(int j = 0; j < codeOutput[i].length; j++) {
						codeOut += " " + Double.toString(codeOutput[i][j]);
					}
				}
				//passed = matchesOutput(sampleIns, codeOutput);
			}
			else {
				System.out.println("noooooooo");
				codeOut = errorMessage;
				passed = 3;
			}
			
			if(passed == 1) {
				verdict.setText("Accepted!");
				verdict.setTextFill(Color.FORESTGREEN);
			}
			else if(passed == 2) {
				verdict.setText("Wrong Answer!!");
				verdict.setTextFill(Color.RED);
			}
			else {
				verdict.setText("Error Alert!!!");
				verdict.setTextFill(Color.RED);
			}
			
			output.setText(codeOut);
			
		});//end run button mouse clicked event
		
		//create submit button
		Button submitBtn = FX.createButton("Submit", Color.WHITE, 20, Color.PURPLE);
		
		//create testing panel bar
		HBox testingBar = new HBox(header, spaceBetween, runBtn, submitBtn);
		testingBar.setHgrow(spaceBetween, Priority.ALWAYS);
		testingBar.setMargin(runBtn, new Insets(10, 15, 0, 0));
		testingBar.setMargin(submitBtn, new Insets(10, 10, 0, 0));
		
		//create vbox to put full test panel in
		VBox testRoot = new VBox(testingBar, verdict, output);
		
		//create full right side root of the entire problem scene
		VBox rightRoot = new VBox(generateCodeHBox(), testRoot);
		return rightRoot;
		
	}//end generateRightSide

	private boolean matchesOutput(int[][] sampleIns2, int[][] codeOutput) {
		// TODO Auto-generated method stub
		return false;
	}

	private int[][] runAgainstSamples() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Generates the problem scene. This includes the title label, description label, sample in section, sample outs section, code section,
	 * code blocks section, and the run and submit code section.
	 * @return problem scene.
	 */
	public Pane generateScene() {
		
		//create root hbox
		HBox root = new HBox(generateDescriptionVBox(), generateRightSide());
		return root;
	}

	
}
