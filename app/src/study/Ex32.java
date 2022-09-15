package study;

import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class Ex32 {
	
	public static void main(String[] args) {
		Connection conn = EX30.getInstance().getConnection();
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("ID : ");
		String id = scan.next();
		try {
			pstmt = conn.prepareStatement(delete());
			pstmt.setString(1, id); //첫번째에 ID를 넣어라
			int result = pstmt.executeUpdate();
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println("데이터베이스 드라이버 로딩실패!");
			e.printStackTrace();
		}
	}
	
	public static String delete() {
		// Scanner scan = new Scanner(System.in);
		// System.out.println("ID : ");
		// String id = scan.next();
		String sql = "DELETE FROM DBTEST WHERE ID=?";
		return sql;
	}
}
