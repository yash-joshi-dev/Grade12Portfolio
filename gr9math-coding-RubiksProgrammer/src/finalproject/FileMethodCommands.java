package finalproject;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


public class FileMethodCommands extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	}

	public static void main(String[] args) throws IOException {
		fileMaker("holo");
	}
	
	public static void fileMaker(String code) throws IOException {
		
		//create java file
		File program = new File("C:\\Users\\yashj\\Grade9ProgramFiles\\Program.java");
		File test = new File("C:\\Users\\yashj\\Grade9ProgramFiles\\TestProject.java");
		FileWriter fileWriter = new FileWriter(program);
		
		//create a new instance of PrintWriter
		PrintWriter writer = new PrintWriter(fileWriter);
		
		//create the package declaration and main method
		writer.println("package finalproject;");
		System.out.println("you");
		writer.println("public class Program {");
		System.out.println("are");
		writer.println("\tpublic static void main(String[] args) {}");
		System.out.println("doing");
		writer.println("\tpublic static int adder(int x, int y) {");
		writer.println("\t\tint sum = x + y;");
		writer.println("\t\treturn sum;");
		System.out.println("it!!");
		writer.println("\t}");
		writer.println("}");
		writer.close();
		fileWriter.close();
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, null, null, program.getPath());
		compiler.run(null, null, null, test.getPath());
		
		
	}
	
	
}
//go through text looking for new lines and separate code by it using for loop
//store it in an array or list or something
//use a for loop to go through each element
//inside the loop, first take in characters until bracket
//put that in another method that decides which command it is and how many inputs it requires
//return that and then, again, inside the original method, look for that many parameters (they will be spaced with a
//comma or )