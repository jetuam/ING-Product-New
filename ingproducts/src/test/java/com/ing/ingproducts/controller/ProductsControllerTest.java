/**
 * 
 */
package com.ing.ingproducts.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.ingproducts.dto.ProductsDTO;
import com.ing.ingproducts.dto.ProductsResponseDTO;
import com.ing.ingproducts.service.ProductsServiceImpl;

import junit.framework.Assert;

/**
 * @author User1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductsControllerTest {
	@Mock
	ProductsServiceImpl productsServiceImpl;
	@InjectMocks
	ProductsController productsController;

	@Test
	public void testShowProducts() throws Exception {

		ProductsDTO productsDTO = new ProductsDTO();
		productsDTO.setProductId(1);
		productsDTO.setProductName("debit cards");
		productsDTO.setDesc("hfgs");

		List<ProductsDTO> productList = new ArrayList<>();
		productList.add(productsDTO);
		ProductsResponseDTO productsResponseDTO = new ProductsResponseDTO();
		productsResponseDTO.setStatusCode(200);
		productsResponseDTO.setStatusMessage("success");
		productsResponseDTO.setProductsDTO(productList);
		Mockito.when(productsServiceImpl.showProducts(1)).thenReturn(productsResponseDTO);
		ProductsResponseDTO showProducts = productsController.showProducts(1);

		Assert.assertNotNull(showProducts);
	}

}
