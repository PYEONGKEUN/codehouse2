package org.itbuddy.codehouse.service;

import org.itbuddy.codehouse.DTO.Article;


public interface IArticleEditService {
	public int insertArticle(Article article);
	public int updateArticle(Article article);
}
