package model.product;

public class ShelfProduct extends Product{
	private String SKU;
	private int barcode;
	private int minimumStock;
	private int maximumStock;
	private int stockAmount;
	private String productGroup;
	
	public ShelfProduct (String name, double minimumPrice, double price, String SKU, int barcode, int minimumStock, int maximumStock, int stockAmount, String productGroup){
		super(name,minimumPrice,price,barcode);
		this.SKU = SKU;
		this.barcode = barcode;
		this.minimumStock = minimumStock;
		this.maximumStock = maximumStock;
		this.stockAmount = stockAmount;
		this.productGroup = productGroup;
		
	}
	
}

