/** Program header:  Player.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This class include the player's id, player name, team name, position, 
 *   and salary, commission rate. This class have one effector that 
 *   calculate commission by multiplying salary with the commission rate.
 *   Note: This is a superclass to:
 *   BaseBallPlayer class, FootballPlayer class, and BasketballPlayer class.
 */

public class Player extends java.lang.Object {
	/** a list of private data members goes here */
	private int id;
	private String playerName;
	private String teamName;
	private String position;
	private double salary;
	private double commissionRate;

	/** constructors go here, with the default constructor listed first */
	public Player(){
		this(10,"Eden Hazard", "Chelsea FC", "Midfielder", 13230000.00, 0.03);
	}

	public Player(int id,String playerName,String teamName,String position,double salary,double commissionRate){
		this.id = id;
		this.playerName = playerName;
		this.teamName = teamName;
		this.position = position;
		this.salary = salary;
		this.commissionRate = commissionRate;
	}
	
	/** getters for private data members go here */
	public int  getId(){
		return id;
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
	public String getTeamName(){
		return teamName;
	}
	
	public String getPosition(){
		return position;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public double getCommissionRate(){
		return commissionRate;
	}	

	/** setters for private data members go here. */
	public void setId(int id){
		this.id = id;
	}
	
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
	
	public void setTeamName(String teamName){
		this.teamName = teamName;
	}
	
	public void setPosition(String position){
		this.position = position;
	}

	public void setSalary(double salary){
		this.salary = salary;
	}
	
	public void setCommissionRate(double commissionRate){
		this.commissionRate = commissionRate;
	}
	
	/** effectors (methods that are not constructor/getter/setter) go here */
	public double calcCommision(){		
		return salary*commissionRate;
	}
}
