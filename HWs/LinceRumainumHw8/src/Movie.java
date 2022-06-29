/** Program header:  Movie.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This is the superclass, and it inherits from the interface without implementing the 
 *     abstract methods of the interface, thus this class has to be defined abstract. 
 *   This class defines four private data fields: title, director, year, and production cost
 *   It also provide a default constructor, and a constructor with four parameters,  
 *     in addition to the regular getters and setters for all private data members.
 *   The overriden toString() method is originally defined in class Object, 
 *     and all other classes are either direct subclasses of Object, or more generations 
 *     down from ancestor class Object. 
 *   For Movie class, because it does not explicitly declare its extended superclass , 
 *      class Object is assigned as its superclass by default.
 */

public abstract class Movie implements Profitable {
	/** a list of private data members goes here */
	private String title;
	private String director;
	private int year;
	private double productionCost;


	/** constructors go here, with the default constructor listed first */
	public Movie(){
		this("Avatar","James Cameron",2009,200.5);
	}

	public Movie(String title,String director,int year,double productionCost){
		this.title = title;
		this.director = director;
		this.year = year;
		this.productionCost = productionCost;
	}
	
	/** getters for private data members go here */
	public String  getTitle(){
		return title;
	}
	
	public String getDirector(){
		return director;
	}
	
	public int getYear(){
		return year;
	}
	
	public double getProductionCost(){
		return productionCost;
	}
	
	/** setters for private data members go here. */
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setDirector(String director){
		this.director = director;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public void setProductionCost(double productionCost){
		this.productionCost = productionCost;
	}
	
	/**  effectors */
	public String toString() {
		String info = String.format("Movie %5s, was directed by %5s in %4d "
				+ "with production cost of %5.3f millions.\n", 
				title, director, year,productionCost);
		return info;
	}
   
}
