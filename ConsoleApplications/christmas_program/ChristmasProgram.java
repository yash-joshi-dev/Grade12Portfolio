/*
 * Name: Yash Joshi
 * Teacher: Mrs. McCafferey
 * Course: ICS4U
 * Description: This program allows the user to create and store a Christmas list with names of people to buy items for, items to buy
 * 				and items to purchase, with their corresponding costs.
 */

package christmas_program;

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

import input_validation.InputValidation;
import array.Array;

public class ChristmasProgram {

	public static void main(String[] args) throws IOException {
		
		//create new instance of scanner object
		Scanner myInput = new Scanner(System.in);
		
		//declare a variable to store the updating budget and original budget
		double budget = 0;
		double oriBudget = 0;
		
		//declare the arrays to store all the information for the the list (names, itemsToBuy, itemsToPurchase, and costs)
		String [] names;
		String [] [] itemsToBuy;
		String [] [] itemsToPurchase;
		double [] [] costs;
		
		//greet user and ask for total Christmas budget (save to variable called budget)
		println("Welcome to the Christmas List Creator!");
		println("Would you like to access an old list (1) or create a new one (2)? Enter your answer: ");
		int selection = InputValidation.intInputValidation(1,2);
		
		//create a while loop so that the program can switch to creating a new list for the user if the user selects to access
		//an old list but doesn't have one
		while(true) {
			
			//if they do want to access an old list, read all the information from the old list; otherwise, ask them to enter
			//all the information
			if(selection == 1) {
				
				//initialize the file and buffered readers (surround FileReader try catch so that if file not found, then can
				//print error message and move to creating a new list)
				FileReader reader;
				try {
					reader = new FileReader("ChristmasList.txt");
				}
				catch(Exception e) {
					println("Sorry, you do not have any previously created Christmas lists saved. Please create a new one.");
					selection = 2;
					continue;
				}//end try-catch block
				
				BufferedReader input = new BufferedReader(reader);
				
				//first read the lengths of the 1d names array and initialize that array
				int namesLength = Integer.parseInt(input.readLine());
				names = new String[namesLength];
				
				//initialize the rest of the arrays based on the length of the names array
				itemsToBuy = new String [names.length] [0];
				itemsToPurchase = new String [names.length] [0];
				costs = new double [names.length] [0];
				
				//initialize the length of each array in the 2d arrays by reading them from the file
				for(int i = 0; i < itemsToBuy.length; i++) {
					itemsToBuy[i] = new String[Integer.parseInt(input.readLine())];
				}
				
				for(int i = 0; i < itemsToPurchase.length; i++) {
					
					int length = Integer.parseInt(input.readLine());
					itemsToPurchase[i] = new String[length];
					costs[i] = new double[length];
				}
				
				//read in the budget and the original budget
				budget = Double.parseDouble(input.readLine());
				oriBudget = Double.parseDouble(input.readLine());
				
				//read in all the names
				for(int i = 0; i < names.length; i++)
					names[i] = input.readLine();
				
				//read in all the items to buy
				for(int i = 0; i < itemsToBuy.length; i++)
					for(int j = 0; j < itemsToBuy[i].length; j++)
						itemsToBuy[i][j] = input.readLine();
				
				//read in all the items to purchase and their respective costs
				for(int i = 0; i < itemsToPurchase.length; i++) {
					for(int j = 0; j < itemsToPurchase[i].length; j++) {
						itemsToPurchase[i][j] = input.readLine();
						costs[i][j] = Double.parseDouble(input.readLine());
					}//end for
				}//end for
				break;
			}
			else {
				
				//ask the user for the budget and save it to variables
				println("Please enter your Christmas shopping budget: ");
				budget = InputValidation.doubleInputValidation(0);
				oriBudget = budget;
				
				//initialize names array to be an empty array
				names = new String[0];
				
				//print message to ask for names and create a variable called name to store the name entered
				println("Please enter the names of the people you would like to shop for below. Once you are finished entering"
						+ " the names, enter 0 to stop.");
				
				String name;
				
				//add the name of each person onto the end of the array using a while loop; make the sentinel be 0
				//also put the upper while loop inside a while loop so that the person cannot enter 0 names
				while(true) {
					while (true) {
						name = myInput.nextLine();
						if(name.equals("0")) break;
						names = Array.insertElement(names, name, names.length);
					}//end while
					println();
					
					//if more than 0 names were entered then break, otherwise print error message and ask for names again
					if(names.length != 0) break;
					println("Sorry, you can't enter 0 names to make the Christmas List. Please enter at least 1 name: ");
				}
					
				//initialize the rest of the arrays based on the length of the names array
				itemsToBuy = new String [names.length] [0];
				itemsToPurchase = new String [names.length] [0];
				costs = new double [names.length] [0];
				
				break;
			}//end else
		}//end while
		
		//use a while loop to constantly display menu and ask for the user's option until the want to exit with a
		//boolean flag called exiting
		boolean exiting = false;
		
		while(!exiting) {
			
			//display the menu
			displayMenu();
			
			//ask user to enter an option and store in variable called choice
			println("Please enter your option: ");
			int choice = InputValidation.intInputValidation(1, 5);
			
			//use a switch case statement to call a method that completes a menu option action based on the user's choice
			switch(choice) {
				case 1: displayCurrentList(budget, oriBudget, names, itemsToBuy, itemsToPurchase, costs);
						break;
				case 2: Object[] updatedArrays = addNameToList(names, itemsToBuy, itemsToPurchase, costs);
						names = (String[]) updatedArrays[0];
						itemsToBuy = (String[][]) updatedArrays[1];
						itemsToPurchase = (String[][]) updatedArrays[2];
						costs = (double[][]) updatedArrays[3];
						break;
				case 3: addItemToName(names, itemsToBuy);
						break;
				case 4: budget =  purchaseItem(budget, names, itemsToBuy, itemsToPurchase, costs);
						break;
				case 5: println("Thank you for using the Christmas List creation tool! Your list has been saved!");
						saveList(names, itemsToBuy, itemsToPurchase, costs, budget, oriBudget);
						exiting = true;
						break;
				default: println("AN ERROR HAS OCCURRED!!!!");
			}//end switch
			
		}//end while
	}//end main
	
