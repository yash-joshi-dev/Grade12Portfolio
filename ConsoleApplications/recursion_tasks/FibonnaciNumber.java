/*
 * Name: Yash Joshi
 * Teacher: Mrs. McCafferey
 * Course: ICS4U
 * Description: This program recursively calculates the nth term of the Fibonacci sequence.
 */

package recursion_tasks;

import java.util.Scanner;
import input_validation.InputValidation;

public class FibonnaciNumber {
	
	//memo table to store intermediate results
	static int[] memo;
	
	public static void main(String[] args) {
		
		//create new instance of scanner
		Scanner myInput = new Scanner(System.in);
		
		//take in the term that the user would like, and validate its between 0 and 46 (the range of n that the fibNum function can handle)
		System.out.println("Please enter the term of the Fibonacci sequence you would like (only between 1 and 46): ");
		int n = InputValidation.intInputValidation(1, 46);
		memo = new int[n+1];
		
		//measure start time for recursive
		long startRecTime = System.nanoTime();
		
		//output the number calculated recursively
		System.out.println("Recursively: The Fibonacci number at term number " + n + " is: " + fibRecNum(n));
		
		//measure end time for recursive
		long endRecTime = System.nanoTime();
		
		//measure start time for loops
		long startLoopTime = System.nanoTime();
		
		//output the number calculated iteratively
		System.out.println("Iteratively: The Fibonacci number at term number " + n + " is: " + fibLoopNum(n));
		
		//measure end time for loops
		long endLoopTime = System.nanoTime();
		
		//output end times
		System.out.println("Recursive: It took " + (endRecTime - startRecTime) + " nanoseconds for the program to run.");
		System.out.println("Iteratively: It took " + (endLoopTime - startLoopTime) + " nanoseconds for the program to run.");
		
	}//end main
	
	/**
	 * Returns the Fibonacci number for a specific term by calculating it RECURSIVELY. Can only input n that is less than 47 
	 * (at 47 and above, strange negative numbers are outputted).
	 * @param n the term number of the Fibonacci sequence to calculate.
	 * @return the number in the Fibonacci sequence at that term number.
	 */
	public static int fibRecNum(int n) {
		
		//base case: if n is 2 or 1, return 1
		if(n < 3) return 1;
		
		//if already in memo table, retrieve value from memo table
		if(memo[n] != 0) return memo[n];
		
		//otherwise, calculate and store value, and return it
		memo[n] = fibRecNum(n-1) + fibRecNum(n-2);
		return memo[n];
		
	}//end fibRecNum
	
	/**
	 * Returns the Fibonnaci number for a specific term by calculating it using a LOOP. Can only input n that is less than 47
	 * (at 47 and above, strange negative numbers are outputted).
	 * @param n the term number of the Fibonacci sequence to calculate.
	 * @return the number in the Fibonacci sequence at the term number.
	 */
	public static int fibLoopNum(int n) {
		
		//if n is 1 or 2, return 1
		if(n < 3) return 1;
		
		//otherwise, keep track of three variables to calculate the fibonacci term using the loop; f1, f2, f3
		int f1 = 1;
		int f2 = 1;
		int f3 = 0;
		
		//iterate from 2 to n, calculating the number for the term and storing it f3, and storing the previous two number in f1 and f2
		for(int i = 3; i <= n; i++) {
			
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
			
		}//end for
		
		return f3;
		
	}//end fibLoopNum
	
}//end class
