
public class Check extends Payment {
	private int checkNum;

	public Check(double subtotal) {
		super(subtotal);
		this.checkNum = checkNum;
	}

	public int getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}

	@Override
	public void toPrint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
	
}
