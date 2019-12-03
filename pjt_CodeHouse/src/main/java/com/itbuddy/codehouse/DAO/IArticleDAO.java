package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Article;

import org.apache.ibatis.annotations.Param;




public interface IArticleDAO {
	public List<Article> selectArticleListOrderByParmDesc( @Param("start") int start, 
															@Param("count") int count, 
															@Param("param") String param); 
	
}
