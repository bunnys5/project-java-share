package AR;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class DBbalancegoods {

	public static Vector<balancegoods> balanceDB(String sql) throws SQLException {

		Vector<balancegoods> Balance = new Vector();

		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();

		Statement stmnt = null;
		if (con != null) {
			stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("NAME");
				int stock = rs.getInt("STOCK");
				balancegoods BalanceGoods = new balancegoods(name, stock);
				Balance.add(BalanceGoods);
			}
			stmnt.close();
			con.close();
		}
		return Balance;
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