	/*
	 * Method Name: saveList
	 * Description: saves the user's Christmas list to a text file
	 * Parameters: String[] names, String[][] itemsToBuy, String[][] itemsToPurchase, double[][] costs, double budget, 
	 * 			   double oriBudget
	 * Returns: void
	 * Throws: IOException
	 */
	public static void saveList(String[] names, String[][] itemsToBuy, String[][] itemsToPurchase, double[][] costs,
			double budget, double oriBudget) throws IOException {

		//declare and initialize file and print writers
		FileWriter writer = new FileWriter("ChristmasList.txt");
		PrintWriter print = new PrintWriter(writer);
		
		//print all the lengths of the arrays to use as information while reading from the list in the future
		print.println(names.length);
		
		for(String [] arr: itemsToBuy) {
			print.println(arr.length);
		}
		
		for(String [] arr: itemsToPurchase) {
			print.println(arr.length);
		}
		//don't need to print the lengths for the costs because it is the same as the items to purchase
		//don't need to print the number of arrays in the itemsToBuy and itemsToPurchase arrays since they are the same
		//number as the length of the names array
		
		//print the original budget and then the new budget
		print.println(budget);
		print.println(oriBudget);
		
		//print all the names
		for(String name: names)
			print.println(name);
		
		//print all items to buy, items to purchase, and their respective costs
		for(String [] arr: itemsToBuy)
			for(String item: arr)
				print.println(item);
		
		for(int i = 0; i < itemsToPurchase.length; i++) {
			for(int j = 0; j < itemsToPurchase[i].length; j++) {
				print.println(itemsToPurchase[i][j]);
				print.println(costs[i][j]);
			}//end for
		}//end for
		
		//close the print writer
		print.close();
	}//end saveList method

