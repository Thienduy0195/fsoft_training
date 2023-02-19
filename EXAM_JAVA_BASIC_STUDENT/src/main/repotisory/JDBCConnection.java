package main.repotisory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01 Class BaseRepository to connect Java
 *                     application to database
 */
public class JDBCConnection {

	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName=STUDENT_MANAGEMENT;encrypt=true;trustServerCertificate=true;" + "integratedSecurity=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "12345";

	public JDBCConnection() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @return Connection
	 * @TODO get Connection from application to database
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// declare Connection instance from JDBC
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
