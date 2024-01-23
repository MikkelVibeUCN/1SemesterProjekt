package model.product;

import java.util.ArrayList;
import java.util.Collections;

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
		insertionSortLast();
	}
	
	/**
	 * findProduct() finds a specific product object by performing binary search
	 * @param barcode, the barcode of the customer to find.
	 * @return The specific product or null if it is not found.
	 */
	public Product findProduct(int barcode) {
		Product result = null; 
		
		boolean found = false;
		int start = 0;
		int end = products.size();
		
		if(products.size() > 1) {
			end--;
		}
		int middle = products.size()/2;
		
		while(!found && start <= end) {
			middle = start+(end - start)/2;
			
			if(products.get(middle).getBarcode() == barcode) {
				result = products.get(middle);
				found = true;
			}
			else if(barcode > products.get(middle).getBarcode()) {
				start = middle + 1;
			}
			else if(barcode < products.get(middle).getBarcode()) {
				end = middle - 1;
				
			}
		}
		return result;
	}

//	public void insertionSortAll() {
//		for(int i = 0; i < products.size() && products.size() > 1 && i != products.size()-1; i++) {
//			int variableIndex = i;
//			
//			while(products.get(variableIndex).compareTo(products.get(variableIndex+1)) > 0 ) {
//				Collections.swap(products, variableIndex, variableIndex+1);
//				
//				if(i > 0 && variableIndex-1 > 0) {
//					variableIndex--;
//				} 
//			}
//		}
//	}

	/**
	 * insertionSortLast sorts the last element by using insertion sort on the products array according to compareTo()
	 * @return void
	 */
	private void insertionSortLast() {
		if(products.size() > 1) {
			int variableIndex = products.size()-2;
			
			while(products.get(variableIndex).compareTo(products.get(variableIndex+1)) > 0 ) {
				Collections.swap(products, variableIndex, variableIndex+1);
				
				if(variableIndex-1 >= 0) {
					variableIndex--;
				} 
			}
		}
	}
}
