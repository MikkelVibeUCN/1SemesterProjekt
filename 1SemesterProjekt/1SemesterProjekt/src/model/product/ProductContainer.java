package model.product;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Random;


public class ProductContainer {
	private ArrayList<Product> products;
	private ArrayList<Product> productsBarcodeDescending;
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
		productsBarcodeDescending = new ArrayList<>(products.size());
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
		insertionSort();
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
	
	public void insertionSort() {
		
		for(int i = 0; i < products.size() && products.size() > 1 && i != products.size()-1; i++) {
			int variableIndex = i;
			
			while(products.get(variableIndex).getBarcode() > products.get(variableIndex+1).getBarcode()) {
				Collections.swap(products, variableIndex, variableIndex+1);
				
				if(i > 0 && variableIndex-1 > 0) {
					variableIndex--;
				} 
			}
		}
		
		
	}
}
