package model;
import java.util.ArrayList;
import java.util.Collections;

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
		insertionSortLast();
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	/**
	 * findCustomer() finds a customer object by performing binary search
	 * @param phoneNo, the phone number of the customer to find
	 * @return The specific customer or null if it is not found
	 */
	public Customer findCustomer(String phoneNo) {
		Customer result = null; 
		
		boolean found = false;
		int start = 0;
		int end = customers.size();
		
		if(customers.size() > 1) {
			end--;
		}
		int middle = customers.size()/2;
		
		while(!found && start <= end) {
			middle = start+(end - start)/2;
			
			if(customers.get(middle).getPhoneNo().equals(phoneNo)) {
				result = customers.get(middle);
				found = true;
			}
			else if(customers.get(middle).getPhoneNo().compareTo(phoneNo) < 0) {
				start = middle + 1;
			}
			else if(customers.get(middle).getPhoneNo().compareTo(phoneNo) > 0){
				end = middle - 1;
			}
		}
		return result;
	}
	
	/**
	 * insertionSortLast sorts the last element by using insertion sort on the customers array according to compareTo()
	 * @return void
	 */
	private void insertionSortLast() {
		if(customers.size() > 1) {
			int variableIndex = customers.size()-2;
			
			while(customers.get(variableIndex).compareTo(customers.get(variableIndex+1)) > 0 ) {
				Collections.swap(customers, variableIndex, variableIndex+1);
				
				if(variableIndex-1 >= 0) {
					variableIndex--;
				} 
			}
		}
	}
}