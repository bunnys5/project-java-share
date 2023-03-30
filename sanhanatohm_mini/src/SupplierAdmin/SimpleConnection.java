package SupplierAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleConnection {
	
	public static void main(String[] args) {
		
		try {
			System.out.println("-------- MySQL DB JDBC Connection Testing ------");
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("MySQL JDBC Driver Registered!");

			Connection  connection = DriverManager.getConnection(
					"jdbc:mariadb://202.28.34.205:3306/test", 
					"64011211075", "64011211075");
			System.out.println("connection:" + connection);
			if (connection != null) {
				System.out.println("You made it, take control your database now!");
				connection.close();
				System.out.println("connection.close()");
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch(ClassNotFoundException ex) {		
			System.out.println("Where is your MySQL DB JDBC Driver?");
			System.out.println("Error! " + ex.getMessage());
			ex.printStackTrace();
		} catch(SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			System.out.println("Error! " + ex.getMessage());
			ex.printStackTrace();
		}
				
	}


}
