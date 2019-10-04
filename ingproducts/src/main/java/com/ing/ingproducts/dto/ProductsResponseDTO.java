/**
 * 
 */
package com.ing.ingproducts.dto;

import java.util.List;

/**
 * @author User1
 *
 */
public class ProductsResponseDTO {

	private int StatusCode;
	private String statusMessage;
	private List<ProductsDTO> ProductsDTO;

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public List<ProductsDTO> getProductsDTO() {
		return ProductsDTO;
	}

	public void setProductsDTO(List<ProductsDTO> productsDTO) {
		ProductsDTO = productsDTO;
	}

}
