/* Name: Yash Joshi
 * Course: ICS 3U
 * Teacher: Mrs. McCafferey
 * Date: June 23, 2021
 * Description: This class is used to host a variety of methods that deal with File I/O and are used to
 * 				get the user's code's output and check the user's code against test cases for each level.
 */

package finalproject;

import java.util.Scanner;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.util.ArrayList;

public class CodeCommands {
	
	//create arrays to hold test cases
	static String[][] testIns1 = {{makeString(10.0/2.0), makeString(1.0/1000.0), makeString(1.0/3600.0)},
								{makeString(34.0/5.0), makeString(1.0/5280.0), makeString(1.0/3600.0)},
								{makeString(45.0/5.0), makeString(1.0/3.7854), makeString(60.0)},
								{makeString(34.0/23.0), makeString(3.7854), makeString(1.0/60.0)},
								{makeString(688.0/45.0), makeString(3.7854), makeString(1.0/5280.0)}};
	static String[][] testOuts1 = {{makeString(1.3888888888888888)}, {makeString(9.973333333333333)},
								{makeString(2044.1160000000002)}, {makeString(0.006508607058546069)},
								{makeString(7.649450244684566E-4)}};
	static String[][][] testIns = {testIns1};
	static String[][][] testOuts = {testOuts1};
	
	
	public static void main(String[] args) {
		//for testing
	}
	
	/*
	 * Method Name: codeChecker
	 * Description: checks the user's code against test cases using codeReader() and either return the output and
	 * 				test input for the fail scene, or nothing for the pass scene.
	 * Parameters: String code
	 * Returns: String[] codeOutput
	 */
	public static Object[] codeChecker(String code, int level) throws IOException {
		
		//create the Object[] to return and boolean to store if output is correct
		Object[] result = new Object[2];
		boolean isPassed;
		
		//create for loop that goes runs the program for each testcase
		for(int i = 0; i < testIns[level-1].length; i++) {
			
			//first run program with input for specific testcase being checked
			String[] output = codeReader(code, testIns[level - 1][i]);
			
			//check if the outputs are a copy of the testOuts (correct testcase outputs)
			isPassed = Array.checkIfCopy(output, testOuts[level - 1][i]);
//			System.out.println(output[0]);
//			System.out.println(testOuts[level - 1][i][0]);
			
			//if passed, continue with the rest of the test cases, otherwise show fail scene with input and output you got
			if(isPassed) {
				continue;
			}
			else {
				result[0] = testIns[level-1][i];
				result[1] = output;
				return result;
			}//end if
		}//end for
		
		//if finishing loop with out returning anything, then return true
		result[0] = null;
		result[1] = null;
		return result;
	}//end codeChecker
	
	/*
	 * Method Name: codeReader
	 * Description: calls the fileMaker method (overwrites a the Program.java file and compiles it), runs the file,
	 * 				reads the output, and returns it in an string array.
	 * Parameters: String code
	 * Returns: String[] codeOutput
	 */
	public static String[] codeReader(String code, String[] inputs) throws IOException {
		
		//create array to store ouput to display
		String[] codeOutput = new String[0];
		
		//write the code file
		boolean errorPresent = fileMaker(code);
		
		//if there is an error, return the error message
		if(errorPresent) {
			codeOutput = Array.insertElement(codeOutput, "Compilation error alert: it seems like you made an "
					+ "error in your code.", 0);
			return codeOutput;
		}//end if
		
		//call the program class and read output; use try catch for IOException
		try {
			
			//create a directory variable and execute the Program.java file
			File file = new File("C:\\Users\\yashj\\git\\gr9math-coding-RubiksProgrammer\\src\\finalproject");
			Process theProcess = Runtime.getRuntime().exec("java Program.java", null, file);
			
			//enter any inputs required
			if(inputs.length != 0) {
				BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(theProcess.getOutputStream()));
				for(int i = 0; i < inputs.length; i++) {
					
					//write the inputs and "flush" them into the stream
					outStream.write(inputs[i] + "\n");
					outStream.flush();
					
					//if its the last input break out of loop, otherwise pause for three seconds
					//before going to next input (to give the program time to process the previous input)
					if(i == inputs.length-1) {
						break;
					}
					Thread.sleep(3000);
				}//end for
			}//end if
			
			//read from the standard output of the Program.java program and add lines to codeOutput array
			BufferedReader inStream = new BufferedReader(new InputStreamReader(theProcess.getInputStream()));
			System.out.println("Code output:");
			String line = inStream.readLine();
			while(line != null) {
				System.out.println(line);
				codeOutput = Array.insertElement(codeOutput, line, codeOutput.length);
				line = inStream.readLine();
			}//end while
		}
		catch (IOException | InterruptedException e) {
			
			System.err.println("Error occurred during internal process.");
			e.printStackTrace();
			
		}//end try-catch block
		
