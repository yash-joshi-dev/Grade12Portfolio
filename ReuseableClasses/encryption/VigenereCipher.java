package encryption;

import java.util.Scanner;

public class VigenereCipher 
{

	/*
	 * Author: Yash J
	 * Method Name: VigenereEncode
	 * Description: encrypts the input string using the Vigenere Cipher (with the inputted key)
	 * Parameters: Scanner in
	 * Returns: void
	 */
	public static void VigenereEncode(Scanner in) {
		
		//ask the user for the message they want to encrypt and turn it into all caps, remove all non-alphabetical letters,
		//and turn it into a char array
		System.out.println("Please enter the text you would like to encrypt using the Vigenere Cipher: ");
		String originalInput = in.nextLine();
		char [] input = originalInput.toUpperCase().replaceAll("[^A-Z]", "").toCharArray(); 
		
		//ask the user for the key to use to encrypt the message and also turn it into all caps, remove all non-alphabetical letters,
		//and turn it into a char array
		System.out.println("Please enter the key that you would like to use to encrypt your message: ");
		char [] key = in.nextLine().toUpperCase().replaceAll("[^A-Z]", "").toCharArray();
		
		//create output string to be an empty string (to concatenate letters onto it later)
		String output = "";
		
		//loop through each character of input string
		for(int i = 0; i < input.length; i++) {
			
			//first turn each character in the input and key into its 0-indexed position in the alphabet by subtracting 65 from
			//its ASCII code (since the ASCII codes for the all caps alphabet begins at 65) 
			int inputPos = (int) input[i] - 65;
			int keyPos = (int) key[i % key.length] - 65;
			
			//add the positions of the input char and key char to get the output characters position and then subtract
			//26 from it if it is larger than 25 (the position of Z in the alphabet)
			int outputPos = inputPos + keyPos;
			if(outputPos > 25) outputPos -= 26;
			
			//find the character at the outputPos index in the alphabet and concatenate that to the output string
			output += (char) (outputPos + 65);
		}
		
		//add back the original capitalization and punctuation of the original text
		output = PreserveCapitalization(originalInput, output.toCharArray());
		output = PreservePunctuation(originalInput, output.toCharArray());
		
		//print out the encrypted message
		System.out.println(output);
		
	}//end VigenereEncode method
	
	/*
	 * Author: Yash J
	 * Method Name: VigenereDecode
	 * Description: decrypts the encrypted message (encrypted using the Vigenere Cipher) with the inputted key
	 * Parameters: Scanner in
	 * Returns: void
	 */
	public static void VigenereDecode(Scanner in) {
		
		//ask the user for the message they want to decrypt and turn it into all caps, remove all non-alphabetical letters,
		//and turn it into a char array
		System.out.println("Please enter the text you would like to decrypt using the Vigenere Cipher: ");
		String originalInput = in.nextLine();
		char [] input = originalInput.toUpperCase().replaceAll("[^A-Z]", "").toCharArray(); 
		
		//ask the user for the key to use to decrypt the message and also turn it into all caps, remove all non-alphabetical letters,
		//and turn it into a char array
		System.out.println("Please enter the key to use to decrypt your message: ");
		char [] key = in.nextLine().toUpperCase().replaceAll("[^A-Z]", "").toCharArray();
		
		//create output string to be an empty string (to concatenate letters onto it later)
		String output = "";
		
		//loop through each character of input string
		for(int i = 0; i < input.length; i++) {
			
			//first turn each character in the input and key into its 0-indexed position in the alphabet by subtracting 65 from
			//its ASCII code (since the ASCII codes for the all caps alphabet begins at 65) 
			int inputPos = (int) input[i] - 65;
			int keyPos = (int) key[i % key.length] - 65;
			
			//subtract the positions of the input char and key char to get the output (decrypted) character's position and then add
			//26 from it if it is negative
			int outputPos = inputPos - keyPos;
			if(outputPos < 0) outputPos += 26;
			
			//find the character at the outputPos index in the alphabet and concatenate that to the output string
			output += (char) (outputPos + 65);
		}
		
		//add back the capitalization and punctuation of the original encrypted message
		output = PreserveCapitalization(originalInput, output.toCharArray());
		output = PreservePunctuation(originalInput, output.toCharArray());
		
		//print out the decrypted message
		System.out.println(output);
		
	}//end VigenereDecode method
	
	/*
	 * Author: Yash J
	 * Method Name: PreserveCapitalization
	 * Description: Takes the input text and creates a copy that reflects the capitalization of the original text.
	 * Parameters: String originalText, char [] inputText
	 * Returns: String capitalizedText
	 */
	public static String PreserveCapitalization(String originalText, char [] inputText) {
		
		//first, replace all uppercase letters with 'A' and lowercase letters with 'B'
		//then, remove all the non-alphabetical characters in the original text and turn it into a char array
		char [] originalArr = originalText.replaceAll("[A-Z]", "A").replaceAll("[a-z]", "B").replaceAll("[^A-Z]", "").toCharArray();
		
		//create string to output
		String output = "";
		
		//loop through the original text character array
		for(int i = 0; i < originalArr.length; i++) {
			
			//if the character in the original text is equal to 'B', add the lowercase version of the
			//character in the input text, at the same position, to the output
			//otherwise, just add the capitalized character of the input text to the output
			if(originalArr[i] == 'B') {
				output += Character.toLowerCase(inputText[i]);
			}
			else {
				output += inputText[i];
			}//end if
		}//end for
		
		return output;
	}//end PreserveCapitalization method
	
	/*
	 * Author: Yash J
	 * Method Name: PreservePunctuation
	 * Description: Takes the input text and creates a copy that reflects the punctuation of the original text.
	 * Parameters: String originalText, char [] inputText
	 * Returns: String puncuatedText
	 */
	public static String PreservePunctuation(String originalText, char [] inputText) {
		
		//create a char array of the originalText where its in all caps and all non-alphabetical letters have been replaced with %
		//also create a char array of the original version of the original text
		char [] copyText = originalText.toUpperCase().replaceAll("[^A-Z]", "%").toCharArray();
		char [] originalArr = originalText.toCharArray();
		
		//create empty string to output
		String output = "";
		
		//loop through the original text character array using a fast counter i and loop through the input text array using
		//a slow counter j
		int j = 0;
		for(int i = 0; i < originalArr.length; i++) {
			
			//if the character in the original message in non-alpabetical, add that to the output
			//otherwise, add the input text character to the output string and increment j by one
			if(copyText[i] == '%') {
				output += originalArr[i];
			}
			else {
				output += inputText[j];
				j++;
			}//end if
		}//end for
		
		return output;
	}//end PreservePunctuation method
}//end class
