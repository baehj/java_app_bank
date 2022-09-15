package bankapp;

public class TransferList {

	private int senderAccount; 		// 보내는이
	private int receiverAccount;	// 받는이
	private int amount; 			// 금액
	private int remittanceDate;		// 송금일
	
	public int getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(int senderAccount) {
		this.senderAccount = senderAccount;
	}
	public int getReceiverAccount() {
		return receiverAccount;
	}
	public void setReceiverAccount(int receiverAccount) {
		this.receiverAccount = receiverAccount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getRemittanceDate() {
		return remittanceDate;
	}
	public void setRemittanceDate(int remittanceDate) {
		this.remittanceDate = remittanceDate;
	}
	
	public TransferList tl;
	public TransferList(){};
}
