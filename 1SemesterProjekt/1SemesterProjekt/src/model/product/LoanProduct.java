package model.product;

import java.util.ArrayList;

public class LoanProduct extends Product {
	private double hourlyPrice;
	private ArrayList<LoanCopy> copies;
	
	public LoanProduct(String name, double minimumPrice, double price,int barcode, double hourlyPrice) {
		super(name, minimumPrice, price, barcode);
		this.hourlyPrice = hourlyPrice;
		this.copies = new ArrayList<>();
		
	}
	public LoanCopy findCopy(int serialNo) {
		LoanCopy result = null;
		int i = 0;
		boolean found = false;
		while(!found && i++ < copies.size()) {
			LoanCopy currentCopy = copies.get(i);
			if(currentCopy.getSerialNumber() == serialNo) {
				found = true;
				result = currentCopy;
			}
		}
		return result;
	}
}
