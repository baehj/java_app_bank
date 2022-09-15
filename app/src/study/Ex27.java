package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex27 {

	public Ex27() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
// oracle - "oracle.jdbc.driver.OracleDriver"
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "java");
// "jdbc:oracle:thin:@loaclhost:1521:xe", "hr", "hr"
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Ex27();
		System.out.println("test"); 
	}

}
