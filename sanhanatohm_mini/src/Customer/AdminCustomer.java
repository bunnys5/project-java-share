package Customer;

public class AdminCustomer {
	
	int id;
	String username;
	int password;
	public AdminCustomer(int id, String username, int password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public String toString() {
		return "id:" + id +", username:" + username +", password:" + password;
	}

}
