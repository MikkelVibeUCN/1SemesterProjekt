package model.order;

import java.util.ArrayList;

public class OrderContainer {
	private ArrayList<Order> orders;
	private static OrderContainer instance;
	
	private OrderContainer() {
		orders = new ArrayList<>();
	}
	
	public OrderContainer getInstance() {
		if(instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	
	public boolean confirmOrder(Order order) {
		try{
			orders.add(order);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
