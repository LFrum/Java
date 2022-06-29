/** Program header:  Profitable.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This is the interface, and it defines abstract methods to be implemented by it subclass.
 *   It also defined some constant variables.
 *   By default, all methods are abstract, and all variable are static final in interface.
 */

public interface Profitable {
	/** all methods are abstract in interface */
	public String getCategory();
	public double calcRevenue();
	public double calcProfit();
}
