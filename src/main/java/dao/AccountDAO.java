package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Account;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class AccountDAO {

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
	//会員登録
	public static int registerAccuont(Account register) {
		String sql = "INSERT INTO team_account VALUES(default, ?, ?, ?, ?)";
		int result = 0;
		
		String salt = GenerateSalt.getSalt(32);
		String hashedPw = GenerateHashedPw.getSafetyPassword(register.getPw(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, register.getName());
			pstmt.setString(2, register.getMail());
			pstmt.setString(3, salt);
			pstmt.setString(4, hashedPw);
			
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
	
	// ログイン処理
		public static Account login(String mail, String hashedPw) {
			String sql = "SELECT * FROM team_account WHERE mail = ? AND password = ?";
			
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				pstmt.setString(1, mail);
				pstmt.setString(2, hashedPw);

				try (ResultSet rs = pstmt.executeQuery()){
					
					if(rs.next()) {
						String id = rs.getString("id");
						String name = rs.getString("name");
						String salt = rs.getString("salt");
						
						return new Account(id, name, mail, null, null,salt);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		// メールアドレスを元にソルトを取得
		public static String getSalt(String mail) {
			String sql = "SELECT salt FROM team_account WHERE mail = ?";
			
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				pstmt.setString(1, mail);

				try (ResultSet rs = pstmt.executeQuery()){
					
					if(rs.next()) {
						String salt = rs.getString("salt");
						return salt;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return null;
		}
}