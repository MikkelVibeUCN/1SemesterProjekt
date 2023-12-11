package tui;

import java.util.Random;

import model.Customer;
import model.CustomerContainer;
import model.product.Product;
import model.product.ProductContainer;
import model.product.ShelfProduct;

public class TryMe {

	
	public static int randomBarcode() {
		String number = "";
		Random random = new Random();
		
		boolean hasRun = false;
	
		for(int i = 0; i < 6; i++) {
			int nextNumber = 0;
			if(!hasRun) {
				nextNumber = random.nextInt(1, 9);
			}
			else {
				nextNumber = random.nextInt(0, 9);
			}
		number += nextNumber;
		}		
		return Integer.parseInt(number);
	}
	
	private static String randomPhoneNo() {
		String number = "";
		int length = 8;
		Random random = new Random();
		
		while(length-- > 0) {
			int nextNumber = random.nextInt(0, 9);
			
			number += nextNumber;
		}
		return number;
	}
	
	public static void createTestData() {
		// Create Products
		ProductContainer productContainer = ProductContainer.getInstance();
		
		for(int i = 0; i < 28000; i++) {
			 ShelfProduct newProduct = new ShelfProduct("test", (double)200, (double)200, "product-swag", randomBarcode(), 200, 500, 300, "group 1");
			 productContainer.addProduct(newProduct);	 
		}
		
		productContainer.addProduct(new ShelfProduct("test1", (double)200, (double)200, "product-swag", 123456, 200, 500, 300, "group 1"));
		
		// Create Customers
		CustomerContainer customerContainer = CustomerContainer.getInstance();
		
		for(int i = 0; i < 1000; i++) {
			Customer newCustomer = new Customer("Sejt navn", "seh@gmail.com", "aalborg somewhere lol", randomPhoneNo(), 5, "Regular");
			customerContainer.addCustomer(newCustomer);
		}
		
		customerContainer.addCustomer(new Customer("Sejt navn", "seh@gmail.com", "aalborg somewhere lol", "12345678", 5, "Regular"));
		
	}
}
