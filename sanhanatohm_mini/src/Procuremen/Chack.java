package Procuremen;

public class Chack {
	
	String name;
	String ReceiveDate;
	public Chack(String name,String ReceiveDate) {
		this.name = name;
		this.ReceiveDate = ReceiveDate;
	}
	public String toString() {
		return "name:" + name +", ReceiveDate:" + ReceiveDate;
	}

}
