/**
 * Name: Yash Joshi
 * Course: ICS4U
 * Teacher: Mrs. McCafferey
 * Date: November 16, 2021
 * Description: This class file (Array.java) completes the arrays tasks, since it hosts a variety of
 * 				basic methods to interact with/use arrays.
 */

package array;

import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/** 
 * This class array.java contains a variety of functions to manipulate and operate on arrays. All methods have been overloaded
 * for working with integers, doubles, and string, except for createRandomIntArray, which is specifically for integers. The
 * insertElement function has also been overloaded for working with multi-dimensional arrays of integers, doubles, and strings.
 * Many of these functions throw a NullPointerException and/or a ArrayIndexOutOfBoundsException depending on whether a null
 * array or an invalid index is passed.
 * @author Yash Joshi
 * @since December 2021
 */
public class Array {
	
	/**
	 * Compares the individual elements in each integer array and returns true if the arrays are the same. Also, returns false if
	 * both arrays are null.
	 * @param array1 - the first array to check
	 * @param array2 - the second array to check
	 * @return true if the arrays are copies of each other and false otherwise
	 */
	public static boolean checkIfCopy(int [] array1, int ... array2) {
		
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
	 * Compares the individual elements in each double array and returns true if the arrays are the same. Also, returns false if
	 * both arrays are null.
	 * @param array1 - the first array to check
	 * @param array2 - the second array to check
	 * @return true if the arrays are copies of each other and false otherwise
	 */
	public static boolean checkIfCopy(double [] array1, double ... array2) {
		
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
	 * Compares the individual elements in each string array and returns true if the arrays are the same. Also, returns false if
	 * both arrays are null.
	 * @param array1 - the first array to check
	 * @param array2 - the second array to check
	 * @return true if the arrays are copies of each other and false otherwise
	 */
	public static boolean checkIfCopy(String [] array1, String ... array2) {
		
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
	 * Compares the location of each integer array and identifies if they point to the same memory location.
	 * @param array1 - first array to check
	 * @param array2 - second array to check
	 * @return true if the arrays are identical and false otherwise
	 */
	public static boolean checkIfIdentical(int [] array1, int [] array2) {
		
		//if both array locations are equal, return true, otherwise, return false
		return (array1==array2);
		
	}//end checkIfIdentical method
	
	/**
	 * Compares the location of each double array and identifies if they point to the same memory location.
	 * @param array1 - first array to check
	 * @param array2 - second array to check
	 * @return true if the arrays are identical and false otherwise
	 */
	public static boolean checkIfIdentical(double [] array1, double [] array2) {
		
		//if both array locations are equal, return true, otherwise, return false
		return (array1==array2);
		
	}//end checkIfIdentical method

	/**
	 * Compares the location of each string array and identifies if they point to the same memory location.
	 * @param array1 - first array to check
	 * @param array2 - second array to check
	 * @return true if the arrays are identical and false otherwise
	 */
	public static boolean checkIfIdentical(String [] array1, String [] array2) {
		
		//if both array locations are equal, return true, otherwise, return false
		return (array1==array2);
		
	}//end checkIfIdentical method
	
	/**
	 * Makes a copy of the original integer array and returns the copy.
	 * @param originalArray - array to make the copy of
	 * @return the newly copied array
	 * @throws NullPointerException if the array is null.
	 */
	public static int[] copyArray(int ... originalArray) {
		
		//create new empty array of the length of the original array
		int [] newArray = new int[originalArray.length];
		
		//use for loop to assign each element of originalArray to elements of newArray
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = originalArray[i];
		}
		
		return newArray;
	}//end copyArray method
	
	/**
	 * Makes a copy of the original double array and returns the copy.
	 * @param originalArray - array to make the copy of
	 * @return the newly copied array
	 * @throws NullPointerException if the array is null.
	 */
	public static double[] copyArray(double ... originalArray) {
		
		//create new empty array of the length of the original array
		double [] newArray = new double[originalArray.length];
		
		//use for loop to assign each element of originalArray to elements of newArray
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = originalArray[i];
		}
		
		return newArray;
	}//end copyArray method

	/**
	 * Makes a copy of the original string array and returns the copy.
	 * @param originalArray - array to make the copy of
	 * @return the newly copied array
	 * @throws NullPointerException if the array is null.
	 */
	public static String[] copyArray(String ... originalArray) {
		
		//create new empty array of the length of the original array
		String [] newArray = new String[originalArray.length];
		
		//use for loop to assign each element of originalArray to elements of newArray
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = originalArray[i];
		}
		
		return newArray;
	}//end copyArray method
	
