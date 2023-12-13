package controller;
import model.*;
import model.product.*;
import tui.MainMenu;

public class ProductController {
	private ProductContainer productContainer;
	
	public ProductController() {
		productContainer = ProductContainer.getInstance();
	}
	
	public int getStockAmount(int barcode) {
		int result = -1;
		Product product = findProduct(barcode);
		if(product instanceof ShelfProduct) {
			result = ((ShelfProduct) product).getStockAmount();
		}
		return result;
	}
	
	public boolean removeStock(int barcode, int amount) {
		boolean result = false;
		Product product = findProduct(barcode);
		if(product instanceof ShelfProduct) {
			((ShelfProduct) product).removeStock(amount);
			result = true;
		}
		return result;
	}
	
	
	
	public Product findProduct(int barcode) {
		return productContainer.findProduct(barcode);
	}
	
	
	public static void main(String[] args) {
        ProductController controller = new ProductController();
        
        ShelfProduct shelfBoi = new ShelfProduct("test", (double)200, (double)200, "product-swag", 25555, 200, 500, 300, "group 1");
        
        Composite kitchen = new Composite("Kitchen", (double)200, (double)200, "kitchen-product", 25676, 200, 500, 300, "group 1");
        
        kitchen.addProduct(shelfBoi);
    }
}
