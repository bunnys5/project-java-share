package sales;

public class Register {
	String username;
	long password;
	Register(String username, long password){
		this.username = username;
		this.password = password;
	}
	public String toString() {
		return "username:" + username + ", password:" + password;
	}

}
