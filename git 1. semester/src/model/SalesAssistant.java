package model;

public class SalesAssistant extends Person {
	private static int count;
	
	private int employeeID;
	
	public SalesAssistant(String name, String mail, String address, String phoneNo, int age) {
		super(name, mail, address, phoneNo, age);
		employeeID = ++count;
	}
	
	public int getID() {
		return employeeID;
	}
}
