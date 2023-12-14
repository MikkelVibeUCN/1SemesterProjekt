package model.order;

import java.util.ArrayList;

import model.Customer;

public class OrderContainer {
	private ArrayList<Order> orders;
	private static OrderContainer instance;
	
	private OrderContainer() {
		orders = new ArrayList<>();
	}
	
	public static OrderContainer getInstance() {
		if(instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	
	public boolean addOrder(Order order) {
		boolean result = false;
		if(order.getOrderLines().size() > 0) {
			orders.add(order);
			result = true;
		}
		return result;
	}
	
	/**
	 * findOrder() finds a specific order object by performing binary search
	 * @param orderID, The ID of the order to look for
	 * @return The specific object or null if it is not found
	 */
	public Order findOrder(int orderID) {
		Order result = null; 
		
		boolean found = false;
		int start = 0;
		int end = orders.size();
		int middle = orders.size()/2;
		while(!found) {
			if(orders.get(middle).getID() == orderID) {
				result = orders.get(middle);
				found = true;
			}
			else if(orderID > orders.get(middle).getID()) {
				start = middle;
				middle = (start+end)/2;
			}
			else if(orderID < orders.get(middle).getID()){
				end = middle;
				middle = (start+end)/2;
			}	
		}
		return result;
	}
}
