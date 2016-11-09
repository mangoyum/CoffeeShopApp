import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

	public class Validate {

		public static char YesOrNo(){
			Scanner sc = new Scanner(System.in);
			
			String response = "";
			boolean cont = true;
			while(cont){
				System.out.print("\nWould you like anything else? (y/n): ");
				response = sc.nextLine();
				if(response.length() != 1){
					continue;
				}
				else if (response.toLowerCase().charAt(0) != 'y' && response.toLowerCase().charAt(0) != 'n'){
					continue;
					}
				else{
					break;
				}
			}
			return response.toLowerCase().charAt(0);
		}
		
		//Breaking while loop if false 
		public static boolean loopingAgain(char response){
			if (response == 'y'){
				return true;
			} else{
				return false;
			}
		}
		
		public static int getOrder(){
			Scanner sc = new Scanner(System.in);
			int i=0;
			boolean isValid = false;
			while(isValid == false){
				
				System.out.print("Enter your order number: ");
				if(sc.hasNextInt()){
					i=sc.nextInt();
					if (i>=0 && i<= 12)isValid = true;
					else System.out.println("Enter a number between 1-12");
				}else{
					System.out.println("Error! Invalid integer value. Try again.");
				}
				sc.nextLine();
			}
			return i;
		}

		public static int getPaymentChoice(){
			Scanner sc = new Scanner(System.in);
			int i=0;
			boolean isValid = false;
			while(isValid == false){
				
				System.out.print("1.Cash\n2.Check\n3.CreditCard\nChoose a payment method: ");
				if(sc.hasNextInt()){
					i=sc.nextInt();
					if (i>0 && i<= 3)isValid = true;
					else System.out.println("Enter a number between 1-3");
				}else{
					System.out.println("Error! Invalid integer value. Try again.");
				}
				sc.nextLine();
			}
			return i;
		}
		public static int getQuantity(){
			Scanner sc = new Scanner(System.in);
			int i=0;
			boolean isValid = false;
			while(isValid == false){
				
				System.out.print("How many do you want? : ");
				if(sc.hasNextInt()){
					i=sc.nextInt();
					if (i>0)isValid = true;
					else System.out.println("Enter a positive number");
				}else{
					System.out.println("Error! Invalid integer value. Try again.");
				}
				sc.nextLine();
			}
			return i;
		}
	
		public static double getChangeAmount(Double grandTotal){
			Scanner sc = new Scanner(System.in);
			double i=0;
			boolean isValid = false;
			while(isValid == false){
				
				System.out.print("Enter amount tendered: ");
				if(sc.hasNextDouble()){
					i=sc.nextDouble();
					if ((i - grandTotal) >= 0 )isValid = true;
					else System.out.println("Give us the right amount");
				}else{
					System.out.println("Error! Invalid integer value. Try again.");
				}
				sc.nextLine();
			}
			return i;
		}	
		public static int checkCheckNum(){
			Scanner sc = new Scanner(System.in);
			int i=0;
			boolean isValid = false;
			while(isValid == false){
				
				System.out.print("Enter check number: ");
				if(sc.hasNextInt()){
					i=sc.nextInt();
					if (i >= 0 )isValid = true;
					else System.out.println("Enter valid check number");
				}else{
					System.out.println("Error! Invalid integer value. Try again.");
				}
				sc.nextLine();
			}
			return i;
		}
		
	public static BigDecimal formattingBD(double num){
		BigDecimal grand = new BigDecimal(num);
		return grand.setScale(2, RoundingMode.HALF_UP);
	}
	}

