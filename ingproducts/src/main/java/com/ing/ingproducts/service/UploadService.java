package com.ing.ingproducts.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ing.ingproducts.dto.UploadResponseDto;

@Service
public interface UploadService {

	public UploadResponseDto uploadFile(MultipartFile file) throws IOException;
}
