package study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex33 {

	public static void main(String[] args) {
		Connection conn = EX30.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(select());
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for (int i=1; i<= cols; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			System.out.println();
			List<User> data = new ArrayList<>();
			while(rs.next()) {
				/*
				 for(int i=1; i<=cols; i++) {
				 
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
				*/
				User user = new User().setId(rs.getString(1)).setPw(rs.getString(2)); //db를 받아 user에 저장한다음
				data.add(user); //data라는 list에 저장함. -> client쪽에서 사용
			}
			Iterator<User> iterator = data.iterator();
			while(iterator.hasNext()) {
				User userinfo = iterator.next();
				System.out.println(
						userinfo.getId()+", " +
						userinfo.getPw()
				);
			}
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
	public static String select() {
		String sql = "SELECT * FROM DBTEST";
		return sql;
	}
}

class User{
	private String id;
	private String pw;
	public String getId() {
		return id;
	}
	public User setId(String id) {
		this.id = id;
		return this;
	}
	public String getPw() {
		return pw;
	}
	public User setPw(String pw) {
		this.pw = pw;
		return this;
	}
	
	
}

