/**
 * 
 */
package com.ing.ingproducts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.ingproducts.dto.ProductsDTO;
import com.ing.ingproducts.dto.ProductsResponseDTO;
import com.ing.ingproducts.entity.Product;
import com.ing.ingproducts.repository.CategoryRepository;
import com.ing.ingproducts.repository.ProductRepository;

/**
 * @author User1
 *
 */
@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductsResponseDTO showProducts(Integer categoryId) {
		/*
		 * Optional<Category> findById =
		 * categoryRepository.findById(categoryId.longValue()); if
		 * (!findById.isPresent()) { throw new
		 * ProductsNotFoundException("category not found"); }
		 */
		// List<Product> productList = findById.get().getProductList();

		List<Product> findByCategoryProductId = productRepository
				.findAllByProductCategoryId(categoryId);
		/*
		 * if (!findByCategoryProductId.isPresent()) { throw new
		 * ProductsNotFoundException("products not found"); }
		 */

		// List<Product> productList = findByCategoryProductId.get();
		List<ProductsDTO> productsDTODTOList = new ArrayList<>();

		findByCategoryProductId.forEach(product -> {
			ProductsDTO productsDTO = new ProductsDTO();
			productsDTO.setProductId(product.getProductId());
			productsDTO.setProductName(product.getProductName());
			productsDTO.setDesc(product.getProductDescription());
			productsDTODTOList.add(productsDTO);
		});
		ProductsResponseDTO productsResponseDTO = new ProductsResponseDTO();
		productsResponseDTO.setProductsDTO(productsDTODTOList);
		productsResponseDTO.setStatusCode(200);
		productsResponseDTO.setStatusMessage("success");
		return productsResponseDTO;
	}

}
