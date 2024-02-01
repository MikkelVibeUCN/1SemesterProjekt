package model;

public class SalesAssistant extends Person {
	
	private int employeeID;
	private static int count;
	
	public SalesAssistant(String name, String mail, String address, String phoneNo, int age) {
		super(name, mail, address, phoneNo, age);
		this.employeeID = ++count;
	}
	
	public int getID() {
		return this.employeeID;
	}
}