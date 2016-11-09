
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ReadFile {

	public static ArrayList<Product> Filereading() {
		BufferedReader br = null;
		String line = "";
		ArrayList<Product> prod = new ArrayList<Product>();
		try {

			br = new BufferedReader(new FileReader("Menu.txt"));
			while ((line = br.readLine()) != null) {

				String[] item = line.split(",");
				for(int i =0; i < item.length; i++){
					item[i] = item[i].trim();
				}

				prod.add(new Product(item[0], item[1], item[2], Double.parseDouble(item[3])));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prod;
	}

	public static String menuPrompt() {
		return "What would you like to order?";
	}
	public static ArrayList<String> getBeverageList(){
		ArrayList <String> beverage = new ArrayList <String>();
		ArrayList <Product> menu = Filereading ();
		for (Product p : menu) {
			if (p.getCategory().equals("beverage")){
				String str1 = String.format("%-30.30s %-10.10s %s", p.getName(), p.getPrice(), p.getDescription());
				beverage.add(str1);
			}
		}
		return beverage; 
	}
	
	public static ArrayList<String> getFoodList() {
		ArrayList <String> food = new ArrayList <String>();
		ArrayList <Product> menu = Filereading();
		for (Product p : menu) {
			if (p.getCategory().equals("food")){
				String str1 = String.format("%-30.30s %-10.10s %s", p.getName(), p.getPrice(), p.getDescription());
				food.add(str1);
			}
		}
		return food;
	}
}
