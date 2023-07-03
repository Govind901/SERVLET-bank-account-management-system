package pojo;

public class AccTransferPojo {
	int sourcrAid,destAid,amount;

	public int getSourcrAid() {
		return sourcrAid;
	}

	public void setSourcrAid(int sourcrAid) {
		this.sourcrAid = sourcrAid;
	}

	public int getDestAid() {
		return destAid;
	}

	public void setDestAid(int destAid) {
		this.destAid = destAid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public AccTransferPojo(int sourcrAid, int destAid, int amount) {
		super();
		this.sourcrAid = sourcrAid;
		this.destAid = destAid;
		this.amount = amount;
	}
	
}
