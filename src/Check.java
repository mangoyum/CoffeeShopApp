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
		
		System.out.println("Subtotal: $" + subChange);
		System.out.println("Taxes: $" + taxesChange);
		System.out.println("Grandtotal: $" + grandChange);
		System.out.println("Paid with my check number:"+ getCheckNum());
		
	}

	@Override
	public void getInput() {
		setCheckNum(Validate.checkCheckNum());
		
	}
	
}
