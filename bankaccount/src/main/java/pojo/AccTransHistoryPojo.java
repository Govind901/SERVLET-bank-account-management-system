package pojo;

import java.sql.Date;

public class AccTransHistoryPojo {
	int transactionid, account_id,  amount;
	String transactiontype;
	Date date;
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public AccTransHistoryPojo(int transactionid, int account_id, int amount, String transactiontype, Date date) {
		super();
		this.transactionid = transactionid;
		this.account_id = account_id;
		this.amount = amount;
		this.transactiontype = transactiontype;
		this.date = date;
	}
	
}
