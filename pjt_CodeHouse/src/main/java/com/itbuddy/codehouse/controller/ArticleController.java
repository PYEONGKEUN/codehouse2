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
import com.itbuddy.codehouse.service.IArticleEditService;
import com.itbuddy.codehouse.service.IArticleService;
import com.itbuddy.codehouse.service.IMemberService;
import com.itbuddy.codehouse.util.CheckString;
import com.itbuddy.codehouse.util.TimeLib;


@Controller
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IArticleService iArticleService;

	
	@RequestMapping(value = "/article", method =  {RequestMethod.POST, RequestMethod.GET})
	public String article(Locale locale, Model model, HttpServletRequest httpServletRequest) {
		logger.info("Welcome article", locale);
		
		String art_no = (String)httpServletRequest.getParameter("article");
		Article article;
		
		if(art_no != null) {
			if(CheckString.isNumber(art_no)) {
				article = iArticleService.getArticle(Integer.parseInt(art_no));
				model.addAttribute("article",article);
			}else {
				return "redirect:./";
			}

		}else {
			return "redirect:./";
		}
		

		return "article";
	}
	
	
	
	@Autowired
	private IArticleEditService iArticleEditService;
	
	
	
	@RequestMapping(value = "/articleedit", method =  {RequestMethod.POST, RequestMethod.GET})
	public String articleEdit(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpSession session) {
		logger.info("Welcome articleEdit", locale);


		if(memberService.isLogin(session)) {

			
			return "articleEdit";
		}else {
			return "redirect:./";
		}
		
		

		
	}
	
	@RequestMapping(value = "/articleedit.insert", method =  {RequestMethod.POST, RequestMethod.GET})
	public String articleEditInsert(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpSession session) {
		logger.info("Welcome articleEdit", locale);


		if(memberService.isLogin(session)) {
			//에디터로부터 제목과 에디터 데이터를 가져옴
			String art_title= (String)httpServletRequest.getParameter("title");
			String art_content= (String)httpServletRequest.getParameter("editordata");
			
			if(art_title == null) art_title="";
			if(art_content == null) art_content="";

			//세션에서 아이디를 가져옴			
			Member member = (Member)session.getAttribute("memberInfo");			
			String mem_id= member.getMem_id();
						

			//insert Article
			Article article = new Article();
			
			article.setArt_title(art_title);
			article.setArt_content(art_content);
			article.setArt_create_time(TimeLib.getCurrDateTime());
			article.setArt_modify_time(TimeLib.getCurrDateTime());
			article.setMem_id(mem_id);	
			
			int art_no = iArticleEditService.insertArticle(article);

			
			return "redirect:./article?article="+art_no;
		}else {
			return "redirect:./";
		}
		

		
	}
	
}
