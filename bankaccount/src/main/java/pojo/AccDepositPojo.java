package pojo;
	
public class AccDepositPojo {
	int accountid,amount;

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public AccDepositPojo(int accountid, int amount) {
		super();
		this.accountid = accountid;
		this.amount = amount;
	}

	public AccDepositPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
