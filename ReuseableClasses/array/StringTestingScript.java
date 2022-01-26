/* Student Test Script for String - Console Only
 * Nov 17, 2021
 * Update to include file output for results
 */
package array;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

// This test script checks the new String versions of the methods in the arrays class

public class StringTestingScript
{
	public static void main (String [] args) throws IOException 
	{
		//Collects the student name so the file can be written with their name
		Scanner myInput = new Scanner (System.in);
		System.out.println("Please enter your first name and last name initial (no spaces)");
		String name = myInput.nextLine();
		String filename = "Array_Class_StringTest_"+name+".txt";

		//creates the ability to write to a file
		FileWriter myWriter = new FileWriter(filename);
		PrintWriter myOutput = new PrintWriter(myWriter);

		//tests create user defined String array, print
		String [] s1 = {"pineapple", "plum", "orange", "grapes", "apple", "banana"};
		String [] s2 = {"pineapple", "pear", "orange", "grapes", "apple", "banana"};
		System.out.println("Testing 'Create empty string array' and 'print' \n\tShould see list of fruit printed once and then in reverse");
		Array.print(s1);
		//Test create user defined string array
		String [] s3 = Array.createEmptyStringArray(6);
		s3 = Array.reverse(s1);
		Array.print(s3);

		//tests copy and checks if its identical
		boolean check1;
		boolean check2;
		String [] s4 = Array.copyArray(s1);
		check1 = Array.checkIfCopy(s1, s4);
		check2 = Array.checkIfIdentical(s2, s4);
		System.out.println("\nTesting 'duplicate array' and 'identical' \n\tShould see true, false");
		System.out.println(check1 + ", " + check2);

		//tests insert and delete
		String [] s5 = Array.insertElement(s2, "pear",s2.length-1);

		String [] s6 = Array.deleteElement(s5, Array.findElement("banana",s5));
		System.out.println("\nTesting 'insert element' and 'delete element'\n\tShould see fruit array with 2 pears and no bananas or plums");
		Array.print(s6);

		// tests 'contains', 'elementCount', 'largest', 'smallest'
		System.out.println("\nTesting 'contains', 'element count', 'largest', smallest\n\tShould see Largest: plum, Smallest: apple, Contains: -1, 1, 1, Counts 0, 1, 2");
		System.out.println("Largest: " + s1[Array.findMax(s1)] + ", Smallest: " + s1[Array.findMin(s1)]);
		System.out.println("Contains: " + Array.findElement("pear", s1) + ", " + Array.findElement( "pear", s2) + ", " + Array.findElement("pear", s5));
		System.out.println("Counts: " + Array.countElements("pear", s1) + ", " + Array.countElements("pear", s2) + ", " + Array.countElements("pear", s5));

		// closes the scanner before exiting
		myInput.close();
		
	}//end main method
}// end ArrayTesting class





