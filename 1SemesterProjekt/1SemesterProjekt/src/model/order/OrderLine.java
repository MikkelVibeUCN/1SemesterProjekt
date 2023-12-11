package model.order;
import model.product.Product;

public class OrderLine {
	private int quantity;
	private Product product;
	
	public OrderLine(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public double getSubTotal() {
		return quantity * product.getPrice();
	}
}
