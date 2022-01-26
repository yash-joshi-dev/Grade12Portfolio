package grade12_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class, JFxFunctions.java, holds useful methods for dealing with controls and layouts in JavaFX.
 * @author yashj
 * @since Jan 2022
 */
public class FX {
	
	/**
	 * Makes it easier to print anything;
	 */
	public static void print(String text) {
		System.out.println(text);
	}
	
	/**
	 * Makes it easier to print anything;
	 */
	public static void print(int text) {
		System.out.println(text);
	}
	
	/**
	 * Makes it easier to print anything;
	 */
	public static void print(double text) {
		System.out.println(text);
	}
	
	/**
	 * Makes it easier to print anything;
	 */
	public static void print(Object text) {
		System.out.println(text);
	}
	
	/**
	 * Makes it easier to print anything;
	 */
	public static void print() {
		System.out.println();
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
		lbl.setWrapText(true);
		return lbl;
	}//end createLabel
	
	/**
	 * Allows the user to easily create and set many properties for a JavaFX button at once.
	 * @param text the text for the button.
	 * @param font the color of the font of the button.
	 * @param fontSize the size of the font of the button.
	 * @return the created button.
	 */
	public static Button createButton(String text, Color font, int fontSize, Color background) {
		Button btn = new Button(text);
		btn.setTextFill(font);
		btn.setFont(new Font(fontSize));
		btn.setBackground(new Background(new BackgroundFill(background, new CornerRadii(5.0), new Insets(-5.0))));
		return btn;
	}//end createButton
	
	/**
	 * Allows user to easily create equal corner rounded rectangle.
	 * @param height
	 * @param width
	 * @param color
	 * @param arcSize
	 * @return
	 */
	public static Rectangle createRect(double width, double height, Color color, double arcSize) {
		
		Rectangle rect = new Rectangle(width, height, color);
		rect.setArcHeight(arcSize);
		rect.setArcWidth(arcSize);
		return rect;
	}//end createRectangle

}//end class
