package bankapp;

public class Account {

	private int account_num; // 계좌번호
	private int user_num;	// 회원번호
	private int balance;	// 잔액
	private String ranking;	// 잔액
	
	public int getAccount_num() {
		return account_num;
	}
	public Account setAccount_num(int account_num) {
		this.account_num = account_num;
		return this;
	}
	public int getUser_num() {
		return user_num;
	}
	public Account setUser_num(int user_num) {
		this.user_num = user_num;
		return this;
	}
	public int getBalance() {
		return balance;
	}
	public Account setBalance(int balance) {
		this.balance = balance;
		return this;
	}
	public String getRanking() {
		return ranking;
	}
	public Account setRanking(String ranking) {
		this.ranking = ranking;
		return this;
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