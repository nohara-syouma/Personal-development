package com.example.Enitity;

public class BuyList {

	private String username;
	private Integer productId;
	private Integer categoryId;
	private String name;
	private Integer price;

	private String img;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public BuyList() {
	}

	public BuyList(String username, Integer productId, Integer categoryId, String name, Integer price, String img) {
		this.username = username;
		this.productId = productId;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.img = img;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
