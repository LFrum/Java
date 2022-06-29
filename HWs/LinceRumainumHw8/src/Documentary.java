/** Program header:  Documentary.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This class extends from abstract class Movie, and implements the inherited abstract methods 
 *     from its grandparent: interface Profitable, thus this class does not need to be defined as abstract. 
 *   It defines two private data fields: number of distributors and premium paid by each distributor.
 *   It also provides a default constructor and a constructor with six parameters,  
 *     in addition to the regular getters and setters for all private data members.
 *   The effector is to get category, calculate revenue and calculate profit.
 *   It also provide its own version of toString() method.
 */

public class Documentary extends Movie{
	/** data variables */
	private int numberOfDistributors;      
	private double premiumPaidByEachDistributor;  
   
	/** constructors */
	public Documentary() { 
		super(); 
	}
	
	public Documentary(String title,String director,int year,double productionCost, 
			int numberOfDistributors, double premiumPaidByEachDistributor) {
		super(title, director, year, productionCost);  
		this.numberOfDistributors = numberOfDistributors;
		this.premiumPaidByEachDistributor = premiumPaidByEachDistributor;
	}
   
	/** getters */
	public int getNumberOfDistributors() {
		return numberOfDistributors; 
	}
	
	public double getPremiumPaidByEachDistributor() { 
		return premiumPaidByEachDistributor; 
	}

	/** setters */
	public void setNumberOfDistributors(int numberOfDistributors){
		this.numberOfDistributors = numberOfDistributors; 
	}
	
	public void setPremiumPaidByEachDistributor(double premiumPaidByEachDistributor){ 
		this.premiumPaidByEachDistributor = premiumPaidByEachDistributor; 
	}

  	/** effectors */
	public String getCategory(){ 
		return "documentary"; 
	}
   
	public double calcRevenue() {
		return premiumPaidByEachDistributor*numberOfDistributors;
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
		
		// get the info of the inherited data from superclass.
		String fromParent = super.toString(); 
		// get the info of its own class
		String myOwnMessage = String.format ("This is an %8s movie and it generates %9s.\nThis movie "
				+ "have %2d of distributors with premium paid $%5.3f millions by each of them.\n", 
				getCategory(), isProfit, numberOfDistributors, premiumPaidByEachDistributor); 
		return fromParent + myOwnMessage; // return the concatenated messages
	}
}