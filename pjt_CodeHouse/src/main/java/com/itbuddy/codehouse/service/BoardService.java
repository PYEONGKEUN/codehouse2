package com.itbuddy.codehouse.service;

import java.util.HashMap;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
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
		HashMap<String,String> hashmap = new HashMap<String, String>();


		hashmap.put("sortParam", sortParam);
		hashmap.put("start", Integer.toString(start));
		hashmap.put("count", Integer.toString(count));





		articles = articleDAO.select_start_count_sortParm(hashmap);

		return articles;
	}

	@Override
	public int getArticlesCount(@Nullable Article whereParam, @Nullable Article likeParam){
		int result = 0;
		
		HashMap<String, String> hashmap = new HashMap<String, String>();
		
		if(whereParam != null) {
			String art_no = null;
			if(whereParam.getArt_no() != null) {
				art_no = Integer.toString(whereParam.getArt_no());
			}
			hashmap.put("where_art_no", art_no);
			hashmap.put("where_art_title", whereParam.getArt_title());
			hashmap.put("where_art_content", whereParam.getArt_content());
			hashmap.put("where_art_create_time", whereParam.getArt_create_time());
			hashmap.put("where_art_modify_time", whereParam.getArt_modify_time());
			hashmap.put("where_mem_id", whereParam.getMem_id());
		}


		
		
		
		result = articleDAO.selectArticlesCount(hashmap);

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


		HashMap<String,String> hashmap = new HashMap<String, String>();

		//		<select id="select_start_count_sortParm" parameterType="java.util.HashMap" resultType="com.itbuddy.codehouse.DTO.Article">
		//		SELECT *
		//		FROM article
		//		<trim prefix="WHERE" prefixOverrides="AND|OR">
		//			<if test="where_art_no != null">AND art_no=#{where_art_no}</if>
		//			<if test="where_art_title != null">AND art_title=#{where_art_title}</if>
		//			<if test="where_art_content != null">AND art_content=#{where_art_content}</if>
		//			<if test="where_art_create_time != null">AND art_create_time=#{where_art_create_time}</if>
		//			<if test="where_art_modify_time != null">AND art_modify_time=#{where_art_modify_time}</if>
		//			<if test="where_mem_id != null">AND mem_id=#{where_mem_id}</if>			
		//		</trim>
		//		
		//		<if test="sortParam != null">ORDER BY ${sortParam} DESC</if>
		//		LIMIT #{start}, #{count}		
		//	</select>
		if(whereParam != null) {
			String art_no = null;
			if(whereParam.getArt_no() != null) {
				art_no = Integer.toString(whereParam.getArt_no());
			}
			hashmap.put("where_art_no", art_no);
			hashmap.put("where_art_title", whereParam.getArt_title());
			hashmap.put("where_art_content", whereParam.getArt_content());
			hashmap.put("where_art_create_time", whereParam.getArt_create_time());
			hashmap.put("where_art_modify_time", whereParam.getArt_modify_time());
			hashmap.put("where_mem_id", whereParam.getMem_id());
		}

		hashmap.put("sortParam", sortParam);		
		hashmap.put("start", Integer.toString(boardVO.getStartIndex()));
		hashmap.put("count", Integer.toString(boardVO.getPageSize()));



		boardVO.setArticles(articleDAO.select_start_count_sortParm(hashmap));



		return boardVO;
	}

}
