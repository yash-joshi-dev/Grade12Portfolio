/* Name: Yash Joshi
 * Course: ICS 4U
 * Teacher: Mrs. McCafferey
 * Date: November 23, 2021
 * Description: This class file is used to host a two input validation methods for the Run-For-It game.
 */

package run_for_it;

import java.util.Scanner;

public class InputValidation {
		
	/*
	 * Method Name: posIntegerChecker
	 * Description: validates if the user has appropriately entered a positive integer for input
	 * Parameters: n/a
	 * Returns: int enteredNumber
	 */
	public static int posIntegerChecker() {
		
		//create new scanner object
		Scanner myInput = new Scanner(System.in);
		
		//create a while loop to run while the user hasn't entered an integer with a boolean flag named isValid
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
				continue;
			}
			finally {
				myInput.nextLine();
			}//end of try-catch-finally block
			
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
		}//end while
		
		//if choice is yes, return true, otherwise, return false
		if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
			return true;
		}
		else {
			return false;
		}
	}//end yesOrNoChecker method
}//end class
