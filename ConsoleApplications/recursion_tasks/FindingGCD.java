/*
 * Name: Yash Joshi
 * Teacher: Mrs. McCafferey
 * Course: ICS4U
 * Description: This program recursively finds the GCD of two numbers using Euler's theorem.
 */

package recursion_tasks;

import java.util.Scanner;

public class FindingGCD {

	public static void main(String[] args) {
		
		//create new instance of scanner
		Scanner myInput = new Scanner(System.in);
		
		//take in the term that the user would like
		System.out.println("Please enter the two numbers that you would like to find the GCD of: ");
		int m = myInput.nextInt();
		int n = myInput.nextInt();

		//output the number
		System.out.println("The GCD of " + m + " and " + n + " is: " + findGCD(m, n));

	}//end main
	
	/**
	 * Finds the greatest common divisor of two numbers (m and n) using Euler's theorem.
	 * @param m first number to find GCD of.
	 * @param n second number to find GCD of.
	 * @return the GCD of m and n.
	 */
	public static int findGCD(int m, int n) {
		
		//if equal return m
		if(m == n) return m;
		
		//if m is less than n, swap their values
		if(m < n) {
			int tmp = m;
			m = n;
			n = tmp;
		}
		
		return findGCD(m-n, n);
		
	}//end findGCD

}//end class
