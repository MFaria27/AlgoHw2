
public class Pokemon implements Comparable<Pokemon> {
	
	private final String name;
	private final int ID;

	public Pokemon(String name, int ID) {
		//There are not pokemon with and ID of 0 and below or 898 and above
		if (ID > 898 && ID < 1) 
			throw new IllegalArgumentException("There is no pokemon with this ID");
		this.name = name;
		this.ID = ID;
	}
	
	public Pokemon(String pokeString) {
		//Split a string assuming it is only a pokemon name and it's ID
		String[] a = pokeString.split("\\s+");
		int id = Integer.parseInt(a[1]);
		if (id > 898 && id < 1) 
			throw new IllegalArgumentException("There is no pokemon with this ID");
		name = a[0];
		ID = id;
	}
	
	public String getName() {
		//Return the pokemon's name
		return name;
	}
	
	public int getID() {
		//Return the pokemon's ID
		return ID;
	}
	
	public String toString() {
		//When printing the pokemon as an object, return this string
		return "ID: #" + ID + " Pokemon: " + name;
	}

	public int compareTo(Pokemon poke) {
		//Implements comparable, compares the ID's of two pokemon
		return Integer.compare(this.ID, poke.ID);
	}
	
	public boolean equals(Object other) {
		//Check all points of equality between this pokemon and the pokemon passed into the method
		if (other == this) return true;
		if (other == null) return false;
		if (other.getClass() != this.getClass()) return false;
		Pokemon that = (Pokemon) other;
		return (this.ID == that.ID) && (this.name.equals(that.name));
	}

}
