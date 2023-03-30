package AR;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;


public class SQLbalancegoods {
	
	public static String viewbalancegoods() {
		System.out.println("balancegoodsDB.viewbalancegoods()");
		String selectSql = "SELECT * FROM GOODS";
		System.out.println("selectSql:" + selectSql);
		return selectSql;
	}

}
