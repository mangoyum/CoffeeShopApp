import java.math.BigDecimal;

public class Cash extends Payment{

	private double cashAmount;
	private double change;
	
	public Cash(double subtotal) {
		super(subtotal);
	}

	public double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}
	
	public double getChange() {
		return cashAmount;
	}

	public void setChange(double change) {
		this.change = change;
	}
	

	public double getCGrandTotal(){
		return getGrandTotal();
	}
	public void getInput() {
		
		cashAmount = Validate.getChangeAmount(generateGrandTotal());
		
		setCashAmount(cashAmount);
		change = cashAmount - getGrandTotal();
		setChange(change);
		
	}

	public String getName(){
		return "Cash Money";
	}

	@Override
	public void toPrint() {
		
		BigDecimal cashMoney = Validate.formattingBD(cashAmount);
		BigDecimal prChange = Validate.formattingBD(change);
		BigDecimal taxesChange = Validate.formattingBD((getTax() - 1) *getSubtotal());
		BigDecimal subChange = Validate.formattingBD(getSubtotal());
		BigDecimal grandChange = Validate.formattingBD(generateGrandTotal());
		
		System.out.printf("%-25.25s\t%10.10s \n","Subtotal: ", "$"+subChange.toString());
		System.out.printf("%-25.25s\t%10.10s \n","Taxes: ", "$"+taxesChange.toString());
		System.out.printf("%-25.25s\t%10.10s \n","Grandtotal: ", "$" + grandChange.toString());
		System.out.printf("%-25.25s\t%10.10s \n","Cash amount paid: ","$" + cashMoney.toString());
		System.out.printf("%-25.25s\t%10.10s \n","Change: ", "$" + prChange.toString());
		
	}
}
