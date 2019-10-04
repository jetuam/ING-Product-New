package com.ing.ingproducts.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.ing.ingproducts.dto.UploadResponseDto;
import com.ing.ingproducts.entity.Category;
import com.ing.ingproducts.entity.Product;
import com.ing.ingproducts.repository.CategoryRepository;
import com.ing.ingproducts.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class UploadServiceImplTest {
	@InjectMocks
	UploadServiceImpl serviceImpl;

	@Mock
	CategoryRepository categoryRepository;

	@Mock
	ProductRepository productRepository;

	Category category;
	Product product;
	UploadResponseDto uploadResponseDto;
	MultipartFile multipartFile;

	@Before
	public void setup() throws FileNotFoundException, IOException {
		multipartFile = new MockMultipartFile("Table structure & user stories.xlsx",
				new FileInputStream(new File("C:\\Users\\User1\\Downloads\\Table structure & user stories.xlsx")));
		category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("savingsAccount");

		uploadResponseDto = new UploadResponseDto();
		uploadResponseDto.setMessage("File has been uploaded successfully!");

		product = new Product();
		product.setProductId(1);
		product.setProductName("savingsAccount");
		product.setProductDescription(
				"The account for the future of your children\r\n" + " No expense or commissions\r\n"
						+ " Total availability\r\n" + " Remuneration - 0.75%\r\n" + " Ceiling - 50000 Euros\r\n"
						+ " Tax - Tax exempt\r\n" + " Min amount for account opening - 10 Euros\r\n"
						+ " Fees (Opening, Managing, closing ) - Free\r\n" + " ");
	}

	@Test
	public void uploadFileTest() throws IOException {
		Mockito.when(categoryRepository.save(Mockito.any())).thenReturn(category);
		Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
		uploadResponseDto = serviceImpl.uploadFile(multipartFile);
		assertEquals("File has been uploaded successfully!", uploadResponseDto.getMessage());
	}

}
