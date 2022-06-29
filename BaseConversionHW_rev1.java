// Lince Rumainum
// Advanced Java
// OCCC Fall 2017
// Base Conversion Assignment
// NOTE: This version does NOT use BigInteger data type

/*
Links used for this assignment:
https://stackoverflow.com/questions/4047808/what-is-the-best-way-to-tell-if-a-character-is-a-letter-or-number-in-java-withou
http://www.fredosaurus.com/notes-java/data/numbers/10biginteger.html
*/

import java.util.Scanner;
import java.math.BigInteger;
import java.lang.String;

public class BaseConversionHW {
	public static void main (String [] args){
		String initialValue = "";
		String initialBase = "";
		String finalBase = "";
		String finalValue = "";
		
		System.out.println("Welcome to Base Conversion Application!");
		
		// Check if there are 3 input 
		if ( args.length == 3 ) {
			initialValue = args [0];
			initialBase = args [1];
			finalBase = args [2];
		}
		// If there aren't 3 input then prompt for each input
		else if ( args.length == 0 ){
			Scanner s = new Scanner (System.in);
			System.out.print("Please enter initial value: ");
			initialValue = s.nextLine();
			System.out.print("Please enter initial base: ");
			initialBase = s.nextLine();
			System.out.print("Please enter final base: ");
			finalBase = s.nextLine();
		}
		else {
			System.out.println("Usage: java BaseConversionHW [initialValue," +
				" initialBase, finalBase]" );
			System.exit(0);
		}
	
		// Change the value of initialBase and finalBase to integer
		int iBase = Integer.parseInt(initialBase);
		int fBase = Integer.parseInt(finalBase);
		initialValue = initialValue.toUpperCase();
		
		// Validating the user's input
		boolean isValidInput = isValidInteger ( initialValue, iBase );
		
		if (isValidInput == true ){
			finalValue = convertInteger(initialValue, iBase, fBase);
		}
		else {
			System.out.println("Invalid initial value. Alphanumeric only."); 
			System.out.println("Please do not use space or any special character(s).");	
			System.exit(0);				
		}
		
		// Print out the result 
		System.out.println("Converting " + initialValue + " from base " + 
			initialBase + " to base " + finalBase + ": " + finalValue + ".");
	}
	
	public static boolean isValidInteger (String theValue, int theBase){
		// contract: returns true if theInteger is a valid expression in theBase; 
		// false otherwise.
		boolean isValidInteger = false;
		String acceptedValue = ""; // the value that is accepted according to the initial base
		int initialAlphaValue = 65; // alphaValue start from 'A'		
		
		if ( theBase >= 2 && theBase <=36 ){
			for (int i = 0; i < theBase; ++i){
				if ( i < 10){
					acceptedValue += (char) ((int) i + (int) '0');
				}
				else {
					acceptedValue += (char) initialAlphaValue;
					initialAlphaValue++;
				}
			}
		}
		else {
			System.out.println("Invalid initial base input.");
			System.out.println("Initial base input should be between 2 and 36.");
			System.exit(0);
		}		
		
		// Validating each character in the input value according to the initial base input
		for ( int i = 0; i < theValue.length(); ++i){
			isValidInteger = false; // Always assume it is false to begin with			
			for ( int j = 0; j < acceptedValue.length(); ++j){
				if ( theValue.charAt(i) == acceptedValue.charAt(j) ){
					isValidInteger = true;
					break;
				}
			}
			if (isValidInteger == false ){
				break;
			}
		}
		
		//System.out.println("isValidInteger = "+ isValidInteger);
		
		return isValidInteger;
	}
	
