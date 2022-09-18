package study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex34 {

	// 테이블 생성 "CREATE TABLE ATTEST(ID VARCHAR(10) NOT NULL, PW VARCHAR(10));
	
	public static void main(String[] args) {
		Connection conn = EX30.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(alter());
			int result = pstmt.executeUpdate();
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {}
		}

	}
	
	// 실습
	// 1) 테이블에 새로운컬럼 추가
	// 2) 테이블의 컬럼 타입 수정
	// 3) 테이블의 컬럼이름 변경
	// 4) 테이블 컬럼 삭제
	
	public static String alter() {
		// 1) 테이블에 새로운컬럼 추가, AGE
		String sql = "ALTER TABLE ATTEST"
				+ "ADD COLUMN AGE VARCHAR(10) NOT NULL";
		// 2) 테이블의 컬럼 타입 수정 , AGE VARCHAR -> INT
		sql = "ALTER TABLE ATTEST MODIFY COLUMN AGE INT";
		// 3) 테이블의 컬럼이름 변경 , PW -> PASSWORD VARCHAR(30) NOT NUL
		sql = "ALTER TABLE ATTEST CHANGE COLUMN PW PASSWORD VARCHAR(30) NOT NULL";
		// 4) 테이블 컬럼 삭제, AGE
		sql = "ALTER TABLE ATTEST DROP CLOUMN AGE";
		
		return sql;
	}
}
