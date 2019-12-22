package com.itbuddy.codehouse.controller;

import java.text.DateFormat;
import java.util.Date;
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
import com.itbuddy.codehouse.service.IBoardService;
import com.itbuddy.codehouse.service.IMemberService;
import com.itbuddy.codehouse.service.IMyPageService;
import com.itbuddy.codehouse.util.CheckString;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IBoardService boardService;
	
	@Autowired
	private IMyPageService myPageService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	//?artpage=10&cmtpage=10&view=[article OR comment]
	public String mypage(Locale locale, Model model, HttpSession session, HttpServletRequest httpServletRequest) {
		logger.info("Welcome board", locale);
		
		
		
		if(memberService.isLogin(session)) {
			// 멤버
			Member member = (Member)myPageService.getMyInfo(session);
			if(member.getMem_img() == "" || member.getMem_img() == null) {
				member.setMem_img("./resources/imgs/noUserImage.png");
			}
			// Test
			member.setMem_img("./resources/imgs/noUserImage.png");
			
			model.addAttribute("member", member);
			
			

			BoardVO boardVO = new BoardVO();
			
			// where 조건 
			Article whereParam = new Article();
			whereParam.setMem_id(member.getMem_id());
			
			int articleTotalCnt = boardService.getArticlesCount(whereParam,null); // 전체 article 개수 구해오는 부분
			String artCurPage = (String)httpServletRequest.getParameter("artpage");
			
			if(artCurPage != null) {
				if(!CheckString.isNumber(artCurPage)) {				
					artCurPage = "1";
				}
			}else {
				artCurPage = "1";
				
			}
			logger.info(artCurPage);

			boardVO = boardService.pagination(articleTotalCnt, Integer.parseInt(artCurPage), "art_create_time",whereParam,null);
			
			model.addAttribute("boardVO", boardVO);
			
			
			
			//
			
			
			return "myPage";
		}else {
			return "redirect:./";
		}
	}
}
