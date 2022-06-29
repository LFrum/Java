/*
Lince Rumainum
Advanced Java
Dr. Goulden
OCCC Fall 2017
Fibonacci Assignment
Week 2
*/

import java.util.Scanner;

public class FibonacciLongHW{

  /*
  public static long fval[]; //static happen in compile time

  public static long fib_rec (int n){
    long result = 1;
    if (n > 2){
      if ( fval[n] != 0 ){ // in java array fills with zeroes if nothing is initialize
        result = fval[n];
      }    
      else {
        result = fib_rec(n-1) + fib_rec(n-2);
        fval[n] = result;
      }
    }
    return result;
  }

  public static long fib_loop (int n){
    long result = 1;
    long a = 1;
    long b = 1;

    if (n > 2){
      for (int i = 2; i < n ; ++i){
        result = a + b;
        a = b;
        b = result;
      }
    }
    return result;
  }
  */
  public static long fib_rec (int n){
    long result = 1;
    if (n > 2){
      result = fib_rec(n-1) + fib_rec(n-2);
    }
    return result;
  }

  public static long fib_loop (int n){
    long result = 1;
    long a = 1;
    long b = 1;

    if (n > 2){
      for (int i = 2; i < n ; ++i){
        result = a + b;
        a = b;
        b = result;
      }
    }
    return result;
  }

  public static void main (String [] args){
    System.out.println("Welcome to Fibonacci Loop & Recursion!");
    int n;
	
    // For Fibonacci using a loop method, n = 10, 50, 90
    n = 10;
    long startTime = System.currentTimeMillis();
    System.out.println("Loop method: Fibonacci (" + n + ") = " + fib_loop(n) );
    long stopTime = System.currentTimeMillis();
    System.out.println( "Elapsed time: approximately " + ((stopTime - startTime) / 1000) + " second" + (((stopTime - startTime) / 1000) < 2 ? "" : "s" ) );
    System.out.println();	
	
    n = 50;
    startTime = System.currentTimeMillis();
    System.out.println("Loop method: Fibonacci (" + n + ") = " + fib_loop(n) );
    stopTime = System.currentTimeMillis();
    System.out.println( "Elapsed time: approximately " + ((stopTime - startTime) / 1000) + " second" + (((stopTime - startTime) / 1000) < 2 ? "" : "s" ) );
    System.out.println();	
	
    n = 90;
    startTime = System.currentTimeMillis();
    System.out.println("Loop method: Fibonacci (" + n + ") = " + fib_loop(n) );
    stopTime = System.currentTimeMillis();
    System.out.println( "Elapsed time: approximately " + ((stopTime - startTime) / 1000) + " second" + (((stopTime - startTime) / 1000) < 2 ? "" : "s" ) );
    System.out.println();	

    // For Fibonacci using a recursive method, n = 30, 40-50, 51    
    n = 30;
    startTime = System.currentTimeMillis();
    System.out.println("Recursion method: Fibonacci (" + n + ") = " + fib_rec(n) );
    stopTime = System.currentTimeMillis();
    System.out.println( "Elapsed time: approximately " + ((stopTime - startTime) / 1000) + " second" + (((stopTime - startTime) / 1000) < 2 ? "" : "s" ) );
    System.out.println();
	
    for (int i = 40; i < 51; ++i){
      startTime = System.currentTimeMillis();
      System.out.println("Recursion method: Fibonacci (" + i + ") = " + fib_rec(i) );
      stopTime = System.currentTimeMillis();
      System.out.println( "Elapsed time: approximately " + ((stopTime - startTime) / 1000) + " second" + (((stopTime - startTime) / 1000) < 2 ? "" : "s" ) );
      System.out.println();
    }
    
    // For the case of n which have a time required: less than 5 minutes
    n = 51;
    startTime = System.currentTimeMillis();
    System.out.println("Recursion method: Fibonacci (" + n + ") = " + fib_rec(n) );
    stopTime = System.currentTimeMillis();
    System.out.println( "Elapsed time: approximately " + ((stopTime - startTime) / 1000) + " second" + (((stopTime - startTime) / 1000) < 2 ? "" : "s" ) );
    System.out.println();
  }
}