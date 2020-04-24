package org.itbuddy.codehouse.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.itbuddy.codehouse.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
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


	@Autowired
	IUploadService uploadService;

	@ResponseBody
	@RequestMapping(value="/uploadimg.action", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String singleFileUpload(
			@RequestParam("mediaFile") MultipartFile file, 
			HttpSession session,
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		return uploadService.imgUpload(file, model, session, request, response);

		

	}


}