	/**
	 * Returns the number of times the integer ‘value’ is found in the integer array.
	 * @param value - the integer that you are counting the occurrences of
	 * @param array - the array in which you are counting the occurrences of the value
	 * @return the number of of occurrences of value in the array.
	 * @throws NullPointerException if the array is null.
	 */
	public static int countElements(int value, int ... array) {
		
		//create a variable to store the number of elements
		int numOfElements = 0;
		
		//iterate through array to see how many elements match the given value
		for(int element: array) {
			if(element == value) {
				numOfElements++;
			}//end if
		}//end for
		
		return numOfElements;
	}//end countElements method

	/**
	 * Returns the number of times the double ‘value’ is found in the double array.
	 * @param value - the double that you are counting the occurrences of
	 * @param array - the array in which you are counting the occurrences of the value
	 * @return the number of of occurrences of value in the array.
	 * @throws NullPointerException if the array is null.
	 */
	public static int countElements(double value, double ... array) {
		
		//create a variable to store the number of elements
		int numOfElements = 0;
		
		//iterate through array to see how many elements match the given value
		for(double element: array) {
			if(element == value) {
				numOfElements++;
			}//end if
		}//end for
		
		return numOfElements;
	}//end countElements method
	
	/**
	 * Returns the number of times the string ‘value’ is found in the String array.
	 * @param value - the String that you are counting the occurrences of
	 * @param array - the array in which you are counting the occurrences of the value
	 * @return the number of of occurrences of value in the array.
	 * @throws NullPointerException if the array is null.
	 */
	public static int countElements(String value, String ... array) {
		
		//create a variable to store the number of elements
		int numOfElements = 0;
		
		//iterate through array to see how many elements match the given value
		for(String element: array) {
			if(element.equalsIgnoreCase(value)) {
				numOfElements++;
			}//end if
		}//end for
		
		return numOfElements;
	}//end countElements method
	
	/**
	 * Returns an empty integer array of the size indicated.
	 * @param size - the length of the new array
	 * @return an empty integer array of the size indicated.
	 */
	public static int[] createEmptyIntArray(int size) {
		int [] array = new int[size];
		return array;
	}//end createEmptyIntArray method
	
	/**
	 * Returns an empty double array of the size indicated.
	 * @param size - the length of the new array
	 * @return an empty double array of the size indicated.
	 */
	public static double[] createEmptyDoubleArray(int size) {
		double [] array = new double[size];
		return array;
	}//end createEmptyDoubleArray method

	/**
	 * Returns an empty string array of the size indicated.
	 * @param size - the length of the new array
	 * @return an empty string array of the size indicated.
	 */
	public static String[] createEmptyStringArray(int size) {
		String [] array = new String[size];
		return array;
	}//end createEmptyIntArray method
	
	/**
	 * Returns array of size indicated filled with random integers between a given range.
	 * @param size - the length of the new array
	 * @param min - minimum random integer that can be generated
	 * @param max - maximum random integer that can be generated
	 * @return new array populated with random integers between min and max.
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
	 * Returns integer array of size indicated filled with information entered by the user.
	 * @param size - length of the new array
	 * @return new integer array populated with values entered by the user.
	 */
	public static int[] createUserDefinedIntArray(int size){
		
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
	}//end createUserDefinedIntArray method
	
