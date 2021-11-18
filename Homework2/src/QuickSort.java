import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	public static int qSteps;
	
	public QuickSort() {
		
	}

	public static void sort(Comparable[] a) {
		//Quick sort sorts a completely random array of integers, so the code will make use of the shuffle method from StdRandom to shuffle the array.
		StdRandom.shuffle(a);
		quickSort(a, 0, a.length-1);
	}
	
	private static void quickSort(Comparable[] a, int low, int high) {
		qSteps++; //A step will be recorded every time a comparison is made.
		if (high <= low) return; //If the low point is greater than the high point, either something failed, or nothing was found.
		int j = partition(a, low, high); //Quick sort works by first selecting a pivot. 
		quickSort(a, low, j-1); //Then everything that is less then that pivot's value is exchanged to the left of the pivot
		quickSort(a, j+1, high); //and everything that is greater will be moved to the right.
		//This ensures that the pivot is always in the correct spot, and when ran recursively throughout the array, will ensure everything is in the correct spot.
	}
	
	private static int partition(Comparable[] a, int low, int high) {
		int i = low, j = high + 1;
		Comparable v = a[low];
		while(true) {
			while(less(a[++i], v)) if (i == high) break; // Once it reaches the end of the right side of the array past the pivot.
			while(less(v, a[--j])) if (j == low) break; // Once it reaches the end of the left side of the array before the pivot.
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, low, j);
		return j;
	}
	
	//The Less(v, w) function returns true if v is less than w using eclipse's compareTo() function.
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
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
			if (less(a[i], a[i-1])) return false;
		}
		return true;
	}
}
