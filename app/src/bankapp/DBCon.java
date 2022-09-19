package bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static DBCon instance;
	private Connection conn;
	public DBCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "java");
			//System.out.println("test"); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static DBCon getInstance() {
		if(instance == null) 
			instance = new DBCon();
			return instance;
	}
	public Connection getConnection() {
		return this.conn;
	}
}
