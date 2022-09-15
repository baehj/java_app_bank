package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class Ex28 {
	Connection conn;
	Statement stmt;
	
	public Ex28() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
// oracle - "oracle.jdbc.driver.OracleDriver"
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "java");
// "jdbc:oracle:thin:@loaclhost:1521:xe", "hr", "hr"
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void createTable() {
		// stmt = null;
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("create table DBTEST(ID varchar(50), PW varchar(50), RANKING INT)");
			if(result < 0) {
				System.out.println("실행실패");
			} else {
				System.out.println("실행성공");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e2) {
			}
		}
	}
	
	public void insert() {
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("insert into DBTEST values ('idid', 'pwpw')");
			if(result < 0) {
				System.out.println("실행실패");
			} else {
				System.out.println("실행성공");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e2) {
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex28().createTable();
		System.out.println("test");
	}

}
