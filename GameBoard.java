/*
 * Name: Yash Joshi
 * Teacher: Mrs. McCafferey
 * Course: ICS4U
 * Description: This class is used to create a game board for a game (can specify colors, positions, checkered squares and more).
 */

package reuseableobjects;

import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * The GameBoard class is designed so that one can create a game board object, which stores and manipulates multiple attributes
 * of a game board, such as the number rows and columns within it, where the borders are on the board, the colors of the board
 * and whether it's checkered or not, and it's height, width, x position, and y position on the screen. When the user wants to 
 * get the board to display it in a JavaFX program, they can use the getBoardToDisplay method to access a JavaFX pane that is a
 * graphical representation of the game board. Moreover, whenever the pane representing the game board is clicked, the int array
 * lastCoordinates is updated to contain the row and column of the cell that was click, which can be very useful for board game
 * applications.
 * 
 * @author Yash Joshi
 * @since Jan 2022
 */
public class GameBoard {
	
	//initialize all fields to use in gameboard class
	private int rows;
	private int columns;
	private double height;
	private double width;
	private double xPos = 0;
	private double yPos = 0;
	private Color boardColor1 = Color.WHITE;
	private Color boardColor2;
	private boolean rightBorder;
	private boolean leftBorder;
	private boolean topBorder;
	private boolean bottomBorder;
	private boolean rowBorders;
	private boolean columnBorder;
	private double outerBorderWeight = 10;
	private double innerBorderWeight = 10;
	private double cellHeight;
	private double cellWidth;
	private int[] lastCoordinates = {-1, -1};

	/**
	 * Constructor to initialize rows, columns, height, and width (and cell height and width).
	 * @param rows number of rows.
	 * @param columns number of columns.
	 * @param height the height in pixels of the board.
	 * @param width the width in pixels of the board.
	 */
	public GameBoard(int rows, int columns, double height, double width) {
		
		this.rows = rows;
		this.columns = columns;
		this.height = height;
		this.width = width;
		this.cellHeight = height/rows;
		this.cellWidth = width/rows;
		
	}//end constructor
	
	/**
	 * Constructor to initialize rows, columns, height, width, the x and y positions, and the general color (and cell height
	 * and width).
	 * @param rows number of rows.
	 * @param columns number of columns.
	 * @param height the height in pixels of the board.
	 * @param width the width in pixels of the board.
	 * @param xPos the x position of the top left corner of the board.
	 * @param yPos the y position of the top left corner of the board.
	 * @param boardColor1 the general color of the board.
	 */
	public GameBoard(int rows, int columns, double height, double width, double xPos, double yPos, Color boardColor1) {
		
		this.rows = rows;
		this.columns = columns;
		this.height = height;
		this.width = width;
		this.cellHeight = height/rows;
		this.cellWidth = width/rows;
		this.xPos = xPos;
		this.yPos = yPos;
		this.boardColor1 = boardColor1;
		
	}//end constructor
	
	/**
	 * Constructor to initialize rows, columns, height, width, the x and y positions, and the two colors for a checkered board
	 * (and cell height and width).
	 * @param rows number of rows.
	 * @param columns number of columns.
	 * @param height the height in pixels of the board.
	 * @param width the width in pixels of the board.
	 * @param xPos the x position of the top left corner of the board.
	 * @param yPos the y position of the top left corner of the board.
	 * @param boardColor1 the first color of the checkered cells on the board.
	 * @param boardColor2 the second color of the checkered cells on the board.
	 */
	public GameBoard(int rows, int columns, double height, double width, double xPos, double yPos, Color boardColor1, Color boardColor2) {
		
		this.rows = rows;
		this.columns = columns;
		this.height = height;
		this.width = width;
		this.cellHeight = height/rows;
		this.cellWidth = width/rows;
		this.xPos = xPos;
		this.yPos = yPos;
		this.boardColor1 = boardColor1;
		this.boardColor2 = boardColor2;
		
	}//end constructor
	
