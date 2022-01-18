package finalproject;
import java.util.*;
public class Program {
public static void main(String[] args) {
try{
System.out.println("Hello");
}
catch(Exception e) {
System.out.println("Exception alert: it looks like an error occurred while running your program.");
}
}
public static double input() {
	Scanner myInput = new Scanner(System.in);
	String input = myInput.nextLine();
	double answer;
	
	if(input.contains("/")) {
		String num1String = input.substring(0, input.indexOf("/"));
		String num2String = input.substring(input.indexOf("/") + 1, input.length());
		
		double num1 = Double.valueOf(num1String);
		double num2 = Double.valueOf(num2String);
		
		answer = num1/num2;
	}
	else {
		answer = Double.valueOf(input);
	}	
	
	return answer;
	
}
public static void print(String string) {
	System.out.println(string);
}
public static void print(int num) {
	System.out.println(num);
}
public static void print(double num) {
	System.out.println(num);
}
}
