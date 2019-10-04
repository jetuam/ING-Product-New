package com.ing.ingproducts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.ingproducts.constants.IngproductsConstants;
import com.ing.ingproducts.dto.CategoryResponseDto;
import com.ing.ingproducts.entity.Category;
import com.ing.ingproducts.exception.ProductsNotFoundException;
import com.ing.ingproducts.repository.CategoryRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	CategoryRepository categoryRepository;

	public CategoryResponseDto getCategoryDetails() {
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		List<Category> categoryDetails = categoryRepository.findAll();
		if (categoryDetails != null) {
			categoryResponseDto.setStatusCode(IngproductsConstants.CATEGORY_GET_STATUS_CODE);
			categoryResponseDto.setMessage(IngproductsConstants.PRODUCT_SUCCESS_STATUS_MSG);
			categoryResponseDto.setCategoryDetails(categoryDetails);
			return categoryResponseDto;
		} else {
			throw new ProductsNotFoundException(IngproductsConstants.CATEGORY_NOT_FOUND_EXCEPTION);
		}
	}

}
