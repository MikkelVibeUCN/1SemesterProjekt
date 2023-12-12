package model;
import model.Discount;
import java.util.ArrayList;

public class DiscountContainer {
	private ArrayList<Discount> discounts;
	private static DiscountContainer instance;
	
	private DiscountContainer() {
		discounts = new ArrayList<>();
	}
	
	public static DiscountContainer getInstance() {
		if(instance == null) {
			instance = new DiscountContainer();
		}
		return instance;
	}
	
	public Discount findDiscount(int id) {
		Discount result = null;
		
		int i = -1;
		boolean found = false;
		while(!found && ++i < discounts.size()) {
			Discount current = discounts.get(i);
			if(current.getID() == id) {
				result = current;
				found = true;
			}
		}
		
		return result;
 	}
	
	public void addDiscount(Discount discount) {
		discounts.add(discount);
	}
}
