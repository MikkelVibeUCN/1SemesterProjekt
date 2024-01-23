package model.order;

import java.text.DecimalFormat;
import java.util.ArrayList;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

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
	private String orderTime;
	private Customer customer;
	private SalesAssistant salesAssistant;
	
	private int orderID;
	private ArrayList<Copy> copies;
	private ArrayList<OrderLine> orderLines;
	
	private static int count;
	
	public Order(SalesAssistant salesAssistant) {
		this.salesAssistant = salesAssistant;
		copies = new ArrayList<>();
		orderLines = new ArrayList<>();
		orderID = ++count;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		orderTime = dtf.format(now);
	}
	
	public void createOrderLine(int quantity, Product product) {
		OrderLine newOrderLine = new OrderLine(quantity, product);
		orderLines.add(newOrderLine);
	}
	
	public void addCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getOrderTime() {
		return orderTime;
	}
	
	public String getCustomerName() {
		return customer.getName();
	}
	
	public String getCustomerType() {
		return customer.getType();
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
	
	public double getDiscountPercentage() {
		return customer.getDiscount().getDiscountPercentage();
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
	
	public boolean deleteOrderLine(String productName) {
		boolean result = false;
		int i = -1;
		while(++i < orderLines.size()) {
			OrderLine currentOrderLine = orderLines.get(i);
			if(currentOrderLine.getProduct().getName().equals(productName)) {
				orderLines.remove(i);
				result = true;
			}
		}
		return result;
	}
	
	public double totalPrice() {
		return withDiscount(getTotalSubTotal());
	}
	
	public double getDiscountAmount() {
		return  getTotalSubTotal() - totalPrice();
	}
	
	public double getTotalSubTotal() {
		double result = 0;
		for(OrderLine orderLine : orderLines) {
			result += orderLine.getSubTotal();
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