package model.product;

public class LoanProduct extends Product {
	private double hourlyPrice;
	public LoanProduct(String name, double minimumPrice, double price,int barcode, double hourlyPrice) {
		super(name, minimumPrice, price, barcode);
		this.hourlyPrice = hourlyPrice;
		
	}

}
