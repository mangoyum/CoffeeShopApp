
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

			br = new BufferedReader(new FileReader("menu.txt"));
			while ((line = br.readLine()) != null) {

				String[] item = line.split(",");

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
}
