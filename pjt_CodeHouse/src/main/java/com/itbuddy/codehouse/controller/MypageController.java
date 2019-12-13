package com.itbuddy.codehouse.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itbuddy.codehouse.service.IMemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private IMemberService memberService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome board", locale);

		if(memberService.isLogin(session)) {
			return "myPage";
		}else {
			return "redirect:./";
		}
		
		
		
		
	}
	
}
