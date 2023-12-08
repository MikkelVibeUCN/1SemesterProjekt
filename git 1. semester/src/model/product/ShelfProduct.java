package model.product;

public class ShelfProduct {
	private String SKU;
	private int barcode;
	private int minimumStock;
	private int maximumStock;
	private int stockAmount;
	private String productGroup;
	public ShelfProduct(String SKU, int barcode, int minimumStock, int maximumStock, int stockAmount, String productGroup) {
		this.SKU = SKU;
		this.barcode = barcode;
		this.minimumStock  = minimumStock;
		this.maximumStock = maximumStock;
		this.stockAmount = stockAmount;
		this.productGroup = productGroup;
	}
	public int getBarcode() {
		return barcode;
	}
}
