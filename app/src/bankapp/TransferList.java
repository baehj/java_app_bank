package bankapp;

import java.util.Date;

public class TransferList {

	private int account_num; 		
	private int user_num;			
	private char sort; 				
	private int amount; 			
	private Date transfer_date;		
	
	
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
	public char getSort() {
		return sort;
	}
	public void setSort(char sort) {
		this.sort = sort;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getTransfer_date() {
		return transfer_date;
	}
	public void setTransfer_date(Date transfer_date) {
		this.transfer_date = transfer_date;
	}
	
	public TransferList tl;
	public TransferList(){};
}
