package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EX30 {
	private static EX30 instance;
	private Connection conn;
	public EX30() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "java");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static EX30 getInstance() {
		if(instance == null) 
			instance = new EX30();
			return instance;
	}
	public Connection getConnection() {
		return this.conn;
	}
}
