package com.ing.ingproducts.service;


import com.ing.ingproducts.dto.ProductDetailsResponseDto;

public interface ProductDetailsService {
	 

	ProductDetailsResponseDto getProductDetails(Integer productId);
}
