package study;

public class Account {
	private long balance;
	public Account() {}
	public long getBalance() {
		return balance;
	}
	public void deposit(int money) {
		balance += money;
	}
	public void withdraw(int money) throws BalanceInsufficientException{
		if(balance < money) {
			throw new BalanceInsufficientException
				("잔고부족 : " + (money-balance)+" 모자람");
		}
		balance -= money; // 예외가 실행되면 실행되지 않음.
	}
}
