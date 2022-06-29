/** Program header:  BaseballPlayer.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This class include the player's id, player name, team name, position,
 *   salary, and commission rate from super and also two private data int type
 *   number of hits and number of times at bats.
 *   This class have two effectors:
 *   1. Calculate statistics of player's batting average by  
 *   	dividing number of hits by the number of times at bats 
 *   	(return a double type).
 *   2. Determine status: True for batting average > 0.25; o/w return false. 
 *   	(return a boolean type)
 *   Note: This is a subclass of Player.
 */

public class BaseballPlayer extends Player{
	/** a list of private data members goes here */
	private int numberOfHits;
	private int numberOfTimesAtBats;

	/** constructors go here, with the default constructor listed first */
	public BaseballPlayer(){
		this(13,"Alex Rodriguez", "New York Yankees", "Shortstop", 20000000.00, 0.025, 3115, 10550);
	}

	public BaseballPlayer(int id,String playerName,String teamName,String position,double salary,
			double commissionRate, int numberOfHits, int numberOfTimesAtBats){
		super(id, playerName, teamName, position, salary, commissionRate);
		this.numberOfHits = numberOfHits; 
		this.numberOfTimesAtBats = numberOfTimesAtBats;
	}

	/** getters for private data members go here */
	public int getNumberOfHits(){
		return numberOfHits;
	}
	
	public int getNumberOfTimesAtBats(){
		return numberOfTimesAtBats;
	}

	/** setters for private data members go here. */
	public void setNumberOfHits(int numberOfHits){
		this.numberOfHits = numberOfHits;
	}

	public void setNumberOfTimesAtBats(int numberOfTimesAtBats){
		this.numberOfTimesAtBats = numberOfTimesAtBats;
	}

	/** effectors (methods that are not constructor/getter/setter) go here */
	public double calcStatistics(){		
		return (double)numberOfHits/numberOfTimesAtBats;
	}
	
	public boolean determineStatus(){
		boolean playersStatus;
		
		if((double)numberOfHits/numberOfTimesAtBats > 0.25){
			playersStatus = true;
		}
		else{
			playersStatus = false;
		}
		
		return playersStatus;
	}
}
