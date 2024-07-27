package ht.helloworld;

public class Invoice implements Payable {

	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	public Invoice(String part, String description, int count, double price) {
		partNumber = part;
		partDescription = description;
		setQuantity(count);
		setPricePerItem(price);
	}
	
	public void setPartNumber(String part) {
		partNumber = part;
	}
	
	public String getPartNumber() {
		return partNumber;
	}
	
	public void setPartDescription(String description) {
		partDescription = description;
	}
	
	public String getPartDescription() {
		return partDescription;
	}
	
	public void setQuantity(int count) {
		if(count >= 0) {
			quantity = count;
		}else {
			throw new IllegalArgumentException("Quantity must be >= 0");
		}
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setPricePerItem(double price) {
		if(price >= 0) {
			pricePerItem = price;
		}else {
			throw new IllegalArgumentException("Price item must be >= 0");
		}
	}
	
	public double getPricePerItem() {
		return pricePerItem;
	}
	
	@Override
	public String toString() {
		return String.format( "%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f",
				"invoice", "part number", getPartNumber(), getPartDescription(),
				"quantity", getQuantity(), "price per item", getPricePerItem() );
 
	}
	
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return getQuantity() * getPricePerItem();
	}

	
}
