package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import model.SalesAssistant;
import model.SalesAssistantContainer;
import model.order.Order;
import org.junit.Before;
import org.junit.Test;

public class OrderControllerTest {
	
	private OrderController orderController;
	private int testEmployeeID;

	@Before
	public void setUp() {
		orderController = new OrderController();

		// Create and add a SalesAssistant to the SalesAssistantContainer
		SalesAssistant testSalesAssistant = new SalesAssistant("Test Fest", "test@gmail.com", "Test Address", "12345678", 69);
		SalesAssistantContainer.getInstance().addSalesAssistant(testSalesAssistant);
		testEmployeeID = testSalesAssistant.getID();
	}

	@Test
	public void testCreateOrder() {
		// Create order
		Order newOrder = orderController.createOrder(testEmployeeID);
		
		// Assert that order is not null
		assertNotNull("Order should not be null", newOrder);
		
		// Assert that order has the right employeeID
		assertEquals("Order should have the correct employee ID", testEmployeeID, newOrder.getSalesAssistantID());
	}
}