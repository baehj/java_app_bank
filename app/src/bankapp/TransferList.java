package bankapp;

import java.util.Date;

public class TransferList {

	private int transferlist_num; 		
	private int account_num; // from
	private int reciever_account_num; // to
	private int amount; // +,-로 입출금 구분.
	private int after_balance; 	
	private Date transfer_date;		
	
	public int getTransferlist_num() {
		return transferlist_num;
	}
	public void setTransferlist_num(int transferlist_num) {
		this.transferlist_num = transferlist_num;
	}
	public int getAccount_num() {
		return account_num;
	}
	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}
	public int getReciever_account_num() {
		return reciever_account_num;
	}
	public void setReciever_account_num(int reciever_account_num) {
		this.reciever_account_num = reciever_account_num;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAfter_balance() {
		return after_balance;
	}
	public void setAfter_balance(int after_balance) {
		this.after_balance = after_balance;
	}
	public Date getTransfer_date() {
		return transfer_date;
	}
	public void setTransfer_date(Date transfer_date) {
		this.transfer_date = transfer_date;
	}

	public String plus(User loginUser, int amount) {
		String sql = "INSERT INTO TRANSFER_LIST VALUES (NULL,";
		return sql;
	}
	public String insert(Account loginAccount, int amount) {
		String sql = "INSERT INTO TRANSFER_LIST VALUES (NULL," + loginAccount.getAccount_num() + "," 
					+ loginAccount.getAccount_num() + "," + amount + "," + loginAccount.getBalance() + ", curdate()) " ;
		return sql;
	}
	public String insertTransfer(Account loginAccount, int reciever_account_num, int amount) {
		String sql = "INSERT INTO TRANSFER_LIST VALUES (NULL," + loginAccount.getAccount_num() + "," 
				+ reciever_account_num + "," + amount + "," + loginAccount.getBalance() + ", curdate()) " ;
	return sql;
	}
	
	
}
