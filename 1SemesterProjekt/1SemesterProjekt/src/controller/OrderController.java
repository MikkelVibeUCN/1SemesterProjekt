package controller;
import javax.swing.plaf.basic.BasicBorders;

import model.*;
import model.order.*;
import model.product.*;

public class OrderController {
	private OrderContainer orderContainer;
	private SalesAssistantController salesAssistantController;
	
	// Create a new order with salesassistant from controller
	public Order createOrder(int employeeID) {
		return new Order(salesAssistantController.findSalesAssistant(employeeID));
	}
	
	/*public boolean addCustomerToOrder(String phoneNo, Order order) {
		
	} */
}
