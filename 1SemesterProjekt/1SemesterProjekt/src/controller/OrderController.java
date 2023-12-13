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
	
	public Order createOrder(int employeeID) {
		currentOrder = new Order(salesAssistantController.findSalesAssistant(employeeID));
		return currentOrder;
	}
	
	public String addCustomerToOrder(String phoneNo) {
		String result = "Kunde eksisterer ikke";
		Customer customer = customerController.findCustomer(phoneNo);
		if(customer != null) {
			currentOrder.addCustomer(customer);
        	result = "Kunde er tilføjet til ordren";
    	}
		return result;
	}
	
	public boolean addProductByBarcode(int quantity, int barcode) {
		boolean result = false;
		Product product = productController.findProduct(barcode);
		if(product != null) {
			if(currentOrder.hasProduct(product)) {
				OrderLine orderLine = currentOrder.findOrderLineFromProduct(product);
				if(orderLine != null) {
					orderLine.addQuantity(quantity);
				}
			}
			else {
				currentOrder.createOrderLine(quantity, product);
			}
			result = true;
		}
		return result;
	}
	
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
	
	public String stockMessage(int barcode, int amount) {
		String result = "Error finding product, please try again";
		Product product = productController.findProduct(barcode);
		
		if(product instanceof ShelfProduct) {
			ShelfProduct shelfP = ((ShelfProduct) product);
			int currentStock = shelfP.getStockAmount();
			
			if((currentStock - amount) > 0) {
				result = "Antal på " + amount + " er godkendt";
			}
			else {
				result = "Antal på " + currentStock + " er godkendt og " + (amount - currentStock) + " er tilføjet som restordre";
			}
			productController.removeStock(barcode, amount);
		}
		return result + "\n";
	}
	
	public String introMessage() {
		String message = "Indtast produkt barcode ";
		
		if(currentOrder.getOrderLines().size() > 0) {
			message += "eller tast \"0\" for at bekræfte";
		} 
		else {
			message += "eller tast \"0\" for at afslutte";
		}
		return message;
	}
	
	public ArrayList<String> orderInfoMessages() {
		return currentOrder.getInfo();
	}
}