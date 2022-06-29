/*
Lince Rumainum
Advanced Java
Dr. Goulden
OCCC Fall 2017
Sort and Merge Assignment
Week 3
*/

/*
Link(s) / book(s) used for this assignment:
Textbook Introduction to Java Programming, Y. Daniel Yang, Chapter 7
http://www.geeksforgeeks.org/merge-two-sorted-arrays/
https://stackoverflow.com/questions/11496700/how-to-use-printwriter-and-file-classes-in-java
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.String;

public class SortAndMergeHW{
	
	int [] sortedList;

	public static void main ( String [] args ) {
		int [] list1 = new int [1];
		int [] list2 = new int [1];
		int size = 1;
		int mergeSize = 0;

		System.out.println( "Welcome to Sort and Merge Application!" );
		System.out.println();

		// List #1 file
		System.out.println( "Please enter the file name (for list #1): ");
		Scanner s = new Scanner (System.in);
		String fileName = s.nextLine();

		try{
			Scanner f = new Scanner(new File(fileName));
			size = f.nextInt();
			mergeSize += size;
			list1 = new int [size];
			// This will only read up to whatever the size that the file specified
			for ( int i = 0; i < list1.length; ++i ){
				list1[i] = f.nextInt();		  
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("File: " + fileName + " is not found!");
			System.out.println(fnfe.toString());
			System.exit(0);
		}
		
		quickSort (list1, 0, size - 1);
		displayArray(list1);		
		
		// List #2 file
		System.out.println( "Please enter the file name (for list #2): ");
		s = new Scanner (System.in);
		String fileName2 = s.nextLine();

		try{
			Scanner f = new Scanner(new File(fileName2));
			size = f.nextInt();
			mergeSize += size;
			list2 = new int [size];
			for ( int i = 0; i < list2.length; ++i ){
				list2[i] = f.nextInt();		  
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("File: " + fileName + " is not found!");
			System.out.println(fnfe.toString());
			System.exit(0);
		}
		
		quickSort (list2, 0, size - 1);
		displayArray(list2);

		int [] mergeList = new int [mergeSize];
		
		mergeList = mergeArrays(list1, list2);
		
		System.out.println("The sorted of the two data lists: ");
		displayArray(mergeList);
		
		// Merge list file
		System.out.println( "Please enter the file name (for merged list): ");
		s = new Scanner (System.in);
		String fileName3 = s.nextLine();
		
		try{
			PrintWriter outFile = new PrintWriter(fileName3);
			
			outFile.print(mergeList.length);
			
			for (int i = 0; i < mergeList.length; ++i){
				if (i%10 == 0) {
					outFile.println();
				}
				outFile.print(mergeList[i] + " ");
			}
			outFile.close();
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("No such file exists.");
		}			
	}
	
	public static void unsortedMergeArray (int [] source, int [] dest, int startIndex){
		int j = startIndex; // the source index of the mergeList
		for (int i = 0; i < source.length; ++i){
			dest[j] = source[i];
			j++;
		}
	}	
	
	// Merge list1[0..n1-1] and list2[0..n2-1] 
	public static int [] mergeArrays(int[] list1, int[] list2){		
		int i = 0, j = 0, k = 0;
		int list1Size = list1.length;
		int list2Size = list2.length;
		int[] mergeList = new int [list1Size + list2Size];

		// Traverse both array
		while (i < list1Size && j < list2Size)
		{
			// Check if current element of first array is smaller than current element
			// of second array. If yes, store first array element and increment first array
			// index. Otherwise do same with second array
			if (list1[i] < list2[j]){
				mergeList[k++] = list1[i++];
			}
			else{
				mergeList[k++] = list2[j++];
			}
		}

		// Store remaining elements of first array
		while (i < list1Size){
			mergeList[k++] = list1[i++];
		}

		// Store remaining elements of second array
		while (j < list2Size){
			mergeList[k++] = list2[j++];
		}
		return mergeList;
	}

	public static void displayArray(int [] a){
		for (int i = 0; i < a.length; ++i){
			if ( i%10 == 0 ){
				System.out.println();
			}
			System.out.printf("%7d", a[i]);
		}
		System.out.println();
		System.out.println();
	}

	public static void quickSort (int [] list, int startIndex, int endIndex){
		if ( startIndex >= endIndex ){
			return;
		}

		int pIndex = partition ( list, startIndex, endIndex);
		quickSort ( list, startIndex, pIndex );
		quickSort ( list, pIndex + 1, endIndex );
	}	

	private static int partition(int [] list, int i, int j) {
		int pIndex = list[i];
		int k = i - 1;
		int m = j + 1;

		while (k < m) {
			k++;
			while (list[k] < pIndex) {
				k++;
			}
			m--;
			while (list[m] > pIndex) {
				m--;
			}
			if (k < m) {
				swapElement(list, k, m);
			}
		}
		return m;
	}

	private static boolean compareElement(int [] list, int i, int j) {
		return list[i] <= list[j];
	}

	// exchange elements i and j in array a
	// and increment a global “exchangeCount” variable
	private static int [] swapElement(int [] list, int i, int j) {
		int [] updatedList;
		int t = list[i];
		list[i] = list[j];
		list[j] = t;

		updatedList = list;
		return updatedList;
	}

}