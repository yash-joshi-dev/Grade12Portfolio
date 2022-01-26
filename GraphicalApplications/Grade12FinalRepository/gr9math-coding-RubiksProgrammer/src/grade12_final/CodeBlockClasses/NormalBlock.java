package grade12_final.CodeBlockClasses;

import grade12_final.FX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class NormalBlock extends CodeBlock {
	
	//also have
	//type, code, block, color, selected color
	protected ComboBox<String> dropDown;
	
	//create constructor
	protected NormalBlock() {
		this.type = 'N';
		this.color = Color.RED;
		this.selectedColor = Color.DARKRED;
		this.normalBg = new Background(new BackgroundFill(this.color, null, null));
		this.selectedBg = new Background(new BackgroundFill(this.selectedColor, null, null));
		this.topBlock = new StackPane();
		this.topBlock.setBackground(normalBg);
		this.topBlock.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		this.topBlock.setPrefHeight(topBlockInitSize);
		this.topBlock.setAlignment(Pos.CENTER);
		
		//init combo box and possible vars
		ObservableList<String> possVars = FXCollections.observableArrayList(initVars);
		this.dropDown = new ComboBox<>(possVars);
		this.dropDown.setValue(possVars.get(0));
	}
	
	/**
	 * Setter for adding another poss vars.
	 */
	public void addPossVars(String var) {
		dropDown.getItems().add(var);
	}
	
	public void switchSelect() {
		
		if(this.selected) {
			this.topBlock.setBackground(this.normalBg);
			this.selected = false;
		}
		else {
			this.topBlock.setBackground(this.selectedBg);
			this.selected = true;
		}
	}
	
}
