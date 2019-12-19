package com.itbuddy.codehouse.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itbuddy.codehouse.DTO.Article;





public interface IArticleDAO {
	public List<Article> select(Article article);
	public List<Article> select_orderByParm_start_count(
			@Param ("parm") String parm, 
			@Param("start")int start, 
			@Param("count") int count
			);
	
    
    public int insert(Article article);
    
    
    public int update(Article article);
}
