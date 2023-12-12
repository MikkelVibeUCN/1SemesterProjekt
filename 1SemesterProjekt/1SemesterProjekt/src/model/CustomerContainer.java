package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.Customer;

public class CustomerContainer {
	private ArrayList<Customer> customers;
	private static final int START_SIZE = 1000;
	private static CustomerContainer instance;
	
	public static CustomerContainer getInstance() {
		if(instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}
	
	private CustomerContainer() {
		customers = new ArrayList<>(START_SIZE);
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
		Collections.sort(customers);
	}
	
	public Customer findCustomer(String phoneNo) {
		Customer result = null; 
		
		boolean found = false;
		int start = 0;
		int end = customers.size()-1;
		int middle = customers.size()/2;
		
		while(!found && middle != end) {
			if(customers.get(middle).getPhoneNo().equals(phoneNo)) {
				result = customers.get(middle);
				found = true;
			}
			else if(customers.get(middle).getPhoneNo().compareTo(phoneNo) < 0) {
				start = middle;
				middle = (start+end)/2;
			}
			else if(customers.get(middle).getPhoneNo().compareTo(phoneNo) > 0){
				end = middle;
				middle = (start+end)/2;
			}
		}
		return result;
	}
}
