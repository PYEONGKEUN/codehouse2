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
import com.itbuddy.codehouse.service.IArticleEditService;
import com.itbuddy.codehouse.service.IArticleService;
import com.itbuddy.codehouse.service.IMemberService;
import com.itbuddy.codehouse.util.CheckString;


@Controller
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IArticleEditService articleEditService;
	
	
	@RequestMapping(value = "/article", method =  {RequestMethod.POST, RequestMethod.GET})
	public String article(Locale locale, Model model, HttpServletRequest httpServletRequest) {
		logger.info("Welcome article", locale);
		
		String art_no = (String)httpServletRequest.getParameter("article");
		Article article;
		
		if(art_no != null) {
			if(CheckString.isNumber(art_no)) {
				article = articleService.getArticle(Integer.parseInt(art_no));
				model.addAttribute("article",article);
			}else {
				return "redirect:./";
			}

		}else {
			return "redirect:./";
		}
		

		return "article";
	}
	
	
	@RequestMapping(value = "/articleedit", method =  {RequestMethod.POST, RequestMethod.GET})
	public String articleEdit(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpSession session) {
		logger.info("Welcome articleEdit", locale);


		if(memberService.isLogin(session)) {
			
			String art_no = (String)httpServletRequest.getParameter("article");
			Article article;
			
			if(art_no != null) {
				//article = articleEditService.getArticle(Integer.parseInt(art_no));
				//model.addAttribute("article",article);
			}else {
				return "redirect:./";
			}
			
			return "article";
		}else {
			return "redirect:./";
		}
		
		

		
	}
	
}
