package grade12_final.CodeBlockClasses;

import grade12_final.FX;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

public class VarReassign extends NormalBlock {
	
	private TextField mathField = new TextField("0");
	
	public VarReassign() {
		
		super();
		this.setBlock();
		
	}

	@Override
	public Pane getBlock() {
		return this.topBlock;
	}

	@Override
	public CodeBlock getNewBlock() {
		// TODO Auto-generated method stub
		return new VarReassign();
	}

	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		String math = mathField.getText();
		
		return this.code = this.dropDown.getValue() + " = " + math + ";\n";
	}
	
	private void setBlock() {
		
		//create set and to labels for block
		Label setLabel = FX.createLabel("set", Color.WHITE, 20);
		Label toLabel = FX.createLabel("to", Color.WHITE, 20);
		
		//
//		mathField.setMinWidth(50);
//		mathField.setPrefWidth(50);
//		mathField.setMaxWidth(400);
//		mathField.autosize();
//		// add listner
//		mathField.textProperty().addListener(new ChangeListener<String>() {
//		    @Override
//		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//		        textField.setPrefWidth(textField.getText().length() * 7); // why 7? Totally trial number.
//		    }
//		});
		
		//add above labels, dropdown, and math field in correct order to an hbox
		HBox content = new HBox(setLabel, this.dropDown, toLabel, this.mathField);
		content.setHgrow(mathField, Priority.SOMETIMES);
//		content.setMargin(setLabel,  new Insets(0, 20, 0, 20));
//		content.setMargin(dropDown, new Insets(0, 20, 0, 20));
//		content.setMargin(toLabel,  new Insets(0, 20, 0, 20));
//		content.setMargin(mathField, new Insets(0, 20, 0, 20));
//		
		//add content to top block stack pane
		this.topBlock.getChildren().add(content);
		
	}

}
