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
	
	public String randomPhoneNo() {
		String number = "";
		int length = 8;
		Random random = new Random();
		
		while(length-- > 0) {
			int nextNumber = random.nextInt(0, 9);
			
			number += nextNumber;
		}
		return number;
	}
	
	
	public static void main(String[] args) {
		CustomerContainer container = CustomerContainer.getInstance();
		
		for(int i = 0; i < 500; i++) {
			Customer newCustomer = new Customer("Sejt navn", "seh@gmail.com", "aalborg somewhere lol", container.randomPhoneNo(), 5, "Regular");
			container.addCustomer(newCustomer);
		}
		
		container.addCustomer(new Customer("Test", "test", "test", "12345678", 5, "test"));
		
		System.out.println(container.findCustomer("12345678").getID());
	}
}
