package General_Assignment_BTJB_opt1_Day2.repositories;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01 
 * Class BaseRepository to connect Java
 *                     application to database
 */
public class BaseRepository {

	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName=CANDIDATE_DATABASE;encrypt=true;trustServerCertificate=true;" + "integratedSecurity=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "12345";

	public BaseRepository() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return Connection 
	 * Get connection for connect Java application to database
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}

}
