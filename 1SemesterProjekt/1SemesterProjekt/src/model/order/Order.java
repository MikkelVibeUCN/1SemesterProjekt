package model.order;

import java.text.DecimalFormat;
import java.util.ArrayList;
import model.product.UniqueCopy;
import model.product.Product;
import model.product.ShelfProduct;
import model.Customer;
import model.SalesAssistant;

public class Order {
	private Customer customer;
	private SalesAssistant salesAssistant;
	DecimalFormat formatter = new DecimalFormat("0.00");
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
	
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	
	public boolean hasProduct(Product product) {
		boolean result = false;
		if(findOrderLineFromProduct(product) != null) {
			result = true;
		}
		return result;
	}
	
	public OrderLine findOrderLineFromProduct(Product product) {
		OrderLine result = null;
		int i = -1;
		boolean found = false;
		while(!found && ++i < orderLines.size()) {
			Product currentProduct = orderLines.get(i).getProduct();
			if(product.equals(currentProduct)) {
				result = orderLines.get(i);
				found = true;
			}
		}
		return result;
		
	}
	
	public ArrayList<String> getInfo() {
		ArrayList<String> result = new ArrayList<>();
		result.add("ID af ordren: " + orderID);
		
		for(OrderLine orderLine : orderLines) {			
			result.add("Navn: " + orderLine.getProduct().getName() + 
					", stregkode: " + orderLine.getProduct().getBarcode() + 
					", pris: " + orderLine.getProduct().getPrice() + 
					", aktuel pris: " + formatter.format(withDiscount(orderLine.getProduct().getPrice())) +
					", antal: " + orderLine.getQuantity() +
					", subtotal: " + formatter.format(withDiscount(orderLine.getSubTotal())));
				
		}
		result.add("Total " + formatter.format(totalPrice()));
		
		result.add("Ekspederet af: " + salesAssistant.getName());
		
		return result;
	}
	
	public double totalPrice() {
		double result = 0;
		for(OrderLine orderLine : orderLines) {
			result += withDiscount(orderLine.getSubTotal());
		}
		return result;
	}
	
	public double withDiscount(double amount) {
		return customer.getDiscount().calculatePrice(amount);
	}
	
}