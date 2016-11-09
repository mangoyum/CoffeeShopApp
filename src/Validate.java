import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {

	public static char YesOrNo() {
		Scanner sc = new Scanner(System.in);

		String response = "";
		boolean cont = true;
		while (cont) {
			System.out.print("\nWould you like to order? (y/n): ");
			response = sc.nextLine();
			if (response.length() != 1) {
				continue;
			} else if (response.toLowerCase().charAt(0) != 'y' && response.toLowerCase().charAt(0) != 'n') {
				continue;
			} else {
				break;
			}
		}
		return response.toLowerCase().charAt(0);
	}

	// Breaking while loop if false
	public static boolean loopingAgain(char response) {
		if (response == 'y') {
			return true;
		} else {
			return false;
		}
	}

	public static int getOrder() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.println();
			System.out.print("Enter item number (Enter 0 to end your order): ");
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				if (i >= 0 && i <= 13)
					isValid = true;
				else
					System.out.println("Enter a number between 1-13");
			} else {
				System.out.println("Error! Invalid entry. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	public static int getPaymentChoice() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {

			System.out.print("1.Cash\n2.Check\n3.CreditCard\nChoose a payment method: ");
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				if (i > 0 && i <= 3)
					isValid = true;
				else
					System.out.println("Enter a number between 1-3");
			} else {
				System.out.println("Error! Invalid entry. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	public static int getQuantity() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {

			System.out.print("How many do you want? : ");
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				if (i > 0)
					isValid = true;
				else
					System.out.println("Enter a positive number");
			} else {
				System.out.println("Error! Invalid entry. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	public static double getChangeAmount(Double grandTotal) {
		Scanner sc = new Scanner(System.in);
		double i = 0;
		boolean isValid = false;
		while (isValid == false) {

			System.out.print("Enter amount tendered: ");
			if (sc.hasNextDouble()) {
				i = sc.nextDouble();
				if ((i - grandTotal) >= 0)
					isValid = true;
				else
					System.out.println("Give us the right amount");
			} else {
				System.out.println("Error! Invalid entry. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	public static int checkCheckNum() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {

			System.out.print("Enter check number: ");
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				if (i > 0)
					isValid = true;
				else
					System.out.println("Enter valid check number");
			} else {
				System.out.println("Error! Invalid entry. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	public static BigDecimal formattingBD(double num) {
		BigDecimal grand = new BigDecimal(num);
		return grand.setScale(2, RoundingMode.HALF_UP);
	}

	public static long creditCardVal() {
		Scanner sc = new Scanner(System.in);
		long creditCard = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print("Enter your Credit Card Number: ");
			if (sc.hasNextLong()) {
				creditCard = sc.nextLong();
				if (creditCard > 999999999999999L && creditCard < 10000000000000000L) {
					isValid = true;
				} else {
					System.out.println("Enter a valid Credit Card Number: ");
				}
			} else {
				System.out.println("Error! Invalid Credit Card Number. Try again.");
			}
			sc.nextLine();
		}
		return creditCard;
	}

	public static int ccvVal() {
		Scanner sc = new Scanner(System.in);
		int cvv = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.println("Enter the credit card security code: ");
			if (sc.hasNextInt()) {
				cvv = sc.nextInt();
				if (cvv > 99 && cvv < 1000) {
					isValid = true;
				} else {
					System.out.println("Enter a valid security code number: ");
				}
			} else {
				System.out.println("Error! Invalid security code. Try again.");
			}

		}
		sc.nextLine();
		return cvv;
	}
	public static String expDateVal(){
	// get current date time with Date()
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		Calendar cal = Calendar.getInstance();

		Scanner scan = new Scanner(System.in);
		Calendar expDate = Calendar.getInstance();
		boolean isValid = false;
		String str1 = "";
		while (isValid == false) {
			System.out.println("Please enter credit card expiration date: (yyyy/mm/dd): ");

			if (scan.hasNext(Pattern.compile("..../../.."))) {
				str1 = scan.next();

				Date desiredDate = new Date();
				try {
					desiredDate = dateFormat.parse(str1);
				} catch (ParseException e) {

					System.out.println(e);
				}
				// desired date is formatted user cc exp date
				expDate = Calendar.getInstance();
				expDate.setTime(desiredDate);// converting from date object to
												// calendar
												// object
				long dateNow = cal.getTimeInMillis();
				long dateCC = expDate.getTimeInMillis();

				if (dateCC >= dateNow) {
					isValid = true;
					System.out.println("Credit card is valid");
				} else {
					System.out.println("You have entered an expired Credit Card.");

				}
			} else {
				System.out.println();
				System.out.println("Error! Invalid input. Try again!");
				
			}
			scan.nextLine();
		}
		return str1;
		//scan.close();
	}
	}

