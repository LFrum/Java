/** Program header:  Animated.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This class extends from abstract class Movie, and implements the inherited abstract methods 
 *     from its grandparent: interface Profitable, thus this class does not need to be defined as abstract. 
 *   It defines two private data fields: royalty rate and income of the related products.
 *   It also provides a default constructor and a constructor with six parameters,  
 *     in addition to the regular getters and setters for all private data members.
 *   The effector is to get category, calculate revenue and calculate profit.
 *   It also provide its own version of toString() method.
 */

public class Animated extends Movie {
	/** data variables */
	private double royaltyRate;      
	private double incomeOfRelatedProducts;  
   
	/** constructors */
	public Animated() { 
		super(); 
	}
	
	public Animated(String title,String director,int year,double productionCost, 
			double royaltyRate, double incomeOfRelatedProducts) {
		super(title, director, year, productionCost);  
		this.royaltyRate = royaltyRate;
		this.incomeOfRelatedProducts = incomeOfRelatedProducts;
	}
   
	/** getters */
	public double getRoyaltyRate() {
		return royaltyRate; 
	}
	
	public double getIncomeOfRelatedProducts() { 
		return incomeOfRelatedProducts; 
	}

	/** setters */
	public void setRoyaltyRate(double royaltyRate){
		this.royaltyRate = royaltyRate; 
	}
	
	public void setincomeOfRelatedProducts(double incomeOfRelatedProducts){ 
		this.incomeOfRelatedProducts = incomeOfRelatedProducts; 
	}

  	/** effectors */
	public String getCategory(){ 
		return "animated"; 
	}
   
	public double calcRevenue() {
		return incomeOfRelatedProducts*royaltyRate;
	} 
	
	public double calcProfit() {
		double revenue = calcRevenue();
		double profit = revenue-getProductionCost();	 
		return profit;
	} 
	
	public String toString() {
		String isProfit;
		
		if (calcProfit()>0){
			isProfit = "profit";
		}
		else{
			isProfit = "no profit";
		}
		
		String fromParent = super.toString(); // get the info of the inherited data from superclass.
		String myOwnMessage = String.format ("This is an %8s movie and it generates %9s.\nThe royalty rate "
				+ "for this movie is %5.3f and generate income of related products of $%5.3f millions.\n", 
				getCategory(), isProfit, royaltyRate, incomeOfRelatedProducts); // get the info of its own class
		return fromParent + myOwnMessage; // return the concatenated messages
	}
}
