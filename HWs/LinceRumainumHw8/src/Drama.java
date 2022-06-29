/** Program header:  Documentary.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This class extends from abstract class Movie, and implements the inherited abstract methods 
 *     from its grandparent: interface Profitable, thus this class does not need to be defined as abstract. 
 *   It defines two private data fields: number of tickets sold and average price of each ticket.
 *   It also provides a default constructor and a constructor with six parameters,  
 *     in addition to the regular getters and setters for all private data members.
 *   The effector is to get category, calculate revenue and calculate profit.
 *   It also provide its own version of toString() method.
 */

public class Drama extends Movie{
	/** data variables */
	private double numberOfTicketsSold;      
	private double averagePriceOfEachTicket;  
   
	/** constructors */
	public Drama() { 
		super(); 
	}
	
	public Drama(String title,String director,int year,double productionCost, 
			double numberOfTicketsSold, double averagePriceOfEachTicket) {
		super(title, director, year, productionCost);  
		this.numberOfTicketsSold = numberOfTicketsSold;
		this.averagePriceOfEachTicket = averagePriceOfEachTicket;
	}
   
	/** getters */
	public double getNumberOfTicketsSold() {
		return numberOfTicketsSold; 
	}
	
	public double getAveragePriceOfEachTicket() { 
		return averagePriceOfEachTicket; 
	}

	/** setters */
	public void setNumberOfTicketsSold(double numberOfTicketsSold){
		this.numberOfTicketsSold = numberOfTicketsSold; 
	}
	
	public void setAveragePriceOfEachTicket(double averagePriceOfEachTicket){ 
		this.averagePriceOfEachTicket = averagePriceOfEachTicket; 
	}

  	/** effectors */
	public String getCategory(){ 
		return "drama"; 
	}
   
	public double calcRevenue() {
		return averagePriceOfEachTicket*numberOfTicketsSold;
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
		String myOwnMessage = String.format ("This is a %5s movie and it generates %9s.\nThis movie "
				+ "sold %8.5f million tickets with average price of each ticket cost: $%4.2f.\n", 
				getCategory(), isProfit, numberOfTicketsSold, averagePriceOfEachTicket); // get the info of its own class
		return fromParent + myOwnMessage; // return the concatenated messages
	}
}