package model.product;

public abstract class Product implements Comparable<Product>{
	private String name;
	private double minimumPrice;
	private double price;
	private int barcode;
	
	public Product(String name, double minimumPrice, double price,int barcode) {
		this.name = name;
		this.minimumPrice = minimumPrice;
		this.price = price;
		this.barcode = barcode;
	}
	public double getPrice() {
		return price;
	}
	
	public int getBarcode() {
		return barcode;
	}
}
