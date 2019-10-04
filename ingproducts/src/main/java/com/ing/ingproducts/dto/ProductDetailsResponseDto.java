package com.ing.ingproducts.dto;

import java.util.List;

public class ProductDetailsResponseDto {
 private Integer statusCode;
 private String message;
 private List<ProductsDTO> productDetails;
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
public List<ProductsDTO> getProductDetails() {
	return productDetails;
}
public void setProductDetails(List<ProductsDTO> productDetails) {
	this.productDetails = productDetails;
}
 
}
