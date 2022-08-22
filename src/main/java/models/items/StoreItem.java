package models.items;

import jakarta.persistence.*;

@Entity
@Table(name="store_item")
public class StoreItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name="item_prioce")
	private double itemPrice;
	@Column(name="item_quantity")
	private int itemQuantity;
	@Column(name="description")
	private String description;
	public StoreItem() {
		this(0, "itemName", 0.00, 0, "This is an item");
		
	}
	
	public StoreItem(int itemId, String itemName, double itemPrice, int itemQuantity, String description) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.description = description;
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

	public double getitemPrice() {
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
