package com.ing.ingproducts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.ingproducts.dto.CategoryResponseDto;
import com.ing.ingproducts.service.CategoriesService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	CategoriesService categoriesService;

	@GetMapping("/")
	public CategoryResponseDto categoryDetails() {

		CategoryResponseDto categoryDetails = categoriesService.getCategoryDetails();

		return categoryDetails;

	}

}
