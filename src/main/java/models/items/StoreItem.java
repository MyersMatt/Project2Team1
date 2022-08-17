package models.items;

public class StoreItem {
	
	private int itemId;
	private String itemName;
	private int itemPrice;
	private int itemQuantity;

	public StoreItem() {
		this(0, "itemName", 0, 0);
		
	}
	
	public StoreItem(int itemId, String itemName, int itemPrice, int itemQuantity) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}
	
	public int getitemId() {
		return this.itemId;
	}

	public void setitemId(int itemId) {
		this.itemId = itemId;
	}

	public String getitemName() {
		return this.itemName;
	}

	public void setitemName(String itemName) {
		this.itemName = itemName;
	}

	public int getitemPrice() {
		return this.itemPrice;
	}

	public void setitemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public int getitemQuantity() {
		return this.itemQuantity;
	}

	public void setitemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
}
