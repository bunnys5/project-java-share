package Procuremen;

public class Check {
	
	String name;
	String ReceiveDate;
	public Check(String name,String ReceiveDate) {
		this.name = name;
		this.ReceiveDate = ReceiveDate;
	}
	public String toString() {
		return "name:" + name +", ReceiveDate:" + ReceiveDate;
	}

}
