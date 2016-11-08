
public class CreditCard extends Payment{
	private long creditCardNum;
	private int expirationDate;
	private int cvv;

	public CreditCard(double subtotal) {
		super(subtotal);
		this.creditCardNum = creditCardNum;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}

	public long getCreditCardNum() {
		return creditCardNum;
	}

	public int getExpirationDate() {
		return expirationDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCreditCardNum(long creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
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


