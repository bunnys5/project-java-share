package sales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class DBregister {
	
	public static Vector<Register> registerDB(String sql) throws SQLException {

		Vector<Register> register = new Vector();
		
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();

		Statement stmnt = null;
		if (con != null) {
			stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				String username = rs.getString("USERNAME");
				long password = rs.getLong("PASSWORD");
				Register registeruser = new Register(username, password);
				register.add(registeruser);
			}
			stmnt.close();
			con.close();
		}
		return register;
	}

	public static void executeDB(String sql) throws SQLException {
		System.out.println("BalanceDB.BalanceGoods()");
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();

		Statement stmnt = null;
		if (con != null) {
			stmnt = con.createStatement();
			stmnt.execute(sql);
			stmnt.close();
			con.close();
		}
	}
	}