	/**
	 * Constructor to initialize rows, columns, height, width, the x and y positions, the general board color, and stroke options
	 * (and cell height and width).
	 * @param rows number of rows.
	 * @param columns number of columns.
	 * @param height the height in pixels of the board.
	 * @param width the width in pixels of the board.
	 * @param xPos the x position of the top left corner of the board.
	 * @param yPos the y position of the top left corner of the board.
	 * @param boardColor1 the general color of the board.
	 * @param allBorders sets all outside borders on if true, otherwise doesn't display the boarders.
	 * @param innerBorders sets all inner borders (of rows and columns) to true, otherwise doesn't display the borders.
	 */
	public GameBoard(int rows, int columns, double height, double width, double xPos, double yPos, Color boardColor1, boolean allBorders, boolean innerBorders) {
		
		this.rows = rows;
		this.columns = columns;
		this.height = height;
		this.width = width;
		this.cellHeight = height/rows;
		this.cellWidth = width/rows;
		this.xPos = xPos;
		this.yPos = yPos;
		this.boardColor1 = boardColor1;
		this.setBorder(allBorders);
		this.setInnerBorder(innerBorders);
		
	}//end constructor
	
	/**
	 * Constructor to initialize rows, columns, height, width, the x and y positions, the two colors for a checkered board, and
	 * stroke options (and cell height and width).
	 * @param rows number of rows.
	 * @param columns number of columns.
	 * @param height the height in pixels of the board.
	 * @param width the width in pixels of the board.
	 * @param xPos the x position of the top left corner of the board.
	 * @param yPos the y position of the top left corner of the board.
	 * @param boardColor1 the first color of the checkered cells on the board.
	 * @param boardColor2 the second color of the checkered cells on the board.
	 * @param allBorders sets all outside borders on if true, otherwise doesn't display the boarders.
	 * @param innerBorders sets all inner borders (of rows and columns) to true, otherwise doesn't display the borders.
	 */
	public GameBoard(int rows, int columns, double height, double width, double xPos, double yPos, Color boardColor1, Color boardColor2, boolean allBorders, boolean innerBorders) {
		
		this.rows = rows;
		this.columns = columns;
		this.height = height;
		this.width = width;
		this.cellHeight = height/rows;
		this.cellWidth = width/rows;
		this.xPos = xPos;
		this.yPos = yPos;
		this.boardColor1 = boardColor1;
		this.boardColor2 = boardColor2;
		this.setBorder(allBorders);
		this.setInnerBorder(innerBorders);
		
	}//end constructor
	
	/**
	 * Getter for rows.
	 * @return number of rows.
	 */
	public int getRows() {
		return this.rows;
	}//end getRows
	
	/**
	 * Getter for columns.
	 * @return number of columns.
	 */
	public int getColumns() {
		return this.columns;
	}//end getColumns
	
	/**
	 * Getter for board height.
	 * @return board height in pixels.
	 */
	public double getHeight() {
		return this.height;
	}//end getHeight
	
	/**
	 * Getter for board width.
	 * @return board width in pixels.
	 */
	public double getWidth() {
		return this.width;
	}//end getWidth
	
	/**
	 * Getter for individual cell height.
	 * @return cell height in pixels.
	 */
	public double getCellHeight() {
		return this.cellHeight;
	}//end getCellHeight
	
	/**
	 * Getter for individual cell width.
	 * @return cell width in pixels.
	 */
	public double getCellWidth() {
		return this.cellWidth;
	}//end getCellWidth
	
	/**
	 * Getter for x position of board (top left corner).
	 * @return x position of the board in pixels.
	 */
	public double getXPos() {
		return this.xPos;
	}//end getXPos
	
	/**
	 * Getter for y position of board (top left corner).
	 * @return y position of the board in pixels.
	 */
	public double getYPos() {
		return this.yPos;
	}//end getYPos
	
	/**
	 * Getter for outer stroke weight.
	 * @return outer stroke weight.
	 */
	public double getOuterStrokeWeight() {
		return this.outerBorderWeight;
	}//end getOuterStrokeWeight
	
	/**
	 * Getter for inner stroke weight.
	 * @return inner stroke weight.
	 */
	public double getInnerStrokeWeight() {
		return this.innerBorderWeight;
	}//end getInnerStrokeWeight
	
	/**
	 * Getter for general color of board (or first color for checkered board).
	 * @return the general color of board (or first color for checkered board).
	 */
	public Color getColor() {
		return this.boardColor1;
	}//end getColor
	
	/**
	 * Getter for the two checkered colors of the board.
	 * @return a color array of length two with the two colors of the checkered board.
	 */
	public Color[] getCheckeredColor() {
		Color[] colors = {this.boardColor1, this.boardColor2};
		return colors;
	}//end getCheckeredColor
	
