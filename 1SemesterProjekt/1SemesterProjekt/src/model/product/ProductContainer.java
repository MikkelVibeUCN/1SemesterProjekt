package model.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.product.Product;

public class ProductContainer {
	private ArrayList<Product> products;
	private static final int START_SIZE = 1000;
	private static ProductContainer instance;
	
	public static ProductContainer getInstance() {
		if(instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}
	
	private ProductContainer() {
		products = new ArrayList<>(START_SIZE);
	}
	
	public void addProduct(Product product) {
		products.add(product);
		Collections.sort(products);
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
