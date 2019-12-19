package com.itbuddy.codehouse.service;

import java.util.List;

import com.itbuddy.codehouse.DTO.Article;

public interface IBoardService {
	public List<Article> getArticles(String parm,int start, int count);
}
