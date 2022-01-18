/*
 * Name: Yash Joshi
 * Teacher: Mrs. McCafferey
 * Course: ICS4U
 * Description: This class is used to create a checkers piece object for the checkers game, which stores the radius, type, 
 * position, color, and more properties of a checkers piece, and also has multiple method to access where the checkers piece can
 * move.
 */

package reuseableobjects;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * The Checkers Piece class can be used by one to create a checkers piece object. This can store many useful data fields about
 * a checkers piece, such as its radius, type, position, opponent type, color, row, column, and if it is a king or not. It also
 * stores a couple of key details about the game board itself (such as cell width and height, the boards position) to manipulate
 * the checker's piece on the board with accuracy. Finally, piece has a couple methods to get the actual checker's piece to display
 * (a circle), move the piece graphically, find out where the piece can move, and delete the piece.
 * 
 * @author Yash Joshi
 * @since Jan 2022
 */
public class CheckersPiece {

	//store current game board (2d array)
	static int[][] currGame = new int[8][8];
	
	//colors for both kinds of checkers (can just set manually here instead of in a constructor)
	static Color[] colors = {Color.WHITE, Color.ORANGE};
	
	//create static variable for radius of checkers (won't change for a different piece)
	static int checkerRad = 35;
	
	//initialize important data fields for object
	//type can be (1 or 2); color is automatically assigned based on type
	//1 type piece will move forward and 2 type piece will move backward
	private int type;
	private int opponent;
	private Color color;
	private int row;
	private int column;
	private double xPos;
	private double yPos;
	private double cellHeight;
	private double cellWidth;
	private double boardXPos;
	private double boardYPos;
	private Circle piece;
	private boolean isKing = false;
	private Circle kingSign;
	
	/**
	 * Sets the values for all fields of checker's piece except for king-related fields.
	 * @param type   the type of the piece (1 for moving forward, white, and 2 for moving backwards, brown)
	 * @param row    the row that the piece is initially in
	 * @param column   the column that the piece is initially in
	 * @param cellHeight  the cell height of the board
	 * @param cellWidth   the cell width of the board
	 * @param boardXPos   the x position of the board (top left corner)
	 * @param boardYPos   the y position of the board (top left corner)
	 * @throws ArrayIndexOutOfBoundsException if type is not either 1 or 2, or row or column is less than 0 or greater than 7.
	 */
	public CheckersPiece(int type, int row, int column, double cellHeight, double cellWidth, double boardXPos, double boardYPos) {
		
		this.type = type;
		this.opponent = (type == 1) ? 2 : 1;
		this.color = colors[type-1];
		this.row = row;
		this.column = column;
		this.cellHeight = cellHeight;
		this.cellWidth = cellWidth;
		this.boardXPos = boardXPos;
		this.boardYPos = boardYPos;
		
		//add type to currGame
		currGame[row][column] = type;
		
		//set x and y positions of the board
		setPos();
		
		//create actual checkers piece
		this.piece = new Circle(this.xPos, this.yPos, this.checkerRad, this.color);
		
	}//end constructor
	
	/**
	 * Getter for the piece's row.
	 * @return piece's row.
	 */
	public int getRow() {
		return this.row;
	}
	
	/**
	 * Getter for the piece's column.
	 * @return piece's column.
	 */
	public int getColumn() {
		return this.column;
	}
	
	/**
	 * Getter for type of piece.
	 * @return the type of the piece (1 or 2).
	 */
	public int getType() {
		return this.type;
	}
	
	/**
	 * Getter for opposite piece.
	 * @return the opposite type of piece (2 or 1)
	 */
	public int getOpp() {
		return this.opponent;
	}
	
	/**
	 * Returns the checkers piece circle.
	 * @return the checkers piece circle
	 */
	public Circle getPiece() {
		return this.piece;
	}

	/**
	 * Getter for if the piece is a king.
	 * @return true if piece is king, false otherwise.
	 */
	public boolean isAKing() {
		return this.isKing;
	}

	/**
	 * Getter for king ring.
	 */
	public Circle getKingRing() {
		return this.kingSign;
	}
	
	/**
	 * Sets the x and y coordinates of the checker's piece depending on the size and position of the board and the 
	 * row and column of the piece.
	 */
	private void setPos() {
		this.yPos = this.row * this.cellWidth + this.cellWidth/2.0 + this.boardYPos;
		this.xPos = this.column * this.cellHeight + this.cellHeight/2.0 + this.boardXPos;
	}

