/** Program header:  LinceRumainumHw6.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This program generate 10 random numbers and sort it in
 *     decreasing order.
 *   Note: the sorting method use is selection sort method. 
 */

import java.lang.Math;

public class LinceRumainumHw6 {
	/** Main method */
	public static void main(String[] args) {
		// Print author info
		System.out.println("Spring 2017, Java, Tue Thurs 1:30pm, Lince Rumainum, hw6"); 
		
		final int SIZE = 10;
		double[] number = new double [SIZE];
		double minRandomNumber = 0;
		double maxRandomNumber = 100;
		
		//Generating 10 random numbers
		for (int i = 0; i < SIZE; i++){
			number[i] = minRandomNumber + (double)(Math.random()*(maxRandomNumber-minRandomNumber));			
		}
		
		System.out.println("\nThe random numbers: \n");
		// Display the random numbers
		printArray(number);
		
		// Sort the array in decreasing order
		sort(number);		

		System.out.println("The random numbers in decresing order: \n");
		// Display the array again to show it's in decreasing order
		printArray(number);
	}
	
	public static void printArray(double[] list){			
		// Display the array
		for (double eachElement: list){
			System.out.printf(" %3.2f" + " ", eachElement);
		}

		System.out.println(" \n");
	}
	
	public static void sort(double[] list) {
		// Below is the selection sort method:
		for (int i = 0; i < list.length - 1; i++) {
			// Find the maximum in the list[i..list.length-1]		      
			double currentMax = list[i];		      
			int currentMaxIndex = i;
			
			for (int j = i + 1; j < list.length; j++) {
				if (currentMax < list[j]) {
					currentMax = list[j];
					currentMaxIndex = j;
				}
			}

			// Swap list[i] with list[currentMaxIndex] if necessary;
			if (currentMaxIndex != i) {
				list[currentMaxIndex] = list[i];
				list[i] = currentMax;
			}
		}
	} // end of sorting method
}
