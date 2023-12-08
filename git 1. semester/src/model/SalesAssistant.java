package model;

public class SalesAssistant extends Person {
	
	private int employeeID;
	
	public SalesAssistant(String name, String mail, String address, String phoneNo, int age, int employeeID) {
		super(name, mail, address, phoneNo, age);
		this.employeeID = employeeID;
		
	}
}
