import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

//Mattheus Faria

public class Hw2Runner {

	public static void main(String[] args) {
		//System.out.println("Hello, World!");
		question1();
		question2();
		question3();

	}
	
	public static void question1() {
		//Question 1 Task 4a
		//Generate a random array of size 100 with ints ranging from 0-1000
		int[] a = IntStream.generate(()-> new Random().nextInt(1000)).limit(100).toArray();
		//Turn that array of int into Integer objects
		Integer[] arr = Arrays.stream(a).boxed().toArray(Integer[]::new);
		
		MinPQ<Integer> pq = new MinPQ<Integer>(arr.length+1);
		//Insert all the array into a Minimum built Heap (Smallest number at the root node)
		for(Integer i : arr) pq.insert(i);
		
		//Turn the priority queue into a stack 
		//In MinPQ and MaxPQ, I made a function that printed the priority queue (method show())
		//For continuity, I will use the method from in class
		Stack<Integer> stack = new Stack<Integer>();
		//Delete the minimum node and put it into the stack
		while(!pq.isEmpty()) stack.push(pq.delMin());
		for (Integer i : stack)
			System.out.print(i + " ");
		System.out.printf("\n\n");
		
		//Question 1 Task 4b
		try {
			//Open up a file of 30 random pokemon
			//File was randomly generated ID's and the pokemon names associated with that ID
			File f = new File("randPokemon.txt");
			Scanner sc = new Scanner(f);
			//Create a Minimum priority queue and show the <howMany> first smallest pokemon based on ID
			
			int howMany = 30;
			MinPQ<Pokemon> pokeQ = new MinPQ<Pokemon>(howMany+1);
			//Read the next line in the file and create a new pokemon data object and insert it into the priority queue
			while (sc.hasNextLine()) {
				pokeQ.insert(new Pokemon(sc.nextLine()));
				if (pokeQ.size() > howMany) pokeQ.delMin();
			}
			
			//Delete the minimum node and put it into the stack
			Stack<Pokemon> pokeStack = new Stack<Pokemon>();
			while(!pokeQ.isEmpty()) pokeStack.push(pokeQ.delMin());
			for (Pokemon poke : pokeStack) System.out.println(poke);
			
		} catch (FileNotFoundException e) {
			//If the file was not found, catch the error
			System.out.println("File was not found.");
			e.printStackTrace();
		}
		System.out.printf("\n");
	}
	
	public static void question2() {
		//Varying sizes that will be used to generate larger and larger array
		int[] arrSizes = {100, 1000, 10000, 100000, 250000};
		
		HeapSort heap = new HeapSort();
		System.out.println();
		System.out.println("Heap Sort:");
		for (int i : arrSizes) {
			//generate an array of random integers from 0-1000
			int[] intSort = IntStream.generate(() -> new Random().nextInt(1000)).limit(i).toArray();
			//Turn the array of ints into Integers
			Integer[] integerSort = Arrays.stream(intSort).boxed().toArray(Integer[]::new);
			Stopwatch timer = new Stopwatch();
			heap.sort(integerSort);
			StdOut.printf("Array Size: %d\n \tElapsed Time: %.1f ms\n", i, timer.elapsedTime()*1000);
		}
		
		QuickSort quick = new QuickSort();
		System.out.println();
		System.out.println("Quick Sort:");
		for (int i : arrSizes) {
			//generate an array of random integers from 0-1000
			int[] intSort = IntStream.generate(() -> new Random().nextInt(1000)).limit(i).toArray();
			//Turn the array of ints into Integers
			Integer[] integerSort = Arrays.stream(intSort).boxed().toArray(Integer[]::new);
			Stopwatch timer = new Stopwatch();
			quick.sort(integerSort);
			StdOut.printf("Array Size: %d\n \tElapsed Time: %.1f ms\n", i, timer.elapsedTime()*1000);
		}
		
		InsertionSort insert = new InsertionSort();
		System.out.println();
		System.out.println("Insertion Sort:");
		for (int i : arrSizes) {
			//generate an array of random integers from 0-1000
			int[] intSort = IntStream.generate(() -> new Random().nextInt(1000)).limit(i).toArray();
			//Turn the array of ints into Integers
			Integer[] integerSort = Arrays.stream(intSort).boxed().toArray(Integer[]::new);
			Stopwatch timer = new Stopwatch();
			insert.sort(integerSort);
			StdOut.printf("Array Size: %d\n \tElapsed Time: %.1f ms\n", i, timer.elapsedTime()*1000);
		}
	}
	
	//This method was made to do a quick fact check with my manual creation of a max-heap
	public static void question3() {
		//The array given in question 3
		int[] a = new int[]{22,38,5,40,20,38,25,47,5,19};
		//Turn the array of ints into Integer Objects
		Integer[] arr = Arrays.stream(a).boxed().toArray(Integer[]::new);
		
		MaxPQ<Integer> pq = new MaxPQ<Integer>(arr.length+1);
		for(Integer i : arr) {
			pq.insert(i);
			pq.show(); //Print the priority Queue without getting rid of the nodes
		}
	}

}
