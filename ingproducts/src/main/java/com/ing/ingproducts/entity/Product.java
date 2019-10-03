package com.ing.ingproducts.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private String productDescription;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
	 private Category category;
	 
	
	
	/*
	 * public Integer getCategoryId() { return categoryId; } public void
	 * setCategoryId(Integer categoryId) { this.categoryId = categoryId; } public
	 * Category getCategory() { return category; } public void setCategory(Category
	 * category) { this.category = category; }
	 */
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
}
