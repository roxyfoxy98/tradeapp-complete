package ing.stockmarket;

public class Transaction {

	private int ID;
	private double ASK;
	private double BID;
	private int QTY;
	

	public int getId() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public double getAsk() {
		return ASK;
	}

	public void setAsk(double ASK) {
		this.ASK = ASK;
	}

	public double getBid() {
		return BID;
	}

	public void setBid(double BID) {
		this.BID = BID;
	}

	public int getQty() {
		return QTY;
	}
	public void setQty(int newQty) {
		
		this.QTY=newQty;
	}
	
	
	
}
