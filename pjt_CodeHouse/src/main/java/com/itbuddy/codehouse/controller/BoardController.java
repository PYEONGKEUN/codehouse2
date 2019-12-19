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
		
		final int PAGE_SIZE = 10;
		
		BoardVO boardVO = new BoardVO();
		
		
		int articleTotalCnt = boardService.getArticlesCount(); // 전체 article 개수 구해오는 부분
		int totalPage = (int)articleTotalCnt/PAGE_SIZE;
		
		//1페이지 일 경우 start의 값은 0
		int start = 0;		
		

		String strStart;
		if(httpServletRequest.getAttribute("page") != null) {
			
			 strStart = httpServletRequest.getAttribute("page").toString();
			 httpServletRequest.setAttribute("page", strStart);
			if(CheckString.isNumber(strStart)) {
				start = Integer.parseInt(strStart);
				int prevPage = start -1;
				int nextPage = start +1;
				 
				 if(prevPage >= 0) {
					 boardVO.setHasPrevPage(true);
				 }else {
					 boardVO.setHasPrevPage(false);
				 }
				 
				 if( nextPage <= totalPage) {
					 boardVO.setHasNextPage(true);
				 }else {
					 boardVO.setHasNextPage(false);
				 }
				
				if(start <=0 ) {//0이하일때 start 값을 0으로 고정
					start = 0;
				}else {
					start = start -1;
				}
				start  = start * PAGE_SIZE;
			}
		}else {
			httpServletRequest.setAttribute("page", "0");
		}
		
		boardVO.setArticles(boardService.getArticles(start, PAGE_SIZE, "art_create_time"));
		
		model.addAttribute("boardVO", boardVO);
		
		 
		
		

		
		return "board";
	}

}
