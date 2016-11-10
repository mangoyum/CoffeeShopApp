import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeShopApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the FAM coffee shop! \n" + "When you are here, you are family! ");
		double dailySubtotal = 0;
		ArrayList<Product> dailyItemsBought = new ArrayList<Product>();
		ArrayList<Integer> dailyCount = new ArrayList<Integer>();
		boolean cont = true;
		
		
		ArrayList<Product> menu = ReadFile.Filereading();
do{
		double subtotal = 0;
		ArrayList<Product> itemsBought = new ArrayList<Product>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		
		System.out.println("Here's our full menu. What would you like to order?");
		printMenu();
		
		while (true){
			int orderNum = Validate.getOrder();
			if (orderNum == 0){
				break;
			}else if(orderNum == 13){
				printMenu();
				orderNum = Validate.getOrder();
			}
			int numOf = Validate.getQuantity();
			itemsBought.add(menu.get((orderNum - 1)));
			dailyItemsBought.add(menu.get((orderNum - 1)));
			count.add(numOf);
			dailyCount.add(numOf);
		}
		
		for (int j = 0; j<count.size(); j++){
			subtotal += itemsBought.get(j).getPrice() * count.get(j);
			dailySubtotal += dailyItemsBought.get(j).getPrice() * count.get(j);
			
		}
		Payment needTotal = new Cash(0);
		System.out.println("Amount owed: $" + Validate.formattingBD(needTotal.getTax()*subtotal));
		Payment typePayment = getPaymentType(subtotal);
		typePayment.getInput();
		
		printReceipt(itemsBought, count);
		typePayment.toPrint();
		char response = Validate.YesOrNo();
		cont = Validate.loopingAgain(response);
}
while(cont);
	Scanner sc = new Scanner(System.in);
	String pw = "";
	
	char resp = Validate.YesOrNo2();
	if (resp == 'y'){
	for (int i=0; i<= 3; i++){
		System.out.print("Enter password to see Daily Total: ");
		pw = sc.nextLine();
		if(pw.equals("FAM")){
			System.out.println("\n\t\tDaily Sales: ");
			printReceipt(dailyItemsBought, dailyCount);
			break;
		}else{
			System.out.println("You entered the wrong password");
		}
	}}
	else{
		System.out.println("Goodnight, see you tomorrow. ");
	}
	
	}

	public static void printMenu() {
		ArrayList<String> beverage = ReadFile.getBeverageList();
		int i = 1;
		System.out.println();
		System.out.println("Beverages: ");
		for (String p : beverage) {
			System.out.println(i + ". " + p);
			i++;
		}
		ArrayList<String> food = ReadFile.getFoodList();
		System.out.println();
		System.out.println("Food: ");
		for (String f : food) {
			System.out.println(i + ". " + f);
			i++;
		}
		System.out.println("13. Show menu again");
		
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
