/**
 * 
 */
package com.ing.ingproducts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.ingproducts.dto.ProductsResponseDTO;
import com.ing.ingproducts.entity.Category;
import com.ing.ingproducts.entity.Product;
import com.ing.ingproducts.repository.ProductRepository;

import junit.framework.Assert;

/**
 * @author User1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductsServiceImplTest {
	@Mock
	ProductRepository productRepository;
	@InjectMocks
	ProductsServiceImpl productsServiceImpl;

	@Test()
	public void testShowProducts() {
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("accounts");
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("debit cards");
		product.setCategory(category);
		product.setProductDescription("debit card related info");
		List<Product> productList = new ArrayList<>();		
		productList.add(product);
		Optional<List<Product>> optionalList=Optional.of(productList);
		Mockito.when(productRepository.findAllByProductCategoryId(1)).thenReturn(optionalList);
		ProductsResponseDTO showProducts = productsServiceImpl.showProducts(1);

		Assert.assertNotNull(showProducts);

	}

}
