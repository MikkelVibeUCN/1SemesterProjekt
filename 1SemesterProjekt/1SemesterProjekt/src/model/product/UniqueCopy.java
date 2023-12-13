package model.product;

public class UniqueCopy extends Copy {
	private UniqueProduct originProduct;
	
	public UniqueCopy(String location, String state, int serialNumber, UniqueProduct originProduct) {
		super(location, state, serialNumber);
		this.originProduct = originProduct;
	}
	
	public Product getOrigin() {
		return originProduct;
	}
	
}
