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
	
	public ArrayList<Product> getProducts() {
		return products;
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
}
