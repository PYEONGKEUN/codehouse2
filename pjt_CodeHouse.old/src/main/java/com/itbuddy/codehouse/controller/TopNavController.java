package com.itbuddy.codehouse.controller;


import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbuddy.codehouse.service.IMemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TopNavController {
	
	private static final Logger logger = LoggerFactory.getLogger(TopNavController.class);
	
	@Autowired
	private IMemberService memberService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/common/topnav")
	public String topnav(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home", locale);
		
		
//		if(memberService.isLogin(session)) {
//			model.addAttribute("isLogin", true);
//		}else {
//			model.addAttribute("isLogin", false);
//		}
//		

		
		return "common/topNav";
	}
	
}
