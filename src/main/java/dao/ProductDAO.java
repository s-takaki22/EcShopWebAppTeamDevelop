package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Product;

public class ProductDAO {
	
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		return DriverManager.getConnection(dbUrl, username, password);
	}
	
	
	public static List<Product> selectAllTeam_product() {
		
		
		// 返却用変数
		List<Product> result = new ArrayList<>();

		String sql = "SELECT * FROM team_product";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String category = rs.getString("category");
					int price = rs.getInt("price"); 
					String content = rs.getString("content");
					int stock = rs.getInt("stock");

					Product employee = new Product(id, name, category, price, content,stock);
					
					result.add(employee);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch	(URISyntaxException e) {
			e.printStackTrace();
		}

		return result;
	}

public static int registerproduct(Product pr) {
	String sql = "INSERT INTO team_product VALUES(default, ?, ?, ?, ?, ? )";
	int result = 0;
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
			pstmt.setString(1, pr.getName());
			pstmt.setString(2, pr.getCategory());
			pstmt.setInt(3, pr.getPricce());
			pstmt.setString(4, pr.getContent());
			pstmt.setInt(5, pr.getStock());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
}
