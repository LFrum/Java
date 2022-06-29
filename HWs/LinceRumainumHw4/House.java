/** Program header:  LinceRumainumHw4.java
 *
 * Author:    Lince Rumainum
 * Class:     Java
 *
 * Brief Program Description:
 *   This class defines what a House class should contain as its components:
 *     totalPrice and totalSqf.
 *   It also provide public method to calculate price per square feet and property tax, 
 *     in addition to the regular getters and setters of the data members.
 */
import java.util.Scanner;

public class House {
	/** a list of private data members goes here */
	private double totalPrice;
	private double totalSqf;
	
	/** Create a Scanner */
    Scanner input = new Scanner(System.in);

	/** constructors go here */
	/** Default constructor */
	public House() {
		this(100000.0, 1000.0);
	}

	/** Construct a house with specified total price and total square feet*/
	public House(double totalPrice, double totalSqf) {
	    this.totalPrice = totalPrice;
	    this.totalSqf = totalSqf;
	}

	/** getters go here */ 
	/** Return totalPrice */
	public double getTotalPrice() {
		return totalPrice;
	}

	/** Return totalSqf */
	public double getTotalSqf() {
		return totalSqf;
	}

	/** setters go here */  
	/** Set a new totalPrice */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/** Set a new totalSqf */
	public void setTotalSqf(double totalSqf) {
		this.totalSqf = totalSqf;
	}

	/** effectors go here */ 
	/** Find price per square feet */
	public double calcPricePerSqf () {
		double pricePerSqf = totalPrice / totalSqf;
		return pricePerSqf;    
	}

	/** Find property tax */
	public double calcPropertyTax(double taxPercentage) {
		double propertyTax = taxPercentage * 0.01 * totalPrice;
		return propertyTax;    
	}
	  
}
