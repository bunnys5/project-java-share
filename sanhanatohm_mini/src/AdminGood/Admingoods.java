package AdminGood;

public class Admingoods {
	
	String idgoods;
	String name;
	String Description;
	int price;
	int stock;
	public Admingoods(String idgoods, String name, String Description, int price, int stock) {
		this.idgoods = idgoods;
		this.name = name;
		this.Description = Description;
		this.price = price;
		this.stock = stock;
	}
	public String toString() {
		return "idgoods:" + idgoods +", name:" + name +", Description:" + Description +", price:" + price +", stock:" + stock;
	}

}
