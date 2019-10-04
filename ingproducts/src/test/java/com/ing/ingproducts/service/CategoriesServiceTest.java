package com.ing.ingproducts.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.ingproducts.dto.CategoryRequestDto;
import com.ing.ingproducts.dto.CategoryResponseDto;
import com.ing.ingproducts.entity.Category;
import com.ing.ingproducts.repository.CategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesServiceTest {
	@Mock
	CategoryRepository categoryRepository;
	@InjectMocks
	CategoriesServiceImpl categoriesServiceImpl;
	Category category;
	CategoryRequestDto categoryRequestDto;
	List<Category> categoryDetails;

	@Before
	public void setup() {
		category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("Mortgage");
		categoryRequestDto = new CategoryRequestDto();
		categoryRequestDto.setCategoryId(1);
		categoryRequestDto.setCategoryName("Mortgage");
		categoryDetails = new ArrayList<>();
		categoryDetails.add(category);

	}

	@Test
	public void testGetCategoryDetails() {
		Mockito.when(categoryRepository.findAll()).thenReturn(categoryDetails);
		CategoryResponseDto categoryResponseDto = categoriesServiceImpl.getCategoryDetails();
		assertEquals(new Integer(1), categoryResponseDto.getCategoryDetails().get(0).getCategoryId());
	}

}
