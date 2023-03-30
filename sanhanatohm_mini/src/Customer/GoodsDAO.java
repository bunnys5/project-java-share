package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {
    private static final String DB_URL = "jdbc:mariadb://202.28.34.205:3306/db64011211064";
    private static final String DB_USER = "64011211064";
    private static final String DB_PASSWORD = "64011211064";

    public List<String> getAllIds() {
        List<String> ids = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT id FROM goods";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // Add data to list
            while (rs.next()) {
                ids.add(rs.getString("id"));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

    public Goods getGoodsById(String id) {
        Goods goods = null;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT * FROM goods WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            // Add data to goods object
            while (rs.next()) {
                goods = new Goods(
                        rs.getString("id"),
                        rs.getString("lv3"),
                        rs.getString("lv2"),
                        rs.getString("lv1"),
                        rs.getString("name"),
                        rs.getDouble("unit_price"),
                        rs.getInt("stocks"));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }
}
