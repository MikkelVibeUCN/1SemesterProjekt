package model.product;

import java.util.ArrayList;

public class Composite extends Product {
	private String SKU;
	private int barcode;
	private int minimumStock;
	private int maximumStock;
	private int stockAmount;
	private String productGroup;
	private ArrayList<Product> products;
	
	public Composite (String name, double minimumPrice, double price, String SKU, int barcode, int minimumStock, int maximumStock, int stockAmount, String productGroup){
		super(name,minimumPrice,price,barcode);
		this.SKU = SKU;
		this.barcode = barcode;
		this.minimumStock = minimumStock;
		this.maximumStock = maximumStock;
		this.stockAmount = stockAmount;
		this.productGroup = productGroup;
		this.products = new ArrayList<>();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public double getPrice() {
		double totalPrice = 0;
		for(Product product : products) {
			totalPrice += product.getPrice();
		}
		return totalPrice;
	}
}