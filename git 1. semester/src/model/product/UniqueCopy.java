package model.product;

public class UniqueCopy {
	private int barcode;
	private String location;
	private String state;
	private int serialNumber;
	
	public UniqueCopy(int barcode,String location,String state,int serialNumber) {
		this.barcode = barcode;
		this.location = location;
		this.state=state;
		this.serialNumber = serialNumber;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
}
