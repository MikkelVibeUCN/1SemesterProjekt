package model.product;

public class CompositeLine {
	private int quantity;
	private Product product;
	
	public CompositeLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
}