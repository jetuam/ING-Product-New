package com.ing.ingproducts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.ingproducts.dto.ProductDetailsResponseDto;
import com.ing.ingproducts.dto.ProductsDTO;
import com.ing.ingproducts.entity.Product;
import com.ing.ingproducts.repository.ProductRepository;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {
	@Autowired
	ProductRepository productDetailsRepository;

	@Override
	public ProductDetailsResponseDto getProductDetails(Integer productId) {
		List<ProductsDTO> productsDTODTOList = new ArrayList<>();
		ProductDetailsResponseDto productDetailsResponseDto = new ProductDetailsResponseDto();
		List<Product> productsDetail = productDetailsRepository.findAllById(productId);
		if (productsDetail != null) {
			productsDetail.forEach(product -> {
				ProductsDTO productsDTO = new ProductsDTO();
				productsDTO.setProductId(product.getProductId());
				productsDTO.setProductName(product.getProductName());
				productsDTO.setDesc(product.getProductDescription());
				productsDTODTOList.add(productsDTO);
			});
			productDetailsResponseDto.setStatusCode(201);
			productDetailsResponseDto.setMessage("Product Description");
			productDetailsResponseDto.setProductDetails(productsDTODTOList);
			return productDetailsResponseDto;
		} else
			return null;
	}

}
