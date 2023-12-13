package model.product;

public abstract class Copy {
	private String location;
	private String state;
	private int serialNumber;
	
	
	public Copy(String location, String state, int serialNumber) {
		this.location = location;
		this.state = state;
		this.serialNumber = serialNumber;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public abstract Product getOrigin();
}
