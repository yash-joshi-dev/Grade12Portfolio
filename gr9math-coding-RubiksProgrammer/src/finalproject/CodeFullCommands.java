package finalproject;

import java.util.Scanner;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.util.ArrayList;

public class CodeFullCommands {
	
	static String[] varNames = new String[0];
	static double[] varValues = new double[0];
	static String[] outputs = new String[0];
	
	public static void main(String[] args) {
		//test
	}
	
	public static void parser(String code) throws IOException {
		
		//write the code file
		fileMaker(code);
		
		//call the program class
		try {
			
			//create a directory variable and execute the Program.java file
			File file = new File("C:\\Users\\yashj\\git\\gr9math-coding-RubiksProgrammer\\src\\finalproject");
			Process theProcess = Runtime.getRuntime().exec("java Program.java", null, file);

			//read from the standard output of the Program.java program
			BufferedReader inStream = new BufferedReader(new InputStreamReader(theProcess.getInputStream()));
			System.out.println("Code output:");
			String line = inStream.readLine();
			while(line != null) {
				System.out.println(line);
				line = inStream.readLine();
			}
		}
		catch (IOException e) {
			System.err.println("Error occurred during process.");
			e.printStackTrace();
		}
	}
	
	/*
	 * Method Name: fileMaker
	 * Description: overwrites Program.java file with user entered code and compiles it.
	 * Parameters: String code
	 * Returns: void
	 */
	public static void fileMaker(String code) throws IOException {
		
		//open Program.java and the filewriter and printwriter
		File program = new File("C:\\Users\\yashj\\git\\gr9math-coding-RubiksProgrammer\\src\\finalproject\\Program.java");
		FileWriter fileWriter = new FileWriter(program);
		PrintWriter writer = new PrintWriter(fileWriter);
		
		//write the code
		writer.println("package finalproject;");
		writer.println("public class Program {");
		writer.println("public static void main(String[] args) {");
		writer.println(code);
		writer.println("}");
		writer.println("}");
		writer.close();
		fileWriter.close();
		
		//compile the file
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, null, null, program.getPath());		
	
	}//end fileMaker method
	
	public static void parser(String[] code) {
		
//		//split code into lines and remove empty lines
//		String[] lines = code.split("\n");
//		lines = emptyStringRemover(lines);
//		
//		//use for loop to iterate through each line
//		for(String line: lines) {
//			
//			//break each line into its keyword (command) and the rest of the line
//			String[] keywordParts = line.split("(");
//			
//			//implement appropriate method
////			methodChooser(keywordParts)
			
//		}//end for
	}//end parser
	
	/*
	 * Method Name: emptyStringRemover
	 * Description: removes empty strings from string array.
	 * Parameters: String [] array
	 * Returns: String [] newArray
	 */
	public static String[] emptyStringRemover(String[] array) {
		
		int index = Array.findElement(array, "");

		while(index != -1) {
			array = Array.deleteStringElement(array, index);
			index = Array.findElement(array, "");
		}
		
		return array;
	}//end emptyStringRemover
	
	/*
	 * Method Name: var
	 * Description: creates a "variable" by adding provided name and value to the corresponding arrays.
	 * Parameters: String name, int value
	 * Returns: void
	 */
	public static void var(String name, double value) {
		
		Array.insertElement(varNames, name, varNames.length);
		Array.insertElement(varValues, value, varValues.length);

	}//end var

	/*
	 * Method Name: varRe
	 * Description: reassigns values to the "variables".
	 * Parameters: String name, int value
	 * Returns: void
	 */
	public static void varRe(String name, int value) {
		
		int index = Array.findElement(varNames, name);
		Array.replaceElement(varValues, value, index);
	
	}//end varRe
	
	/*
	 * Method Name: input
	 * Description: takes in double input and assigns it to a "variable" of the name provided
	 * Parameters: String name
	 * Returns: void
	 */
	public static void input(String name) {
		
		//create instance of scanner class and take in the double input
		Scanner myInput = new Scanner(System.in);
		double value = myInput.nextDouble();
		myInput.nextLine();
		
		//add the name and value of the input to the variable arrays
		var(name, value);
		
	}//end input
	
	/*
	 * Method Name: print
	 * Description: takes in multiple objects, converts them to a string if not a string already,
	 * 				and stores them in an output array.
	 * Parameters: Objects...textPieces
	 * Returns: void
	 */
	public static void print(Object...textPieces) {
		
		String text;
		
		for(int i = 0; i < textPieces.length; i++) {
			
			try {
				text = (String) textPieces[i];
			}
			catch(Exception e) {
				text = String.valueOf(textPieces[i]);
			}
			
			Array.insertElement(outputs, text, outputs.length);
		}
		
	}
	
	

}
