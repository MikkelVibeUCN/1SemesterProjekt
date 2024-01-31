package gui;

import java.util.Random;

import model.*;
import model.product.Product;
import model.product.ProductContainer;
import model.product.ShelfProduct;
import model.product.UniqueCopy;
import model.product.UniqueProduct;

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
		
		UniqueProduct prod = new UniqueProduct("seje", (double)200, (double)300, "product-inside", 100, 200, 140, 1234567);
		productContainer.addProduct(prod);
		
		prod.addCopy(new UniqueCopy("somewhere", "available", 123456781, prod));
		prod.addCopy(new UniqueCopy("somewhere", "available", 123456782, prod));
		prod.addCopy(new UniqueCopy("somewhere", "available", 123456783, prod));
		prod.addCopy(new UniqueCopy("somewhere", "available", 123456784, prod));
		prod.addCopy(new UniqueCopy("somewhere", "available", 123456785, prod));
		prod.addCopy(new UniqueCopy("somewhere", "available", 123456786, prod));
		prod.addCopy(new UniqueCopy("somewhere", "available", 123456787, prod));
		
		productContainer.addProduct(new ShelfProduct("test1", (double)200, (double)200, "product-swag", 123456, 200, 500, 300, "group 1"));
		
		// Create Customers
		CustomerContainer customerContainer = CustomerContainer.getInstance();
		
		for(int i = 0; i < 1000; i++) {
			Customer newCustomer = new Customer("Sejt navn", "seh@gmail.com", "aalborg somewhere lol", randomPhoneNo(), 5, "Regular");
			customerContainer.addCustomer(newCustomer);
		}
		
		
		Customer customer = new Customer("Sejt navn", "seh@gmail.com", "aalborg somewhere lol", "12345678", 5, "Regular");
		
		customerContainer.addCustomer(customer);
		DiscountContainer newContainer = DiscountContainer.getInstance();
		
		Discount discount = new Discount("Percentage");
		
		discount.setDiscountPercentage(0.9f);
		
		newContainer.addDiscount(discount);
		
		customer.setDiscount(discount);
		
		SalesAssistant salesAssistant = new SalesAssistant("Mikkeller", "666@hell.gg", "PureGym 69", "6969", 17);
		
		SalesAssistantContainer salesContainer = SalesAssistantContainer.getInstance();
		
		salesContainer.addSalesAssistant(salesAssistant);
	}
}