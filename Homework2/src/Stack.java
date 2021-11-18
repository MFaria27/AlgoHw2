import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	//Create an array of items
	private Item[] a = (Item[]) new Object[1]; 
	private int N = 0; 

	public boolean isEmpty() { //Returns true if the array is empty
		return N == 0;
	}

	public int size() { //Return the number of items in the stack
		return N;
	}

	private void resize(int max) { //Resize the stack to a size of the integer passed into the array
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}

	public void push(Item item) { //Add a new item to the stack
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}

	public Item pop() { //Remove an item from the top of stack
		Item item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	public Iterator<Item> iterator() { //Make the array iteratable
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {
		private int i = 0;

		public boolean hasNext() {
			return i < N;
		}

		public Item next() {
			return a[i++];
		}

		public void remove() {
		}
	}
}

