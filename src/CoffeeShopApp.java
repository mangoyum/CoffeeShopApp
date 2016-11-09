import java.util.ArrayList;

public class CoffeeShopApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the FAM coffee shop! \n" + "When you are here, you are family! ");
		System.out.println("Here's our full menu. What would you like to order?");
		double subtotal = 0;		

		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<Product> menu = ReadFile.Filereading();

		ArrayList<Product> itemsBought = new ArrayList<Product>();

		printMenu();
		
		while (true){
			int orderNum = Validate.getOrder();
			if (orderNum == 0){
				break;
			}
			int numOf = Validate.getQuantity();
			itemsBought.add(menu.get((orderNum - 1)));
			count.add(numOf);
		}
		
		for (int j = 0; j<count.size(); j++){
			subtotal += itemsBought.get(j).getPrice() * count.get(j);
			
		}
		Payment needTotal = new Cash(0);
		System.out.println("You own: $" + Validate.formattingBD(needTotal.getTax()*subtotal));
		Payment typePayment = getPaymentType(subtotal);
		typePayment.getInput();
		
		printReceipt(itemsBought, count);
		typePayment.toPrint();

	}

	public static void printMenu() {
		ArrayList<String> beverage = ReadFile.getBeverageList();
		int i = 1;
		System.out.println("Beverages: ");
		for (String p : beverage) {
			System.out.println(i + ". " + p);
			i++;
		}
		ArrayList<String> food = ReadFile.getFoodList();
		System.out.println("Food: ");
		for (String f : food) {
			System.out.println(i + ". " + f);
			i++;

		}
		}
	public static Payment getPaymentType(Double subTotal){
		int a = Validate.getPaymentChoice();
		Payment p;
		if (a == 1){
			return new Cash(subTotal);
		}else if(a == 2){
			return new Check(subTotal);
			}
		else{
			 return new CreditCard(subTotal);
			} 
	}
	
	public static void printReceipt(ArrayList<Product> item, ArrayList<Integer> count){
		System.out.println("\n\n\t\tFAM Coffee Shop\n\n");
		for(int j=0; j<item.size(); j++){
			System.out.printf("%-25.25s x %-7s $%5s\n",item.get(j).getName(),Integer.toString(count.get(j)),
			(Validate.formattingBD(item.get(j).getPrice() * count.get(j))).toString());
		}
		System.out.println("\n\n");
		
	}
}
