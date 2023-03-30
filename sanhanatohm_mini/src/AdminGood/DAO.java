package AdminGood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;



public class DAO {
	
	public static void ComboBoxVL1 (JComboBox<CatagoryItem> comboBox, int id) {
		try {

			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM c_l1 ");

			while (rs.next()) {

				CatagoryItem item = new CatagoryItem(rs.getString("name"),rs.getInt("id"));
				comboBox.addItem(item);
				
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
	
	public static void ComboBoxVL2 (JComboBox<CatagoryItem> comboBox, int id) {
		try {

			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM c_l2 WHERE lv1='" + id + "'");

			while (rs.next()) {

				CatagoryItem item = new CatagoryItem(rs.getString("name"),rs.getInt("id"));
				comboBox.addItem(item);
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
	
	public static void ComboBoxVL3 (JComboBox<CatagoryItem> comboBox, int id) {
		try {

			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM c_l3 WHERE lv2='" + id + "'");

			while (rs.next()) {

				CatagoryItem item = new CatagoryItem(rs.getString("name"),rs.getInt("id"));
				comboBox.addItem(item);
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
	
	public static void addGoods (Goods Goods)  {
		
		try {
			String insersql = "INSERT INTO goods_g (lv3,lv2,lv1,name,unit_price,stocks) VALUES " + "(" + Goods.lv3 + "," +  Goods.lv2 + "," + Goods.lv1+ ",'"+Goods.name+"',"+Goods.unit_price+","+Goods.stocks + ")";
			
			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();
			
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insersql);
				stmnt.close();
				con.close();
				System.out.println("Goods add successfully.");
			}
			
			
			
			
		} catch (SQLException ex) {
			System.out.println("Error! Invalid id.");
			
		}
	}
	
	public static void showDataTable(DefaultTableModel tableModel) {
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();
		
		try {
			String query = "SELECT * FROM goods_g";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("ID");
				String lv3 = rs.getString("lv3");
				String lv2 = rs.getString("lv2");
				String lv1 = rs.getString("lv1");
				String name = rs.getString("name");
				String price = rs.getString("unit_price");
				String stocks = rs.getString("stocks");

//				System.out.format("%s, %s, %s, %s, %s, %s, %s");
				
				Object[] row = {id, lv3, lv2, lv1, name, price, stocks};
				
				tableModel.addRow(row);
			}
			st.close();
			rs.close();
			con.close();
			
		}catch (SQLException ex) {
			System.out.println("Error! Invalid id.");
			System.err.println(ex.getMessage());
		}
	}
	
	public static void editgoods(upgoods up) {
        Le11ConnMariaDB connDB = new Le11ConnMariaDB();
        Connection con = connDB.getConnection();
        try {
            String upsql = "UPDATE GOODS_G SET NAME='" + up.nameup + "', UNIT_PRICE='" + up.Priceup + "', STOCKS='" + up.stocksup + "' WHERE ID=" + up.id;
            Statement stmnt = null;
            if (con != null) {
                stmnt = con.createStatement();
                stmnt.execute(upsql);
                stmnt.close();
                con.close();
                System.out.println("goods update successfully.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
	
	public static void deleteGoods(upgoods up) {
        Le11ConnMariaDB connDB = new Le11ConnMariaDB();
        Connection con = connDB.getConnection();
        try {
            String upsql = "DELETE FROM GOODS_G WHERE ID=" + up.id;
            Statement stmnt = null;
            if (con != null) {
                stmnt = con.createStatement();
                stmnt.execute(upsql);
                stmnt.close();
                con.close();
                System.out.println("goods update successfully.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
	
	
	

		
	}

