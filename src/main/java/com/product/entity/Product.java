package com.product.entity;

import java.math.BigDecimal;

public class Product {
	
	private int productId;
	private String productName;
	private String category;
	private BigDecimal price;
	private int quantity;
	private String description;
	
	//No argument constructor
	public Product() {
	}
	
	//parameterized constructor
	public Product(String productName, String category, BigDecimal price, int quantity, String description) {
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}

	//Getters and Setters
	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getCategory() {
		return category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", price=" + price + ", quantity=" + quantity + ", description=" + description + "]";
	}
	
	
}