	/**
	 * Kings the checkers piece (turns on king flag and puts a ring on it).
	 */
	public void kingPiece() {
		
		this.isKing = true;
		kingSign = new Circle(this.xPos, this.yPos, this.checkerRad-20, Color.TRANSPARENT);
		kingSign.setStroke(Color.GOLD);
		kingSign.setStrokeWidth(5);
		
	}//end kingPiece
	
	/**
	 * Sets the row and column of the the piece, and also resets the x and y positions, and the x and y position of the circle part
	 * of the piece itself.
	 * @param row the row the piece should be moved to.
	 * @param col the column the piece should be moved to.
	 */
	public void movePiece(int row, int col) {
		
		//set currGame at current row and column to empty (0) and set it to type at new row and column
		currGame[this.row][this.column] = 0;
		currGame[row][col] = this.type;
		
		//first set row and column
		this.row = row;
		this.column = col;
		
		//set x and y pos
		setPos();
		
		//move circle
		this.piece.relocate(this.xPos - this.checkerRad, this.yPos - this.checkerRad);
		
		//if king, move ring too
		if(this.isKing) {
			kingSign.relocate(this.xPos - (this.checkerRad - 20 + 2.5), this.yPos - (this.checkerRad-20 + 2.5));
		}
		
	}//end movePiece
	
	/**
	 * Checks if a certain square in relation to the current spot of the piece, exists and is of the correct type.
	 * @param rowOffset the vertical distance of checking spot from current row.
	 * @param colOffset the horizontal distance of checking spot from current column.
	 * @param typeChecking the type to check for in the spot to move.
	 * @return true if the move is possible, false otherwise.
	 */
	private boolean movePossible(int rowOffset, int colOffset, int typeChecking) {
		
		//use following two booleans to check if spot even exists (within bounds of the board)
		boolean rowGood;
		boolean colGood;
		
		//check if the row of the checking spot exists, either backwards (if offset is negative) or forwards (if offset is positive)
		if(rowOffset < 0) rowGood = this.row + rowOffset >= 0;
		else rowGood = this.row + rowOffset < 8;
		
		//check if the column of the checking spot exists, either backwards or forwards (if the offset is negative or positive)
		if(colOffset < 0) colGood = this.column + colOffset >= 0;
		else colGood = this.column + colOffset < 8;
		
		//return true if the row and columns are within bounds, and the spot is of the correct type; return false otherwise
		return rowGood && colGood && (currGame[this.row + rowOffset][this.column + colOffset] == typeChecking);
		
	}//end movePossible
	
	/**
	 * Checks if offset of current row and column of the piece match the row and column of the last spot.
	 * @param rowOffset the row offset.
	 * @param colOffset the column offset.
	 * @param lastSpot an int array containing the row and column of the last spot on the gameboard.
	 * @return true if offset matches the last spot coordinates, false otherwise.
	 */
	private boolean isLastSpot(int rowOffset, int colOffset, int[] lastSpot) {
		return (lastSpot[0] == this.row + rowOffset) && (lastSpot[1] == this.column + colOffset);
	}
	
	/**
	 * Returns the coordinates of all spots the selected piece can jump to (and delete other pieces in the process), besides going back to the spot it was
	 * at before (only needed for king).
	 * @param lastSpot an int array containing the row and column of the last spot on the gameboard.
	 * @return an arraylist containing coordinates of all possible jumping spots.
	 */
	public ArrayList<int[]> jumpMoves(int[] lastSpot) {
		  
		ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
		
		//find moves differently, depending on if the piece is a king, type 1, or type 2
		if(this.isKing) {
			
			//second check all possible jumping spots, making sure it isn't the last spot
			if(movePossible(-1, -1, this.opponent) && movePossible(-2, -2, 0) && !isLastSpot(-2, -2, lastSpot)) {
				possibleMoves.add(new int[] {this.row-2, this.column-2});
			}
			if(movePossible(-1, 1, this.opponent) && movePossible(-2, 2, 0) && !isLastSpot(-2, 2, lastSpot)) {
				possibleMoves.add(new int[] {this.row-2, this.column+2});
			}
			if(movePossible(1, -1, this.opponent) && movePossible(2, -2, 0) && !isLastSpot(2, -2, lastSpot)) {
				possibleMoves.add(new int[] {this.row+2, this.column-2});
			}
			if(movePossible(1, 1, this.opponent) && movePossible(2, 2, 0) && !isLastSpot(2, 2, lastSpot)) {
				possibleMoves.add(new int[] {this.row+2, this.column+2});
			}
		
		}
		else if(this.type == 1) {
			
			//check all forward jumping spots
			if(movePossible(-1, -1, this.opponent) && movePossible(-2, -2, 0)) {
				possibleMoves.add(new int[] {this.row-2, this.column-2});
			}
			if(movePossible(-1, 1, this.opponent) && movePossible(-2, 2, 0)) {
				possibleMoves.add(new int[] {this.row-2, this.column+2});
			}
			
		}
		else if(this.type == 2) {
			
			//check all backwards jumping spots
			if(movePossible(1, -1, this.opponent) && movePossible(2, -2, 0)) {
				possibleMoves.add(new int[] {this.row+2, this.column-2});
			}
			if(movePossible(1, 1, this.opponent) && movePossible(2, 2, 0)) {
				possibleMoves.add(new int[] {this.row+2, this.column+2});
			}
			
		}//end if
		
		return possibleMoves;
		
	}//end jumpMoves
	
