package Procuremen;

public class Order {
	
	String idgoods;
	String supplier;
	String good;
	int quantity;
	String OrderDate;
	public Order(String supplier, String idgoods, String good, int quantity, String OrderDate) {
		this.idgoods = idgoods;
		this.supplier = supplier;
		this.good = good;
		this.quantity = quantity;
		this.OrderDate = OrderDate;
	}
	public String toString() {
		return "supplier:" + supplier +", idgoods:" + idgoods +", good:" + good +", quantity:" + quantity +", OrderDate:" + OrderDate; 
	}

}
