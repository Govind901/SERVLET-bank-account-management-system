package pojo;

public class AccBalancePojo {
	int balance;
	int accountid;
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public AccBalancePojo(int balance,int accountid) {
		super();
		this.balance = balance;
		this.accountid=accountid;
	}
	
}
