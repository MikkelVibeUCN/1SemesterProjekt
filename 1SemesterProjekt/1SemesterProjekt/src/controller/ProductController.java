package controller;
import model.product.*;

/**
 * ProductController handles everything to do with products
 * @author gruppe-1
 */

public class ProductController {
	private ProductContainer productContainer;
	
	public ProductController() {
		productContainer = ProductContainer.getInstance();
	}
	
	/**
	 * getStockAmount() finds the stock amount of a specific product
	 * @param barcode, the barcode of the specific product.
	 * @return int containing the amount in stock, returns -1 if the product isn't found
	 */
	public int getStockAmount(int barcode) {
		int result = -1;
		Product product = findProduct(barcode);
		if(product instanceof ShelfProduct) {
			result = ((ShelfProduct) product).getStockAmount();
		}
		return result;
	}
	
	/**
	 * removeStock removes stock from a specific product.
	 * @param barcode, the barcode of the specific product
	 * @return String containing the message to print to the user.
	 */
	public boolean removeStock(int barcode, int amount) {
		boolean result = false;
		Product product = findProduct(barcode);
		if(product instanceof ShelfProduct) {
			((ShelfProduct) product).removeStock(amount);
			result = true;
		}
		return result;
	}
	
	public String getNameFromBarcode(int barcode) {
		String result = null;
		Product product = findProduct(barcode);
		if(product != null) {
			result = product.getName();
		}
		return result;
	}
	
	public Product findProduct(int barcode) {
		return productContainer.findProduct(barcode);
	}
}