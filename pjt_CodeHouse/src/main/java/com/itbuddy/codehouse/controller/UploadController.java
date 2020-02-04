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

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	// 컨트롤러에서 인식하는 PATH
	private String UPLOADS_PATH ="/uploads";

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
		logger.info("REAL_PATH : " + REAL_PATH);
		String SINGLE_FILE_UPLOAD_PATH = "test";
		String FULL_UPLOAD_PATH = UPLOADS_PATH + "/" + SINGLE_FILE_UPLOAD_PATH;
		
		File dir = new File(REAL_PATH,SINGLE_FILE_UPLOAD_PATH);

		if(dir.exists()) {
			logger.info(dir.getPath()+" is Exist");
		}else {

			dir.mkdir();
			Runtime.getRuntime().exec("chown -R tomcat:tomcat "+dir.getPath());		
			logger.info(dir.getPath()+" is not Exist so create dir");
		}

		// Save mediaFile on system
		if (!file.getOriginalFilename().isEmpty()) {
			File saveFile = new File(dir.getPath(), file.getOriginalFilename());
			file.transferTo(saveFile);
			model.addAttribute("msg", "File uploaded successfully.");

			logger.info("File uploaded successfully.");

			String hostAndPort = request.getRequestURL().toString().replace(request.getRequestURI(),"");
			logger.info(hostAndPort+FULL_UPLOAD_PATH+"/"+file.getOriginalFilename());
			return hostAndPort+FULL_UPLOAD_PATH+"/"+file.getOriginalFilename();
		} else {
			model.addAttribute("msg", "Please select a valid mediaFile..");
			logger.info("Please select a valid mediaFile..");
			return null;
		}

	}


}
