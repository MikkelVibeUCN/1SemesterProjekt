package model;

public class Discount {
	private String type;
	private static int count;
	private int discountID;
	private float discountPercentage;
	private float loanDiscountPercentage;
	
	public Discount(String type) {
		this.type = type;
		discountID = ++count;
	}
}
