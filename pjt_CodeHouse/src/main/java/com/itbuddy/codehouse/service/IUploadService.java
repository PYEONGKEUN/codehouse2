package com.itbuddy.codehouse.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.itbuddy.codehouse.DTO.Art_file;

public interface IUploadService {

	public String restore(MultipartFile multipartFile);
	public String genSaveFileName(String extName);
	public boolean writeFile(MultipartFile multipartFile, String saveFileName);
	public void profileUpload(String email, MultipartFile file, HttpServletRequest request, HttpServletResponse response);
	
}
