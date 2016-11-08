
public class Cash extends Payment{

	private double cashAmount;
	private double change;
	
	public Cash(double subtotal) {
		super(subtotal);
	}

	public double getCashAmount() {
		return cashAmount;
	}
	
	public double getChange() {
		return change;
	}

	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public double generateChange() {
		
		generateGrandTotal();
		
		change = cashAmount - getGrandTotal();
		
		return change;
	}

	

	
	
}
