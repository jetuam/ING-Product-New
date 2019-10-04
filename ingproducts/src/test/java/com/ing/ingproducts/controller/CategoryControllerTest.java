package com.ing.ingproducts.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.ingproducts.dto.CategoryResponseDto;
import com.ing.ingproducts.entity.Category;
import com.ing.ingproducts.service.CategoriesServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {
	@Mock
	CategoriesServiceImpl categoriesServiceImpl;
	@InjectMocks
	CategoryController categoryController;

	@Test
	public void testCategoryDetails() {
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("Mortgage");
		List<Category> categoryDetails = new ArrayList<>();
		categoryDetails.add(category);
		categoryResponseDto.setCategoryDetails(categoryDetails);
		categoryResponseDto.setStatusCode(201);
		categoryResponseDto.setMessage("CategoryDetails");
		Mockito.when(categoriesServiceImpl.getCategoryDetails()).thenReturn(categoryResponseDto);
		CategoryResponseDto categoryResponseDto1 = categoryController.categoryDetails();
		assertEquals(categoryResponseDto.getCategoryDetails().get(0).getCategoryId(),
				categoryResponseDto1.getCategoryDetails().get(0).getCategoryId());
	}
}
