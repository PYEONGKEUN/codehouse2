package org.itbuddy.codehouse.controller;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.itbuddy.codehouse.DTO.Member;
import org.itbuddy.codehouse.service.IMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IMemberService memberService;
	
	/**
	 * 로그인 서비스들을 모아놓음
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest httpServletRequest,Model model, HttpSession session) {
		logger.info("Welcome login");
		
		return "login";
	}
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String loginAction(HttpServletRequest httpServletRequest, HttpSession session) {
		logger.info("Do Login");
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		
		Member member = new Member();
		
		member.setMem_id(id);
		member.setMem_pw(pw);				

		if(memberService.login(member, session)) {
			return "redirect:./";
		}else {
			return "login";
		}		
		
	}
	
	
	@RequestMapping(value = "/logout.action")
	public String logout(Model model, HttpSession session) {
		logger.info("Do Logout");
		
		memberService.logout(session);
		
		return "redirect:./";
	}
	
}
