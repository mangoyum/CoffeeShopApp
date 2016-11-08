
public class Check extends Payment {
	private int checkNum;

	public Check(double subtotal, double tax, double grandTotal, int checkNum) {
		super(subtotal, tax, grandTotal);
		this.checkNum = checkNum;
	}

	public int getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}
	
	

	
	
	
}
