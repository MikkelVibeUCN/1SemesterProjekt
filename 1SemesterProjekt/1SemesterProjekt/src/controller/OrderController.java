package controller;

import model.Customer;
import model.order.Order;
import model.order.OrderContainer;
import model.order.OrderLine;
import model.product.Product;

public class OrderController {
	private OrderContainer orderContainer;
	private ProductController productController;
	private CustomerController customerController;
	private SalesAssistantController salesAssistantController;
	
	public OrderController() {
		orderContainer = OrderContainer.getInstance();
		productController = new ProductController();
		customerController = new CustomerController();
		salesAssistantController = new SalesAssistantController();
	}
	
	public Order createOrder(int employeeID) {
		return new Order(salesAssistantController.findSalesAssistant(employeeID));
	}
	
	public boolean addCustomerToOrder(String phoneNo, Order order) {
		boolean result = false;
		Customer customer = customerController.findCustomer(phoneNo);
		if(customer != null) {
			order.addCustomer(customer);
			result = true;
		}
		return result;
	}
	
	public boolean addProductByBarcode(int quantity, int barcode, Order order) {
		boolean result = false;
		Product product = productController.findProduct(barcode);
		if(product != null) {
			if(order.hasProduct(product)) {
				OrderLine orderLine = order.findOrderLineFromProduct(product);
				if(orderLine != null) {
					orderLine.addQuantity(quantity);
				}
			}
			else {
				order.createOrderLine(quantity, product);
			}
			result = true;
		}
		return result;
	}
	
	public boolean confirmOrder(Order order) {
		return orderContainer.addOrder(order);
	}
}