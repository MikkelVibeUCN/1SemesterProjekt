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
	private ArrayList<UniqueCopy> copies;
	private ArrayList<OrderLine> orderLines;
	
	private static int count;
	
	public Order(SalesAssistant salesAssistant) {
		this.salesAssistant = salesAssistant;
		orderID = ++count;
	}
	
	public void createOrderLine(int quantity, Product product) {
		OrderLine newOrderLine = new OrderLine(quantity, product);
		orderLines.add(newOrderLine);
	}
	
	public void addCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void addCopyToOrder(UniqueCopy copy) {
		
	}
	
}