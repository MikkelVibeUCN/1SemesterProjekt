package model;

public class Customer extends Person {
	
	private String type;
	private Discount discount;
	private int id;
	private static int count;
	
	public Customer(String name, String mail, String address, String phoneNo, int age, int employeeID, String type) {
		super(name, mail, address, phoneNo, age);
		this.type = type;
		id = ++count;
	}
	
	public void addDiscount(Discount discount) {
		this.discount = discount;
	}
	
	public int getID() {
		return id;
	}
}
