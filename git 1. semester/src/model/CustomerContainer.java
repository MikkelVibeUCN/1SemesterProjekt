package model;
import java.util.ArrayList;

public class CustomerContainer {
	private ArrayList<Customer> customers;
	
	public CustomerContainer() {
		customers = new ArrayList<>();
	}
	
	public Customer findCustomer(String phoneNo) {
		Customer result = null;
		boolean found = false;
		int i = -1;
		while(!found && ++i < customers.size()) {
			Customer currentCustomer = customers.get(i);
			if(currentCustomer.getPhoneNumber().equals(phoneNo)) {
				found = true;
				result = currentCustomer;
			}
		}
		return result;
	}
}
