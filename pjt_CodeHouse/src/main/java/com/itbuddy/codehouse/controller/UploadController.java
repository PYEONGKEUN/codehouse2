package com.itbuddy.codehouse.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RestController
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
// 컨트롤러에서 인식하는 PATH
	private String UPLOADS_PATH ="/files";
	
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
	public String singleFileUpload(@RequestParam("mediaFile") MultipartFile file, 
			Model model,
			HttpServletRequest request) throws IOException {
		
		
		logger.info("File uploaded loading.");
		//ServletConfig 에 등록된 파일 경로
		String REAL_PATH = request.getServletContext().getRealPath(UPLOADS_PATH);
		String SINGLE_FILE_UPLOAD_PATH = "test";
		String FULL_PATH = REAL_PATH + "/" + SINGLE_FILE_UPLOAD_PATH;
		
		File dir = new File(FULL_PATH);
		
		if(dir.isDirectory()) {
			logger.info(FULL_PATH+" is Exist");
		}else {
			
			dir.mkdir();
			Runtime.getRuntime().exec("chmod 777 "+FULL_PATH);		
			logger.info(FULL_PATH+" is not Exist so create dir");
		}
			
	   // Save mediaFile on system
	   if (!file.getOriginalFilename().isEmpty()) {
		   File saveFile = new File(FULL_PATH, file.getOriginalFilename());
	      file.transferTo(saveFile);
	      model.addAttribute("msg", "File uploaded successfully.");
	      
	      logger.info("File uploaded successfully.");
	      return UPLOADS_PATH+"/"+file.getOriginalFilename();
	   } else {
	      model.addAttribute("msg", "Please select a valid mediaFile..");
	      logger.info("Please select a valid mediaFile..");
	      return null;
	   }
	   
	}


}
