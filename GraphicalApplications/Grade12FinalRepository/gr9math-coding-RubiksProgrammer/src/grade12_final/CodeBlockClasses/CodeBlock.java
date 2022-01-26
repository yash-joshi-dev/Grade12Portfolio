package grade12_final.CodeBlockClasses;

import javafx.scene.Group;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public abstract class CodeBlock {

	public static double topBlockInitSize = 40;
	static double roundSize = 5;
	static Color shadowColor = Color.LIGHTGRAY;
	static String[] initVars;
	
	//create all private fields
	protected String code = "";
	protected StackPane topBlock;
	protected char type;
	protected Color color;
	protected Color selectedColor;
	protected boolean inCode = false;
	protected boolean selected = false;
	protected Background normalBg;
	protected Background selectedBg;
	
	
	public static void setInitVars(String... vars) {
		initVars = vars;
	}
	
	//create abstract method to create block shape
	public abstract void switchSelect();
	public abstract Pane getBlock();
	public abstract CodeBlock getNewBlock();
	public abstract String getCode();
//	protected abstract Shape setShape();
	
	
	
}
