package com.itbuddy.codehouse.service;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbuddy.codehouse.DAO.IArticleDAO;
import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.VO.BoardVO;
import com.itbuddy.codehouse.controller.BoardController;
@Service
public class BoardService implements IBoardService{

	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private IArticleDAO articleDAO;
	
	@Override
	public List<Article> getArticles(int start, int count, String sortParam) {
		// TODO Auto-generated method stub
		List<Article> articles = null;
		
		articles = articleDAO.select_start_count_sortParm(start, count, sortParam);
		
		return articles;
	}
	
	@Override
	public int getArticlesCount(){
		int result = 0;
		result = articleDAO.selectArticlesCount();
		
		return result;
	}

	@Override
	public BoardVO pagination(int totArticlesCnt, int curPage, String sortParam, Article whereParam, Article likeParam) {
		// TODO Auto-generated method stub
		
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTotArticlesCnt(totArticlesCnt);
		boardVO.setPageCnt((int)Math.ceil(boardVO.getTotArticlesCnt()*1.0/boardVO.getPageSize()));
		boardVO.setRangeCnt((int) Math.ceil(boardVO.getPageCnt()*1.0/boardVO.getRangeSize()));		
		
		boardVO.setCurPage(curPage);
		boardVO.setStartPage((boardVO.getCurRange() - 1) * boardVO.getRangeSize() + 1);
		boardVO.setEndPage(boardVO.getStartPage() +boardVO.getRangeSize() - 1);
		
		if(boardVO.getEndPage() > boardVO.getPageCnt()){
			boardVO.setEndPage(boardVO.getPageCnt());
        }
		
		boardVO.setPrevPage(boardVO.getCurPage()-1);
		boardVO.setNextPage(boardVO.getCurPage()+1);
		
		boardVO.setCurRange((int)((boardVO.getCurPage()-1)/boardVO.getRangeSize()) + 1);
		boardVO.setStartIndex((boardVO.getCurPage()-1) * boardVO.getPageSize());
		
		
		boardVO.setArticles(articleDAO.select_start_count_sortParm(boardVO.getStartIndex(), boardVO.getPageSize(), sortParam));
		
		
		
		return boardVO;
	}

}
