package controller;
import model.Customer;
import model.CustomerContainer;

public class CustomerController {
	private CustomerContainer customerContainer;
	
	public CustomerController() {
		customerContainer = CustomerContainer.getInstance();
	}
	public Customer findCustomer(String phoneNo) {
		return customerContainer.findCustomer(phoneNo);
	}
}