	/**
	 * Getter for size 2 last coordinates int array.
	 * @return the coordinates of the last clicked cell on the board.
	 */
	public int[] getLastCoordinates() {
		return this.lastCoordinates;
	}//end getLastCoordinates
	
	/**
	 * Setter for rows.
	 * @param rows number of rows.
	 */
	public void setRows(int rows) {
		this.rows = rows;
		this.cellHeight = this.height/rows;
	}//end setRows
	
	/**
	 * Setter for columns.
	 * @param columns number of columns.
	 */
	public void setColumns(int columns) {
		this.columns = columns;
		this.cellWidth = this.width/columns;
	}//end setColumns
	
	/**
	 * Setter for board height.
	 * @param height height of board in pixels.
	 */
	public void setHeight(double height) {
		this.height = height;
		this.cellHeight = height/this.rows;
	}//end setHeight
	
	/**
	 * Setter for board width.
	 * @param width width of board in pixels.
	 */
	public void setWidth(double width) {
		this.width = width;
		this.cellWidth = width/this.columns;
	}//end setWidth
	
	/**
	 * Setter for x position of the board.
	 * @param xPos 
	 */
	public void setXPos(double xPos) {
		this.xPos = xPos;
	}//end setXPos
	
	/**
	 * Setter for y position of the board.
	 * @param yPos
	 */
	public void setYPos(double yPos) {
		this.yPos = yPos;
	}//end setYPos
	
	/**
	 * Setter for weight of outer borders.
	 * @param weight
	 */
	public void setOuterStrokeWeight(double weight) {
		this.outerBorderWeight = weight;
	}//end setOuterStrokeWeight
	
	/**
	 * Setter for weight of inner borders.
	 * @param weight
	 */
	public void setInnerStrokeWeight(double weight) {
		this.innerBorderWeight = weight;
	}//end setInnerStrokeWeight
	
	/**
	 * Setter for general color of board.
	 * @param color
	 */
	public void setColor(Color color) {
		this.boardColor1 = color;
	}//end setColor
	
	/**
	 * Setter for two colors of checkered board.
	 * @param color1
	 * @param color2
	 */
	public void setCheckeredColors(Color color1, Color color2) {
		this.boardColor1 = color1;
		this.boardColor2 = color2;
	}//end setCheckeredColors
	
	/**
	 * Setter to set if one wants the turn on or turn off all outer borders.
	 * @param allBorders if true, it turns on all borders, if false, turns off all outer borders.
	 */
	public void setBorder(boolean allBorders) {
		this.topBorder = allBorders;
		this.bottomBorder = allBorders;
		this.rightBorder = allBorders;
		this.leftBorder = allBorders;
	}//end setBorder
	
	/**
	 * Setter to turn on or turn off both side borders and the top and bottom borders separately.
	 * @param sideBorders boolean to turn on/off side borders.
	 * @param topBottomBorders boolean to turn on/off top and bottom borders.
	 */
	public void setBorder(boolean sideBorders, boolean topBottomBorders) {
		this.topBorder = topBottomBorders;
		this.bottomBorder = topBottomBorders;
		this.rightBorder = sideBorders;
		this.leftBorder = sideBorders;
	}//end setBorder
	
	/**
	 * Setter to turn on or off left, right, top, and bottom borders, all separately.
	 * @param top
	 * @param right
	 * @param bottom
	 * @param left
	 */
	public void setBorder(boolean top, boolean right, boolean bottom, boolean left) {
		this.topBorder = top;
		this.rightBorder = right;
		this.bottomBorder = bottom;
		this.leftBorder = left;
	}//end setBorder
	
	/**
	 * Setter to turn on or off all inner borders at the same time.
	 * @param innerBorder boolean to turn on or off all inner borders (all inner borders of rows and columns).
	 */
	public void setInnerBorder(boolean innerBorder) {
		this.rowBorders = innerBorder;
		this.columnBorder = innerBorder;
	}//end setInnerBorder
	
	/**
	 * Setter to turn on or off the inner row borders and inner column borders separately.
	 * @param row boolean to turn on or off all inner row borders.
	 * @param column boolean to turn on or off all inner column borders.
	 */
	public void setInnerBorder(boolean row, boolean column) {
		this.rowBorders = row;
		this.columnBorder = column;
	}//end setInnerBorder
	
