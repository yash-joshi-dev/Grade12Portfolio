package grade12_final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import grade12_final.CodeBlockClasses.CodeBlock;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CodeList extends StackPane {

	static private int placerHeight = 10;
	
	//create two vboxes to store code blocks and to store placer rectangles
	private LinkedList<CodeBlock> codeObjectList = new LinkedList<>();
	private VBox blockList = new VBox();
	private VBox placers = new VBox();
	private int count = 0;
	private HashMap<Rectangle, Integer> hmap = new HashMap<>();
	
	public CodeList() {
		
		//add first placer to placers; make it transparent
		blockList.setFillWidth(false);
		placers.setFillWidth(false);
		this.getChildren().add(blockList);
		addPlacer(placerHeight/2.0);
		
	}
	
	public void showPlacers() {
		
		this.getChildren().add(placers);
		
	}
	
	public void hidePlacers() {
		
		this.getChildren().remove(placers);
		
		
	}
	
	private void addPlacer(double height) {
		
		Rectangle placer = new Rectangle(Main.screenWidth * 0.43, height, Color.BLUE);
//		placer.setStroke(Color.BLACK);
		placer.setMouseTransparent(false);
		hmap.put(placer, count);
		placers.getChildren().add(placer);
		placers.setMargin(placer, new Insets(0, 0, CodeBlock.topBlockInitSize - placerHeight, 0));
		placer.setOnMouseClicked(event -> {
			CodeBlock block = Problem.selectedPiece.getNewBlock();
			blockList.getChildren().add(hmap.get(placer), block.getBlock());
			codeObjectList.add(hmap.get(placer), block);
//			blockList.setMargin(gblock, new Insets(5, 0, 5, 0));
			Problem.selectedPiece.switchSelect();
			Problem.selectedPiece = null;
			count++;
			hidePlacers();
			addPlacer(placerHeight);
			
		});
		
	}
	
	/**
	 * Gets all the code for all of the code blocks. Returns empty string if no code blocks are there.
	 */
	public String getCode() {
		
		String code = "";
		
		for(CodeBlock block: codeObjectList) {
			code += block.getCode() + "\n";
		}
		
		return code;
	}
	
	
}
