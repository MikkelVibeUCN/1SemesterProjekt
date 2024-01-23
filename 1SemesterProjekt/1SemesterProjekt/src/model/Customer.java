package model;

public class Customer extends Person implements Comparable<Customer> {
	
	private String type;
	private Discount discount;
	private int id;
	private static int count;
	
	public Customer(String name, String mail, String address, String phoneNo, int age, String type) {
		super(name, mail, address, phoneNo, age);
		this.type = type;
		id = ++count;
	}
	
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	public int getID() {
		return id;
	}
	
	public int compareTo(Customer customer) {
		return getPhoneNo().compareTo(customer.getPhoneNo());
	}
	
	public Discount getDiscount() {
		return discount;
	}
	
	public String getType() {
		return type;
	}
}