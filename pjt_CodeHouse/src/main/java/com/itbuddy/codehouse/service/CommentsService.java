package com.itbuddy.codehouse.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.itbuddy.codehouse.DAO.ICommentDAO;
import com.itbuddy.codehouse.DTO.Comment;
import com.itbuddy.codehouse.VO.CommentsVO;
import com.itbuddy.codehouse.controller.BoardController;
@Service
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


		HashMap<String,String> hashmap = new HashMap<String, String>();


		if(whereParam != null) {
			String art_no = null;
			String cmt_no = null;
			if(whereParam.getArt_no() != null) {
				art_no = Integer.toString(whereParam.getArt_no());
			}
			if(whereParam.getCmt_no() != null) {
				cmt_no = Integer.toString(whereParam.getCmt_no());
			}
			hashmap.put("where_cmt_no", art_no);
			hashmap.put("where_cmt_title", whereParam.getCmt_title());
			hashmap.put("where_cmt_content", whereParam.getCmt_content());
			hashmap.put("where_cmt_create_time", whereParam.getCmt_create_time());
			hashmap.put("where_cmt_modify_time", whereParam.getCmt_modify_time());
			hashmap.put("where_mem_id", whereParam.getMem_id());
			hashmap.put("where_art_no", cmt_no);
		}

		hashmap.put("sortParam", sortParam);		
		hashmap.put("start", Integer.toString(commentsVo.getStartIndex()));
		hashmap.put("count", Integer.toString(commentsVo.getPageSize()));



		commentsVo.setComments(commentDAO.select_start_count_sortParm(hashmap));




		return commentsVo;
	}

	@Override
	public int getCommentsCount(@Nullable Comment whereParam, @Nullable Comment likeParam) {
		// TODO Auto-generated method stub
		int result = 0;

		HashMap<String,String> hashmap = new HashMap<String, String>();


		if(whereParam != null) {
			String art_no = null;
			String cmt_no = null;
			if(whereParam.getArt_no() != null) {
				art_no = Integer.toString(whereParam.getArt_no());
			}
			if(whereParam.getCmt_no() != null) {
				cmt_no = Integer.toString(whereParam.getCmt_no());
			}
			hashmap.put("where_cmt_no", art_no);
			hashmap.put("where_cmt_title", whereParam.getCmt_title());
			hashmap.put("where_cmt_content", whereParam.getCmt_content());
			hashmap.put("where_cmt_create_time", whereParam.getCmt_create_time());
			hashmap.put("where_cmt_modify_time", whereParam.getCmt_modify_time());
			hashmap.put("where_mem_id", whereParam.getMem_id());
			hashmap.put("where_art_no", cmt_no);
		}
		result = commentDAO.selectCommentsCount(hashmap);

		return result;



	}

}
