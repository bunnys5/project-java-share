package AdminGood;

public class Goods {
	public int id;
	public int lv3;
	public int lv2;
	public int lv1;
	public String name;
	public int unit_price;
	public int stocks;
	
	public Goods(int id, int lv3, int lv2, int lv1, String name, int unit_price, int stocks) {
		this.id = id;
		this.lv3 = lv3;
		this.lv2 = lv2;
		this.lv1 = lv1;
		this.name = name;
		this.unit_price = unit_price;
		this.stocks = stocks;
	}
	
	public String toString() {
		return "id: " + id + ", lv3: " + lv3 + ", lv2: " + lv2 + ", lv1: " + lv1 + ", name: " + name + ", unit_price: " + unit_price + ", stocks" + stocks; 
	}
	

}
