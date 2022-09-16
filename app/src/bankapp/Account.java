package bankapp;

public class Account {

	private int account_num; // 계좌번호
	private int user_num;	// 회원번호
	private int balance;	// 잔액
	private char ranking;	// 잔액
	
	public int getAccount_num() {
		return account_num;
	}
	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public char getRanking() {
		return ranking;
	}
	public void setRanking(char ranking) {
		this.ranking = ranking;
	}
	
	public Account account; //field
	public Account() {}
	
	public String createAccount(int userNum) {
		int accountNum = (int) (Math.random()*899999+100000);
		String sql = "INSERT INTO ACCOUNT VALUES ( '" + accountNum + "','" + userNum + "', 0 , 3)";
		return sql;
	}
	public String deposit(int amount) {
		String sql = "UPDATE ACCOUNT SET BALANCE = BALANCE +" + amount;
		return null;
	}
	public String selectAcByUser_num(int user_num) {
		String sql = "SELECT * FROM ACCOUNT WHERE USER_NUM = " + user_num ;
		return null;
	}
	
}