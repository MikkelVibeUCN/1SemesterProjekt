package model.product;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Random;


public class ProductContainer {
	private ArrayList<Product> products;
	private static final int START_SIZE = 28000;
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
	
	public Product findProduct(int barcode) {
		Product result = null; 
		
		boolean found = false;
		int start = 0;
		int end = products.size();
		int middle = products.size()/2;
		while(!found && middle != end) {
			if(products.get(middle).getBarcode() == barcode) {
				result = products.get(middle);
				found = true;
			}
			else if(barcode > products.get(middle).getBarcode()) {
				start = middle;
				middle = (start+end)/2;
			}
			else if(barcode < products.get(middle).getBarcode()){
				end = middle;
				middle = (start+end)/2;
			}
		}
		return result;
	}
	
//	public int randomBarcode() {
//		String number = "";
//		Random random = new Random();
//		
//		boolean hasRun = false;
//		
//		for(int i = 0; i < 6; i++) {
//			int nextNumber = 0;
//			if(!hasRun) {
//				nextNumber = random.nextInt(1, 9);
//			}
//			else {
//				nextNumber = random.nextInt(0, 9);
//			}
//			
//			number += nextNumber;
//		}		
//		return Integer.parseInt(number);
//	}
//	
//	
//	public static void main(String[] args) {
//		ProductContainer container = ProductContainer.getInstance();
//		
//		for(int i = 0; i < 500; i++) {
//			 ShelfProduct newProduct = new ShelfProduct("test", (double)200, (double)200, "product-swag", container.randomBarcode(), 200, 500, 300, "group 1");
//			 container.addProduct(newProduct);
//		}
//		
//		container.addProduct(new ShelfProduct("test", (double)200, (double)200, "product-swag", 123456, 200, 500, 300, "group 1"));
//		
//		System.out.println(container.findProduct(123456).getBarcode());
//		
//		for(Product product : container.products) {
//			System.out.println(product.getBarcode());
//		}
//		
//	}
}
