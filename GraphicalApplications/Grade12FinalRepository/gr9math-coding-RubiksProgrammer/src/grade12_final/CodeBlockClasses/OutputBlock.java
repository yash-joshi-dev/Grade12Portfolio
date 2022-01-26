package grade12_final.CodeBlockClasses;

import grade12_final.FX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class OutputBlock extends NormalBlock {

	//private fields
//	private ObservableList<String> possVars;

	
	//constructor for block
	public OutputBlock() {
		
		//init stuff in super constructor
		super();
		
		//generate stack pane for the block
		setBlock();
		
	}
	
	/**
	 * Getter for the code.
	 */
	public String getCode() {
		
		return this.code = "System.out.println(" + this.dropDown.getValue() + ");\n";
		
	}
	
	/**
	 * Getter for new block of same type.
	 */
	public OutputBlock getNewBlock() {
		return new OutputBlock();
	}
	
	/**
	 * Getter for the block.
	 */
	public StackPane getBlock() {
		return this.topBlock;
	}
	
	/**
	 * Setter for block stack pane.
	 */
	private void setBlock() {
		
		//create output label
		Label text = FX.createLabel("output", Color.WHITE, 20);
		
		//create new hbox contining text and dropdown menu
		HBox content = new HBox(text, this.dropDown);
		content.setMargin(text,  new Insets(0, 20, 0, 20));
		content.setMargin(dropDown, new Insets(0, 20, 0, 20));
		
		//create stackpane to stack everything on top of
		this.topBlock.getChildren().add(content);

	}
	
}
