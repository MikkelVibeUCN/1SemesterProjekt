package model.product;

public class UniqueCopy {
	private String location;
	private String state;
	private int serialNumber;
	private static int count;
	private int id;
	
	public UniqueCopy(String location, String state, int serialNumber, int id) {
		this.location = location;
		this.state = state;
		this.serialNumber = serialNumber;
		id = ++count;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
}
