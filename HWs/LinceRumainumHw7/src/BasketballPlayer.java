/** Program header:  BasketballPlayer.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This class include the player's id, player name, team name, position,
 *   salary, and commission rate from super and also two private data int type
 *   number of shots made and number of shots attempted.
 *   This class have two effectors:
 *   1. Calculate statistics of player's rushing average by  
 *   	dividing number of shots made by number of shots attempted 
 *   	(return a double type).
 *   2. Determine status: True for shot percentage > 0.32; o/w return false. 
 *   	(return a boolean type)
 *   Note: This is a subclass of Player.
 */

public class BasketballPlayer extends Player{
	/** a list of private data members goes here */
	private int numberOfShotsMade;
	private int numberOfShotsAttempted;

	/** constructors go here, with the default constructor listed first */
	public BasketballPlayer(){
		this(23, "Michael Jordan", "Chicago Bulls", "Shooting Guard", 33000000.00, 0.035, 12195, 24537);
	}

	public BasketballPlayer(int id,String playerName,String teamName,String position,double salary,
			double commissionRate, int numberOfShotsMade, int numberOfShotsAttempted){
		super(id, playerName, teamName, position, salary, commissionRate);
		this.numberOfShotsMade = numberOfShotsMade; 
		this.numberOfShotsAttempted = numberOfShotsAttempted;
	}

	/** getters for private data members go here */
	public int getNumberOfShotsMade(){
		return numberOfShotsMade;
	}
	
	public int getNumberOfShotsAttempted(){
		return numberOfShotsAttempted;
	}

	/** setters for private data members go here. */
	public void setNumberOfShotsMade(int numberOfShotsMade){
		this.numberOfShotsMade = numberOfShotsMade;
	}

	public void setNumberOfShotsAttempted(int numberOfShotsAttempted){
		this.numberOfShotsAttempted = numberOfShotsAttempted;
	}

	/** effectors (methods that are not constructor/getter/setter) go here */
	public double calcStatistics(){		
		return (double)numberOfShotsMade/numberOfShotsAttempted;
	}
	
	public boolean determineStatus(){
		boolean playersStatus;
		
		if((double)numberOfShotsMade/numberOfShotsAttempted > 0.32){
			playersStatus = true;
		}
		else{
			playersStatus = false;
		}
		
		return playersStatus;
	}
}