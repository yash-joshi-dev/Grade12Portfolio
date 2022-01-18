/*
 * Name: Yash Joshi
 * Teacher: Mrs. McCafferey
 * Course: ICS4U
 * Description: This program is a graphical checker's game, in which users can navigate through a GUI to look at how to play the game,
 * 				actually the play the game of Checkers, and exit the game.
 */

package checkers_game;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import reuseableobjects.CheckersPiece;
import reuseableobjects.GameBoard;

public class CheckersGame extends Application {
	
	//home scene and how to play panes
	static Pane homeScene = createHomePane();
	static Pane howToScene = createHowToPane();
	
	//create the scene and initialize the stage
	static Scene scene = new Scene(homeScene, 900, 900);
	static Stage stage;
	
	//main method for the program
	public static void main(String[] args) {
		launch(args);
	}
	
	//start method for the JavaFX part of the program
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//set stage to the inputted primaryStage
		stage = primaryStage;
		
		//set title and display home scene
		stage.setTitle("Checkers Game");
		stage.setScene(scene);
		stage.show();

	}
	
	/**
	 * Allows the user to easily create and set many properties for a JavaFX label at once.
	 * @param text the text for the label.
	 * @param xPos the x position of the label.
	 * @param yPos the y position of the label.
	 * @param font the color of the font of the label.
	 * @param fontSize the size of the font of the label.
	 * @return the created label.
	 */
	public static Label createLabel(String text, double xPos, double yPos, Color font, int fontSize) {
		Label lbl = new Label(text);
		lbl.setLayoutX(xPos);
		lbl.setLayoutY(yPos);
		lbl.setTextFill(font);
		lbl.setFont(new Font(fontSize));
		return lbl;
	}//end createLabel
	
	/**
	 * Allows the user to easily create and set many properties for a JavaFX label at once.
	 * @param text the text for the label.
	 * @param font the color of the font of the label.
	 * @param fontSize the size of the font of the label.
	 * @return the created label.
	 */
	public static Label createLabel(String text, Color font, int fontSize) {
		Label lbl = new Label(text);
		lbl.setTextFill(font);
		lbl.setFont(new Font(fontSize));
		return lbl;
	}
	
	/**
	 * Allows the user to easily create and set many properties for a JavaFX button at once.
	 * @param text the text for the button.
	 * @param font the color of the font of the button.
	 * @param fontSize the size of the font of the button.
	 * @return the created button.
	 */
	public static Button createButton(String text, Color font, int fontSize) {
		Button btn = new Button(text);
		btn.setTextFill(font);
		btn.setFont(new Font(fontSize));
		return btn;
	}
	
	/**
	 * Creates the home pane for the game, which consists of the main title, the play button, how to button, and exit button.
	 * @return the created home pane.
	 */
	public static VBox createHomePane() {
		
		//create title label
		Label lblTitle = createLabel("Welcome To Checkers!!", Color.BLACK, 80);
		lblTitle.setWrapText(true);
		
		//create play button
		Button btnPlay = new Button("Play");
		btnPlay.setOnAction(e -> scene.setRoot(createGamePane()));
		btnPlay.setFont(new Font(40));
		btnPlay.setPrefHeight(150);
		btnPlay.setPrefWidth(500);
		
		//create how to button
		Button btnHowTo = new Button("How To");
		btnHowTo.setFont(new Font(40));
		btnHowTo.setPrefHeight(150);
		btnHowTo.setPrefWidth(500);
		btnHowTo.setOnAction(e -> scene.setRoot(howToScene));
		
		//create exit button
		Button btnExit = new Button("Exit");
		btnExit.setFont(new Font(40));
		btnExit.setPrefHeight(150);
		btnExit.setPrefWidth(500);
		btnExit.setOnAction(e -> stage.close());
		
		//add the title and buttons to a vbox
		VBox vbxHome = new VBox(lblTitle, btnPlay, btnHowTo, btnExit);
		vbxHome.setMargin(lblTitle, new Insets(40, 0, 50, 20));
		vbxHome.setMargin(btnPlay, new Insets(40, 0, 50, 200));
		vbxHome.setMargin(btnHowTo, new Insets(40, 0, 50, 200));
		vbxHome.setMargin(btnExit, new Insets(40, 0, 50, 200));
		vbxHome.setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));
		
		return vbxHome;
		
	}//end createHomePane()
	
	/**
	 * Creates the how to pane for the game, which consists of just a how to title, a label with all the rules of the game, and
	 * a back to main menu button.
	 * @return the created how to pane.
	 */
	public static VBox createHowToPane() {
		
		//create title
		//create title label
		Label lblTitle = createLabel("Rules To Play", Color.BLACK, 80);
		lblTitle.setWrapText(true);
		
		//create instructions label
		Label lblInstructions = createLabel("- General Play: White player moves first. On a player's turn, they can select any one of their pieces to move. "
											+ "Once a player has completed their move, their turn is over and it's the next player's turn.\n\n"
											+ "- To Move: Once a piece is selected to move, the green squares that appear will show where they player "
											+ "can move that piece. A player is generally allowed to a move a piece diagonally one step right or left, towards "
											+ "the opponent's side. In the case a piece of the opponent is diagonally 'in front' of the player's piece and there "
											+ "is an empty spot in the same diagonal behind the opponent's piece, the player can jump the opponents piece and "
											+ "remove it from the board. If a player can make multiple jumps in a turn, they can choose to do that or they can "
											+ "choose not to by clicking the piece they are moving again (it will be highlighted slightly green in that case).\n\n"
											+ "- Kinging: If a player's piece reaches the other side, it becomes a 'king' (denoted by a golden ring on it), "
											+ "and is then allowed to move and jump backwards.\n\n"
											+ "- To Win: The first player to jump all the other player's pieces wins the game.", Color.BLACK, 20);
		lblInstructions.setWrapText(true);
		
		//create back button
		Button btnBack = new Button("Back to Home");
		btnBack.setFont(new Font(40));
		btnBack.setPrefHeight(150);
		btnBack.setPrefWidth(500);
		btnBack.setOnAction(e -> scene.setRoot(homeScene));
		
		//create vbox to store all controls above
		VBox vbxHowTo = new VBox(lblTitle, lblInstructions, btnBack);
		vbxHowTo.setMargin(lblTitle, new Insets(30, 0, 10, 200));
		vbxHowTo.setMargin(lblInstructions, new Insets(20, 0, 20, 20));
		vbxHowTo.setMargin(btnBack, new Insets(30, 0, 50, 200));
		
		return vbxHowTo;
		
	}//end createHowToPane method
	
	//create all the static variables that will be needed for all the method below:
	//create var to store which player is moving
	static int playerNum = 1;
	
	//create var to store whether the player is in a double move or not
	static boolean inMove = false;
	
	//create array to store points of both players
	static int[] points = new int[2];
	
	//create an array list to store all the coordinates of all the possible moves the current selected piece can make, and
	//another array list to store all the highlighted rectangles at those possible spots
	static ArrayList<int[]> possibleMoves = new ArrayList<int[]> ();
	static ArrayList<Rectangle> possibleCells = new ArrayList<Rectangle> ();
	
	//create labels to show the number of checkers each player has captured
	static Label player1Label = createLabel("Player 1 Pieces Captured: 0", Color.BLACK, 40);
	static Label player2Label = createLabel("Player 2 Pieces Captured: 0", Color.BLACK, 40);
	
	//create backgrounds and turn labels that change to show which player is currently playing
	static Background normalBackground = new Background(new BackgroundFill(Color.LIGHTBLUE, null, null));
	static Background turnBackground = new Background(new BackgroundFill(Color.AQUAMARINE, null, null));
	static Label turn1lbl = createLabel(" <-- Current Player", Color.BLACK, 30);
	static Label turn2lbl = createLabel(" <-- Current Player", Color.TRANSPARENT, 30);
	
	//combine the player and turn labels in two hboxes
	static HBox all1Labels = new HBox(player1Label, turn1lbl);
	static HBox all2Labels = new HBox(player2Label, turn2lbl);
	
	/**
	 * Resets all the game variables to the state they should be at the beginning of each game.
	 */
	public static void resetGameVars() {
		
		playerNum = 1;
		inMove = false;
		points = new int[2];
		
		//only uncomment below code to end game faster
//		points[0] = 10;
//		points[1] = 10;
		
		possibleMoves.clear();;
		possibleCells.clear();;
		player1Label.setText("Player 1 Pieces Captured: 0");
		player2Label.setText("Player 2 Pieces Captured: 0");
		all1Labels.setBackground(turnBackground);
		all2Labels.setBackground(normalBackground);
		turn1lbl.setTextFill(Color.BLACK);
		turn2lbl.setTextFill(Color.TRANSPARENT);
		
	}//end resetGameVars
	
	/**
	 * Increments the current players points by one and also updates that corresponding players checkers captured label.
	 * @param playerType the type of the player that just captured a piece.
	 */
	public static void updatePoints(int playerType) {
		
		int pointCount = ++points[playerType-1];
		Label label = (playerType == 1) ? player1Label : player2Label;
		label.setText("Player " + playerType + " Pieces Captured: " + pointCount);
		
	}//end method
	
	/**
	 * Switches to the next player's turn by switching the playerNum, and then the backgrounds of both players (the player with the
	 * turn gets the aqua background, while the other gets the light blue background) and the transparency of the turn label (the
	 * player with the turn gets their turn label turned black while the other player gets their turn label turned invisible).
	 * @param opp the player type to switch the turn to.
	 */
	public static void switchPlayers(int opp) {
		
		playerNum = opp;
		
		if(opp == 1) {
			all1Labels.setBackground(turnBackground);
			all2Labels.setBackground(normalBackground);
			turn1lbl.setTextFill(Color.BLACK);
			turn2lbl.setTextFill(Color.TRANSPARENT);
		}
		else {
			all1Labels.setBackground(normalBackground);
			all2Labels.setBackground(turnBackground);
			turn1lbl.setTextFill(Color.TRANSPARENT);
			turn2lbl.setTextFill(Color.BLACK);
		}//end if
		
	}//end switchPlayers
	
	/**
	 * Creates the win pane, which consists of a vbox containing a win label, replay button, and back to main menu button, stacked
	 * on top of a black tinted rectangle, which acts as an overlay on top of the board, disabling the player from clicking the
	 * checker's pieces anymore.
	 * @param playerType the type of the player that won the game.
	 * @return a stack pane of the win scene (with the vbox stacked on top of the overlay).
	 */
	public static Pane createWinPane(int playerType) {
		
		//create label to show who won
		Label winLabel = createLabel("Player " + playerType + " has WON!!!", Color.AQUA, 80);
		
		//create buttons to play another game or go back main menu
		Button retryBtn = createButton("Play Again", Color.BLACK, 40);
		retryBtn.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, new CornerRadii(5.0), new Insets(-5.0))));
		retryBtn.setOnMouseClicked(event -> scene.setRoot(createGamePane()));
		
		Button backBtn = createButton("Main Menu", Color.BLACK, 40);
		backBtn.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, new CornerRadii(5.0), new Insets(-5.0))));
		backBtn.setOnMouseClicked(event -> scene.setRoot(homeScene));
		
		
		//create overlay to prevent further clicking in background
		Rectangle overlay = new Rectangle(scene.getWidth(), scene.getHeight(), Color.BLACK);
		overlay.setOpacity(0.6);
		
		//create the background vbox to store everything
		VBox background = new VBox(winLabel, retryBtn, backBtn);
		background.setAlignment(Pos.CENTER);
		background.setLayoutX(scene.getWidth()-350);
		background.setLayoutY(scene.getHeight()-250);
		background.setMaxWidth(750);
		background.setMaxHeight(500);
		background.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, new CornerRadii(5.0), new Insets(-5.0))));
		
		//insets to make vbox controls look better
		background.setMargin(winLabel, new Insets(0, 0, 20, 0));
		background.setMargin(retryBtn, new Insets(20, 0, 20, 0));
		background.setMargin(backBtn, new Insets(20, 0, 0, 0));
		
		//create the stack pane to return
		StackPane pane = new StackPane(overlay, background);
		
		return pane;
		
	}//end createWinPane method
	
	/**
	 * Creates the game pane, which consists of the 8x8 checkered game board, all 24 checkers pieces, and player labels to indicate
	 * how many pieces each player has captured and which player's turn it is. This also has all of the game logic which is as
	 * follows: Whenever a valid checkers piece is selected, all the spots where the checkers piece can move to are displayed in 
	 * green. Once the user selects a green square to move to, if a double move can be made the displayChoices method is recursively
	 * called to account for that; otherwise, it just switches the player, adds to the player's captured count if an opponents piece 
	 * was deleted (which gets removed from the game board), and kings the piece if necessary. Once a player reaches 12 points, the
	 * win scene is generated and displayed on top of the board, with all of its logic.
	 * @return the created game pane with all of the game components and logic.
	 */
	public static Pane createGamePane() {
		
		//create the real base stackpane to return
		StackPane baseRoot = new StackPane();
		
		//reset all the static game vars
		resetGameVars();
		
		//create instance of gameboard object and get its display pane
		GameBoard gameBoard = new GameBoard(8, 8, 720, 720, 90, 0, Color.RED, Color.BLACK, false, false);
		Pane board = gameBoard.getBoardToDisplay();
		
		//create array to initialize all checkers pieces (1 - 12 are white and forward moving, 13-24 are black and backwards moving)
		int[][] initPos = {{0, 21, 0, 22, 0, 23, 0, 24},
								 {17, 0, 18, 0, 19, 0, 20, 0},
								 {0, 13, 0, 14, 0, 15, 0, 16},
								 {0, 0, 0, 0, 0, 0, 0, 0},
								 {0, 0, 0, 0, 0, 0, 0, 0},
								 {9, 0, 10, 0, 11, 0, 12, 0},
								 {0, 5, 0, 6, 0, 7, 0, 8},
								 {1, 0, 2, 0, 3, 0, 4, 0}};
		
		//create array to store all checker pieces
		CheckersPiece[] pieces = new CheckersPiece[24];

		//use for nested for loop to create all pieces
		for(int i = 0; i < 8; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				//set type if there is a piece there
				if(initPos[i][j] == 0) continue;
				int type = initPos[i][j] < 13 ? 1 : 2;

				CheckersPiece piece = new CheckersPiece(type, i, j, gameBoard.getCellHeight(), gameBoard.getCellWidth(), gameBoard.getXPos(), gameBoard.getYPos());
				pieces[initPos[i][j] - 1] = piece;
				Circle checker = piece.getPiece();
				board.getChildren().add(checker);
				
				//if mouse is clicked
				checker.setOnMouseClicked(event -> {
					
					//if this is the current player's piece, then show choices
					if(piece.getType() == playerNum && !inMove) {
						
						//turn off all highlighted pieces
						if(possibleCells.size() > 0) {
							board.getChildren().removeAll(possibleCells);
						}
						
						//get the possible moves
						possibleMoves = piece.getMoves();
						
						//if there are moves, then highlight them and give them their logic
						if(possibleMoves.size() > 0) {
							
							//clear the possible cells array
							possibleCells.clear();
							
							for(int[] coordinates: possibleMoves) {

								//declare vars to store row and col
								int row = coordinates[0];
								int col  = coordinates[1];
								
								//create the rectangle for the spot
								Rectangle movableSpot = new Rectangle(col * gameBoard.getCellWidth() + gameBoard.getXPos(), 
										row * gameBoard.getCellHeight() + gameBoard.getYPos(), gameBoard.getCellHeight(), gameBoard.getCellWidth());
								movableSpot.setFill(Color.GREEN);
								
								//add rectangle to possible cells and the board itself
								possibleCells.add(movableSpot);
								board.getChildren().add(movableSpot);
								
								//add movable spot logic
								movableSpot.setOnMouseClicked(e -> {
									
									//create boolean flag to see if piece was deleted
									boolean deleted = false;
									
									//if a piece was jumped, delete the jumped piece
									if(Math.abs(piece.getRow() - row) == 2) {
										
										//turn on deleted flag
										deleted = true;
										
										//store the piece to delete and delete it internally
										CheckersPiece pieceToDelete = pieces[initPos[(piece.getRow() + row)/2][(piece.getColumn() + col)/2]-1];
										pieceToDelete.deletePiece();
										
										//remove king ring from board if the piece was a king, and then remove itself
										if(pieceToDelete.isAKing()) board.getChildren().remove(pieceToDelete.getKingRing());
										board.getChildren().remove(pieceToDelete.getPiece());
										
										//remove the piece from initPos and increment other persons point counter
										initPos[(piece.getRow() + row)/2][(piece.getColumn() + col)/2] = 0;
										updatePoints(piece.getType());
										
										//if anyone has won, display win scene
										if(points[piece.getType()-1] == 12) baseRoot.getChildren().add(createWinPane(piece.getType()));
										
									}
									 
									//move piece to spot
									int[] lastSpot = {piece.getRow(), piece.getColumn()};
									int tmp = initPos[piece.getRow()][piece.getColumn()];
									initPos[piece.getRow()][piece.getColumn()] = 0;
									piece.movePiece(row, col);
									initPos[piece.getRow()][piece.getColumn()] = tmp;
									
									//if piece wasn't a king and it reached the end, king it
									int end = piece.getType() == 1 ? 0 : 7;
									if(!piece.isAKing() && row == end) {
										piece.kingPiece();
										board.getChildren().add(piece.getKingRing());
									}
									
									//if piece can jump again, then give options to jump
									ArrayList<int[]> doubleJumpSpots = piece.jumpMoves(lastSpot);
									if(deleted && doubleJumpSpots.size() > 0) {
										
										displayChoices(doubleJumpSpots, piece, pieces, gameBoard, board, initPos, baseRoot);
										
									}
									else {
										
										//delete all highlighted pieces and switch player
										board.getChildren().removeAll(possibleCells);
										switchPlayers(piece.getOpp());
										
									}//end if
									
								});//end mouse clicked event handler for the movable spot
								
							}//end for
							
						}
						else { 
							System.out.println("There are no possible moves with this piece.");
						}//end if
						
					}
					else {
						System.out.println("You cannot choose that piece.");
					}//end if
					
				});//end outer mouse clicked event handler for the checker's piece
				
			}//end if
			
		}//end if
		
		//add insets to the two hboxes containing the player labels
		all1Labels.setMargin(player1Label, new Insets(10, 0, 10, 50));
		all1Labels.setMargin(turn1lbl, new Insets(20, 0, 10, 0));
		
		all2Labels.setMargin(player2Label, new Insets(10, 0, 10, 50));
		all2Labels.setMargin(turn2lbl, new Insets(20, 0, 10, 0));
		
		//create new vbox to store players points and gameboard pane
		VBox gameRoot = new VBox(all2Labels, board, all1Labels);
		gameRoot.setMargin(board, new Insets(15, 0, 15, 0));
		
		//add game root to base root and return base root
		baseRoot.getChildren().add(gameRoot);
		return baseRoot;
		
	}//end createGamePane
	
	/**
	 * Highlights all the inputted possible move spots and locks the player into a move (sets the in move flag to true) where they
	 * cannot select any other pieces to move. Also highlights the spot at which the current piece is, in case the the player wants
	 * to keep the piece in the same spot. When any of the other spots are clicked, the piece is moved, pieces are deleted if
	 * necessary, and the piece is kinged if necessary; then, if another double jump can be made, this method is recursively called
	 * again. If the player chooses to keep the piece in the same spot, simply the highlighted pieces are stopped being highlighted
	 * and the player number is switched.
	 * 
	 * @param possibleMoves an array list of coordinates of all possible spots the selected piece can move to.
	 * @param piece the checkers piece that is in the double jump.
	 * @param pieces and array of checkers piece objects that can be accessed to delete if necessary.
	 * @param gameBoard the current game board object.
	 * @param board the pane that represents the game board.
	 * @param initPos the 2d array that contains where all the pieces are and their indices in the pieces array.
	 * @param baseRoot the underlying stack pane of the entire game scene.
	 */
	public static void displayChoices(ArrayList<int[]> possibleMoves, CheckersPiece piece, CheckersPiece[] pieces, GameBoard gameBoard, Pane board, int[][] initPos, StackPane baseRoot) {
		
		//turn on inMove
		inMove = true;
		
		//turn off all highlighted pieces
		if(possibleCells.size() > 0) {
			board.getChildren().removeAll(possibleCells);
		}
		
		//clear all array of all previous cells
		possibleCells.clear();
		
		//for each coordinate in possible moves, highlight that cell
		for(int[] coordinates: possibleMoves) {
			
			//declare vars to store row and col
			int row = coordinates[0];
			int col  = coordinates[1];
			
			//create the rectangle for the spot
			Rectangle movableSpot = new Rectangle(col * gameBoard.getCellWidth() + gameBoard.getXPos(), 
					row * gameBoard.getCellHeight() + gameBoard.getYPos(), gameBoard.getCellHeight(), gameBoard.getCellWidth());
			movableSpot.setFill(Color.GREEN);
			
			//add rectangle to possible cells and the board itself
			possibleCells.add(movableSpot);
			board.getChildren().add(movableSpot);
			
			//add movable spot logic
			movableSpot.setOnMouseClicked(e -> {
				
				//if a piece was jumped, delete the jumped piece
				if(Math.abs(piece.getRow() - row) == 2) {
					
					//store the piece to delete and delete it internally
					CheckersPiece pieceToDelete = pieces[initPos[(piece.getRow() + row)/2][(piece.getColumn() + col)/2]-1];
					pieceToDelete.deletePiece();
					
					//remove king ring from board if the piece was a king, and then remove itself
					if(pieceToDelete.isAKing()) board.getChildren().remove(pieceToDelete.getKingRing());
					board.getChildren().remove(pieceToDelete.getPiece());
					
					//remove the piece from initPos and increment other persons point counter
					initPos[(piece.getRow() + row)/2][(piece.getColumn() + col)/2] = 0;
					updatePoints(piece.getType());
					
					//if anyone has won, display win scene
					if(points[piece.getType()-1] == 12) baseRoot.getChildren().add(createWinPane(piece.getType()));
					
				}//end if
				 
				//move piece to selected spot; also remember the previous spot
				int[] prevSpot = {piece.getRow(), piece.getColumn()};
				int tmp = initPos[piece.getRow()][piece.getColumn()];
				initPos[piece.getRow()][piece.getColumn()] = 0;
				piece.movePiece(row, col);
				initPos[piece.getRow()][piece.getColumn()] = tmp;
				
				//if piece wasn't a king and it reached the end, king it
				int end = piece.getType() == 1 ? 0 : 7;
				if(!piece.isAKing() && row == end) {
					piece.kingPiece();
					board.getChildren().add(piece.getKingRing());
				}
				
				//if piece can jump again, then give options to jump
				ArrayList<int[]> doubleJumpSpots = piece.jumpMoves(prevSpot);
				if(doubleJumpSpots.size() > 0) {
					displayChoices(doubleJumpSpots, piece, pieces, gameBoard, board, initPos, baseRoot);
				}
				else {
					
					//delete all highlighted pieces and switch player, and turn off inMove
					board.getChildren().removeAll(possibleCells);
					switchPlayers(piece.getOpp());
					inMove = false;
					
				}//end if
				return;
				
			});//end event handler for mouse clicked

		}//end for
		
		//add another an overlay on top of the current piece (slightly transparent green cell), which if clicked, allows
		//the player to keep the piece at the same spot
		
		//create the rectangle for the same spot
		Rectangle sameSpot = new Rectangle(piece.getColumn() * gameBoard.getCellWidth() + gameBoard.getXPos(), 
				piece.getRow() * gameBoard.getCellHeight() + gameBoard.getYPos(), gameBoard.getCellHeight(), gameBoard.getCellWidth());
		sameSpot.setFill(Color.GREEN);
		sameSpot.setOpacity(0.3);
		
		//add rectangle to possible cells and the board itself
		possibleCells.add(sameSpot);
		board.getChildren().add(sameSpot);
		
		//simply remove all highlighted spots, switch player, turn off inMove, and return, if clicked
		sameSpot.setOnMouseClicked(e -> {
			board.getChildren().removeAll(possibleCells);
			switchPlayers(piece.getOpp());
			inMove = false;
			return;
		});//end event handler
		
	}//end displayChoices
	
}//end class
