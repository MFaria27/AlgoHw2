
public class Pokemon implements Comparable<Pokemon> {
	
	private final String name;
	private final int ID;

	public Pokemon(String name, int ID) {
		if (ID > 898) 
			throw new IllegalArgumentException("There is no pokemon with this ID");
		this.name = name;
		this.ID = ID;
	}
	
	public Pokemon(String pokeString) {
		String[] a = pokeString.split("\\s+");
		name = a[0];
		ID = Integer.parseInt(a[1]);
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
	
	public String toString() {
		return "ID: #" + ID + " Pokemon: " + name;
	}

	public int compareTo(Pokemon poke) {
		return Integer.compare(this.ID, poke.ID);
	}
	
	public boolean equals(Object other) {
		if (other == this) return true;
		if (other == null) return false;
		if (other.getClass() != this.getClass()) return false;
		Pokemon that = (Pokemon) other;
		return (this.ID == that.ID) && (this.name.equals(that.name));
	}

}
