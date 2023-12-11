package controller;
import javax.swing.plaf.basic.BasicBorders;

import model.*;
import model.order.*;
import model.product.*;

public class OrderController {
	private OrderContainer orderContainer;
	private ProductContainer productContainer;
	private CustomerContainer customerContainer;
	private SalesAssistantController salesAssistantController;
	
	public OrderController() {
		orderContainer = OrderContainer.getInstance();
		productContainer = ProductContainer.getInstance();
		customerContainer = CustomerContainer.getInstance();
		salesAssistantController = new SalesAssistantController();
	}
	// Create a new order with sales assistant from controller
	public Order createOrder(int employeeID) {
		return new Order(salesAssistantController.findSalesAssistant(employeeID));
	}
	
		
	public boolean addCustomerToOrder(String phoneNo, Order order) {
		boolean result = false;
		Customer customer = customerContainer.findCustomer(phoneNo);
		if(customer != null) {
			order.addCustomer(customer);
			result = true;
		}
		return result;
		
	}
	
	public boolean addProductByBarcode(int quantity, int barcode, Order order) {
		boolean result = false;
		Product product = productContainer.findProduct(barcode);
		if(product != null) {
			order.createOrderLine(quantity, product);
			result = true;
		}
		return result;
		
	}
}

