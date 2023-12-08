package model.product;

public class LoanProduct extends Product {
	private int barcode;
	private double hourlyPrice;
	public LoanProduct(String name, double minimumPrice, double price,int barcode, double hourlyPrice) {
		super(name, minimumPrice, price);
		this.barcode = barcode;
		this.hourlyPrice = hourlyPrice;
		
	}

}
