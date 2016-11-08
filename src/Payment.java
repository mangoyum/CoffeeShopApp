<<<<<<< HEAD

public abstract class Payment {
||||||| merged common ancestors

public class Payment {
=======
public abstract class Payment {
	
>>>>>>> 406d8ada2fbf10f2fc463640c92e30b88596d813
	private double subtotal;
	private final double TAX = 1.06;
	private double grandTotal;
	
	//constructor
	public Payment(double subtotal) {
		super();
		this.subtotal = subtotal;
<<<<<<< HEAD
		
			
||||||| merged common ancestors
		this.TAX = tax;
		this.grandTotal = grandTotal;	
=======
>>>>>>> 406d8ada2fbf10f2fc463640c92e30b88596d813
	}
//getters and setters
	public double getSubtotal() {
		return subtotal;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
<<<<<<< HEAD

	public void generateGrandTotal() {
		grandTotal = subtotal * TAX;
	}
	
||||||| merged common ancestors

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
=======
>>>>>>> 406d8ada2fbf10f2fc463640c92e30b88596d813
	
	public double generateGrandTotal() {
		grandTotal = subtotal * TAX;
		
		return grandTotal;
		
	}
	
}
