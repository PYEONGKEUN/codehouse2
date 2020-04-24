package org.itbuddy.codehouse.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itbuddy.codehouse.service.IMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SignUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	
	

	
	@RequestMapping(value = "/signup")
	public String signUp(Locale locale, Model model, HttpSession session, HttpServletRequest httpServletRequest) {
		logger.info("Welcome SignUp", locale);
		
		

		
		return "signup";
	} 
	
	
	
	@PostMapping("/signup.action")
	public boolean signupAction(Model model, HttpServletRequest httpServletRequest) {
		
	
		
		return true;
	}

}
