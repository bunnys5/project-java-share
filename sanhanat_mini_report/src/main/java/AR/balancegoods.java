package AR;

public class balancegoods {
	String name;
	int stock;
	balancegoods(String name, int stock){
		this.name = name;
		this.stock = stock;
	}
	
	public String toString() {
		return "name:" + name + ", stock:" + stock;
	}

}
