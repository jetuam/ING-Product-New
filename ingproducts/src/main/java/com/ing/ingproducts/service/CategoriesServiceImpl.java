package com.ing.ingproducts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.ingproducts.repository.CategoryRepository;

@Service
public class CategoriesServiceImpl  implements CategoriesService{
    @Autowired
    CategoryRepository categoryRepository;
	@Override
	public void getCategoryDetails()
  {
		/*List<Categories> categoryDetails=categoryRepository.findAll();
		if(categoryDetails==null)
		{
			return null;
		}
		else 
		{
		return categoryDetails;
	}
  }*/

}
}