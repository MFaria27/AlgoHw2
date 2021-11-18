
public class MinPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	
	public MinPQ(int maxN) {
		//Make an array of Keys of size maxN passed into the method
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty() { //Returns true if the array is empty
		return N == 0;
	}
	
	public int size() { //Return the number of items in the stack
		return N;
	}
	
	public void insert(Key v) { //Insert the Key into the priority queue
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMin() { //Delete the minimum value node and return the Key deleted
		Key min = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		return min;
	}
	
	private void swim(int k) { //Place the new node in it's correct location
		while (k > 1 && greater(k/2, k)) {
			exch(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k) { //Re-Heapify the heap by sinking the exchanged node to its correct location
		while (2*k <= N) {
			int j = 2*k;
			if(j < N && greater(j, j+1)) j++;
			if(!greater(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	private boolean greater(int i, int j) { //return true if the Key at one index is greater than the Key at the other
		return pq[i].compareTo(pq[j]) > 0;
	}

	private void exch(int i, int j) { //Exchange the values at indices i and j
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	//This method is not required in Priority Queue API, but I made it in order to assist with checking my work on question 3
	public void show() { //Display the priority queue without using delMin()
		for(Key k : pq) {
			if(!(k == null))
				System.out.print(k + " ");
		}
		System.out.println(" ");
	}
}

