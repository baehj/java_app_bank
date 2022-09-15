package bankapp;

public class Account {

	private int accountNum; // 계좌번호
	private int userNum;	// 회원번호
	private int balance;	// 잔액
	
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public Account account; //field
	public Account() {}
	
}