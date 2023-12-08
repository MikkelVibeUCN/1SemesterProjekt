package model;

public abstract class Person {
	private String name;
	private int age;
	private String mail;
	private String address;
	private String phoneNo;
	
	public String getPhoneNumber() {
		return phoneNo;
	}
	
	public Person(String name, String mail, String address, String phoneNo, int age) {
		this.name = name;
		this.mail = mail;
		this.address = address;
		this.phoneNo = phoneNo;
		this.age = age;
	}
}