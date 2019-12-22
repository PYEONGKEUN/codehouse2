package com.itbuddy.codehouse.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.itbuddy.codehouse.DAO.ICommentDAO;
import com.itbuddy.codehouse.DTO.Comment;
import com.itbuddy.codehouse.VO.BoardVO;
import com.itbuddy.codehouse.VO.CommentsVO;
import com.itbuddy.codehouse.controller.BoardController;

public class CommentsService implements ICommentService{

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private ICommentDAO commentDAO;
	
	@Override
	public CommentsVO pagination(int totCommentsCnt, int curPage, String sortParam, Comment whereParam, Comment likeParam) {
		// TODO Auto-generated method stub
		
		CommentsVO commentsVo = new CommentsVO();
				
		commentsVo.setTotArticlesCnt(totCommentsCnt);
		commentsVo.setPageCnt((int)Math.ceil(commentsVo.getTotArticlesCnt()*1.0/commentsVo.getPageSize()));
		commentsVo.setRangeCnt((int) Math.ceil(commentsVo.getPageCnt()*1.0/commentsVo.getRangeSize()));		
				
		commentsVo.setCurPage(curPage);
		commentsVo.setStartPage((commentsVo.getCurRange() - 1) * commentsVo.getRangeSize() + 1);
		commentsVo.setEndPage(commentsVo.getStartPage() +commentsVo.getRangeSize() - 1);
				
		if(commentsVo.getEndPage() > commentsVo.getPageCnt()){
			commentsVo.setEndPage(commentsVo.getPageCnt());
        }
		
		commentsVo.setPrevPage(commentsVo.getCurPage()-1);
		commentsVo.setNextPage(commentsVo.getCurPage()+1);
		
		commentsVo.setCurRange((int)((commentsVo.getCurPage()-1)/commentsVo.getRangeSize()) + 1);
		commentsVo.setStartIndex((commentsVo.getCurPage()-1) * commentsVo.getPageSize());
		
		
		commentsVo.setComments(commentDAO.select_start_count_sortParm(commentsVo.getStartIndex(), commentsVo.getPageSize(), sortParam));
		
		
		
		return commentsVo;
	}

}
