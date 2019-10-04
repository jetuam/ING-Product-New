package com.ing.ingproducts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.ingproducts.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "SELECT P FROM Product P WHERE P.category.categoryId=:categoryId")
	List<Product> findAllByProductCategoryId(@Param("categoryId") Integer categoryId);

}
