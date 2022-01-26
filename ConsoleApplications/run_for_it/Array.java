/** 
 * This class file (Array.java) completes the arrays tasks, since it hosts a variety of basic methods to interact with/use arrays.
 * @author Yash Joshi
 * Course: ICS4U
 * Teacher: Mrs. McCafferey
 * Date: November 16, 2021
 * Description: This class file (Array.java) completes the arrays tasks, since it hosts a variety of
 * 				basic methods to interact with/use arrays.
 */

//add throws exception to stuff and try catch error
//create the input validation class
//change all headers to reflect javadoc stuff
//create overloaded methods for strings and doubles
//do the christmas project
//print, checkifidentical, 

package run_for_it;

import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Array {
	
	/**
	 * Compares the individual elements in the array and returns true if the arrays are the same.
	 * @param int [] array1 - does stuff
	 * @param int [] array2 - does more stuff
	 * @return boolean isCopy
	 * @throws ArrayIndexOutOfBounds throws this when array is out of bounds
	 * @exception Fileio djfkals;jfkdlsa;
	 */
	public static boolean checkIfCopy(int [] array1, int [] array2) {
		
		//first check if the arrays are identical; if the are, return false (as they aren't copies)
		if(array1 == array2) {
			return false;
		}	
		
		//then check if both arrays are of same length; if they aren't return false
		if(array1.length != array2.length) {
			return false;
		}
		
		//if same length, iterate through arrays and compare elements
		for(int i = 0; i < array1.length; i++) {
			
			//if any two elements don't match, return false
			if(array1[i] != array2[i]) {
				return false;
			}//end if
		}//end for
		
		//otherwise, if it passes both tests above, return true
		return true;
	}//end checkIfCopy method

	/**
	 * Compares the location of each array and identifies if they point to the same array.
	 * @param array1 - stuff
	 * @param array2 - more stuff. 
	 * @return boolean identical
	 */
	public static boolean checkIfIdentical(int [] array1, int [] array2) {
		
		//if both array locations are equal, return true, otherwise, return false
		return (array1==array2);
		
	}//end checkIfIdentical method

	/**
	 * Method Name: copyArray
	 * Description: Makes a copy of the original array and returns the copy.
	 * Parameters: int [] originalArray
	 * Returns: int [] newArray
	 */
	public static int[] copyArray(int [] originalArray) {
		
		//create new empty array of the length of the original array
		int [] newArray = new int[originalArray.length];
		
		//use for loop to assign each element of originalArray to elements of newArray
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = originalArray[i];
		}
		
		return newArray;
	}//end copyArray method

	/**
	 * Method Name: countElements
	 * Description: Returns the number of times the ‘value’ is found in the array.
	 * Parameters: int value, int [] array
	 * Returns: int numOfElements
	 */
	public static int countElements(int value, int [] array) {
		
		//create a variable to store the number of elements
		int numOfElements = 0;
		
		//iterate through array to see how many elements match the given value
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				numOfElements++;
			}//end if
		}//end for
		
		return numOfElements;
	}//end countElements method

	/**
	 * Method Name: createEmptyIntArray
	 * Description: returns empty array of size indicated
	 * Parameters: int size
	 * Returns: int [] newArray
	 */
	public static int[] createEmptyIntArray(int size) {
		int [] array = new int[size];
		return array;
	}//end createEmptyIntArray method
	
	/**
	 * Method Name: createRandomIntArray
	 * Description: returns array of size indicated filled with random integers between min and max
	 * Parameters: int size, int min, int max
	 * Returns: int [] newArray
	 */
	public static int[] createRandomIntArray(int size, int min, int max) {
		
		//create instance of random object and an empty array of the specified size
		Random randNum = new Random();
		int [] array = new int[size];
		
		//use for loop to fill array with random integers
		for(int i = 0; i < size; i ++) {
			array[i] = randNum.nextInt(max - min + 1) + min;
		}
		return array;
		
	}//end createRandomIntArray method
	
	/**
	 * Method Name: createUserDefinedArray
	 * Description: returns array of size indicated filled with information entered by the user
	 * Parameters: int size
	 * Returns: int [] newArray
	 */
	public static int[] createUserDefinedArray(int size){
		
		//create instance of scanner object and create empty array of specified size
		int [] array = new int[size];
		Scanner myInput = new Scanner(System.in);
		
		//create for loop to ask user for values to fill array
		for(int i = 0; i < array.length; i++) {
			
			//do error checking while asking for input
			while(true) {
				try {
					array[i] = myInput.nextInt();
					break;
				}
				catch(Exception e) {
					System.out.println("Sorry, your input was invalid. Please enter valid input: ");
				}
				finally {
					myInput.nextLine();
				}//end try catch block	
			}//end while
		}//end for
		
		return array;
	}//end createUserDefinedArray method
	
	/**
	 * Method Name: deleteElement
	 * Description: Creates an integer array with size originalArray.length - 1 and deletes the integer
	 * 				element at index ‘position’. All other values >position, are shifted to
	 * 				index-1.
	 * Parameters: int [] originalArray, int position
	 * Returns: int [] newArray
	 */
	public static int[] deleteElement(int [] originalArray, int position) {
		
		//create empty array that has a size one less than the length of the originalArray
		int [] newArray = createEmptyIntArray(originalArray.length - 1);
		
		//create a for loop to iterate through array to assign values to all the elements
		for(int i = 0; i < newArray.length; i++) {
			
			//for elements at indices less than the given position, copy the elements from the originalArray
			//otherwise, for elements at indices >= the position, skip over the element at that position
			//and copy the remaining elements of the original array
			if(i < position) {
				newArray[i] = originalArray[i];
			}
			else {
				newArray[i] = originalArray[i+1];
			}//end if
		}//end for
		
		return newArray;
	}//end deleteElement method
	
	/**
	 * Method Name: deleteElement
	 * Description: Creates a double array with size originalArray.length - 1 and deletes the double element
	 * 				at index ‘position’. All other values >position, are shifted to
	 * 				index-1.
	 * Parameters: double [] originalArray, int position
	 * Returns: double [] newArray
	 */
	public static double[] deleteElement(double [] originalArray, int position) {
		
		//create empty array that has a size one less than the length of the originalArray
		double [] newArray = new double[originalArray.length - 1];
		
		//create a for loop to iterate through array to assign values to all the elements
		for(int i = 0; i < newArray.length; i++) {
			
			//for elements at indices less than the given position, copy the elements from the originalArray
			//otherwise, for elements at indices >= the position, skip over the element at that position
			//and copy the remaining elements of the original array
			if(i < position) {
				newArray[i] = originalArray[i];
			}
			else {
				newArray[i] = originalArray[i+1];
			}//end if
		}//end for
		
		return newArray;
	}//end deleteElement method

	/**
	 * Method Name: deleteElement
	 * Description: Creates a string array with size originalArray.length - 1 and deletes the string element
	 * 				at index ‘position’. All other values >position, are shifted to
	 * 				index-1.
	 * Parameters: String [] originalArray, int position
	 * Returns: String [] newArray
	 */
	public static String[] deleteElement(String [] originalArray, int position) {
		
		//create empty array that has a size one less than the length of the originalArray
		String [] newArray = new String[originalArray.length - 1];
		
		//create a for loop to iterate through array to assign values to all the elements
		for(int i = 0; i < newArray.length; i++) {
			
			//for elements at indices less than the given position, copy the elements from the originalArray
			//otherwise, for elements at indices >= the position, skip over the element at that position
			//and copy the remaining elements of the original array
			if(i < position) {
				newArray[i] = originalArray[i];
			}
			else {
				newArray[i] = originalArray[i+1];
			}//end if
		}//end for
		
		return newArray;
	}//end deleteElement method

	/**
	 * Method Name: Hello
	 * Description: Returns the position of the first instance of the indicated value.
	 * 				Returns -1 if the ‘value’ is not found.
	 * @param int value, int [] array
	 * Returns: int position
	 * 
	 */
	public static int findElement(int value, int [] array) {
		
		//iterate through array and return the index of the first element that matches value
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				return i;
			}//end if
		}//end for
		
		//if no match found, just return -1
		return -1;
	}//end findElements method

	/**
	 * Method Name: findMax
	 * Description: returns the position (index) of the maximum value in the array.
	 * Parameters: int [] array
	 * Returns: int position
	 */
	public static int findMax(int [] array) {
		
		//set max and position equal to the first element and index of the array
		int max = array[0];
		int position = 0;
		
		//use for loop to go through elements, and compare elements to find the max and its position
		for(int i = 1; i < array.length; i++) {
			
			//if element is greater than max set before, set its value and index equal to 
			//the max and position, repectively
			if(array[i] > max) {
				max = array[i];
				position = i;
			}//end if
		}//end for loop
		
		return position;
	}//end findMax method

	/**
	 * Method Name: findMin
	 * Description: returns the position (index) of the minimum value in the array.
	 * Parameters: int [] array
	 * Returns: int position
	 */
	public static int findMin(int [] array) {
		
		//set min and position equal to the first element and index of the array
		int min = array[0];
		int position = 0;
		
		//use for loop to go through elements, and compare elements to find the min and its position
		for(int i = 1; i < array.length; i++) {
			
			//if element is less than min set before, set its value and index equal to 
			//the min and position, repectively
			if(array[i] < min) {
				min = array[i];
				position = i;
			}//end if
		}//end for loop
		
		return position;
	}//end findMin method

	/**
	 * Method Name: insertElement
	 * Description: Creates an integer array with size originalArray.length +1 and inserts the element
	 * 				‘value’ at index ‘position’. All other values >position, are shifted to
	 * 				index+1.
	 * Parameters: int [] originalArray, int value, int position
	 * Returns: int [] newArray
	 */
	public static int[] insertElement(int [] originalArray, int value, int position) {
		
		//create empty array that has a size one greater than the length of the originalArray
		int [] newArray = createEmptyIntArray(originalArray.length + 1);
		
		//create a for loop to iterate through array to assign values to all the elements
		for(int i = 0; i < newArray.length; i++) {
			
			//for elements at indices less than the given position, copy the elements from the originalArray
			//otherwise, if the index is equal to the position, set element to given value
			//otherwise, for elements at indices greater than the given position, copy the remaining from the originalArray	
			if(i < position) {
				newArray[i] = originalArray[i];
			}
			else if(i == position) {
				newArray[i] = value;
			}
			else {
				newArray[i] = originalArray[i-1];
			}//end if
		}//end for
		
		return newArray;
	}//end insertElement method
	
	/**
	 * Method Name: insertElement
	 * Description: Creates a double array with size originalArray.length +1 and inserts the double element
	 * 				‘value’ at index ‘position’. All other values >position, are shifted to
	 * 				index+1.
	 * Parameters: double [] originalArray, double value, int position
	 * Returns: double [] newArray
	 */
	public static double[] insertElement(double [] originalArray, double value, int position) {
		
		//create empty array that has a size one greater than the length of the originalArray
		double [] newArray = new double[originalArray.length + 1];
		
		//create a for loop to iterate through array to assign values to all the elements
		for(int i = 0; i < newArray.length; i++) {
			
			//for elements at indices less than the given position, copy the elements from the originalArray
			//otherwise, if the index is equal to the position, set element to given value
			//otherwise, for elements at indices greater than the given position, copy the remaining from the originalArray	
			if(i < position) {
				newArray[i] = originalArray[i];
			}
			else if(i == position) {
				newArray[i] = value;
			}
			else {
				newArray[i] = originalArray[i-1];
			}//end if
		}//end for
		
		return newArray;
	}//end insertElement method

	/**
	 * Method Name: insertElement
	 * Description: Creates a string array with size originalArray.length +1 and inserts the String element
	 * 				‘value’ at index ‘position’. All other values >position, are shifted to
	 * 				index+1.
	 * Parameters: String [] originalArray, String value, int position
	 * Returns: String [] newArray
	 */
	public static String[] insertElement(String [] originalArray, String value, int position) {
		
		//create empty array that has a size one greater than the length of the originalArray
		String [] newArray = new String[originalArray.length + 1];
		
		//create a for loop to iterate through array to assign values to all the elements
		for(int i = 0; i < newArray.length; i++) {
			
			//for elements at indices less than the given position, copy the elements from the originalArray
			//otherwise, if the index is equal to the position, set element to given value
			//otherwise, for elements at indices greater than the given position, copy the remaining from the originalArray	
			if(i < position) {
				newArray[i] = originalArray[i];
			}
			else if(i == position) {
				newArray[i] = value;
			}
			else {
				newArray[i] = originalArray[i-1];
			}//end if
		}//end for
		
		return newArray;
	}//end insertElement method

	/**
	 * Method Name: print
	 * Description: prints each element in the array to the screen with a space between
	 * 				each element.
	 * Parameters: int [] array
	 * Returns: void
	 */
	public static void print(int [] array) {
		
		//print first element
		System.out.print(array[0]);
		
		//create for loop to print the rest of the elements with a space in front of each
		for(int i = 1; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}//end print method
	
	//Created by Mrs McCafferrey
	/**
	 * Method Name: printArrayToFile
	 * Description: Prints each element in an array to a file on a single line, separated by commas
	 * Parameters: PrintWriter, the printWriter variable tells the method where to print
	 * 				int [], the array containing the elements to be printed
	 * Returns: n/a
	 */
	public static void printArrayToFile(PrintWriter myOutput, int [] array)
	{	
		//prints first line
		myOutput.print(array[0]);
		
		// prints the rest of the elements separated by commas and spaces
		for (int i = 1; i<=array.length-1; i++)
		{
			myOutput.print(", "+ array[i]);
		} 
		myOutput.println(); //brings cursor to a new line
		
	}// ends printArrayToFile method
	
	//Created by Mrs. McCafferrey
	/**
	 * Method Name: printArrayToFile
	 * Description: Prints each element in an array to a file on a single line, separated by commas
	 * Parameters: PrintWriter, the printWriter variable tells the method where to print
	 * 				String [], the array containing the elements to be printed
	 * Returns: n/a
	 */
	public static void printArrayToFile(PrintWriter myOutput, String [] array) 
	{	
		//prints first line
		myOutput.print(array[0]);
		
		// prints the rest of the elements separated by commas and spaces
		for (int i = 1; i<=array.length-1; i++)
		{
			myOutput.print(", "+ array[i]);
		}
		myOutput.println(); //brings cursor to a new line
		
	}// ends printArrayToFile method

	/**
	 * Method Name: replaceElement
	 * Description: Replaces the element at index ‘position’ with the indicated ‘value’.
	 * Parameters: int [] array, int value, int position
	 * Returns: void
	 */
	public static void replaceElement(int [] array, int value, int position) {
		
		//set element at index 'position' in the array equal to the value
		array[position] = value;
	}//end replaceElement method
	
	/**
	 * Method Name: replaceElements
	 * Description: Replaces all elements of the original value with the new value.
	 * Parameters: int [] array, int originalValue, int newValue
	 * Returns: void
	 */
	public static void replaceElements(int [] array, int originalValue, int newValue) {
		
		//iterate through array
		for(int i = 0; i < array.length; i++) {
			
			//if current element equal the originalValue, replace it with the newValue
			if(array[i] == originalValue) {
				array[i] = newValue;
			}
		}//end for loop
		
	}//end replaceElements method
	
	/**
	 * Method Name: sortHighToLow
	 * Description: Creates a new array where the values from the original array are sorted from
	 * 				the Highest value to the Lowest value.
	 * Parameters: int [] originalArray
	 * Returns: int [] newArray
	 */
	public static int[] sortHighToLow(int [] originalArray) {
		 
		//create new array that is the length of the originalArray
		int [] newArray = new int[originalArray.length];
		
		//create for loop to iterate through the newArray and assign values to elements
		for(int i = 0; i < newArray.length; i++) {
			
			//assign the current max of the originalArray to the element at index i of newArray
			newArray[i] = originalArray[findMax(originalArray)];
			
			//delete the max from the original array
			originalArray = deleteElement(originalArray, findMax(originalArray));
		}//end for
		
		return newArray;
	}//end sortHighToLow method

	/**
	 * Method Name: sortLowToHigh
	 * Description: Creates a new array where the values from the original array are sorted
	 * 				from the Lowest value to the Highest value.
	 * Parameters: int [] originalArray
	 * Returns: int [] newArray
	 */
	public static int[] sortLowToHigh(int [] originalArray) {
		 
		//create new array that is the length of the originalArray
		int [] newArray = new int[originalArray.length];
		
		//create for loop to iterate through the newArray and assign values to elements
		for(int i = 0; i < newArray.length; i++) {
			
			//assign the current min of the originalArray to the element at index i of newArray
			newArray[i] = originalArray[findMin(originalArray)];
			
			//delete the current min from the original array
			originalArray = deleteElement(originalArray, findMin(originalArray));
		}//end for
		
		return newArray;
	}//end sortLowToHigh method

	/**
	 * Method Name: swapElements
	 * Description: swaps the values at index position1 with index position2.
	 * Parameters: int [] array, int position1, int position2
	 * Returns: void
	 */
	public static void swapElements(int [] array, int position1, int position2) {
		
		//store one element temporarily to swap
		int temp = array[position1];
		
		//swap elements
		array[position1] = array[position2];
		array[position2] = temp;
		
	}//end swapElements method

}//end class