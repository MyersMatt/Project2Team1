package models.items;

public class StoreItem {
	
	private int itemId;
	private String itemName;
	private int itemPrice;
	private int itemQuantity;

	public User() {
		this("itemId", "itemName", "itemPrice", "itemQuantity");
		
	}
	
	public User(int itemId, String itemName, int itemPrice, int itemQuantity) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemprice = itemPrice;
		this.itemQuantity = itemQuantity;
	}
	
	public String getitemId() {
		return this.itemId;
	}

	public String setitemId(int itemId) {
		return this.itemId = itemId;
	}

	public String getitemName() {
		return this.itemName;
	}

	public String setitemName(String itemName) {
		return this.itemName = itemName;
	}

	public String getitemPrice() {
		return this.itemPrice;
	}

	public String setitemPrice(int itemPrice) {
		return this.itemPrice = itemPrice;
	}
	
	public String getitemQuantity() {
		return this.itemQuantity;
	}

	public String setitemQuantity(int itemQuantity) {
		return this.itemQuantity = itemQuantity;
	}
}
