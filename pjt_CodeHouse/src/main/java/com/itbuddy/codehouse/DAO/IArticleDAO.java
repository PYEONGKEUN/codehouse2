package com.itbuddy.codehouse.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itbuddy.codehouse.DTO.Article;


public interface IArticleDAO {
	// Artcle을 Parm기준으로 정렬하여 가져온다.
	public List<Article> selectArticleListOrderByParmDesc( @Param("start") int start, 
															@Param("count") int count, 
															@Param("param") String param); 
	
}
