/*
 * Name: Yash Joshi
 * Teacher: Mrs. McCafferey
 * Course: ICS4U
 * Description: This program writes the names and highscores of people to anywhere in the highscores.txt file.
 */

package fileio_assignment;

import java.io.*;
import java.util.Scanner;
import input_validation.InputValidation;
import array.Array;

public class FileIOAssignment1 {

	public static void main(String[] args) throws IOException {
		
		//create new instance of scanner object
		Scanner myInput = new Scanner(System.in);
		
		//initialize file and print writers
		FileWriter file = new FileWriter("highscores.txt", true);
		PrintWriter writer = new PrintWriter(file);
		
		//create a while loop to keep asking the user what they would like to do
		boolean done = false;
		while(!done) {
			
			//ask the user what they would like to do and take in their choice
			System.out.println("Please enter 1 to append to the list, 2 to add in the middle of the list, or 3 to exit: ");
			int choice = InputValidation.intInputValidation(1, 3);
			
			//do appropriate action based on choice
			switch(choice) {
				case 1: appendToList(myInput);
						break;
				case 2: insertInList(myInput);
						break;
				case 3: System.out.println("The highscores list has been saved! Thank-you!");
						done = true;
						break;
			}//end switch
		}//end while
	}//end main
	
	/**
	 * Appends inputted text to the bottom of the highscores.txt file.
	 * @param myInput - the scanner to use to collect input.
	 * @throws IOException 
	 */
	public static void appendToList(Scanner myInput) throws IOException {
		
		//initialize file and print writers; set file writer to append mode
		FileWriter file = new FileWriter("highscores.txt", true);
		PrintWriter writer = new PrintWriter(file);
		
		//ask the user to input the name and highscore they would like to append
		//ask until the user enters 0 for the name using a while loop
		while(true) {
			
			//ask for name and store in as variable
			System.out.println("Please enter the name you would like to append (enter 0 if you don't want to append anymore): ");
			String name = myInput.nextLine();
			
			//break if 0 entered
			if(name.equals("0")) break;
			
			//otherwise ask for highscore and concatenate the name with the highscore and append to the file
			System.out.println("Please enter the highscore for " + name + ": ");
			writer.append(name + " " + InputValidation.posIntegerChecker());
			
		}//end while
		
		writer.close();
	}//end appendToList method
	
	/**
	 * inserts inputted text to any part of the highscores.txt file.
	 * @param myInput - the scanner to use to collect input.
	 * @throws IOException 
	 */
	public static void insertInList(Scanner myInput) throws IOException {
		
		//initialize buffered reader
		BufferedReader input = new BufferedReader(new FileReader("highscores.txt"));
		
		//first read all the information from the highscores file and store each line in an array
		String[] lines = new String[0];
		String line = input.readLine();
		while(line != null) {
			lines = Array.insertElement(lines, line, lines.length);
			line = input.readLine();
		}//end while
		
		//initialize print writer
		PrintWriter writer = new PrintWriter(new FileWriter("highscores.txt"));
		
		//ask the user for data until they enter 0 for the name, using a while loop
		while(true) {
			
			//ask for name and store in as variable
			System.out.println("Please enter the name you would like to insert (enter 0 if you don't want to insert anymore): ");
			String name = myInput.nextLine();
			
			//break if 0 entered
			if(name.equals("0")) break;
			
			//ask for highscore and store as var
			System.out.println("Please enter the highscore for " + name + ": ");
			int score = InputValidation.posIntegerChecker();
			
			//ask the user where they would like to insert the data
			System.out.println("At which line would you like to insert the data? Please select a number between 1 and "
					+ (lines.length+1) + ": ");
			int lineNum = InputValidation.intInputValidation(1, lines.length+1);
			
			//insert the data (both name and score) into the array at the lineNum-1 index
			lines = Array.insertElement(lines, (name + " " + score), lineNum-1);
			
		}//end while
		
		//write all the lines of the highscore file back
		for(String eachLine: lines) writer.println(eachLine);
		writer.close();
		
	}//end insertInList method
}//end class
