/**
 * 
 */
package com.ing.ingproducts.service;

import com.ing.ingproducts.dto.ProductsResponseDTO;

/**
 * @author User1
 *
 */
public interface ProductsService {

	ProductsResponseDTO showProducts(Integer categoryId);

}
