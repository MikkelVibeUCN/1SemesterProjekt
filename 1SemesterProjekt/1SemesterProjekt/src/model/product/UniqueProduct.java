package model.product;

import java.util.ArrayList;

public class UniqueProduct extends Product{
	private String SKU;
	private int minimumStock;
	private int maximumStock;
	private int stockAmount;
	private ArrayList<UniqueCopy> copies;
	
	public UniqueProduct(String name, double minimumPrice, double price, String SKU, int minimumStock, int maximumStock, int stockAmount,int barcode) {
		super(name,minimumPrice,price,barcode);
		this.SKU = SKU;
		this.minimumStock = minimumStock;
		this.maximumStock = maximumStock;
		this.stockAmount = stockAmount;
		copies = new ArrayList<>();
	}
	
	public UniqueCopy findCopy(int serialNo) {
		UniqueCopy result = null;
		int i = -1;
		boolean found = false;
		while(!found && ++i < copies.size()) {
			UniqueCopy currentCopy = copies.get(i);
			if(currentCopy.getSerialNo() == serialNo) {
				found = true;
				result = currentCopy;
			}
		}
		return result;
	}
	
	public void addCopy(UniqueCopy copy) {
		copies.add(copy);
	}
}