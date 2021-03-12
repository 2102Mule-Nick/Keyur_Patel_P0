package com.revature.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserStatus {
	
	private int cartId;	//default value = 0
	
	private List<UserComments> userComments; //default value = null
	
	private float total; //default value = 0.0
	
	private List<Integer> quantity; //Integer is a Wrapper class
	
	private int userId;

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public List<UserComments> getItems() {
		return userComments;
	}



	public void setItems(List<UserComments> userComments) {
		this.userComments = userComments;
	}



	public float getTotal() {
		return total;
	}



	public void setTotal(float total) {
		this.total = total;
	}



	public List<Integer> getQuantity() {
		return quantity;
	}



	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}

	public UserStatus() {
		this.userComments = new ArrayList<>();
		this.quantity = new ArrayList<>();
	}
	
	public UserStatus(int cartId, List<UserComments> userComments, float total, List<Integer> quantity, int userId) {
		super();
		this.cartId = cartId;
		this.userComments = userComments;
		this.total = total;
		this.quantity = quantity;
		this.userId = userId;
	}
	
}
