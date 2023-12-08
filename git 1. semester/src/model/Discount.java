package model;

public class Discount {
	private String type;
	private static int count;
	private double discount;
	private int discountID;
	private float discountPercentage;
	private float loanDiscountPercentage;
	
	public Discount(String type) {
		this.type = type;
		discountID = ++count;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	public double calculatePrice(double amount) {
		double result = -1;
		if(discountPercentage != 0) {
			result = amount*discountPercentage;
		}
		else if (discount != 0) {
			result = amount - discount;
		}
		return result;
	}
}