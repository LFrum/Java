/*
Lince Rumainum
Advanced Java
Dr. Goulden
OCCC Fall 2017
Palindromes Assignment
Week 2
*/

/*
Links used for this assignment:
Textbook Introduction to Java Programming, Y. Daniel Yang, Chapter 9
Textbook Introduction to Java Programming, Y. Daniel Yang, Chapter 9 Section 4
*/

import java.util.Scanner;
import java.lang.*;
import java.lang.StringBuilder;

public class PalindromesHW {
	
	public static boolean isPalindrome = false;
		
	public static void main (String [] args){
		String userInput = "";
		String nonSpaceInput = "";
		String SpaceIncludedInput = "";
		
		boolean isStrictPalindrome = false;
		boolean isOrdinaryPalindrome = false;
		
		System.out.println("Welcome to Palindromes Verification Application!");
		
		// Check if there are 1 input 
		if ( args.length == 1 ) {
			userInput = args [0]; // this input works for only one word without space
		}
		else {
			Scanner s = new Scanner (System.in);
			System.out.println("Please enter word or sentence to verify if it is a palindrome: ");
			userInput = s.nextLine();
		}
		
		while ( userInput.equals(null) || userInput.equals("") ){
			Scanner s = new Scanner (System.in);
			System.out.println("There was no input!");
			System.out.println("Please enter word or sentence to verify if it is a palindrome: ");
			userInput = s.nextLine();
		}
		
		// Convert user's input to upper case only characters
		userInput = userInput.toUpperCase();		
		
		// Convert user's input to alphanumeric & space characters only sentence
		SpaceIncludedInput = spaceIncludedSentence(userInput);
		// Test if the user's input is a strict palindrome
		isStrictPalindrome = testSentence(SpaceIncludedInput);
		
		// Strict Palindromes
		if (isStrictPalindrome == true ){
			System.out.println();
			System.out.println("The sentence is a STRICT palindrome!");
			System.out.println();
			System.out.println("The verified sentence (space included & no special characters):");
			System.out.println(SpaceIncludedInput);
		}
		else {
			// Convert user's input to alphanumeric only sentence
			nonSpaceInput = noSpaceSentence (SpaceIncludedInput);
			// Test if the user's input is a ordinary palindrome
			isOrdinaryPalindrome = testSentence (nonSpaceInput);
			
			if (isOrdinaryPalindrome == true ){
				System.out.println();
				System.out.println("The sentence is an ORDINARY palindrome!");
				System.out.println();
				System.out.println("The verified sentence (no special characters & no spaces):");
				System.out.println(nonSpaceInput);				
			}
			else{
				System.out.println("The sentence is NOT a palindrome!");
				System.exit(0);
			}
		}
	}	
	
	public static String spaceIncludedSentence(String initialSentence){
		// Create a string builder
		StringBuilder stringBuilder = new StringBuilder();
				
		// Build string of alphanumeric & space characters only
		for (int i = 0; i < initialSentence.length(); ++i){
			if ( Character.isLetterOrDigit(initialSentence.charAt(i)) || Character.isSpaceChar(initialSentence.charAt(i)) ){
				stringBuilder.append(initialSentence.charAt(i));
			}
		}
		String newSentence = stringBuilder.toString();
		return newSentence;	
	}
	
	public static String noSpaceSentence(String initialSentence){
		// Create a string builder
		StringBuilder stringBuilder = new StringBuilder();
				
		// Build string of alphanumeric characters only
		for (int i = 0; i < initialSentence.length(); ++i){
			if ( Character.isLetterOrDigit(initialSentence.charAt(i)) ){
				stringBuilder.append(initialSentence.charAt(i));
			}
		}
		String newSentence = stringBuilder.toString();
		return newSentence;	
	}
	
	public static boolean testSentence(String alphanumSentence){
		int index = 0;
		int lastCharIndex = alphanumSentence.length() - 1; // last index of alphanumSentence		
		char lastChar = alphanumSentence.charAt(lastCharIndex); // last char of alphanumSentence		
		
		// Base case
		if (index == lastCharIndex){
			isPalindrome = true;
		}		
		else if (alphanumSentence.charAt(index) == alphanumSentence.charAt(lastCharIndex) ) {			
			if (lastCharIndex < 2) {
				isPalindrome = true;
			}
			// Recursive case
			else {
				// take out the first and last characters in the string
				alphanumSentence =   alphanumSentence.substring(1, alphanumSentence.length() - 1);				
				testSentence(alphanumSentence);
			}		
		}
		else {
			isPalindrome = false;
		}
		
		return isPalindrome;	

	}
}