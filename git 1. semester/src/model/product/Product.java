package model.product;

public class Product extends CompositeLine {
	private String name;
	private double minimumPrice;
	private double price;
	
	public Product(int quantity, double subPrice, String name, double minimumPrice, double price) {
		super(quantity,subPrice);
		this.name = name;
		this.minimumPrice = minimumPrice;
		this.price = price;
	}
}
