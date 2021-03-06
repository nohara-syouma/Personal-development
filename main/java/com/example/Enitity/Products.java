package com.example.Enitity;

public class Products {
	private Integer productId;
	private Integer categoryId;
	private String cName;

	private Integer price;

	private String name;

	private String img;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Products() {
	}

	public Products(Integer productId, Integer categoryId, String name, Integer price) {
		this.productId = productId;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}

	public Products(Integer productId, Integer categoryId, String name, Integer price, String img) {
		this.productId = productId;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.img = img;

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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

}