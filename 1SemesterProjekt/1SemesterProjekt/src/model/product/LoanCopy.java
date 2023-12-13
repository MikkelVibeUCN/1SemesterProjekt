package model.product;

public class LoanCopy extends Copy {
	private LoanProduct originProduct;
	
	public LoanCopy(String location, String state, int serialNumber, LoanProduct originProduct) {
		super(location, state , serialNumber);
		this.originProduct = originProduct;
	}
	
	public Product getOrigin() {
		return originProduct;
	}
}
