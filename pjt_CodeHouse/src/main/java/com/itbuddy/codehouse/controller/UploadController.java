package com.itbuddy.codehouse.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {

	
	
	private String DOWNLOAD_PATH = "./";
	private String SINGLE_FILE_UPLOAD_PATH = "single";
	
	
//	@ResponseBody
//	@RequestMapping(value="/uploadimg.action", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
//	public String uploadImg(Model model,
//			@RequestParam("id") String email,
//			@RequestParam("file1") MultipartFile file) {
//
//		return null;
//	}
	@ResponseBody
	@RequestMapping(value="/uploadimg.action", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String singleFileUpload(@RequestParam("mediaFile") MultipartFile file, Model model)
	      throws IOException {

	   // Save mediaFile on system
	   if (!file.getOriginalFilename().isEmpty()) {
		   File saveFile = new File(DOWNLOAD_PATH + "/" + SINGLE_FILE_UPLOAD_PATH, file.getOriginalFilename());
	      file.transferTo(saveFile);
	      model.addAttribute("msg", "File uploaded successfully.");
	      return saveFile.toPath().toString();
	   } else {
	      model.addAttribute("msg", "Please select a valid mediaFile..");
	      return null;
	   }
	   
	}


}
