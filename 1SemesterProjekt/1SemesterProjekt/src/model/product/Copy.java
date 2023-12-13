package model.product;

public abstract class Copy {
	private String location;
	private String state;
	private int serialNo;
	
	
	public Copy(String location, String state, int serialNo) {
		this.location = location;
		this.state = state;
		this.serialNo = serialNo;
	}
	
	public int getSerialNo() {
		return serialNo;
	}
	
	public abstract Product getOrigin();
}
