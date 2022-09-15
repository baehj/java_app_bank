package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class Ex29 {
	Connection conn;
	PreparedStatement pstmt;
	
	public Ex29() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
// oracle - "oracle.jdbc.driver.OracleDriver"
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "java");
// "jdbc:oracle:thin:@loaclhost:1521:xe", "hr", "hr"
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert1() {
		pstmt = null;
		try {
			for(int i=0; i<9; i++) {
				int j = 0;
				if(i<3) {
					j = 1;
				}else if (i>=3 && i<6) {
					j = 2;
				}else {j=3;}
				pstmt = conn.prepareStatement("insert into DBTEST values ('user" + i + "', '123', '" + j + "')");
				int result = pstmt.executeUpdate();
				String msg = result > -1 ? "성공" : "실패";
				System.out.println(msg);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e2) {
			}
		}
	}
	
	public void selectRanking() {
		pstmt = null;
		try {
			pstmt = conn.prepareStatement("select ID from DBTEST where RANKING = '1'");
			ResultSet result = pstmt.executeQuery();
			 while(result.next()){
				 String ID = result.getString("ID");
				 int RANKING = result.getInt("RANKING");
				 System.out.println("ID" + ID);
				 System.out.println("RANKING" + RANKING);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e2) {
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex29().selectRanking();
		System.out.println("test");
	}

}
