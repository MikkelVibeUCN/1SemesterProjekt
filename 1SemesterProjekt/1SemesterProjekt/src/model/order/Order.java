package model.order;

import java.text.DecimalFormat;
import java.util.ArrayList;
import model.product.UniqueCopy;
import model.product.UniqueProduct;
import model.product.Copy;
import model.product.LoanCopy;
import model.product.LoanProduct;
import model.product.Product;
import model.product.ShelfProduct;
import model.Customer;
import model.SalesAssistant;

public class Order {
	private Customer customer;
	private SalesAssistant salesAssistant;
	DecimalFormat formatter = new DecimalFormat("0.00");
	private int orderID;
	private ArrayList<Copy> copies;
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
	

	public boolean addCopyToOrder(Copy copy) {
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
	
	public int getSalesAssistantID() {
		return salesAssistant.getID();
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
			result.add(getOrderLineString(orderLine));
		}
		
		for(Copy copy : copies) {			
			result.add(getCopyString(copy));
		}
		
		result.add("Total " + formatter.format(totalPrice()));
		
		result.add("Ekspederet af: " + salesAssistant.getName());
		
		return result;
	}
	
	private String getOrderLineString(OrderLine orderLine) {
		return "Navn: " + orderLine.getProduct().getName() + 
				", stregkode: " + orderLine.getProduct().getBarcode() + 
				", pris: " + orderLine.getProduct().getPrice() + 
				", aktuel pris: " + formatter.format(withDiscount(orderLine.getProduct().getPrice())) +
				", antal: " + orderLine.getQuantity() +
				", subtotal: " + formatter.format(withDiscount(orderLine.getSubTotal()));
	}
	
	private String getCopyString(Copy copy) {
		Product product = copy.getOrigin();
		
		String priceString = ", pris: " + formatter.format(product.getPrice());
		String priceAfterDiscountString = ", aktuel pris: " + formatter.format(withDiscount(product.getPrice()));
		
		if(copy instanceof LoanCopy) {
			priceString += " per time.";
			priceAfterDiscountString += " per time.";
		} 
		
		return "Navn: " + product.getName() + 
				", stregkkode: " + product.getBarcode() +
				", serienummer: " + copy.getSerialNo() +
				priceString + 
				priceAfterDiscountString;
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
	
	public void addQuantityToOrderLine(OrderLine orderLine, int amount) {
		orderLine.addQuantity(amount);
	}
}