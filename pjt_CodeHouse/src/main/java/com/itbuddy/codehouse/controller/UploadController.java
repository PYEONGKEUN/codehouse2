package com.itbuddy.codehouse.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@PropertySource({"classpath:application.properties"})
@Controller
@RestController
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Value("${uploads.location}")
    private String uploadsLocation;
    @Value("${uploads.uri_path}")
    private String uploadsUriPath;
	

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
		
		logger.info("REAL_PATH : " + uploadsLocation);
		String SINGLE_FILE_UPLOAD_PATH = "test";
		
		
		File dir = new File(uploadsLocation,SINGLE_FILE_UPLOAD_PATH);

		if(dir.exists()) {
			logger.info(dir.getPath()+ " is Exist");
		}else {

			dir.mkdir();
			//Runtime.getRuntime().exec("chmod 777 "+FULL_PATH);		
			logger.info(dir.getPath()+" is not Exist so create dir");
		}

		// Save mediaFile on system
		if (!file.getOriginalFilename().isEmpty()) {
			File saveFile = new File(dir.getPath(), file.getOriginalFilename());
			file.transferTo(saveFile);
			model.addAttribute("msg", "File uploaded successfully.");

			logger.info("File uploaded successfully.");
			//itbuddy.iptime.org/codehouse
			String hostAndPort = request.getRequestURL().toString().replace(request.getRequestURI(),"")+"/codehouse";
			logger.info(hostAndPort+uploadsUriPath+"/"+file.getOriginalFilename());
			return hostAndPort+uploadsUriPath+"/"+file.getOriginalFilename();
		} else {
			model.addAttribute("msg", "Please select a valid mediaFile..");
			logger.info("Please select a valid mediaFile..");
			return null;
		}

	}


}