	/*
	 * Method Name: println()
	 * Description: prints the given string and moves cursor to the next line
	 * Parameters: String text
	 * Returns: void
	 */
	public static void println(String text) {
		System.out.println(text);
	}
	
	/*
	 * Method Name: println()
	 * Description: prints a new line (hence, moving cursor to the next line)
	 * Parameters: n/a
	 * Returns: void
	 */
	public static void println() {
		System.out.println();
	}
	
	/*
	 * Method Name: displayMenu()
	 * Description: displays the menu options for the online shopping machine.
	 * Parameters: n/a
	 * Returns: void
	 */
	public static void displayMenu() {
		println("Christmas Shopping List Menu:");
		println("1. Display Current List");
		println("2. Add Name to List");
		println("3. Add Item to Name");
		println("4. Purchase Item");
		println("5. Exit");
	}
	
	/*
	 * Method Name: displayCurrentList()
	 * Description: displays the name of each person, each item left to purchase, items purchased along with its
	 * 				cost.
	 * Parameters: double budget, double oriBudget, String [] names, String [] [] itemsToBuy, String [] [] itemsToPurchase, double [] [] costs
	 * Returns: void
	 */
	public static void displayCurrentList(double budget, double oriBudget, String [] names, String [] [] itemsToBuy, String [] [] itemsToPurchase, double [] [] costs) {
		
		//declare number formatter object
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		println("Your Christmas List: ");
		println();
		
		//iterate through names array and print name and items to buy, items to purchase, and their costs for each person
		for(int i = 0; i < names.length; i++) {
			println("Person: " + names[i]);
			
			System.out.print("    -> Items To Buy: ");
			if(itemsToBuy[i].length > 0) {
				Array.print(", ", itemsToBuy[i]);
				println();
			}
			else println("None");
			
			System.out.print("    -> Items Purchased: ");
			if(itemsToPurchase[i].length > 0) {
				Array.print(", ", itemsToPurchase[i]);
				println();
			}
			else println("None");
			
			System.out.print("    -> Costs: ");
			if(costs[i].length > 0) {
				
				//print first cost
				System.out.print("$" + formatter.format(costs[i][0]));
				
				//iterate through array and print rest of the costs
				for(int j = 0; j < costs[i].length-1; j++) {
					System.out.print(", $" + formatter.format(costs[i][j]));
				}
			}
			else {System.out.print("N/A");}
			println("\n");
		}//end for
		
		//display the money spend and budget left
		println("Current Spent: $" + (oriBudget - budget));
		println("Budget Left: $" + budget);
	}//end displayCurrentList method
	
	/*
	 * Method Name: addNameToList()
	 * Description: adds a new name to the names list.
	 * Parameters: String [] names, String [] [] itemsToBuy, String [] [] itemsToPurchase, double [] [] costs
	 * Returns: Object[] updatedArrays
	 */
	public static Object[] addNameToList(String [] names, String [] [] itemsToBuy, String [] [] itemsToPurchase, double [] [] costs) {
		
		//create new instance of scanner object
		Scanner myInput = new Scanner(System.in);
		
		//ask the user to enter the new name
		println("Please enter the new name to add to the list: ");
		names = Array.insertElement(names, myInput.nextLine(), names.length);
		
		//add an extra array to itemsToBuy, itemsToPurchase, and costs multidimensional arrays to store the information
		//for the new person
		itemsToBuy = Array.insertElement(itemsToBuy, Array.createEmptyStringArray(0), names.length-1);
		itemsToPurchase = Array.insertElement(itemsToPurchase, Array.createEmptyStringArray(0), names.length-1);
		costs = Array.insertElement(costs, Array.createEmptyDoubleArray(0), names.length-1);
		
		//create array of objects to return and return all the updated arrays within it
		Object[] updatedArrays = {names, itemsToBuy, itemsToPurchase, costs};
		return updatedArrays;
		
	}//end addNameToList method
	
