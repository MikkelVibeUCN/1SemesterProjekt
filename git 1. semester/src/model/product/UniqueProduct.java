package model.product;

public class UniqueProduct {
	private String SKU;
	private int minimumStock;
	private int maximumStock;
	private int stockAmount;
	
	public UniqueProduct (String SKU, int minimumStock, int maximumStock, int stockAmount ) {
		this.SKU = SKU;
		this.minimumStock = minimumStock;
		this.maximumStock = maximumStock;
		this.stockAmount = stockAmount;
	}
}