	public static String convertInteger(String theValue, int initialBase, int finalBase){
		// contract: converts theInteger from initialBase to finalBase and returns the
		// result as a String.
		// precondition: theValue must be a valid expression in initialBase.
		
		String finalBaseValue = "";
		String reverseFinalValue = "";
		String finalValue = "";
		int initialAlphaValue = (int) 'A'; // alphaValue start from 'A'		
		
		if ( finalBase >= 2 && finalBase <=36 ){
			for (int i = 0; i < finalBase; ++i){
				if ( i < 10){
					finalBaseValue += (char) ((int) i + (int) '0');
				}
				else {
					finalBaseValue += (char) initialAlphaValue;
					initialAlphaValue++;
				}
			}
		}
		else {
			System.out.println("Invalid final base input.");
			System.out.println("Final base input should be between 2 and 36.");
			System.exit(0);
		}		
		
		int charDecimalValue = 0;
		int j = 0; // the initial value for base to the power of zero, e.g.: initialBase^j
		BigInteger biTotaDecimalValue = BigInteger.valueOf(0);		
		
		//Converting to decimal value
		for (int i = theValue.length()-1 ; i >= 0 ; --i){
			//System.out.println("theValue.charAt(" + i +") = " + theValue.charAt(i));
			if ( Character.isDigit(theValue.charAt(i))){
				charDecimalValue = (int) theValue.charAt(i) - (int) '0';				
			}
			else if ( Character.isLetter(theValue.charAt(i))){
				charDecimalValue = (int) theValue.charAt(i) - (int) 'A' + 10;
			}
			else{
			System.out.println("Invalid final base input.");
			System.out.println("Final base input should be between 2 and 36.");
			System.exit(0);
			}
			//System.out.println("charDecimalValue = " + charDecimalValue);
			
			BigInteger iBaseTotal = BigInteger.valueOf(1); // because anything to the power of 0 equal to 1
			if ( j > 0 ) {
				for (int k = 0; k < j; ++k){
					iBaseTotal = iBaseTotal.multiply(BigInteger.valueOf(initialBase));
				}
			}
			
			//System.out.println("iBaseTotal = " + iBaseTotal);
			
			BigInteger biCharDecimalValue = BigInteger.valueOf(charDecimalValue);
			
			biTotaDecimalValue = biTotaDecimalValue.add(biCharDecimalValue.multiply(iBaseTotal));
			
			//totaDecimalValue += (charDecimalValue * Math.pow(initialBase,j));
			//System.out.println("biTotaDecimalValue = " + biCharDecimalValue + " * " + initialBase + "^" + j + " = " + biTotaDecimalValue);
			j++;
		}
		
		// BigInteger good = BigInteger.valueOf(2000000000);
		//"good.add(BigInteger.ONE) = " + good.add(BigInteger.ONE));
		//good.multiply(BigInteger.valueOf(3))
		
		//Converting from decimal value into the final base value
		BigInteger calculation = biTotaDecimalValue;
		BigInteger mod = BigInteger.valueOf(0);
		
		//System.out.println("Calculation = " + calculation);
		//BigInteger bi = BigInteger.valueOf(myInteger.intValue());
		do{
			//Using BigInteger to store all the value in calculation
			BigInteger fBase = BigInteger.valueOf(finalBase);
			BigInteger charDecimalValue2 = BigInteger.valueOf(0);
			
			//mod = calculation % fBase;
			mod = calculation.mod(fBase);
			//System.out.println("Mod = " + calculation + " % " + fBase + " = " + mod);
			calculation = calculation.divide(fBase);			
			//System.out.println("Calculation = " + calculation);
			
			if (mod.intValue() > 9){
				BigInteger biTen = BigInteger.valueOf(10);
				BigInteger biA = BigInteger.valueOf((int)'A');
				charDecimalValue2 = biA.add(mod.subtract(biTen));
			}
			else{
				BigInteger biZero = BigInteger.valueOf((int)'0');
				charDecimalValue2 = mod.add(biZero);
			}
			// Putting back the value into integer data type
			charDecimalValue = charDecimalValue2.intValue();
			// Storing the character into string reverseFinalValue
			reverseFinalValue += (char) charDecimalValue;	

			//System.out.println("reverseFinalValue = " + reverseFinalValue);
		} while(calculation.compareTo(BigInteger.valueOf(0)) > 0); // DO NOT USE (calculation.intValue() > 0)
		
		//Reversing the reverseFinalValue to get the actual final value		
		for (int i = reverseFinalValue.length()-1 ; i >= 0 ; --i){
			finalValue += reverseFinalValue.charAt(i);			
		}		
		//System.out.println("finalValue = " + finalValue);
		return finalValue;
	}
}