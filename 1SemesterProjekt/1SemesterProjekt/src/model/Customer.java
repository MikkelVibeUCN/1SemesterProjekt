package model;

public class Customer extends Person {
	
	private String type;
	private Discount discount;
	
	public Customer(String name, String mail, String address, String phoneNo, int age, int employeeID, String type) {
		super(name, mail, address, phoneNo, age);
		this.type = type;
		
	}
	
	public void addDiscount(Discount discount) {
		this.discount = discount;
	}
}
