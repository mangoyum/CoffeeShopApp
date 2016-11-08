import java.util.ArrayList;

public class CoffeeShopApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the FAM coffee shop! \n" + "When you are here, you are family! ");

		System.out.println("Here's our full menu. What would you like to order?");
		// print out by category, each item and price, with description
		// underneath
		double subtotal = 0;
		
		// instantiate a subtotal
		// instantiate read file(menu)
		// Array list of quantity
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<Product> menu = ReadFile.Filereading();
		// create an array list of items bought ( which will be empty here)
		ArrayList<Product> itemsBought = new ArrayList<Product>();
		// ask for quantity
		// need a loop

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
		System.out.println(subtotal);
		Payment typePayment = getPaymentType(subtotal);
		typePayment.getInput();
		typePayment.toPrint();
		
		//for(int j=0; j<count.size(); j++){
			//System.out.println(itemsBought.get(j).getName() + " x " + count.get(j));
		//}
		// while (true)
		// int order = prompt for order
		// if (int order = 0){
		// break the loop
		// itemBought.add(menu.get((i - 1)));

		// for loop through the subtotal += itemsBought.getPrice()
		// Instantiate payment type
		// Print itemsBought
		// Pring using BigDecimal
		// Print receipt
		// return to menu for new order
		// We want to have the array list inside the do while loop so it will be
		// re-instantiated
		// everytime

		// Figure out how to print on same line if quantity of 2

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
	
}
