package org.itbuddy.codehouse.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itbuddy.codehouse.DTO.Article;
import org.itbuddy.codehouse.DTO.Comment;
import org.itbuddy.codehouse.DTO.Member;
import org.itbuddy.codehouse.VO.BoardVO;
import org.itbuddy.codehouse.VO.CommentsVO;
import org.itbuddy.codehouse.service.IBoardService;
import org.itbuddy.codehouse.service.ICommentService;
import org.itbuddy.codehouse.service.IMemberService;
import org.itbuddy.codehouse.service.IMyPageService;
import org.itbuddy.codehouse.util.CheckString;
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
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IBoardService boardService;

	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private IMyPageService myPageService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	//?artpage=10&cmtpage=10&view=[article OR comment]
	public String mypage(Locale locale, Model model, HttpSession session, HttpServletRequest httpServletRequest) {
		logger.info("Welcome board", locale);
		
		
		
		//if(memberService.isLogin(session)) {
			// 멤버
			Member member = (Member)myPageService.getMyInfo(session);
			if(member.getMem_img() == "" || member.getMem_img() == null) {
				member.setMem_img("./resources/imgs/noUserImage.png");
			}
			// Test
			member.setMem_img("./resources/imgs/noUserImage.png");
			
			model.addAttribute("member", member);
			
			
			//articles 페이징
			BoardVO boardVO = new BoardVO();
			
			// where 조건 
			Article artWhereParam = new Article();
			artWhereParam.setMem_id(member.getMem_id());
			
			int articleTotalCnt = boardService.getArticlesCount(artWhereParam,null); // 전체 article 개수 구해오는 부분
			String artCurPage = (String)httpServletRequest.getParameter("artpage");
			
			if(artCurPage != null) {
				if(!CheckString.isNumber(artCurPage)) {				
					artCurPage = "1";
				}
			}else {
				artCurPage = "1";
				
			}
			logger.info(artCurPage);

			boardVO = boardService.pagination(articleTotalCnt, Integer.parseInt(artCurPage), "art_create_time",artWhereParam,null);
			
			model.addAttribute("boardVO", boardVO);
			
			
			
			//comments 페이징
			CommentsVO commentsVO = new CommentsVO();
			
			// where 조건 
			Comment cmtWhereParam = new Comment();
			cmtWhereParam.setMem_id(member.getMem_id());
			
			int commentTotalCnt = commentService.getCommentsCount(cmtWhereParam,null); // 전체 article 개수 구해오는 부분
			String cmtCurPage = (String)httpServletRequest.getParameter("cmtpage");
			
			if(cmtCurPage != null) {
				if(!CheckString.isNumber(cmtCurPage)) {				
					cmtCurPage = "1";
				}
			}else {
				cmtCurPage = "1";
				
			}
			logger.info(cmtCurPage);

			commentsVO = commentService.pagination(commentTotalCnt, Integer.parseInt(cmtCurPage), "cmt_create_time",cmtWhereParam,null);
			
			model.addAttribute("commentsVO", commentsVO);
			
			
			return "myPage";
		//}else {
		//	return "redirect:./";
		//}
	}
}
