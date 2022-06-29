/*
Lince Rumainum
Advanced Java
Dr. Goulden
OCCC Fall 2017
Sieve of Eratosthenes Assignment
Week 3
*/

/*
Link(s) / book(s) used for this assignment:
Textbook Introduction to Java Programming, Y. Daniel Yang, Chapter 7
http://www.geeksforgeeks.org/sieve-of-eratosthenes/
https://www.cs.hmc.edu/~oneill/papers/Sieve-JFP.pdf
https://stackoverflow.com/questions/2582732/time-complexity-of-sieve-of-eratosthenes-algorithm/2582776
https://stackoverflow.com/questions/15004944/max-value-of-integer
*/

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.String;

public class SoEHW{     

	public static void main(String args[])
	{		
		int startInput = 0, endInput = 0;
		// Display a friendly greeting to the user.
		System.out.println("Welcome to Sieve of Eratosthenes Prime Number" + 
		"Method Application!");

		if ( args.length == 2 ){
			startInput = Integer.parseInt(args[0]);
			endInput = Integer.parseInt(args[1]);;
		}
		else {
			// Prompt user for input using scanner
			Scanner s = new Scanner (System.in);
			do{
				try{
					// Prompt the user for a start value > 1
					System.out.println("Please enter an integer > 1 for the");
					System.out.print("starting point of your prime numbers list: ");
					startInput = s.nextInt();
				}
				catch(InputMismatchException ime){
					System.out.println("Invalid Input! Integer only!");
					System.out.println(ime.toString());
					System.exit(0);
				}

				if (startInput < 2){
					System.out.println("Please enter an integer > 1!");
				}
			} while (startInput < 2);

			do{
				try{
					// Prompt the user for a stop value. This will be the size of the array + 1
					System.out.println("Please enter an integer for the stopping point"); 
					System.out.print("of your pontential prime numbers list: ");
					endInput = s.nextInt();
				}
				catch(InputMismatchException ime){
					System.out.println("Invalid Input! Integer only!");
					System.out.println(ime.toString());
					System.exit(0);
				}

				if (endInput < startInput){
					System.out.println("Please enter an integer >= " + startInput);
				}
			} while (endInput < startInput);
		}

		sieveOfEratosthenes(startInput, endInput);
	}

	public static void sieveOfEratosthenes(int startPoint, int endPoint)
	{
		// Use the stop value to create an array of type boolean and set every value to true.
		int isPrimeArraySize = endPoint + 1;

		boolean [] isPrime = new boolean[isPrimeArraySize];
		for(int i = 0; i < isPrimeArraySize; ++i){
			isPrime[i] = true;
		}

		for(int p = 2; p*p <= endPoint; p++){            
			if(isPrime[p] == true){
			// Update all multiples of p
			// Execute the Sieve of Eratosthenes algorithm (using false to mark off entries)
				for(int i = p*2; i <= endPoint; i += p){
					isPrime[i] = false;
				}
			}
		}

		int totalPrimeNumbers = 0;
		// Display the total number of primes found in the interval [start, stop]
		for(int i = startPoint; i <= endPoint; i++){
			if(isPrime[i] == true){
				totalPrimeNumbers++;
			}
		}

		System.out.println();
		System.out.println("Total prime number" + (totalPrimeNumbers == 1 ? "" : "s" ) + " between ");
		System.out.println(startPoint + " and " + endPoint + " : " + totalPrimeNumbers + ".");
	}
}