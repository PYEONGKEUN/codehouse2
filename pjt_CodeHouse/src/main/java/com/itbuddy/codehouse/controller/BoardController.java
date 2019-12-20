package com.itbuddy.codehouse.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

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
import com.itbuddy.codehouse.VO.BoardVO;
import com.itbuddy.codehouse.service.IBoardService;
import com.itbuddy.codehouse.util.CheckString;

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
	@RequestMapping(value = "/board", method =  {RequestMethod.POST, RequestMethod.GET})
	public String board(Locale locale, Model model, HttpServletRequest httpServletRequest) {
		logger.info("Welcome board", locale);



		BoardVO boardVO = new BoardVO();
		int articleTotalCnt = boardService.getArticlesCount(); // 전체 article 개수 구해오는 부분
		String curPage = (String)httpServletRequest.getParameter("page");
		
		if(curPage != null) {
			if(!CheckString.isNumber(curPage)) {				
				curPage = "1";
			}
		}else {
			curPage = "1";
		}
		logger.info(curPage);
		
		//httpServletRequest.setAttribute("page", curPage);
		boardVO = boardService.pagination(articleTotalCnt, Integer.parseInt(curPage), "art_create_time",null,null);

		model.addAttribute("boardVO", boardVO);

		return "board";
	}

}
