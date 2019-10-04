package com.ing.ingproducts.dto;

import java.util.List;

import com.ing.ingproducts.entity.Category;

public class CategoryResponseDto {

	private Integer statusCode;
	private String message;
	private List<Category> categoryDetails;

	public List<Category> getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(List<Category> categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
