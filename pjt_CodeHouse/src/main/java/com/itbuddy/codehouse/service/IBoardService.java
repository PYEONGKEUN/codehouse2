package com.itbuddy.codehouse.service;

import java.util.List;

import com.itbuddy.codehouse.DTO.Article;

public interface IBoardService {

	public List<Article> getArticles(int start, int count, String sortParam);
	public int getArticlesCount();
}
