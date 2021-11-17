import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Hw2Runner {

	public static void main(String[] args) {
		//System.out.println("Sweet");
		//question1();
		question2();

	}
	
	public static void question1() {
		//Question 4a
		int[] a = IntStream.generate(()-> new Random().nextInt(1000)).limit(100).toArray();
		Integer[] arr = Arrays.stream(a).boxed().toArray(Integer[]::new);
		
		MinPQ<Integer> pq = new MinPQ<Integer>(arr.length+1);
		for(Integer i : arr) pq.insert(i);
		
		Stack<Integer> stack = new Stack<Integer>();
		while(!pq.isEmpty()) stack.push(pq.delMin());
		for (Integer i : stack)
			System.out.print(i + " ");
		System.out.println(" ") ;System.out.println(" ");
		
		//Question 4b
		try {
			File f = new File("randPokemon.txt");
			Scanner sc = new Scanner(f);
			MinPQ<Pokemon> pokeQ = new MinPQ<Pokemon>(31);
			while (sc.hasNextLine()) {
				pokeQ.insert(new Pokemon(sc.nextLine()));
				if (pokeQ.size() > 30) pokeQ.delMin();
			}
			Stack<Pokemon> pokeStack = new Stack<Pokemon>();
			while(!pokeQ.isEmpty()) {
				Pokemon p = pokeQ.delMin();
				pokeStack.push(p);
			}
			for (Pokemon poke : pokeStack) System.out.println(poke);
		} catch (FileNotFoundException e) {
			System.out.println("File was not found.");
			e.printStackTrace();
		}
	}
	
	public static void question2() {
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

}
