package grade12_final;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner myInput = new Scanner(System.in);
		
double height = myInput.nextDouble();
double base = myInput.nextDouble();
		
		try{
height = 67*2/3.0;

System.out.println(height);

		}
		catch(Exception e) {
			
			System.out.println("Looks like an error occurred while trying to run your program");
		
		}
	
	
	}
	
	
}

