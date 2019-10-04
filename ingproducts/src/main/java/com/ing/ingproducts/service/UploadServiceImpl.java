package com.ing.ingproducts.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ing.ingproducts.dto.UploadResponseDto;
import com.ing.ingproducts.entity.Category;
import com.ing.ingproducts.entity.Product;
import com.ing.ingproducts.repository.CategoryRepository;
import com.ing.ingproducts.repository.ProductRepository;

@Service
public class UploadServiceImpl implements UploadService {
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public UploadResponseDto uploadFile(MultipartFile file) throws IOException {
		UploadResponseDto responseDto = new UploadResponseDto();
		InputStream in = file.getInputStream();
		XSSFWorkbook workbook = new XSSFWorkbook(in);
		Sheet sheet = workbook.getSheetAt(0);
		String prevCatCell = "";
		Iterator<Row> rowIterator = sheet.iterator();
		Category category2 = null;
		while (rowIterator.hasNext()) {
			Row currentRow = rowIterator.next();

			String currCatcell = currentRow.getCell(1).getStringCellValue().trim();
			String prodCell = currentRow.getCell(2).getStringCellValue();
			String prodDescCell = currentRow.getCell(3).getStringCellValue();
			if (!currCatcell.equalsIgnoreCase("Category Name")) {
				if (!prevCatCell.equalsIgnoreCase(currCatcell)) {
					Category category = new Category();
					category.setCategoryName(currCatcell);
					category2 = categoryRepository.save(category);
				}

				Product product = new Product();
				product.setProductName(prodCell);
				product.setProductDescription(prodDescCell);
				product.setCategory(category2);
				productRepository.save(product);
				prevCatCell=currCatcell;
			}
		}
		responseDto.setMessage("File has been uploaded successfully!");
		return responseDto;
	}

}
