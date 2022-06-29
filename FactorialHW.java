/*
Lince Rumainum
Advanced Java
Dr. Goulden
OCCC Fall 2017
Factorial Assignment
Week 2
*/

import java.util.Scanner;

public class FactorialHW{

  public static int fac_rec(int n){
    int result = 1;
    if ( n > 0 ){
      result = n * fac_rec( n-1 );
    }
    return result;
  }

  public static int fac_loop(int n){
    int result = 1;
    if ( n > 0 ){
      for (int i = 1; i <= n; ++i){
        result*= i;
      }
    }
    return result;
  }
  
    public static long fac_rec_long(int n){
    long result = 1;
    if ( n > 0 ){
      result = n * fac_rec_long( n-1 );
    }
    return result;
  }

  public static long fac_loop_long(int n){
    long result = 1;
    if ( n > 0 ){
      for (int i = 1; i <= n; ++i){
        result*= i;
      }
    }
    return result;
  }

  public static void main (String [] args){
    System.out.println("Welcome to Factorial Loop & Recursion!");
    int n;

    System.out.println("NOTE: Maximum integer value: 15!");
    System.out.println("NOTE: The factorial result will be in integer data type");
    System.out.print("Please enter an integer: ");
    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    System.out.println();
	
    long startTime = System.currentTimeMillis();
    System.out.println("Loop method: " + n + "! = " + fac_loop(n) );
    long stopTime = System.currentTimeMillis();
    long elapsedTime = (stopTime - startTime) / 1000;
    System.out.println( "Elapsed time: approximately " + elapsedTime + " second" + (elapsedTime == 0 ? "" : "s" ) );
    System.out.println();
    
    startTime = System.currentTimeMillis();
    System.out.println("Recursion method: " + n + "! = " + fac_rec(n) );
    stopTime = System.currentTimeMillis();
    System.out.println( "Elapsed time: approximately " + elapsedTime + " second" + (elapsedTime == 0 ? "" : "s" ) );
    System.out.println();
	
    System.out.println();
    System.out.println("NOTE: MAX. integer value: 20!");
    System.out.println("NOTE: The factorial result will be in long data type");
    System.out.print("Please enter an integer: ");
    n = s.nextInt();
    System.out.println();
	
    startTime = System.currentTimeMillis();
    System.out.println("Loop method: " + n + "! = " + fac_loop_long(n) );
    stopTime = System.currentTimeMillis();
    System.out.println( "Elapsed time: approximately " + elapsedTime + " second" + (elapsedTime == 0 ? "" : "s" ) );
    System.out.println();	
    
    startTime = System.currentTimeMillis();
    System.out.println("Recursion method: " + n + "! = " + fac_rec_long(n) );
    stopTime = System.currentTimeMillis();
    System.out.println( "Elapsed time: approximately " + elapsedTime + " second" + (elapsedTime == 0 ? "" : "s" ) );
    System.out.println();
  }
}