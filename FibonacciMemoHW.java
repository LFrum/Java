/*
Lince Rumainum
Advanced Java
Dr. Goulden
OCCC Fall 2017
Fibonacci Memoization Assignment
Week 2
*/

/*
Links used for this assignment:
http://www.fredosaurus.com/notes-java/data/numbers/10biginteger.html
*/

import java.util.Scanner;
import java.math.BigInteger;

public class FibonacciMemoHW{

  public static long fval[]; 
  public static BigInteger fval_BigInteger[]; 

  public static long fib_rec (int n){
    long result = 1;
    if (n > 2){		
	  System.out.println("if (n > 2): " + n);
      if ( fval[n] != 0 ){ 
        result = fval[n];
      }    
      else {
        result = fib_rec(n-1) + fib_rec(n-2);
        fval[n] = result;
      }
    }
    return result;
  }

  public static BigInteger fib_rec_BigInteger (int n){
    BigInteger result = BigInteger.valueOf(1);
    if (n > 2){
		System.out.println("if (n > 2): " + n);
      //if ( fval_BigInteger[n] != BigInteger.valueOf(0) )
	  if ( fval_BigInteger[n].compareTo(BigInteger.valueOf(0)) > 0{ 
	    System.out.println("fval_BigInteger[" + n + "]");
	    System.out.println("result:" + result);
        result = fval_BigInteger[n];
      }    
      else {
        result = (fib_rec_BigInteger(n-1)).add(fib_rec_BigInteger(n-2));
        fval_BigInteger[n] = result;
		System.out.println("fval_BigInteger[" + n + "]: fval_BigInteger[n]");
      }
    }
    return result;
  }


  public static void main (String [] args){
    System.out.println("Welcome to Fibonacci Loop & Recursion!");
    int n;
    
    // For the case of largest Fibonacci Number for n using long data type
    n = 92;	
    fval = new long [n + 1];
    fval[1] = 1;
    fval[2] = 1;
    long startTime = System.currentTimeMillis();
    System.out.println("Recursion method: Fibonacci (" + n + ") = " + fib_rec(n) );
    long stopTime = System.currentTimeMillis();
    System.out.println( "Elapsed time: approximately " + ((stopTime - startTime) / 1000) + " second" + (((stopTime - startTime) / 1000) < 2 ? "" : "s" ) );
    System.out.println();
	
    // For the n = 50, 90, 100, 150, 200, 250, 300 using BigInteger data type
	
	//int [] k = new int [];
	//k = {50, 90, 100, 150, 200, 250, 300};
	
	//for (int i = 0; i < k.length - 1 ; ++i){
	  n = 150;
      fval_BigInteger = new BigInteger [n + 1];
      fval_BigInteger[1] = BigInteger.valueOf(1);
      fval_BigInteger[2] = BigInteger.valueOf(1);
      startTime = System.currentTimeMillis();
      //System.out.println("Recursion method: Fibonacci (" + k[i] + ") = " + fib_rec_BigInteger(k[i]);
	  System.out.println("Recursion method: Fibonacci (" + n + ") = " + fib_rec_BigInteger(n));
      stopTime = System.currentTimeMillis();
      System.out.println( "Elapsed time: approximately " + ((stopTime - startTime) / 1000) + " second" + ( ( (stopTime - startTime) / 1000 ) < 2 ? "" : "s" ) );
      System.out.println();
	//}
  }
}