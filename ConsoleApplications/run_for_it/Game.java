/* Name: Yash Joshi
 * Course: ICS 4U
 * Teacher: Mrs. McCafferey
 * Date: November 23, 2021
 * Description: This file runs the Run-For-It game; it asks the user for the number of player playing and then "rolls" six dice for each,
 * 				player. Then, if they receive points based on the rules of the game, it gives the player those points and displays their
 * 				current score. Finally, when one player reaches 100 points, it displays that they win and asks if the user would like to
 * 				play the game again.
 */

package run_for_it;

import java.util.*;

public class Game {

	public static void main(String[] args) throws InterruptedException {
		
		//create a while loop to run while the game is being played (run for each game)
		while(true) {
			
			//ask the user to enter the number of players in the game and store the number in a variable called input
			System.out.println("Welcome to Run For It!\n");
			System.out.println("Please enter the number of players participating: ");
			int input = InputValidation.posIntegerChecker();
			System.out.println("There are " + input + " players participating in the game.");
			System.out.println();
			
			//create an array to store the scores of all the players in the game
			int [] scores = Array.createEmptyIntArray(input);
			
			//create while loop to continuously go through the players array for each round of the game until someone wins
			//use a boolean flag called isDone to control the loop
			boolean isDone = false;
			
			while(!isDone) {
				
				//create a for loop to iterate through each element of the scores array
				for(int i = 0; i < scores.length; i++) {
					
					//stores the sorted rolls (in ascending order) for the player in a rolls array
					int [] rolls = Array.sortLowToHigh(rollSixTimes());
					
					//print the player's rolls
					System.out.println("Player " + (i + 1) + " rolls: ");
					Array.print(rolls);
					System.out.println();
					
					//if first roll isn't a 1, add no points for player; else if second roll isn't a 2, add no points again;
					//else, keep adding for however long the sequence is (starting from 1, going up by 1)
					if(rolls[0] != 1) {
						System.out.println("Sorry, you get no points! There is no sequence starting from 1, going up by"
								+ " 1 in your set of rolls!");
						System.out.println();
						
						//pause for one second
						Thread.sleep(1000);
						continue;
					}
					else {
						//count the number rolls that are in a sequence starting from 1 (use a variable called counter and 
						//lastNumber to do that)
						int counter = 0;
						int lastNumber = 1;
						for(int j = 1; j < rolls.length; j++) {
							if(rolls[j] - lastNumber == 1) {
								lastNumber = rolls[j];
								counter++;
							}//end if
						}//end for
						
						//if player got 0 points than display sorry message again, otherwise update player's score
						//and show how many points they got, and how many they have currently
						if(counter == 0) {
							System.out.println("Sorry, you get no points! There is no sequence starting from 1, going up by"
									+ " 1 in your set of rolls!");
							System.out.println();
							
							//pause for one second
							Thread.sleep(1000);
							continue;
						}
						else {
							//increase counter by one to count for the 1 at the beginning of the sequence and
							//add that number of fives to the current player's score
							scores[i] += (++counter)*5;
							System.out.println("Player " + (i+1) + " gets " + (counter*5) + " points!!!");
							System.out.println("Player " + (i+1) + " now has " + scores[i]+ " points!");
							System.out.println();
						
							//pause for one second
							Thread.sleep(1000);
						}//end if
					}//end if
					
					//check if the player has won; if they have break out of the for loop and inner while loop
					if(scores[i] >= 100) {
						System.out.println("Player " + (i+1) + " has WON!!!!");
						System.out.println();
						isDone = true;
						break;
					}//end if
				}//end for
			}//end while
			
			//ask the user if they would like to replay the game
			System.out.println("Would you like to play Run For It again? Please enter Y/N or yes/no: ");
			boolean replay = InputValidation.yesOrNoChecker();
			
			//if player wants to replay, then continue, otherwise break out of the loop
			if(replay) {
				System.out.println();
				continue;
			}
			else {
				System.out.println("Thank you for playing Run For It !!!!!!");
				break;
			}//end if
			
		}//end while (one loop goes through the entire game)
		
	}//end main
	
	/*
	 * Method Name: rollDice
	 * Description: generates a random integer between 1 and 6 and returns that
	 * Parameters: n/a
	 * Returns: int number
	 */
	public static int rollDice() {
		
		//create new random object
		Random randNumber = new Random();
		
		//generate a random integer between 1-6 and return it
		return randNumber.nextInt(6) + 1;
		
	}//end rollDice method
	
	/*
	 * Method Name: rollSixTimes
	 * Description: generates six random numbers using the rollDice method and returns and array of the numbers
	 * Parameters: n/a
	 * Returns: int [] numbers
	 */
	public static int[] rollSixTimes() {
		
		//create numbers array to store each number rolled
		int [] numbers = Array.createEmptyIntArray(6);
		
		//use for each loop to assign each element in numbers array to a randomly generated number between 1 and 6
		for(int i = 0; i < 6; i++) {
			numbers[i] = rollDice();
		}
		
		return numbers;
		
	}//end rollSixTimes method
}//end class





