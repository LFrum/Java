/** Program header:  LinceRumainumHw4.java
 *
 * Author:    Lince Rumainum
 * Class:     Java
 *
 * Brief Program Description:
 *   This class is the application class with the main method.
 *   It creates two house objects with set of constant values for
 *   its parameters (total price and total square feet).
 *   Then it creates a third house object with default House constructor. 
 *   Then it asks for user input parameters for total price and total square feet
 *   that will be used by the third house object.
 *   Then it will ask for user input for tax percentage that will be used
 *   for all three house objects.
 *   Then it calculate and output the house characteristics: 
 *   price per square feet and property tax of each house objects.
 */

import java.util.Scanner;

public class LinceRumainumHw4 {
	/** Main method */
	public static void main(String[] args) {
		// Print author info
		System.out.println("Spring 17, Java, Tue Thurs 1:30pm, Lince Rumainum, hw4"); 

	    // Create two House objects
	    House myHouse1 =
	    		new House(295000.0, 3395.0);
	    
	    House myHouse2=
	    		new House(189000.0, 675.0);
	    
	    House myHouse3=	new House();
	    
	    // Create a Scanner
	    Scanner input = new Scanner(System.in);

	    // Enter total price
	    System.out.print("Enter the total price of the house, for example, 395000.0: ");
	    double totalPrice = input.nextDouble();

	    // Enter total square feet
	    System.out.print("Enter the total square feet of the house, for example, 4015.0: ");
	    double totalSqf = input.nextDouble();
	    
	    myHouse3.setTotalPrice(totalPrice);
	    myHouse3.setTotalSqf(totalSqf);
	    
	    //Enter tax percentage
	    System.out.print("Enter tax percentage amount, for example, 1.25: ");
	    double taxPercentage =  input.nextDouble();	    
	    
	    /**Store data in local variables of each houses by invoking
	    two functions: calcPricePerSqf() and calcPropertyTax(double)*/
	    double myHouse1TotalPrice= myHouse1.calcPricePerSqf();
	    double myHouse1PropertyTax=myHouse1.calcPropertyTax(taxPercentage);
	    double myHouse2TotalPrice= myHouse2.calcPricePerSqf();
	    double myHouse2PropertyTax=myHouse2.calcPropertyTax(taxPercentage);
	    double myHouse3TotalPrice= myHouse3.calcPricePerSqf();
	    double myHouse3PropertyTax=myHouse3.calcPropertyTax(taxPercentage);
	    
	    // Display price per square feet and property tax of myHouse1
	    System.out.printf("The total price per square feet is $%10.1f\nThe property tax is $%10.2f\n",
	    		myHouse1TotalPrice, myHouse1PropertyTax);
	    
	    // Display price per square feet and property tax of myHouse2
	    System.out.printf("The total price per square feet is $%10.1f\nThe property tax is $%10.2f\n",
	    		myHouse2TotalPrice, myHouse2PropertyTax);
	    
	    // Display price per square feet and property tax of myHouse3
	    System.out.printf("The total price per square feet is $%10.1f\nThe property tax is $%10.2f\n",
	    		myHouse3TotalPrice, myHouse3PropertyTax);

	  }
}
