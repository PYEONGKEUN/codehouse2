package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Article;





public interface IArticleDAO {
	public List<Article> select(Article article);

    
    public Article insert(Article article);
    
    
    public Article update(Article article);
}
