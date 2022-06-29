/*
Lince Rumainum
Advanced Java
Dr. Goulden
OCCC Fall 2017
Sudoku Solver 3x3 Assignment
Week 4
*/

/*
Link(s) / book(s) used for this assignment:
Textbook Introduction to Java Programming, Y. Daniel Yang, Chapter 8
https://stackoverflow.com/questions/26448352/counting-the-number-of-lines-in-a-text-file-java
https://stackoverflow.com/questions/4680588/java-count-empty-lines-in-a-text-file-string
http://www.geeksforgeeks.org/backtracking-set-7-suduku/
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.lang.Character;
import java.lang.String;
import java.io.BufferedReader;


public class SudokuSolverHW{

	// Store the sudoku matrix in this variable
	public static char[][] theGame;
	// small boxes size
	public static int puzzleSize; 
	
	// Counting how many lines in the file
	public static int countLines(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			// count only if the line have entries
			while (line != null && !line.trim().isEmpty()) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				count++;
			}
			return count;
		} 
		finally {
			br.close();
		}
	}	

	public static void displayGame(char [] [] theGame){
		for(int r = 0; r < theGame.length; ++r){
			System.out.println();
			// print an empty line per x-by-x small boxes
			if(r > 0 && (r%puzzleSize == 0) ){				
				System.out.println();
			}
			for(int c = 0; c < theGame[r].length; ++c){
				System.out.print(theGame[r][c] + " ");				
				// print extra spaces per x-by-x small boxes
				if ((c+1)%puzzleSize == 0){
					System.out.print("  ");
				}
			}
		}
		System.out.println();
		System.out.println();
	}

	public static void main (String [] args){
		// input file name
		String fileName;
		// the size of the x-by-x of the whole puzzle
		int sudokuSize = 1;

		if ( args.length == 1 ){
			fileName = args[0];
		}
		else {
			Scanner s = new Scanner(System.in);
			System.out.print("Please enter file name: ");
			fileName = s.nextLine();
		}

		try{
			System.out.println("Reading from file " + fileName + "...");
			sudokuSize = countLines(fileName);
			puzzleSize = (int) Math.abs(Math.sqrt(sudokuSize));			
			System.out.println("This is a " + sudokuSize + "x" + sudokuSize + " sudoku");
		}
		catch(IOException e){
			System.out.println(fileName + " was not found!");
			System.out.println(e.toString());
			System.exit(0);
		}
		
		try{
			Scanner f = new Scanner(new File(fileName));

			theGame = new char [sudokuSize] [sudokuSize];

			for (int r = 0; r < sudokuSize; ++r){
				for( int c = 0; c < sudokuSize; ++c){
					theGame[r][c] = f.next().charAt(0);
					theGame[r][c] = Character.toUpperCase(theGame[r][c]);
				}
			}
			
			boolean isValid; // does the puzzle have a valid entries?
			boolean isSolved; // does the puzzle actually completed with valid entries?
			boolean isComplete = isCompletePuzzle(theGame); // does the puzzle have empty spots?
			
			displayGame(theGame);
			if (isComplete == true){
				isValid = isValid(theGame);			
				if (isValid == true){
					isSolved = true;					
					System.out.println("The sudoku puzzle is complete and valid!");
				}
				else{
					System.out.println("The sudoku puzzle is complete but not valid!");
				}
			}
			else{
				solvePuzzle(theGame);
				isSolved = isSolvedPuzzle (theGame);
				if (isSolved == true){
					System.out.println("The sudoku puzzle is solved!");
					displayGame(theGame);
				}
				else{
					System.out.println();
					System.out.println("The sudoku puzzle above has no solution!");
				}
			}
		}
		catch(FileNotFoundException fnfe){
			System.out.println(fileName + " was not found!");
			System.out.println(fnfe.toString());
			System.exit(0);
		}
	}
	
	// Check if there is any empty box
	public static boolean emptyBox(char[][] theGame){
		for (int i = 0; i < theGame.length; i++){ // row
			for (int j = 0; j < theGame[i].length; j++){ // col
				if (theGame[i][j] == '-' || theGame[i][j] == '*'){
					return true;
				}
			}
		}
		return false;
	}
	
	// Find what is the row's number of the empty box
	public static int emptyBoxRow(char[][] theGame){
		for (int i = 0; i < theGame.length; i++){ // row
			for (int j = 0; j < theGame[i].length; j++){ // col
				if (theGame[i][j] == '-' || theGame[i][j] == '*'){
					return i;
				}
			}
		}
		return 0;
	}
	
	// Find what is the column's number of the empty box
	public static int emptyBoxCol(char[][] theGame){
		for (int i = 0; i < theGame.length; i++){ // row
			for (int j = 0; j < theGame[i].length; j++){ // col
				if (theGame[i][j] == '-' || theGame[i][j] == '*'){
					return j;
				}
			}
		}
		return 0;
	}
	
	// Solve the puzzle 
	public static boolean solvePuzzle(char[][] theGame) {
		int row = 0; 
		int col = 0;
		char entry;
		
		// is there any empty boxes to be solved?
		if (emptyBox(theGame)){
			row = emptyBoxRow(theGame);
			col = emptyBoxCol(theGame);
		}
		else if (!emptyBox(theGame)){
			return true;
		}		
		
		if (puzzleSize == 2 || puzzleSize == 3){
			// try digits 1 to 9	 for 3-by-3 sudoku puzzle
			for (int num = 0; num < theGame.length; ++num){
				// set entry into theGame's index
				entry = (char) ((int) num + (int) '1');
				// if the entry is possible
				if (isPossible(theGame, row, col, entry) == true){
					// tentative assignment
					theGame[row][col] = entry;
		
					// return, if success
					if (solvePuzzle(theGame)){
						return true;
					}
					// failure, unmake & try again
					theGame[row][col] = '-';
				}
			}
		}
		else{			
			// try digits and/or alphanumeric
			for (int num = 0; num < theGame.length; ++num){
				// set entry into theGame's index, this including 0
				if (num < 10){
					entry = (char) ((int) num + (int) '0');
				}
				else{
					entry = (char) ((int) num + (int) 'A' - 10);				
				}
				
				// if the entry is possible
				if (isPossible(theGame, row, col, entry) == true){
					// tentative assignment
					theGame[row][col] = entry;
		
					// return, if success
					if (solvePuzzle(theGame)){
						return true;
					}
					// failure, unmake & try again
					theGame[row][col] = '-';
				}
			}
		}
		// this will trigger backtracking
		return false; 
	}
	
	// check if the current entry possible by checking the row, column, and the small box of current spot
	public static boolean isPossible (char [][] theGame, int currentRow, int currentCol, char possibleEntry){
		return !rowCheck(theGame, currentRow, possibleEntry) && !colCheck(theGame, currentCol, possibleEntry) &&
		!boxCheck(theGame, currentRow, currentCol, possibleEntry);
	}
	
	public static boolean rowCheck(char[][] theGame, int currentRow, char possibleEntry){
		for (int col = 0; col < theGame[currentRow].length; ++col){
			if (theGame[currentRow][col] == possibleEntry){
				return true;
			}
		}
		return false;
	}
	
	public static boolean colCheck(char[][] theGame, int currentCol, char possibleEntry){
		for (int row = 0; row < theGame.length; ++row){
			if (theGame[row][currentCol] == possibleEntry){
				return true;
			}
		}
		return false;		
	}
	
	public static boolean boxCheck(char[][] theGame, int currentRow, int currentCol, char possibleEntry){
		int boxStartRow = currentRow - currentRow%puzzleSize;
		int boxStartCol = currentCol - currentCol%puzzleSize;
		
		for (int row = 0; row < puzzleSize; row++){
			for (int col = 0; col < puzzleSize; col++){
				if (theGame[row+boxStartRow][col+boxStartCol] == possibleEntry){
					return true;
				}
			}
		}
		return false;	
	}	
	
	// Check whether the sudoku puzzle is complete and valid
	public static boolean isSolvedPuzzle(char[][] theGame) {
		if ( !isCompletePuzzle(theGame) || !isValid (theGame) ){
			return false;
		}
		else{
			// The puzzle is solved
			return true;
		} 
	}
	
	// Check whether the sudoku puzzle is complete 
	public static boolean isCompletePuzzle(char[][] grid) {
		for (int row = 0; row < theGame.length; ++row){
			for (int col = 0; col < theGame[row].length; ++col){
				if (grid[row][col] == '-' || grid[row][col] == '*'){
					return false;
				}			
			}
		}
		return true; // The puzzle is complete
	}
	
	// Check whether the sudoku puzzle is valid
	public static boolean isValid(char[][] grid) {
		char minNum, maxNum, minAlpha, maxAlpha;
		
		if (puzzleSize == 2 || puzzleSize == 3){							
			minNum = (char) ((int) '1');
			if (puzzleSize == 2){
				maxNum = (char) ((int) '4');
			}
			else {
				maxNum = (char) ((int) '9');
			}
				
			for (int row = 0; row < theGame.length; ++row){
				for (int col = 0; col < theGame[row].length; ++col){
					if (grid[row][col] == '-' || grid[row][col] == '*' || grid[row][col] < minNum || 
						grid[row][col] > maxNum || !isValid(row, col, grid)){
						return false;
					}			
				}
			}			
		}
		else if (puzzleSize == 4 || puzzleSize == 5 || puzzleSize == 6){
			minNum = (char) ((int) '0');
			maxNum = (char) ((int) '9');
			minAlpha = (char) ((int) 'A');
			if (puzzleSize == 4){
				maxAlpha = (char) ((int) 'F');
			}
			else if (puzzleSize == 5){
				maxAlpha = (char) ((int) 'O');
			}
			else{
				maxAlpha = (char) ((int) 'Z');
			}
			
			for (int row = 0; row < theGame.length; ++row){
				for (int col = 0; col < theGame[row].length; ++col){
					if (grid[row][col] == '-' || grid[row][col] == '*' || grid[row][col] < minNum || 
						( (grid[row][col] > maxNum) && (grid[row][col] < minAlpha) ) || 
						grid[row][col] > maxAlpha || !isValid(row, col, grid)){
						System.out.println("Returning false in isValid(char[][] grid) function");
						return false;
					}			
				}
			}
		}
		else {
			System.out.println("Invalid sudoku puzzle size!");
			System.out.println("This application only solve sudoku puzzle: !");
			System.out.println("4x4");
			System.out.println("9x9");
			System.out.println("16x16");
			System.out.println("25x25");
			System.out.println("36x36");
			System.exit(0);
		}				
		return true; // The puzzle is valid
	}

	// Check whether grid[currentRow][currentCol] is valid in the grid
	public static boolean isValid(int currentRow, int currentCol, char[][] grid) {
		// Check whether grid[i][j] is unique in currentRow
		// Check rows
		for (int column = 0; column < grid[currentRow].length; column++){
			if (column != currentCol && grid[currentRow][column] == grid[currentRow][currentCol]){
				return false;
			}
		}

		// Check whether grid[currentRow][currentCol] is unique in currentCol
		// Check columns
		for (int row = 0; row < grid.length; row++){
			if (row != currentRow && grid[row][currentCol] == grid[currentRow][currentCol]){
				return false;
			}
		}

		// Check whether grid[currentRow][currentCol] is unique in the puzzleSize-by-puzzleSize box
		// Check small boxes
		for (int row = (currentRow / puzzleSize) * puzzleSize; row < (currentRow / puzzleSize) * puzzleSize + puzzleSize; row++){
			for (int col = (currentCol / puzzleSize) * puzzleSize; col < (currentCol / puzzleSize) * puzzleSize + puzzleSize; col++){
				if (row != currentRow && col != currentCol && grid[row][col] == grid[currentRow][currentCol]){
					return false;
				}
			}
		}

		return true; // The current value at grid[currentRow][currentCol] is valid
	}
}