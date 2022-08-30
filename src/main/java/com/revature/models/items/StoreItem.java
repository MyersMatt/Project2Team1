package com.revature.models.items;

import javax.persistence.*;

@Entity
@Table(name="store_item")
public class StoreItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id",insertable = false, updatable = false)
	private int itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name="item_price")
	private double itemPrice;
	@Column(name="item_quantity")
	private int itemQuantity;
	@Column(name="description")
	private String description;

	@Column(name="image_url")
	private String imageUrl;
	public StoreItem() {
		this( "itemName", 0.00, 0, "This is an item");
		
	}

	public StoreItem(String itemName, double itemPrice, int itemQuantity, String  description){
		this(0,itemName,itemPrice,itemQuantity,description);
	}

	public StoreItem(int itemId, String itemName, double itemPrice, int itemQuantity, String description) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.description = description;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItemId() {return itemId;}

	public void setItemId(int itemId) {	this.itemId = itemId;}
}
