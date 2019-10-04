package com.ing.ingproducts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.ingproducts.dto.ProductDetailsResponseDto;
import com.ing.ingproducts.service.ProductDetailsService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/product")
public class ProductDetailsController {

	@Autowired
	ProductDetailsService productDetailsService;

	@GetMapping("/{productId}")
	public ProductDetailsResponseDto productsDetails(@PathVariable("productId") Integer productId) {
		ProductDetailsResponseDto productDetailsResponseDto = productDetailsService.getProductDetails(productId);

		return productDetailsResponseDto;

	}

}
