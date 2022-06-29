/** Program header:  LinceRumainumHw7.java
 *
 * Author:    Lince Rumainum
 * Class:     Java  1:30 p.m. T TR
 *
 * Brief Program Description:
 *   This class is the application class that has the main method.
 *   It creates six objects: 
 *   two baseball players, two football players, and two basketball players.
 *   It does not have any user input, hardcoding the parameters of the constructor instead.
 *   It output the players information and
 *   Then it calculate and output the commission rate, statistics, and determine status.
 */

public class LinceRumainumHw7 {
	public static void main(String[] args){
		// Print author info
		System.out.println("Spring 2017, Java, Tue Thurs 1:30pm, Lince Rumainum, hw7"); 

		// Input for the baseball players
		BaseballPlayer otherBaseballPlayer = new BaseballPlayer(19,"Tommy Joseph", "Philadelphia Phillies", 
				"First Baseman", 507500.00, 0.015, 1000, 10000);
		
		BaseballPlayer defaultBaseballPlayer = new BaseballPlayer();
		
		// Input for the football players
		FootballPlayer otherFootballPlayer = new FootballPlayer(12, "Josh Gordon", "Cleveland Browns", 
				"Wide Receiver", 1500000.00, 0.005, 20, 10);
		
		FootballPlayer defaultFootballPlayer = new FootballPlayer();
		
		// Input for the basketball players
		BasketballPlayer otherBasketballPlayer = new BasketballPlayer(12, "Joe Harris", "Cleveland Cavaliers", 
				"Guard", 3000000.00, 0.005, 1000, 5000);
		
		BasketballPlayer defaultBasketballPlayer = new BasketballPlayer();
		
		// calculate the commissions
		double otherBaseballPlayerCommission = otherBaseballPlayer.calcCommision();
		double defaultBaseballPlayerCommission  = defaultBaseballPlayer.calcCommision();
		
		double otherFootballPlayerCommission  = otherFootballPlayer.calcCommision();
		double defaultFootballPlayerCommission  = defaultFootballPlayer.calcCommision();
		
		double otherBasketballPlayerCommission  = otherBasketballPlayer.calcCommision();
		double defaultBasketballPlayerCommission  = defaultBasketballPlayer.calcCommision();
		
		// output the results
		// baseball players output
		System.out.println("\nFor the other baseball player:");
		System.out.printf("player id: %2d\n", otherBaseballPlayer.getId());
		System.out.printf("name: %10s\n", otherBaseballPlayer.getPlayerName());
		System.out.printf("team: %10s\n", otherBaseballPlayer.getTeamName());
		System.out.printf("position: %10s\n", otherBaseballPlayer.getPosition());
		System.out.printf("salary: $%10.2f\n", otherBaseballPlayer.getSalary());
		System.out.printf("commission rate: %3.3f\n", otherBaseballPlayer.getCommissionRate());
		System.out.printf("commission: $%6.2f\n", otherBaseballPlayerCommission);
		System.out.printf("number of hits: %5d\n", otherBaseballPlayer.getNumberOfHits());
		System.out.printf("number of times at bats: %5d\n", otherBaseballPlayer.getNumberOfTimesAtBats());
		System.out.printf("statistics: %3.1f\n", otherBaseballPlayer.calcStatistics());
		System.out.printf("keeping status: %5s\n\n", otherBaseballPlayer.determineStatus());
		
		System.out.println("\nFor the default baseball player:");
		System.out.printf("player id: %2d\n", defaultBaseballPlayer.getId());
		System.out.printf("name: %10s\n", defaultBaseballPlayer.getPlayerName());
		System.out.printf("team: %10s\n", defaultBaseballPlayer.getTeamName());
		System.out.printf("position: %10s\n", defaultBaseballPlayer.getPosition());
		System.out.printf("salary: $%10.2f\n", defaultBaseballPlayer.getSalary());
		System.out.printf("commission rate: %3.3f\n", defaultBaseballPlayer.getCommissionRate());
		System.out.printf("commission: $%6.2f\n", defaultBaseballPlayerCommission);
		System.out.printf("number of hits: %5d\n", defaultBaseballPlayer.getNumberOfHits());
		System.out.printf("number of times at bats: %5d\n", defaultBaseballPlayer.getNumberOfTimesAtBats());
		System.out.printf("statistics: %3.1f\n", defaultBaseballPlayer.calcStatistics());
		System.out.printf("keeping status: %5s\n\n", defaultBaseballPlayer.determineStatus());
		
		// football players output
		System.out.println("\nFor the other football player:");
		System.out.printf("player id: %2d\n", otherFootballPlayer.getId());
		System.out.printf("name: %10s\n", otherFootballPlayer.getPlayerName());
		System.out.printf("team: %10s\n", otherFootballPlayer.getTeamName());
		System.out.printf("position: %10s\n", otherFootballPlayer.getPosition());
		System.out.printf("salary: $%10.2f\n", otherFootballPlayer.getSalary());
		System.out.printf("commission rate: %3.3f\n", otherFootballPlayer.getCommissionRate());
		System.out.printf("commission: $%6.2f\n", otherFootballPlayerCommission);
		System.out.printf("number of yards: %3d\n", otherFootballPlayer.getNumberOfYards());
		System.out.printf("number of rushes: %3d\n", otherFootballPlayer.getNumberOfRushes());
		System.out.printf("statistics: %3.1f\n", otherFootballPlayer.calcStatistics());
		System.out.printf("keeping status: %5s\n\n", otherFootballPlayer.determineStatus());
		
		System.out.println("\nFor the default football player:");
		System.out.printf("player id: %2d\n", defaultFootballPlayer.getId());
		System.out.printf("name: %10s\n", defaultFootballPlayer.getPlayerName());
		System.out.printf("team: %10s\n", defaultFootballPlayer.getTeamName());
		System.out.printf("position: %10s\n", defaultFootballPlayer.getPosition());
		System.out.printf("salary: $%10.2f\n", defaultFootballPlayer.getSalary());
		System.out.printf("commission rate: %3.3f\n", defaultFootballPlayer.getCommissionRate());
		System.out.printf("commission: $%6.2f\n", defaultFootballPlayerCommission);
		System.out.printf("number of yards: %3d\n", defaultFootballPlayer.getNumberOfYards());
		System.out.printf("number of rushes: %3d\n", defaultFootballPlayer.getNumberOfRushes());
		System.out.printf("statistics: %3.1f\n", defaultFootballPlayer.calcStatistics());
		System.out.printf("keeping status: %5s\n\n", defaultFootballPlayer.determineStatus());		
		
		// basketball players output
		System.out.println("\nFor the other basketball player:");
		System.out.printf("player id: %2d\n", otherBasketballPlayer.getId());
		System.out.printf("name: %10s\n", otherBasketballPlayer.getPlayerName());
		System.out.printf("team: %10s\n", otherBasketballPlayer.getTeamName());
		System.out.printf("position: %5s\n", otherBasketballPlayer.getPosition());
		System.out.printf("salary: $%10.2f\n", otherBasketballPlayer.getSalary());
		System.out.printf("commission rate: %3.3f\n", otherBasketballPlayer.getCommissionRate());
		System.out.printf("commission: $%6.2f\n", otherBasketballPlayerCommission);
		System.out.printf("number of shots made: %5d\n", otherBasketballPlayer.getNumberOfShotsMade());
		System.out.printf("number of shots attempted: %5d\n", otherBasketballPlayer.getNumberOfShotsAttempted());
		System.out.printf("statistics: %3.1f\n", otherBasketballPlayer.calcStatistics());
		System.out.printf("keeping status: %5s\n\n", otherBasketballPlayer.determineStatus());
		
		System.out.println("\nFor the default basketball player:");
		System.out.printf("player id: %2d\n", defaultBasketballPlayer.getId());
		System.out.printf("name: %10s\n", defaultBasketballPlayer.getPlayerName());
		System.out.printf("team: %10s\n", defaultBasketballPlayer.getTeamName());
		System.out.printf("position: %10s\n", defaultBasketballPlayer.getPosition());
		System.out.printf("salary: $%10.2f\n", defaultBasketballPlayer.getSalary());
		System.out.printf("commission rate: %3.3f\n", defaultBasketballPlayer.getCommissionRate());
		System.out.printf("commission: $%6.2f\n", defaultBasketballPlayerCommission);
		System.out.printf("number of shots made: %5d\n", defaultBasketballPlayer.getNumberOfShotsMade());
		System.out.printf("number of shots attempted: %5d\n", defaultBasketballPlayer.getNumberOfShotsAttempted());
		System.out.printf("statistics: %3.1f\n", defaultBasketballPlayer.calcStatistics());
		System.out.printf("keeping status: %5s\n\n", defaultBasketballPlayer.determineStatus());		
	}
}
