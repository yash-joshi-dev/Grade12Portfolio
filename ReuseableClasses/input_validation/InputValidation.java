/* Name: Yash Joshi
 * Course: ICS 4U
 * Teacher: Mrs. McCafferey
 * Date: November 23, 2021
 * Description: This class file is used to host some input validation methods that can be reused in other classes.
 */

package input_validation;

import java.util.Scanner;
import array.Array;

public class InputValidation {
	
	/*
	 * Method Name: choiceValidation()
	 * Description: checks if the entered choice is in the given list; if not, then continuous to ask until it gets a valid
	 * 				choice for input.
	 * Parameters: String [] options
	 * Returns: String validatedChoice
	 */
	public static String choiceValidation(String ... options) {
		
		//create new instance of scanner object
		Scanner myInput = new Scanner(System.in);
		
		//take in a choice as input
		String choice = myInput.nextLine();
		
		//use while loop to continuously ask the person to enter a name until they enter a valid name in the names array
		while(Array.findElement(choice, options) == -1) {
			
			//give user an error message and display the user's available options for names
			System.out.println("Sorry, that is not valid choice. Please select from one options listed: ");
			Array.print(options);
			
			//ask for name again
			System.out.println();
			System.out.println("Please specify your choice: ");
			choice = myInput.nextLine();
		}//end while
		
		return choice;
	}//end choiceValidation method
	
	/*
	 * Method Name: doubleInputValidation
	 * Description: validates doubles by checking if the input is a double and larger than the given lower limit
	 * Parameters: int lowerbound
	 * Returns: double input
	 */
	public static double doubleInputValidation(int lowerbound) {
		
		//declare input variable and create new instance of scanner object
		double input;
		Scanner myInput = new Scanner(System.in);
		
		//create while loop to keep error checking until valid double input is entered
		while(true) {
			
			try {
				input = myInput.nextDouble();
				myInput.nextLine();
			}
			catch(Exception e) {
				
				//since the double part of this method will most likely only be used for money, it won't really have a high value that will be used
				System.out.print("Invalid input. Please enter an DECIMAL NUMBER greater than $"
						+ lowerbound + ": ");
				myInput.nextLine();
				continue;
				
			}//end try-catch block
			
			//then check if the double is greater than low; if it is, return the output, otherwise continue
			if(input > lowerbound) {
				return input;
			}
			else {
				System.out.print("Invalid input. Please enter a decimal number GREATER THAN$" + lowerbound + ": ");
			}//end if
		}//end while
	}//end doubleInputValidation method
	
	/*
	 * Method Name: intInputValidation
	 * Description: validates integer inputs by checking if the input is and integer and within a given range.
	 * Parameters: int low, int high
	 * Returns: integer input
	 */
	public static int intInputValidation(int low, int high) {
		
		//declare input variable and create a new instance of the scanner object
		int input;
		Scanner myInput = new Scanner(System.in);
		
		//create while loop to keep error checking until valid integer input is entered
		while(true) {
			
			//first check if the user entered an integer for input
			try {
				input = myInput.nextInt();
				myInput.nextLine();
			}
			catch(Exception e) {
				System.out.print("Invalid input. Please enter an INTEGER between "
						+ low + " and " + high + ": ");
				myInput.nextLine();
				continue;
				
			}//end try-catch block
			
			//then check if the integer is between the range of low to high; if it is, return the output, otherwise continue 
			if(low <= input && input <= high) {
				return input;
			}
			else {
				System.out.print("Invalid input. Please enter an integer BETWEEN " + low + " and " + high + ": ");
			}//end if
		}//end while
	}//end intInputValidation method
	
	/*
	 * Method Name: posIntegerChecker
	 * Description: validates if the user has appropriately entered a positive integer for input
	 * Parameters: n/a
	 * Returns: int enteredNumber
	 */
	public static int posIntegerChecker() {
		
		//create new scanner object
		Scanner myInput = new Scanner(System.in);
		
		//create a while loop to run while the user hasn't entered an integer with a flag named isValid
		//also create a variable input to store the input
		boolean isValid = false;
		int input = 0;
		
		while(!isValid) {
			
			//try to get integer input; if an exception is thrown, print an error statement to user and try again
			try {
				input = myInput.nextInt();
			}
			catch(Exception e) {
				System.out.println("That is not a valid number of players. Please enter an integer: ");
				myInput.nextLine();
				continue;
			}//end try-catch block
			
			//check if the input is negative or equal to 0; if it is print error message and ask for input again; else
			//break out of the loop
			if(input <= 0) {
				System.out.println("That is not a valid number of players. Please enter a positive integer: ");
				continue;
			}
			else {
				isValid = true;
			}//end if
		}//end while
		
		return input;
		
	}//end posIntegerChecker method

	/*
	 * Method Name: yesOrNoChecker
	 * Description: validates yes or no inputs by checking if the user has properly entered y or n, or
	 * 				yes or no and returning true for yes and false for no.
	 * Parameters: n/a
	 * Returns: boolean value (true for yes and false for no).
	 */
	public static boolean yesOrNoChecker() {
		
		//create new instance of scanner class
		Scanner myInput = new Scanner(System.in);
		
		//take in the user's choice
		String choice = myInput.nextLine();
		
		//keep asking for choice until user enters a valid choice
		while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n") && !choice.equalsIgnoreCase("yes") && ! choice.equalsIgnoreCase("no")) {
			System.out.println("Sorry I couldn't understand that! Please enter either y or n, or yes or no: ");
			choice = myInput.nextLine();
		}
		
		//if choice is yes, return true, otherwise, return false
		if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
			return true;
		}
		else {
			return false;
		}
	}//end yesOrNoChecker method
	
	
}//end class