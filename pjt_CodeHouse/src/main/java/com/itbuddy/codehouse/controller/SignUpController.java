package com.itbuddy.codehouse.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.DTO.Member;
import com.itbuddy.codehouse.VO.BoardVO;
import com.itbuddy.codehouse.service.IMemberService;
import com.itbuddy.codehouse.util.CheckString;

@Controller
public class SignUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	
	
	@Autowired
	private IMemberService memberService;
	
	@RequestMapping(value = "/signup")
	public String signUp(Locale locale, Model model, HttpSession session, HttpServletRequest httpServletRequest) {
		logger.info("Welcome board", locale);
		
		
		
		if(memberService.isLogin(session)) {			
			
			return "redirect:./";
		}else {
			return "signup";
		}
	} 

}
