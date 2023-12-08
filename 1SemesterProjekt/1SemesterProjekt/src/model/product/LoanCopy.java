package model.product;

public class LoanCopy {
	private int barcode;
	private String location;
	private String state;
	private int serialNumber;
	
	public LoanCopy(int barcode, String location, String state, int serialNumber) {
		this.barcode = barcode;
		this.location = location;
		this.state = state;
		this.serialNumber = serialNumber;
	}
}
