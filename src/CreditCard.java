import java.math.BigDecimal;
import java.util.Calendar;

public class CreditCard extends Payment {
	private long creditCardNum;
	private String expirationDate;
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

	public String getExpirationDate() {
		return expirationDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCreditCardNum(long creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	public void setExpirationDate(String expirationDate2) {
		this.expirationDate = expirationDate2;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public void toPrint() {
		BigDecimal taxesChange = Validate.formattingBD((getTax() - 1) *getSubtotal());
		BigDecimal subChange = Validate.formattingBD(getSubtotal());
		BigDecimal grandChange = Validate.formattingBD(generateGrandTotal());
		
		System.out.printf("%-25.25s\t%10.10s \n","Subtotal: ", "$"+subChange.toString());
		System.out.printf("%-25.25s\t%10.10s \n","Taxes: ", "$"+taxesChange.toString());
		System.out.printf("%-25.25s\t%10.10s \n","Grandtotal: ", "$" + grandChange.toString());
		System.out.printf("%-25.25s\t%10.10s \n","Paid with Credit Card: ", 
				"**** "+Long.toString(getCreditCardNum()).substring(12,16));
	}

	@Override
	public void getInput() {
		creditCardNum = Validate.creditCardVal();
		setCreditCardNum(creditCardNum);
		cvv = Validate.ccvVal();
		setCvv(cvv);
		expirationDate = Validate.expDateVal();
		setExpirationDate(expirationDate);
	}

}
