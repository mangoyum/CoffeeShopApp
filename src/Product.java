
public class Product {
	private String name;
	private String category;
	private String description;
	private double price;
	
	//constructor
	public Product(String name, String category, String description, double price) {
		
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		
		}
//methods
	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
