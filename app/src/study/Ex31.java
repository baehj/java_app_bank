package study;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class Ex31 {
	public String updateSql() {
		Scanner scan = new Scanner(System.in);
		System.out.println("ID : ");
		String id = scan.next();
		System.out.println("PW : ");
		String pw = scan.next();
		String sql = "UPDATE DBTEST SET PW='"+ pw + "' WHERE ID='" + id + "'"; 
		return sql;
	}
	
	public void update(String sql) {
		Statement stmt = null;
		Connection conn = EX30.getInstance().getConnection();
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			}catch(SQLException e) {}
		}
	}
	
	public static void main(String args[]) {
		Ex31 ex31 = new Ex31();
		ex31.update(ex31.updateSql());
	}
}
