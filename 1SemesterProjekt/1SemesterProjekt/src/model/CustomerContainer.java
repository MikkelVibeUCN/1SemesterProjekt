package model;
import java.util.ArrayList;

public class CustomerContainer {
	private ArrayList<Customer> customers;
	
	public CustomerContainer() {
		customers = new ArrayList<>();
	}
	
	public Customer findCustomer(int customerID) {
		Customer result = null; 
		
		int count = 0;
		
		boolean found = false;
		int start = 0;
		int end = customers.size();
		int middle = customers.size()/2;
		while(!found) {
			if(customers.get(middle).getID() == customerID) {
				result = customers.get(middle);
				found = true;
			}
			else if(middle == end) {
				found = true;
			}
			else if(customerID > customers.get(middle).getID()) {
				start = middle;
				middle = (start+end)/2;
			}
			else if(customerID < customers.get(middle).getID()){
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
