/** Program header:  LinceRumainumHw8.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This class is the application class that has the main method.
 *   It creates an array of superclass type, then initialize it with objects of different subclass types.
 *   It follows the class-interface design in employeeArrayVersion 1, and the array can be navigated 
 *   	with dynamic binding, without having to know the exact subclass type of each array element. 
 *   It calculates and output each array item's characteristics.
 *   It creates methods and passes array as parameters, and it uses for-each loop to 
 *     navigate an array of objects. 
 */

public class LinceRumainumHw8 {
	public static void main(String[] args){
		// Print author info
		System.out.println("Spring 17, Java, T TR 1:30pm, Lince Rumainum, hw8\n"); 

		// each array element is of superclass reference type
	   	Movie[] list = new Movie[6];

		// now let the parent reference refers to child class objects.
   	 	list[0] = new Animated("Minion","Kyle Balda", 2015, 74.000, 0.055, 2123.950);
		list[1] = new Animated("Zootopia","Rich Moore", 2016, 150.000, 0.055, 1552.523);
    	list[2] = new Documentary("Taxi to The Dark Side","Alex Gibney", 2007, 1.000, 25, 0.050);
   	 	list[3] = new Documentary("Inside Job","Charles Ferguson", 2010, 2.000, 15, 0.075);
    	list[4] = new Drama("Manchester by the Sea","Kenneth Lonergan", 2016, 8.500, 20.12345, 12.50);
   	 	list[5] = new Drama("The Fault in Our Stars","Josh Boone", 2014, 12.000, 1.12345, 6.50);
   	 	
   	 	printMovieInfo(list);
   	 	double profitOfAllMovies = calcTotalProfit(list);
		System.out.printf("\nThe sum of all of the movie's profit is $%6.3f millions.\n", 
				profitOfAllMovies);   	 
	}
	
	public static void printMovieInfo(Movie[] info){
		/** a list of private data members in this method */
		String stringOutput;
		double movieRevenue;
		double movieProfit;
		
		for(Movie eachMovie : info){
			stringOutput = eachMovie.toString();
			movieRevenue = eachMovie.calcRevenue();
			movieProfit = eachMovie.calcProfit();
			//Print out results in console
			System.out.printf("%s",stringOutput);
			System.out.printf("The movie's revenue is %5.3f millions, "
					+ "and the movie's profit is $%5.3f millions.\n\n", 
					movieRevenue, movieProfit);
		}
	}

	public static double calcTotalProfit(Movie[] pay){
		/** a list of private data member(s) in this method */
		double totalProfit = 0;
		
		for(int i = 0; i < pay.length; i++){
			totalProfit += pay[i].calcProfit();
		}
		return totalProfit;
	}
	
}
