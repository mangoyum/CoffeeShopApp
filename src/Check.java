import java.math.BigDecimal;

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
		BigDecimal taxesChange = Validate.formattingBD((getTax() - 1) *getSubtotal());
		BigDecimal subChange = Validate.formattingBD(getSubtotal());
		BigDecimal grandChange = Validate.formattingBD(generateGrandTotal());
		
		System.out.printf("%-25.25s\t%10.10s \n","Subtotal: ", "$"+subChange.toString());
		System.out.printf("%-25.25s\t%10.10s \n","Taxes: ", "$"+taxesChange.toString());
		System.out.printf("%-25.25s\t%10.10s \n","Grandtotal: ", "$" + grandChange.toString());
		System.out.printf("%-25.25s\t%10.10s \n","Paid with my check number: ", Integer.toString(getCheckNum()));
		
	}

	@Override
	public void getInput() {
		setCheckNum(Validate.checkCheckNum());
		
	}
	
	

	
	
	
}
