package model.order;

import java.util.ArrayList;

import model.Customer;

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
	
	public Order findOrder(int orderID) {
		Order result = null; 
		
		int count = 0;
		
		boolean found = false;
		int start = 0;
		int end = orders.size();
		int middle = orders.size()/2;
		while(!found) {
			if(orders.get(middle).getID() == orderID) {
				result = orders.get(middle);
				found = true;
			}
			else if(middle == end) {
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
			System.out.println("Start " + start + " Middle: " + middle + " End: "+end);
			
			count++;
		}
		System.out.println(count);
		return result;
	}
}