	/*
	 * Method Name: addItemToName()
	 * Description: adds an item to a particular individual.
	 * Parameters: String [] names, String [] [] itemsToBuy
	 * Returns: void
	 */
	public static void addItemToName(String [] names, String [] [] itemsToBuy) {
		
		//create new instance of scanner object
		Scanner myInput = new Scanner(System.in);
		
		//ask the user to specify the person they would like to add an item for
		println("Please specify the person you would like to add an item for: ");
		String person = InputValidation.choiceValidation(names);
		
		//ask the user to enter an item until they enter 0 (keep a counter of how many items they enter)
		println("Please enter the item(s) you would like to add for " + person + " (enter 0 when you are finished): ");
		int counter = 0;
		while(true) {
			
			//take in the input and check if 0; if it is break out of loop, else continue
			String item = myInput.nextLine();
			if(item.equals("0")) break;
			
			//find the name in the names array and use the position of that name to insert the item into the right array in
			//the 2d itemsToBuy array
			int position = Array.findElement(person, names);
			itemsToBuy[position] = Array.insertElement(itemsToBuy[position], item, itemsToBuy[position].length);
			counter++;
		}
		
		//if only one item was added, print message with item; else, print it with items
		if(counter == 1)
			println("The item was added.");
		else
			println("The " + counter + " items were added.");
			
	}//end addItemToName method

	/*
	 * Method Name: purchaseItem()
	 * Description: moves item from the to-buy list (for a person) to the purchased list.
	 * Parameters: int budget, String [] names, String [] [] itemsToBuy, String [] [] itemsToPurchase, double [] [] costs
	 * Returns: double newBudget
	 */
	public static double purchaseItem(double budget, String [] names, String [] [] itemsToBuy, String [] [] itemsToPurchase, double [] [] costs) {
		
		//create new instance of scanner object
		Scanner myInput = new Scanner(System.in);
		
		//ask the user to specify the person they would like to purchase an item for
		println("Please specify the person you would like to purchase an item for: ");
		String person = InputValidation.choiceValidation(names);
		
		//ask the user to specify the item that they would like to purchase for the specific person
		println("Please specify the item you would like to purchase for " + person + ": ");
		int personPosition = Array.findElement(person, names);
		String item = InputValidation.choiceValidation(itemsToBuy[personPosition]);
		
		//ask the user to enter the cost of the item
		println("Please specify the cost of the item: ");
		double cost = InputValidation.doubleInputValidation(0);
		
		
		//create a while loop to run while the cost is greater than the budget
		while(cost > budget) {
			
			//ask if the user wants to continue to purchase a different item or leave this option
			println("Would you like to purchase a different item (1) or leave this menu option (2)? Enter your answer: ");
			boolean answerIsYes = InputValidation.yesOrNoChecker();
			
			//if yes, than ask for item and cost again, else return the original budget and break out of the method
			if(answerIsYes) {
				
				//ask the user to specify the item that they would like to purchase for the specific person
				println("Please specify the item you would like to purchase for " + person + ": ");
				personPosition = Array.findElement(person, names);
				item = InputValidation.choiceValidation(itemsToBuy[personPosition]);
				
				//ask the user to enter the cost of the item
				println("Please specify the cost of the item: ");
				cost = InputValidation.doubleInputValidation(0);
			}
			else {
				return budget;
			}//end if
		}//end while
			
		//delete item from itemsToBuy list
		int itemPosition = Array.findElement(item, itemsToBuy[personPosition]);
		itemsToBuy[personPosition] = Array.deleteElement(itemsToBuy[personPosition], itemPosition);
		
		//insert the item into itemsToPurchase list and cost of item into costs list
		itemsToPurchase[personPosition] = Array.insertElement(itemsToPurchase[personPosition], item, itemsToPurchase[personPosition].length);
		costs[personPosition] = Array.insertElement(costs[personPosition], cost, costs[personPosition].length);
		
		//return new budget
		return (budget-cost);
	}//end purchaseItem method
	
}//end class
