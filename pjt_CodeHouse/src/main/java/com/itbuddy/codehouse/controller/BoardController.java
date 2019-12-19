package com.itbuddy.codehouse.controller;


import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.service.IBoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IBoardService boardService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model, HttpServletRequest httpServletRequest) {
		logger.info("Welcome board", locale);
		
		int pageRow = 10;
		int curPage = 1;
		int nextPage = 2;
		if(httpServletRequest.getAttribute("page")!= null) {
			curPage = Integer.parseInt(httpServletRequest.getAttribute("page").toString());
		}else {
			curPage = 1;
		}
		
		
		int start = (curPage*pageRow)-1;
		
		
		
		
		
		List<Article> articles = boardService.getArticles("art_create_time", start, pageRow);
		if(articles != null) {
			nextPage = curPage+1;
		}else {
			nextPage = curPage;
		}
		model.addAttribute("articles", articles);
		httpServletRequest.setAttribute("page", nextPage);
		
		return "board";
	}
	
}
