
public abstract class Payment {

	private double subtotal;
	private final double TAX = 1.06;
	private double grandTotal;

	// constructor
	public Payment(double subtotal) {
		super();
		this.subtotal = subtotal;

	}

	// getters and setters
	public double getSubtotal() {
		return subtotal;
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

	public double generateGrandTotal() {
		grandTotal = subtotal * TAX;

		return grandTotal;

	}

}
