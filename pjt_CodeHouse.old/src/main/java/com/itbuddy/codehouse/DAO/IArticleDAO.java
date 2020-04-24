package com.itbuddy.codehouse.DAO;

import java.util.HashMap;
import java.util.List;


import com.itbuddy.codehouse.DTO.Article;





public interface IArticleDAO {
	public List<Article> select(Article article);
	
	public List<Article> select_start_count_sortParm(HashMap<String, String> hashmap);
	
	public int selectArticlesCount(HashMap<String, String> hashmap);
    
    public int insert(Article article);
    
    public int update(Article article);
    
}
