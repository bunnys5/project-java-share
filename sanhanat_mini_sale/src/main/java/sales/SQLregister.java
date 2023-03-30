package sales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class SQLregister {
	
	public static String registerSQL(Register register) {
		System.out.println("registerSQL.addregisterSQL()");
		String insertSql = "INSERT INTO CUSTOMER VALUES" 
				+ "('" + register.username 
				+ "', " + register.password 
				+ ")";
		System.out.println("insertSql:" + insertSql);
		return insertSql;
	}

}
