package com.itbuddy.codehouse.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;

import com.itbuddy.codehouse.DTO.Article;





public interface IArticleDAO {
	public List<Article> select(Article article);
	
	public List<Article> select_start_count_sortParm( @Param("start") int start,
			@Param("count") int count,
			@Param("sortParam") String sortParam);
	
	public int selectArticlesCount();
    
    public int insert(Article article);
    
    public int update(Article article);
    
}