		//return codeOutput
		return codeOutput;
	}//end codeReader method
	
	/*
	 * Method Name: fileMaker
	 * Description: overwrites Program.java file with user entered code, compiles it, and returns a boolean
	 * 				that informs the coder if there were compilation errors.
	 * Parameters: String code
	 * Returns: boolean errorPresent
	 */
	public static boolean fileMaker(String code) throws IOException {
		
		//create boolean to return
		boolean errorPresent;
		
		//open Program.java and the filewriter and printwriter
		File program = new File("C:\\Users\\yashj\\git\\gr9math-coding-RubiksProgrammer\\src\\finalproject\\Program.java");
		FileWriter fileWriter = new FileWriter(program);
		PrintWriter writer = new PrintWriter(fileWriter);
		
		//write the code; make it so that there is a try catch block which can catch any errors
		//also import java.util.* and create an instance of Scanner class
		writer.println("package finalproject;");
		writer.println("import java.util.*;");
		writer.println("public class Program {");
		writer.println("public static void main(String[] args) {");
		writer.println("try{");
		writer.println(code);
		writer.println("}");
		writer.println("catch(Exception e) {");
		writer.println("System.out.println(\"Exception alert: it looks like an error occurred while"
				+ " running your program.\");");
		writer.println("}");
		writer.println("}");
		writer.println("public static double input() {\n"
				+ "	Scanner myInput = new Scanner(System.in);\n"
				+ "	String input = myInput.nextLine();\n"
				+ "	double answer;\n"
				+ "	\n"
				+ "	if(input.contains(\"/\")) {\n"
				+ "		String num1String = input.substring(0, input.indexOf(\"/\"));\n"
				+ "		String num2String = input.substring(input.indexOf(\"/\") + 1, input.length());\n"
				+ "		\n"
				+ "		double num1 = Double.valueOf(num1String);\n"
				+ "		double num2 = Double.valueOf(num2String);\n"
				+ "		\n"
				+ "		answer = num1/num2;\n"
				+ "	}\n"
				+ "	else {\n"
				+ "		answer = Double.valueOf(input);\n"
				+ "	}	\n"
				+ "	\n"
				+ "	return answer;\n"
				+ "	\n"
				+ "}");
		writer.println("public static void print(String string) {\n"
				+ "	System.out.println(string);\n"
				+ "}\n"
				+ "public static void print(int num) {\n"
				+ "	System.out.println(num);\n"
				+ "}\n"
				+ "public static void print(double num) {\n"
				+ "	System.out.println(num);\n"
				+ "}");
		writer.println("}");
		
		//close the filewriter and printwriter
		writer.close();
		fileWriter.close();
		
		//create outputstream to receive any compilation errors
		OutputStream output = new ByteArrayOutputStream();
		
		//compile the file
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, null, output, program.getPath());
		
		//if there is no error, return false, otherwise return true
		String error = output.toString();
		if(error.equals("")) {
			errorPresent = false;
		}
		else {
			System.out.println("ERROR ALERT");
			System.out.println(error);
			errorPresent = true;
		}//end if
		
		return errorPresent;

	}//end fileMaker method

	/*
	 * Method Name: makeString
	 * Description: turns doubles to strings 
	 * Parameters: double num
	 * Returns: String string
	 */
	public static String makeString(double num) {
		return Double.toString(num);
	}//end makeString

}//end class
