import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class HeapSort {
	
	public static void sort(Comparable[] a) {
		//Heapsort sorts through heaps by exchanging and sinking nodes in a priority queue (Binary)
		int N = a.length-1;
		for (int k = N/2; k >= 1; k--)
			sink(a, k, N);
		while(N > 1) { //Exchange the largest element with a[N] and then fix the heap with sink (Re-Heapify)
			exch(a, 1, N--); 
			sink(a, 1, N);
		}
	}
	
	private static void sink(Comparable[] a, int k, int N) { //Re-Heapify the heap by sinking the exchanged node to its correct location 
		while (2*k <= N) {
			int j = 2*k;
			if(j < N && less(a, j, j+1)) j++;
			if(!less(a, k, j)) break;
			exch(a, k, j);
			k = j;
		}
	}
	
	//The Less(v, w) function returns true if v is less than w using eclipse's compareTo() function.
	private static boolean less(Comparable[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}

	//The exch, or exchange function, takes an array and the indices that the array will swap.
	//It does this by setting the first value to a placeholder variable, setting the first value as the second value, then setting the second value to the placeholder variable.
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	//The show function takes an array and prints all the values ({"C", "A", "T"} will display "CAT").
	public void show(Comparable[] a) {
		for (Comparable element : a)
			StdOut.print(element + " ");
		StdOut.println();
	}

	//The isSorted function returns a boolean value that represents whether or not an array has been sorted.
	//It checks this by using the less() function, and making sure that every value is less than the next. 
	//If it is not, it will return false.
	public boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a, i, i-1)) return false;
		}
		return true;
	}
}