	/**
	 * Returns a pane with the graphical representation of the game board, with each cell as its own separate rectangle on the pane.
	 * Whenever any cell on the board is clicked, the last coordinates int array will be updated to contain the row and column number
	 * of the clicked cell.
	 * @return pane with the graphical representation fo the game board.
	 */
	public Pane getBoardToDisplay() {
		
		//create root pane
		Pane root = new Pane();
		
		//first print out all the squares in a nested for loop
		double xCoordinate = this.xPos;
		double yCoordinate = this.yPos;
		
		for(int i = 0; i < this.rows; i++) {
			
			for(int j = 0; j < this.columns; j++) {
				
				//create cell
				Rectangle cell = new Rectangle(xCoordinate, yCoordinate, this.cellWidth, this.cellHeight);
				
				//create checkered pattern if two colors; otherwise make them all same color
				if((i+j)%2 == 1 && this.boardColor2 != null) cell.setFill(this.boardColor2);
				else cell.setFill(this.boardColor1);
				
				//if clicked, set lastCoordinates to the row and column of the cell
				cell.setOnMouseClicked(event -> {
					this.lastCoordinates[0] = (int) ((cell.getLayoutBounds().getMinX() - this.xPos)/this.cellWidth);
					this.lastCoordinates[1] = (int) ((cell.getLayoutBounds().getMinY() - this.yPos)/this.cellHeight);
				});
				
				//add to pane
				root.getChildren().add(cell);
				
				//give a border for the sides if columnBorders are selected (don't do it on the exposed side of the edge cells)
				if(this.columnBorder) {
					if(j != 0) {
						Line leftBorder = new Line(xCoordinate, yCoordinate, xCoordinate, yCoordinate + this.cellHeight);
						leftBorder.setStrokeWidth(this.innerBorderWeight);
						root.getChildren().add(leftBorder);
					}
					if(j != this.columns-1) {
						Line rightBorder = new Line(xCoordinate + this.cellWidth, yCoordinate, xCoordinate + this.cellWidth, yCoordinate + this.cellHeight);
						rightBorder.setStrokeWidth(this.innerBorderWeight);
						root.getChildren().add(rightBorder);
					}//end if
				}//end if
				
				//do same for rows if rowBorders are selected (don't do it on the exposed side of the top and bottom cells)
				if(this.columnBorder) {
					if(i != 0) {
						Line topBorder = new Line(xCoordinate, yCoordinate, xCoordinate + this.cellWidth, yCoordinate);
						topBorder.setStrokeWidth(this.innerBorderWeight);
						root.getChildren().add(topBorder);
					}
					if(i != this.rows-1) {
						Line bottomBorder = new Line(xCoordinate, yCoordinate + this.cellHeight, xCoordinate + this.cellWidth, yCoordinate + this.cellHeight);
						bottomBorder.setStrokeWidth(this.innerBorderWeight);
						root.getChildren().add(bottomBorder);
					}//end if
				}//end if
				
				//also add borders to exposed sides of cells if those options are selected
				if(this.leftBorder && j == 0) {
					Line leftBorder = new Line(xCoordinate, yCoordinate, xCoordinate, yCoordinate + this.cellHeight);
					leftBorder.setStrokeWidth(this.outerBorderWeight);
					root.getChildren().add(leftBorder);
				}
				if(this.rightBorder && j == this.columns-1) {
					Line rightBorder = new Line(xCoordinate + this.cellWidth, yCoordinate, xCoordinate + this.cellWidth, yCoordinate + this.cellHeight);
					rightBorder.setStrokeWidth(this.innerBorderWeight);
					root.getChildren().add(rightBorder);
				}
				if(this.topBorder && i == 0) {
					Line topBorder = new Line(xCoordinate, yCoordinate, xCoordinate + this.cellWidth, yCoordinate);
					topBorder.setStrokeWidth(this.outerBorderWeight);
					root.getChildren().add(topBorder);
				}
				if(this.bottomBorder && i == this.rows - 1) {
					Line bottomBorder = new Line(xCoordinate, yCoordinate + this.cellHeight, xCoordinate + this.cellWidth, yCoordinate + this.cellHeight);
					bottomBorder.setStrokeWidth(this.outerBorderWeight);
					root.getChildren().add(bottomBorder);
				}//end series of if statements
				
				//update the x coordinate when moving to next cell
				xCoordinate += this.cellWidth;
				
			}//end inner for
			
			//update both the x and y coordinates when moving onto next row
			xCoordinate = this.xPos;
			yCoordinate += this.cellHeight;
			
		}//end outer for
		
		return root;
	}//end getBoardToDisplay method
	
	
}//end class
