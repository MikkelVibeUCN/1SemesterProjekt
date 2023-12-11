package model.order;

import java.util.ArrayList;
import model.product.UniqueCopy;
import model.product.Product;
import model.Customer;
import model.SalesAssistant;

public class Order {
	private Customer customer;
	private SalesAssistant salesAssistant;
	private int orderID;
	private ArrayList<Product> copies;
	private ArrayList<OrderLine> orderLines;
	
	private static int count;
	
	public Order(SalesAssistant salesAssistant) {
		this.salesAssistant = salesAssistant;
		copies = new ArrayList<>();
		orderLines = new ArrayList<>();
		orderID = ++count;
	}
	
	public void createOrderLine(int quantity, Product product) {
		OrderLine newOrderLine = new OrderLine(quantity, product);
		orderLines.add(newOrderLine);
	}
	
	public void addCustomer(Customer customer) {
		this.customer = customer;
	}
	

	public boolean addCopyToOrder(Product copy) {
		try{
			copies.add(copy);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public int getID() {
		return orderID;
	}
	
}