/**
 * 
 */
package com.ing.ingproducts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.ingproducts.constants.IngproductsConstants;
import com.ing.ingproducts.dto.ProductsDTO;
import com.ing.ingproducts.dto.ProductsResponseDTO;
import com.ing.ingproducts.entity.Product;
import com.ing.ingproducts.exception.ProductsNotFoundException;
import com.ing.ingproducts.repository.ProductRepository;

/**
 * @author User1
 *
 */
@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductsResponseDTO showProducts(Integer categoryId) {

		Optional<List<Product>> optionalfindByCategoryProductId = productRepository.findAllByProductCategoryId(categoryId);
		List<ProductsDTO> productsDTODTOList = new ArrayList<>();
		if (!optionalfindByCategoryProductId.isPresent()) {
			throw new ProductsNotFoundException("products not found");
		}
		List<Product> productList=optionalfindByCategoryProductId.get();
		productList.forEach(product -> {
			ProductsDTO productsDTO = new ProductsDTO();
			productsDTO.setProductId(product.getProductId());
			productsDTO.setProductName(product.getProductName());
			productsDTO.setDesc(product.getProductDescription());
			productsDTODTOList.add(productsDTO);
		});
		ProductsResponseDTO productsResponseDTO = new ProductsResponseDTO();
		productsResponseDTO.setProductsDTO(productsDTODTOList);
		productsResponseDTO.setStatusCode(IngproductsConstants.PROUD_GET_STATUS_CODE);
		productsResponseDTO.setStatusMessage(IngproductsConstants.PRODUCT_SUCCESS_STATUS_MSG);
		return productsResponseDTO;
	}

}
