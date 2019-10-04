/**
 * 
 */
package com.ing.ingproducts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.ingproducts.dto.ProductsResponseDTO;
import com.ing.ingproducts.service.ProductsService;

/**
 * @author User1
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ProductsController {
	@Autowired
	ProductsService productsService;

	@GetMapping("/products/{categoryId}")
	public ProductsResponseDTO showProducts(@PathVariable Integer categoryId) {

		return productsService.showProducts(categoryId);

	}
}
