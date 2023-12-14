package controller;
import model.Customer;
import model.CustomerContainer;

/**
 * CustomerController handles everything to do with customers
 * @author gruppe-1
 */

public class CustomerController {
	private CustomerContainer customerContainer;
	
	public CustomerController() {
		customerContainer = CustomerContainer.getInstance();
	}
	public Customer findCustomer(String phoneNo) {
		return customerContainer.findCustomer(phoneNo);
	}
}
