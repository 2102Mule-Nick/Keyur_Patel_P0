package com.revature.pojo;

public class UserComments {

	private final int productId;

	private float cost;

	private String itemName;

	private int quantity;

	private float discount;

	public int getProductId() {

		return this.productId;
	}
	
	public void setCost(float cost) {
		if (cost > 0) {

			this.cost = cost;
		}
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getCost() {
		return cost;
	}

	public UserComments() {

		this(1, 3.0f, "default-item-name", 1, 0.0f);

	}

	public UserComments(int productId, float cost, String itemName, int quantity, float discount) {
		super();
		this.productId = productId;
		this.setCost(cost);
		this.setItemName(itemName);
		this.setQuantity(quantity);
		this.setDiscount(discount);
	}
	
	
}
