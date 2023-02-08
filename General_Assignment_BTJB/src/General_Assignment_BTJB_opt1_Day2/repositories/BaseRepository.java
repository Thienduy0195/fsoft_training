package General_Assignment_BTJB_opt1_Day2.repositories;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseRepository {

	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName=CANDIDATE_DATABASE;encrypt=true;trustServerCertificate=true;" + "integratedSecurity=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "12345";

	public BaseRepository() {
		// TODO Auto-generated constructor stub
	}

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
