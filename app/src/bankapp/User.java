package bankapp;

import java.util.Date;

public class User {
	
	private int user_num;
	private String name;
	private String id;
	private String password;
	private int birth;
	private int phone;
	private Date join_date;
	private String admin; // Y, N
	
	
	public int getUser_num() {
		return user_num;
	}
	public User setUser_num(int user_num) {
		this.user_num = user_num;
		return this;
	}
	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
	public String getId() {
		return id;
	}
	public User setId(String id) {
		this.id = id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	public int getBirth() {
		return birth;
	}
	public User setBirth(int birth) {
		this.birth = birth;
		return this;
	}
	public int getPhone() {
		return phone;
	}
	public User setPhone(int phone) {
		this.phone = phone;
		return this;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public User setJoin_date(Date join_date) {
		this.join_date = join_date;
		return this;
	}
	public String getAdmin() {
		return admin;
	}
	public User setAdmin(String admin) {
		this.admin = admin;
		return this;
	}
	
	public String joinUser(String name, String id, String password, int birth, int phone) {
		String sql = "INSERT INTO USER VALUES (NULL, '" + name + "','" + id + "','"
				+ password + "','" + birth + "','" + phone + "', curdate() , 'N' )" ;
		return sql;
	}

	/*
	 * public String nameCheck(String name1, int phone1) { String sql =
	 * "SELECT * FROM USER"; //String sql = "SELECT * FROM USER WHERE NAME =" +
	 * name1 + "AND PHONE = " + phone1; return sql; }
	 */
	public String selectUserById(String id) {
		String sql = "SELECT * FROM USER WHERE ID ='" + id +"'";
		return sql;
	}
	public String selectUserByUserNum(int user_num) {
		String sql = "SELECT * FROM USER WHERE USER_NUM = '" + user_num + "'";
		return sql;
	}
	public String selectUserByPhone(int phone) {
		String sql = "SELECT * FROM USER WHERE PHONE = " + phone;
	    return sql;
	}

	public String login(String id, String password) {
		String sql = "SELECT * FROM USER WHERE ID = '" + id + "' AND PASSWORD = '" + password +"'";
		return sql;
	}
	public String selectUserByNamePhone(String name, int phone) {
		String sql = "SELECT * FROM USER WHERE NAME = '" + name + "' AND PHONE = '" + phone +"'";
		return sql;
	}
	public String selectUserNumById(String id) {
		String sql = "SELECT USER_NUM FROM USER WHERE ID = '" + id ;
		return sql;
	}
	public String changePhone(int user_num, int afterPhone) {
		String sql = "UPDATE USER SET PHONE = " + afterPhone + " WHERE USER_NUM = " + user_num;
		return sql;
	}
	public String changePw(int user_num, int afterPw) {
		String sql = "UPDATE USER SET PASSWORD = " + afterPw + " WHERE USER_NUM = " + user_num;
		return sql;
	}
	
}
