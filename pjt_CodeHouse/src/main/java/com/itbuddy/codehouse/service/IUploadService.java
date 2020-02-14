package com.itbuddy.codehouse.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;


public interface IUploadService {

	
	public String imgUpload(String email, 
			MultipartFile file, 
			Model model,
			HttpServletRequest request, 
			HttpServletResponse response) throws IOException;
	
}
