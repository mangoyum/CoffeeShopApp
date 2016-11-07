
public class Payment {
	private double subtotal;
	private final double TAX;
	private double grandTotal;
	
	//constructor
	public Payment(double subtotal, double tax, double grandTotal) {
		super();
		this.subtotal = subtotal;
		this.TAX = tax;
		this.grandTotal = grandTotal;	
	}

	public double getSubtotal() {
		return subtotal;
	}

	public double getTax() {
		return TAX;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
	
}
