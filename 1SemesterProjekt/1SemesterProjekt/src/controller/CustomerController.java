package controller;
import model.*;

public class CustomerController {
	private CustomerContainer customerContainer;
	
	public CustomerController() {
		customerContainer = CustomerContainer.getInstance();
	}
	public Customer findCustomer(String phoneNo) {
		Customer customer = customerContainer.findCustomer(phoneNo);
		return customer;
	}
}
