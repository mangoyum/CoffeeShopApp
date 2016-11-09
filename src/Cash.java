
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
		
		System.out.println("Cash amount payed: " + cashAmount);
		System.out.println("Change: " + change);
		
	}

	
	
}
