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
	private String login_check;
	
	
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
	public String getLogin_check() {
		return login_check;
	}
	public User setLogin_check(String login_check) {
		this.login_check = login_check;
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
	public String selectUserByUserNum(String id) {
		String sql = "SELECT user_num FROM USER where id = '" + id + "'";
		return sql;
	}
	public String selectUserByPhone(int phone) {
		String sql = "SELECT * FROM USER WHERE PHONE = " + phone;
	    return sql;
	}

	/*
	 * public String selectByIdPhone(String id1, int phone1) { String sql =
	 * "SELECT * FROM USER WHERE ID ='" + id1 +"'"; return sql; }
	 */	
	public String login(String id, String password) {
		String sql = "UPDATE USER SET LOGIN_CHECK = 'Y' WHERE ID = '" + id + "' AND PASSWORD = '" + password + "'" ;
		return sql;
	}
	public String selectUserByNamePhone(String name, int phone) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
