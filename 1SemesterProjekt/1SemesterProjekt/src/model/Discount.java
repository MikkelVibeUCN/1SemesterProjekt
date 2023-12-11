package model;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Discount {
	private String type;
	private static int count;
	private final static double MAX_DISCOUNT = 0.2;
	private double discount;
	private int discountID;
	private float discountPercentage;
	private float loanDiscountPercentage;
	
	public Discount(String type) {
		this.type = type;
		this.discountID = ++count;
		this.discount = 0;
		this.discountPercentage = 0;
		
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
			if(amount/discount*100 < MAX_DISCOUNT*10) {
				result = amount - amount * MAX_DISCOUNT;
			}
			else {
				result = amount - discount;
			}
		}
		return result;
	}
	
	public int getID() {
		return discountID;
	}
}