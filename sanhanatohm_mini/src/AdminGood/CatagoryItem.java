package AdminGood;

public class CatagoryItem {
	public int id;
	public String name;
	
	public CatagoryItem (String name, int id) {
		this.id = id;
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public int getId() {
		return id;
	}

}