	/**
	 * Returns double array of size indicated filled with information entered by the user.
	 * @param size - length of the new array
	 * @return new double array populated with values entered by the user.
	 */
	public static double[] createUserDefinedDoubleArray(int size){
		
		//create instance of scanner object and create empty array of specified size
		double [] array = new double[size];
		Scanner myInput = new Scanner(System.in);
		
		//create for loop to ask user for values to fill array
		for(int i = 0; i < array.length; i++) {
			
			//do error checking while asking for input
			while(true) {
				try {
					array[i] = myInput.nextDouble();
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
	}//end createUserDefinedDoubleArray method
	
	/**
	 * Returns string array of size indicated filled with information entered by the user.
	 * @param size - length of the new array
	 * @return new string array populated with values entered by the user.
	 */
	public static String[] createUserDefinedStringArray(int size){
		
		//create instance of scanner object and create empty array of specified size
		String [] array = new String[size];
		Scanner myInput = new Scanner(System.in);
		
		//create for loop to ask user for values to fill array
		for(int i = 0; i < array.length; i++) {
			array[i] = myInput.nextLine();
		}//end for
		
		return array;
	}//end createUserDefinedStringArray method
	
	/**
	 * Creates an integer array with size originalArray.length - 1 and deletes the integer element at index ‘position’.
	 * All other values >position, are shifted to index-1.
	 * @param originalArray - the array from which an element is to be deleted
	 * @param position - the index of the element to be deleted
	 * @return copy of the original array without the element that was at index 'position'.
	 * @throws NullPointerException if the originalArray is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the array.
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
	 * Creates an double array with size originalArray.length - 1 and deletes the double element at index ‘position’.
	 * All other values >position, are shifted to index-1.
	 * @param originalArray - the array from which an element is to be deleted
	 * @param position - the index of the element to be deleted
	 * @return copy of the original array without the element that was at index 'position'.
	 * @throws NullPointerException if the originalArray is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the array.
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
	 * Creates an string array with size originalArray.length - 1 and deletes the string element at index ‘position’.
	 * All other values >position, are shifted to index-1.
	 * @param originalArray - the array from which an element is to be deleted
	 * @param position - the index of the element to be deleted
	 * @return copy of the original array without the element that was at index 'position'.
	 * @throws NullPointerException if the originalArray is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the array.
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
	 * Returns the position of the first instance of the indicated value in an integer array. Returns -1 if the value is not found.
	 * @param value - the integer to find
	 * @param array - the array to find the specified integer in
	 * @return the index of the first instance of 'value' in array.
	 * @throws NullPointerException if the array is null.
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
	 * Returns the position of the first instance of the indicated value in an double array. Returns -1 if the value is not found.
	 * @param value - the double to find
	 * @param array - the array to find the specified double in
	 * @return the index of the first instance of 'value' in array.
	 * @throws NullPointerException if the array is null.
	 */
	public static int findElement(double value, double [] array) {
		
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
	 * Returns the position of the first instance of the indicated value in an string array. Returns -1 if the value is not found.
	 * @param value - the string to find
	 * @param array - the array to find the specified string in
	 * @return the index of the first instance of 'value' in array.
	 * @throws NullPointerException if the array is null.
	 */
	public static int findElement(String value, String [] array) {
		
		//iterate through array and return the index of the first element that matches value
		for(int i = 0; i < array.length; i++) {
			if(array[i].equalsIgnoreCase(value)) {
				return i;
			}//end if
		}//end for
		
		//if no match found, just return -1
		return -1;
	}//end findElements method

	/**
	 * Returns the position (index) of the maximum value in the integer array.
	 * @param array - the array to find the maximum value in
	 * @return the index of the maximum value.
	 * @throws NullPointerException if the array is null.
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
	 * Returns the position (index) of the maximum value in the double array.
	 * @param array - the array to find the maximum value in
	 * @return the index of the maximum value.
	 * @throws NullPointerException if the array is null.
	 */
	public static int findMax(double [] array) {
		
		//set max and position equal to the first element and index of the array
		double max = array[0];
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
	 * Returns the position (index) of the lexographically largest string in the array.
	 * @param array - the array to find the maximum value in
	 * @return the index of the maximum value.
	 * @throws NullPointerException if the array is null.
	 */
	public static int findMax(String [] array) {
		
		//set max and position equal to the first element and index of the array
		String max = array[0];
		int position = 0;
		
		//use for loop to go through elements, and compare elements to find the max and its position
		for(int i = 1; i < array.length; i++) {
			
			//if element is greater than max set before, set its value and index equal to 
			//the max and position, repectively
			if(array[i].compareTo(max) > 0) {
				max = array[i];
				position = i;
			}//end if
		}//end for loop
		
		return position;
	}//end findMax method

	/**
	 * Returns the position (index) of the minimum value in the integer array.
	 * @param array - the array to find the minimum value in
	 * @return the index of the minimum value.
	 * @throws NullPointerException if the array is null.
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
	 * Returns the position (index) of the minimum value in the double array.
	 * @param array - the array to find the minimum value in
	 * @return the index of the minimum value.
	 * @throws NullPointerException if the array is null.
	 */
	public static int findMin(double [] array) {
		
		//set min and position equal to the first element and index of the array
		double min = array[0];
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
	 * Returns the position (index) of the lexographically smallest value in the string array.
	 * @param array - the array to find the minimum value in
	 * @return the index of the minimum value.
	 * @throws NullPointerException if the array is null.
	 */
	public static int findMin(String [] array) {
		
		//set min and position equal to the first element and index of the array
		String min = array[0];
		int position = 0;
		
		//use for loop to go through elements, and compare elements to find the min and its position
		for(int i = 1; i < array.length; i++) {
			
			//if element is less than min set before, set its value and index equal to 
			//the min and position, repectively
			if(array[i].compareTo(min) < 0) {
				min = array[i];
				position = i;
			}//end if
		}//end for loop
		
		return position;
	}//end findMin method

	/**
	 * Creates an integer array with size originalArray.length +1 and inserts the element ‘value’ at index ‘position’.
	 * All other values >position, are shifted to index+1.
	 * @param originalArray - array to insert new integer into
	 * @param value - integer to be inserted into array
	 * @param position - index to insert value at
	 * @return new array with 'value' inserted at index 'position'.
	 * @throws NullPointerException if the originalArray is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the originalArray.
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
	 * Creates a double array with size originalArray.length +1 and inserts the element ‘value’ at index ‘position’.
	 * All other values >position, are shifted to index+1.
	 * @param originalArray - array to insert new double into
	 * @param value - double to be inserted into array
	 * @param position - index to insert value at
	 * @return new array with 'value' inserted at index 'position'.
	 * @throws NullPointerException if the originalArray is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the originalArray.
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
	 * Creates an string array with size originalArray.length +1 and inserts the element ‘value’ at index ‘position’.
	 * All other values >position, are shifted to index+1.
	 * @param originalArray - array to insert new string into
	 * @param value - string to be inserted into array
	 * @param position - index to insert value at
	 * @return new array with 'value' inserted at index 'position'.
	 * @throws NullPointerException if the originalArray is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the originalArray.
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
	 * Creates an 2d integer array with a size originalArray.length + 1 and inserts the array ‘array’ at index ‘position’.
	 * All other arrays > position, are shifted to index + 1.
	 * @param originalArray - the 2d array to insert new array into
	 * @param array - the integer array to be inserted into originalArray
	 * @param position - index to insert array at
	 * @return new 2d integer array with 'array' inserted at index 'position'.
	 * @throws NullPointerException if the originalArray is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the originalArray.
	 */
	public static int[][] insertElement(int [] [] originalArray, int [] array, int position) {
		
		//create empty array that has a size one greater than the length of the originalArray
		int [] [] newArray = new int[originalArray.length + 1] [0];
		
		//create a nested for loop to iterate through array to assign values to all the elements
		for(int i = 0; i < newArray.length; i++) {
			
			//for arrays at indices less than the given position, copy the arrays from the originalArray
			//otherwise, if the index is equal to the position, set that array equal to given array
			//otherwise, for arrays at indices greater than the given position, copy the remaining from the originalArray	
			if(i < position) {
				newArray[i] = originalArray[i];
			}
			else if(i == position) {
				newArray[i] = array;
			}
			else {
				newArray[i] = originalArray[i-1];
			}//end if
		}//end for
		
		return newArray;
	}//end insertElement method
	
	/**
	 * Creates an 2d double array with a size originalArray.length + 1 and inserts the array ‘array’ at index ‘position’.
	 * All other arrays > position, are shifted to index + 1.
	 * @param originalArray - the 2d array to insert new array into
	 * @param array - the double array to be inserted into originalArray
	 * @param position - index to insert array at
	 * @return new 2d double array with 'array' inserted at index 'position'.
	 * @throws NullPointerException if the originalArray is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the originalArray.
	 */
	public static double[][] insertElement(double [] [] originalArray, double [] array, double position) {
		
		//create empty array that has a size one greater than the length of the originalArray
		double [] [] newArray = new double[originalArray.length + 1] [0];
		
		//create a nested for loop to iterate through array to assign values to all the elements
		for(int i = 0; i < newArray.length; i++) {
			
			//for arrays at indices less than the given position, copy the arrays from the originalArray
			//otherwise, if the index is equal to the position, set that array equal to given array
			//otherwise, for arrays at indices greater than the given position, copy the remaining from the originalArray	
			if(i < position) {
				newArray[i] = originalArray[i];
			}
			else if(i == position) {
				newArray[i] = array;
			}
			else {
				newArray[i] = originalArray[i-1];
			}//end if
		}//end for
		
		return newArray;
	}//end insertElement method
	
	/**
	 * Creates an 2d string array with a size originalArray.length + 1 and inserts the array ‘array’ at index ‘position’.
	 * All other arrays > position, are shifted to index + 1.
	 * @param originalArray - the 2d array to insert new array into
	 * @param array - the string array to be inserted into originalArray
	 * @param position - index to insert array at
	 * @return new 2d string array with 'array' inserted at index 'position'.
	 * @throws NullPointerException if the originalArray is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the originalArray.
	 */
	public static String[][] insertElement(String [] [] originalArray, String [] array, int position) {
		
		//create empty array that has a size one greater than the length of the originalArray
		String [] [] newArray = new String[originalArray.length + 1] [0];
		
		//create a nested for loop to iterate through array to assign values to all the elements
		for(int i = 0; i < newArray.length; i++) {
			
			//for arrays at indices less than the given position, copy the arrays from the originalArray
			//otherwise, if the index is equal to the position, set that array equal to given array
			//otherwise, for arrays at indices greater than the given position, copy the remaining from the originalArray	
			if(i < position) {
				newArray[i] = originalArray[i];
			}
			else if(i == position) {
				newArray[i] = array;
			}
			else {
				newArray[i] = originalArray[i-1];
			}//end if
		}//end for
		
		return newArray;
	}//end insertElement method
	
	/**
	 * Prints each element in the integer array to the screen with a space between each element.
	 * @param array - the array from which elements are to be printed
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the array is of length 0.
	 */
	public static void print(int ... array) {
		
		//print first element
		System.out.print(array[0]);
		
		//create for loop to print the rest of the elements with a space in front of each
		for(int i = 1; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}//end print method
	
	/**
	 * Prints each element in the double array to the screen with a space between each element.
	 * @param array - the array from which elements are to be printed
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the array is of length 0.
	 */
	public static void print(double ... array) {
		
		//print first element
		System.out.print(array[0]);
		
		//create for loop to print the rest of the elements with a space in front of each
		for(int i = 1; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}//end print method
	
	/**
	 * Prints each element in the double array to the screen with the specified delimiter between each element.
	 * @param delimiter - the delimiter you want to use to separate the elements
	 * @param array - the array from which elements are to be printed
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the array is of length 0.
	 */
	public static void print(String delimiter, double ... array) {
		
		//print first element
		System.out.print(array[0]);
		
		//create for loop to print the rest of the elements with a space in front of each
		for(int i = 1; i < array.length; i++) {
			System.out.print(delimiter + array[i]);
		}
	}//end print method
	
	/**
	 * Prints each element in the string array to the screen with a space between each element.
	 * @param array - the array from which elements are to be printed
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the array is of length 0.
	 */
	public static void print(String ... array) {
		
		//print first element
		System.out.print(array[0]);
		
		//create for loop to print the rest of the elements with a space in front of each
		for(int i = 1; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}//end print method
	
	/**
	 * Prints each element in the string array to the screen with the specified delimiter between each element.
	 * @param delimiter - the delimiter you want to use to separate the elements
	 * @param array - the array from which elements are to be printed
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the array is of length 0.
	 */
	public static void print(String delimiter, String ... array) {
		
		//print first element
		System.out.print(array[0]);
		
		//create for loop to print the rest of the elements with a space in front of each
		for(int i = 1; i < array.length; i++) {
			System.out.print(delimiter + array[i]);
		}
	}//end print method
	
	/**
	 * Prints each element in an integer array to a file on a single line, separated by commas
	 * @author Mrs. McCafferey
	 * @param PrintWriter - the printWriter variable tells the method where to print
	 * @param array - the array containing the elements to be printed
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the array is of length 0.
	 */
	public static void printArrayToFile(PrintWriter myOutput, int ... array)
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
	 * Prints each element in a double array to a file on a single line, separated by commas
	 * @author Mrs. McCafferey
	 * @param PrintWriter - the printWriter variable tells the method where to print
	 * @param array - the array containing the elements to be printed
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the array is of length 0.
	 */
	public static void printArrayToFile(PrintWriter myOutput, double ... array)
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
	 * Prints each element in a string array to a file on a single line, separated by commas
	 * @author Mrs. McCafferey
	 * @param PrintWriter, the printWriter variable tells the method where to print
	 * @param array - the array containing the elements to be printed
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the array is of length 0.
	 */
	public static void printArrayToFile(PrintWriter myOutput, String ... array) 
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
	 * Replaces the element at index ‘position’ with the indicated ‘value’ in an integer array.
	 * @param array - the array in which an integer is to be replaced
	 * @param value - the integer to replace the element at index 'position'
	 * @param position - the index of the integer to replace
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the array.
	 */
	public static void replaceElement(int [] array, int value, int position) {
		
		//set element at index 'position' in the array equal to the value
		array[position] = value;
	}//end replaceElement method
	
	/**
	 * Replaces the element at index ‘position’ with the indicated ‘value’ in an double array.
	 * @param array - the array in which an double is to be replaced
	 * @param value - the double to replace the element at index 'position'
	 * @param position - the index of the integer to replace
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the array.
	 */
	public static void replaceElement(double [] array, double value, int position) {
		
		//set element at index 'position' in the array equal to the value
		array[position] = value;
	}//end replaceElement method
	
	/**
	 * Replaces the element at index ‘position’ with the indicated ‘value’ in an string array.
	 * @param array - the array in which an string is to be replaced
	 * @param value - the string to replace the element at index 'position'
	 * @param position - the index of the integer to replace
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the array.
	 */
	public static void replaceElement(String [] array, String value, int position) {
		
		//set element at index 'position' in the array equal to the value
		array[position] = value;
	}//end replaceElement method
	
	/**
	 * Replaces all elements of the original value with the new value in an integer array.
	 * @param array - the array in which elements are to be replaced
	 * @param originalValue - the integer to be replaced (completely)
	 * @param newValue - the integer to replace all occurrences of the originalValue
	 * @throws NullPointerException if the array is null.
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
	 * Replaces all elements of the original value with the new value in a double array.
	 * @param array - the array in which elements are to be replaced
	 * @param originalValue - the double to be replaced (completely)
	 * @param newValue - the double to replace all occurrences of the originalValue
	 * @throws NullPointerException if the array is null.
	 */
	public static void replaceElements(double [] array, double originalValue, double newValue) {
		
		//iterate through array
		for(int i = 0; i < array.length; i++) {
			
			//if current element equal the originalValue, replace it with the newValue
			if(array[i] == originalValue) {
				array[i] = newValue;
			}
		}//end for loop
		
	}//end replaceElements method
	
	/**
	 * Replaces all elements of the original value with the new value in a string array.
	 * @param array - the array in which elements are to be replaced
	 * @param originalValue - the string to be replaced (completely)
	 * @param newValue - the string to replace all occurrences of the originalValue
	 * @throws NullPointerException if the array is null.
	 */
	public static void replaceElements(String [] array, String originalValue, String newValue) {
		
		//iterate through array
		for(int i = 0; i < array.length; i++) {
			
			//if current element equal the originalValue, replace it with the newValue
			if(array[i] == originalValue) {
				array[i] = newValue;
			}
		}//end for loop
		
	}//end replaceElements method
	
	/**
	 * Reverses the order of the elements in an integer array.
	 * @param originalArray - the array to be reversed
	 * @return a copy of the originalArray with all the elements in reverse order
	 * @throws NullPointerException if the array is null.
	 */
	public static int[] reverse(int [] originalArray) {
		
		//create new array of the length of the original array
		int [] newArray = new int[originalArray.length];
		
		//iterate through the original array and set the values of the new array to the values of the original array while
		//iterating through the new array backwards
		for(int i = 0; i < originalArray.length; i++) {
			newArray[newArray.length-1-i] = originalArray[i];
		}
		
		return newArray;
	}//end reverse method
	
	/**
	 * Reverses the order of the elements in an double array.
	 * @param originalArray - the array to be reversed
	 * @return a copy of the originalArray with all the elements in reverse order
	 * @throws NullPointerException if the array is null.
	 */
	public static double[] reverse(double [] originalArray) {
		
		//create new array of the length of the original array
		double [] newArray = new double[originalArray.length];
		
		//iterate through the original array and set the values of the new array to the values of the original array while
		//iterating through the new array backwards
		for(int i = 0; i < originalArray.length; i++) {
			newArray[newArray.length-1-i] = originalArray[i];
		}
		
		return newArray;
	}//end reverse method
	
	/**
	 * Reverses the order of the elements in an string array.
	 * @param originalArray - the array to be reversed
	 * @return a copy of the originalArray with all the elements in reverse order
	 * @throws NullPointerException if the array is null.
	 */
	public static String[] reverse(String [] originalArray) {
		
		//create new array of the length of the original array
		String [] newArray = new String[originalArray.length];
		
		//iterate through the original array and set the values of the new array to the values of the original array while
		//iterating through the new array backwards
		for(int i = 0; i < originalArray.length; i++) {
			newArray[newArray.length-1-i] = originalArray[i];
		}
		
		return newArray;
	}//end reverse method
	
	/**
	 * Creates a new array where the values from the original integer array are sorted from the Highest value to the Lowest value.
	 * @param originalArray - the array to be sorted
	 * @return a copy of the originalArray sorted in descending order.
	 * @throws NullPointerException if the array is null.
	 */
	public static int[] sortHighToLow(int ... originalArray) {
		 
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
	 * Creates a new array where the values from the double original array are sorted from the Highest value to the Lowest value.
	 * @param originalArray - the array to be sorted
	 * @return a copy of the originalArray sorted in descending order.
	 * @throws NullPointerException if the array is null.
	 */
	public static double[] sortHighToLow(double ... originalArray) {
		 
		//create new array that is the length of the originalArray
		double [] newArray = new double[originalArray.length];
		
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
	 * Creates a new array where the values from the original string array are sorted from the Highest value to the Lowest value.
	 * @param originalArray - the array to be sorted
	 * @return a copy of the originalArray sorted in descending order.
	 * @throws NullPointerException if the array is null.
	 */
	public static String[] sortHighToLow(String ... originalArray) {
		 
		//create new array that is the length of the originalArray
		String [] newArray = new String[originalArray.length];
		
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
	 * Creates a new array where the values from the original integer array are sorted from the Lowest value to the Highest value.
	 * @param originalArray - the array to be sorted
	 * @return a copy of the originalArray sorted in ascending order.
	 * @throws NullPointerException if the array is null.
	 */
	public static int[] sortLowToHigh(int ... originalArray) {
		 
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
	 * Creates a new array where the values from the original double array are sorted from the Lowest value to the Highest value.
	 * @param originalArray - the array to be sorted
	 * @return a copy of the originalArray sorted in ascending order.
	 * @throws NullPointerException if the array is null.
	 */
	public static double[] sortLowToHigh(double ... originalArray) {
		 
		//create new array that is the length of the originalArray
		double [] newArray = new double[originalArray.length];
		
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
	 * Creates a new array where the values from the original string array are sorted from the Lowest value to the Highest value.
	 * @param originalArray - the array to be sorted
	 * @return a copy of the originalArray sorted in ascending order.
	 * @throws NullPointerException if the array is null.
	 */
	public static String[] sortLowToHigh(String ... originalArray) {
		 
		//create new array that is the length of the originalArray
		String [] newArray = new String[originalArray.length];
		
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
	 * Swaps the values at index position1 with index position2 in an integer array.
	 * @param array - the array in which the swap will occur
	 * @param position1 - the first position to swap from
	 * @param position2 - the second position to swap from
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the array.
	 */
	public static void swapElements(int [] array, int position1, int position2) {
		
		//store one element temporarily to swap
		int temp = array[position1];
		
		//swap elements
		array[position1] = array[position2];
		array[position2] = temp;
		
	}//end swapElements method
	
	/**
	 * Swaps the values at index position1 with index position2 in a double array.
	 * @param array - the array in which the swap will occur
	 * @param position1 - the first position to swap from
	 * @param position2 - the second position to swap from
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the position is not a valid index in the array.
	 */
	public static void swapElements(double [] array, int position1, int position2) {
		
		//store one element temporarily to swap
		double temp = array[position1];
		
		//swap elements
		array[position1] = array[position2];
		array[position2] = temp;
		
	}//end swapElements method
	
	/**
	 * Swaps the values at index position1 with index position2 in an string array.
	 * @param array - the array in which the swap will occur
	 * @param position1 - the first position to swap from
	 * @param position2 - the second position to swap from
	 * @throws NullPointerException if the array is null.
	 * @throws ArrayIndexOutOfBoundsException if the positions are not valid indexes in the array.
	 */
	public static void swapElements(String [] array, int position1, int position2) {
		
		//store one element temporarily to swap
		String temp = array[position1];
		
		//swap elements
		array[position1] = array[position2];
		array[position2] = temp;
		
	}//end swapElements method

}//end class