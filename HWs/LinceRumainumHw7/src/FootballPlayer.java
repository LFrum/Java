/** Program header:  FootballPlayer.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This class include the player's id, player name, team name, position,
 *   salary, and commission rate from super and also two private data int type
 *   number of yards and number of rushes.
 *   This class have two effectors:
 *   1. Calculate statistics of player's rushing average by  
 *   	dividing number of yards by number of rushes 
 *   	(return a double type).
 *   2. Determine status: True for rushing average > 3.5; o/w return false. 
 *   	(return a boolean type)
 *   Note: This is a subclass of Player.
 */

public class FootballPlayer extends Player{
	/** a list of private data members goes here */
	private int numberOfYards;
	private int numberOfRushes;

	/** constructors go here, with the default constructor listed first */
	public FootballPlayer(){
		this(11, "Julian Edelman", "New England Patriots", "Wide Receiver", 4250000.00, 0.02, 57, 11);
	}

	public FootballPlayer(int id,String playerName,String teamName,String position,double salary,
			double commissionRate, int numberOfYards, int numberOfRushes){
		super(id, playerName, teamName, position, salary, commissionRate);
		this.numberOfYards = numberOfYards; 
		this.numberOfRushes = numberOfRushes;
	}

	/** getters for private data members go here */
	public int getNumberOfYards(){
		return numberOfYards;
	}
	
	public int getNumberOfRushes(){
		return numberOfRushes;
	}

	/** setters for private data members go here. */
	public void setNumberOfYards(int numberOfYards){
		this.numberOfYards = numberOfYards;
	}

	public void setNumberOfRushes(int numberOfRushes){
		this.numberOfRushes = numberOfRushes;
	}

	/** effectors (methods that are not constructor/getter/setter) go here */
	public double calcStatistics(){		
		return (double)numberOfYards/numberOfRushes;
	}
	
	public boolean determineStatus(){
		boolean playersStatus;
		
		if((double)numberOfYards/numberOfRushes > 3.5){
			playersStatus = true;
		}
		else{
			playersStatus = false;
		}
		
		return playersStatus;
	}
}