	/**
	 * Checks where the selected piece can move and returns an 2d array containing those coordinates.
	 * @return an arraylist containing all possible coordinates of where the piece can move (as size 2 integer arrays, with the row
	 * 			and column as elements).
	 */
	public ArrayList<int[]> getMoves() {
		
		ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
		
		//find moves differently, depending on if the piece is a king, type 1, or type 2
		if(this.isKing) {
			
			//first check all diagonal spots directly connected to this piece's spot
			if(movePossible(-1, -1, 0)) {
				possibleMoves.add(new int[] {this.row-1, this.column-1});
			}
			if(movePossible(-1, 1, 0)) {
				possibleMoves.add(new int[] {this.row-1, this.column+1});
			}
			if(movePossible(1, -1, 0)) {
				possibleMoves.add(new int[] {this.row+1, this.column-1});
			}
			if(movePossible(1, 1, 0)) {
				possibleMoves.add(new int[] {this.row+1, this.column+1});
			}
			
			//second check all possible jumping spots
			if(movePossible(-1, -1, this.opponent) && movePossible(-2, -2, 0)) {
				possibleMoves.add(new int[] {this.row-2, this.column-2});
			}
			if(movePossible(-1, 1, this.opponent) && movePossible(-2, 2, 0)) {
				possibleMoves.add(new int[] {this.row-2, this.column+2});
			}
			if(movePossible(1, -1, this.opponent) && movePossible(2, -2, 0)) {
				possibleMoves.add(new int[] {this.row+2, this.column-2});
			}
			if(movePossible(1, 1, this.opponent) && movePossible(2, 2, 0)) {
				possibleMoves.add(new int[] {this.row+2, this.column+2});
			}
		
		}
		else if(this.type == 1) {
			
			//check all forward diagonals
			if(movePossible(-1, -1, 0)) {
				possibleMoves.add(new int[] {this.row-1, this.column-1});
			}
			if(movePossible(-1, 1, 0)) {
				possibleMoves.add(new int[] {this.row-1, this.column+1});
			}
			
			//check all forward jumping spots
			if(movePossible(-1, -1, this.opponent) && movePossible(-2, -2, 0)) {
				possibleMoves.add(new int[] {this.row-2, this.column-2});
			}
			if(movePossible(-1, 1, this.opponent) && movePossible(-2, 2, 0)) {
				possibleMoves.add(new int[] {this.row-2, this.column+2});
			}
			
		}
		else if(this.type == 2) {
			
			//check all backward diagonals
			if(movePossible(1, -1, 0)) {
				possibleMoves.add(new int[] {this.row+1, this.column-1});
			}
			if(movePossible(1, 1, 0)) {
				possibleMoves.add(new int[] {this.row+1, this.column+1});
			}
			
			//check all backwards jumping spots
			if(movePossible(1, -1, this.opponent) && movePossible(2, -2, 0)) {
				possibleMoves.add(new int[] {this.row+2, this.column-2});
			}
			if(movePossible(1, 1, this.opponent) && movePossible(2, 2, 0)) {
				possibleMoves.add(new int[] {this.row+2, this.column+2});
			}
			
		}//end if
		
		return possibleMoves;
	}//end getMoves
	
	/**
	 * Deletes piece from currGame array.
	 */
	public void deletePiece() {
		currGame[this.row][this.column] = 0;
	}//end deletePiece
}
