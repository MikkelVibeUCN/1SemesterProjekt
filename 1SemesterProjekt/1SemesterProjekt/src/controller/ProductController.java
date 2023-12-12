package controller;
import model.*;
import model.product.*;

public class ProductController {
	private ProductContainer productContainer;
	
	public ProductController() {
		productContainer = ProductContainer.getInstance();
	}
	
	public int getStockAmount(int barcode) {
		int result = -1;
		Product p = productContainer.findProduct(barcode);
		if(p instanceof ShelfProduct) {
			result = ((ShelfProduct) p).getStockAmount();
		}
		return result;
	}
	
	public boolean removeStock(Product product, int amount) {
		boolean result = false;
		if(product instanceof ShelfProduct) {
			((ShelfProduct) product).removeStock(amount);
			result = true;
		}
		return result;
	}
	
	public boolean isValidAmount(int barcode, int amount) {
		boolean result = false;
		Product product = productContainer.findProduct(barcode);
		if(product instanceof ShelfProduct) {
			result = ((ShelfProduct) product).isValidAmount(amount);
		}
		return result;
	}
	
	public Product findProduct(int barcode) {
		return productContainer.findProduct(barcode);
	}
}
