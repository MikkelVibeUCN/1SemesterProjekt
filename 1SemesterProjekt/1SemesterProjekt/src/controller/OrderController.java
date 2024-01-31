package controller;

import java.util.ArrayList;

import model.Customer;
import model.order.Order;
import model.order.OrderContainer;
import model.order.OrderLine;
import model.product.LoanCopy;
import model.product.LoanProduct;
import model.product.Product;
import model.product.ShelfProduct;
import model.product.UniqueCopy;
import model.product.UniqueProduct;

/**
 * OrderController handles everything to do with orders
 * @author gruppe-1
 */

public class OrderController {
	private Order currentOrder;
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
	
	/**
	 * createOrder() creates order objects
	 * @param employeeID, The ID of the employee assosiated with the order
	 * @return The created order
	 */
	public Order createOrder(int employeeID) {
		currentOrder = new Order(salesAssistantController.findSalesAssistant(employeeID));
		return currentOrder;
	}
	
	/**
	 * addCustomerToOrder() adds a customer to the order
	 * @param phoneNo, the phone number of the customer
	 * @return String containing the message to print to the user.
	 */
	public boolean addCustomerToOrder(String phoneNo) {
		boolean result = false;
		Customer customer = customerController.findCustomer(phoneNo);
		if(customer != null) {
			currentOrder.addCustomer(customer);
        	result = true;
    	}
		return result;
	}
	
	public boolean deleteOrderLine(String productName) {
		return currentOrder.deleteOrderLine(productName);
	}
	
	/**
	 * addProductByBarcode() adds a bulk product to the order
	 * @param quantity, the amount to add
	 * @param barcode, the barcode of the product
	 * @return true on success, false on failure.
	 */
	public boolean addProductByBarcode(int quantity, int barcode) {
		boolean result = false;
		Product product = productController.findProduct(barcode);
		if(product != null) {
			if(currentOrder.hasProduct(product)) {
				OrderLine orderLine = currentOrder.findOrderLineFromProduct(product);
				if(orderLine != null) {
					currentOrder.addQuantityToOrderLine(orderLine, quantity);
				}
			}
			else {
				currentOrder.createOrderLine(quantity, product);
			}
			result = true;
		}
		return result;
	}
	
	public Order getOrder() {
		return currentOrder;
	}
	
	/**
	 * addProductBySerialNo() adds a unique item to the order
	 * @param barcode, the barcode of the product.
	 * @param serialNo, the serialnumber of the unique item.
	 * @return true on success, false on failure.
	 */
	public boolean addProductBySerialNo(int barcode, int serialNo) {
		boolean result = false;
		
		Product product = productController.findProduct(barcode);
		
		if(product instanceof UniqueProduct) {
			UniqueCopy copy = ((UniqueProduct) product).findCopy(serialNo);
			
			result = currentOrder.addCopyToOrder(copy);	
		}
		else if (product instanceof LoanProduct) {
			LoanCopy copy = ((LoanProduct) product).findCopy(serialNo);
			
			result = currentOrder.addCopyToOrder(copy);	
		}
		
		return result;
		
	}
	
	public boolean confirmOrder() {
		return orderContainer.addOrder(currentOrder);
	}
	
	public Customer findCustomer(String phoneNo) {
		return customerController.findCustomer(phoneNo);
	}

	public int getStockAmount(int barcode) {
		return productController.getStockAmount(barcode);
	}
}