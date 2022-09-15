package bankapp;

public class User {
	
	private String userNum;	// 회원번호
	private String name; 	// 이름
	private String id; 		// 아이디
	private int birth; 		// 생년월일
	private int pw; //비밀번호
	private int phone; // 전화번호
	private int joinDate; // 가입일
	private int balance; //잔액
	private int login; // 0은 로그인X, 1은 로그인O
	private int rank; // 0은 로그인X, 1은 로그인O
	
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(int joinDate) {
		this.joinDate = joinDate;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getLogin() {
		return login;
	}
	public void setLogin(int login) {
		this.login = login;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String join(String name, String id, int pw, int birth, int phone) {
		String sql = "INSERT INTO DBTEST VALUES (" + name;
		
		// userNum, Name
		
		return sql;
	}
	public String nameCheck(String name, int phone) {
		String sql = "SELECT * FROM DBTEST WHERE NAME =" + name + "AND PHONE = " + phone;
		return sql;
	}
	public String idCheck(String id) {
		String sql = "SELECT * FROM DBTEST WHERE ID =" + id;
		return sql;
	}
	
	
}
