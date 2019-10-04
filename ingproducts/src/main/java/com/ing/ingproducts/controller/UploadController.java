package com.ing.ingproducts.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ing.ingproducts.dto.UploadResponseDto;
import com.ing.ingproducts.repository.CategoryRepository;
import com.ing.ingproducts.repository.ProductRepository;
import com.ing.ingproducts.service.UploadService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class UploadController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UploadService uploadService;

	@PostMapping("/uploadFile")
	public ResponseEntity<UploadResponseDto> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		UploadResponseDto responseDto = new UploadResponseDto();
		responseDto = uploadService.uploadFile(file);
		return new ResponseEntity<UploadResponseDto>(responseDto, HttpStatus.OK);
	}

}
