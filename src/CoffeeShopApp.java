import java.util.Scanner;

public class CoffeeShopApp {
	Scanner scan = new Scanner (System.in);
	public static void main(String[] args) {
		
		
		Product p = new Product ("rooibos tea", "beverage", "African herbal red tea", 2.95);
		Product q = new Product ("chai tea", "beverage", "aromatic black tea with cardamom and other spices", 2.95);
		
		System.out.println((p.getPrice()) + q.getPrice());
		
		
		
	}
	public String paymentChoice(String paymentType){
		
		if (paymentType.equalsIgnoreCase("cash")){
			
		}
		return null;
	}
	
}
