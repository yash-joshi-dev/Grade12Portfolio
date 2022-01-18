package finalproject;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


public class Commands extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	}

	public static void main(String[] args) throws IOException {
	
	}
	
}
//go through text looking for new lines and separate code by it using for loop
//store it in an array or list or something
//use a for loop to go through each element
//inside the loop, first take in characters until bracket
//put that in another method that decides which command it is and how many inputs it requires
//return that and then, again, inside the original method, look for that many parameters (they will be spaced with a
//comma or )