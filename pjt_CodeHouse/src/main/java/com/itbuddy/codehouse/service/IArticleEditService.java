package com.itbuddy.codehouse.service;

import org.springframework.stereotype.Service;

import com.itbuddy.codehouse.DTO.Article;


public interface IArticleEditService {
	public int insertArticle(Article article);
	public int updateArticle(Article article);
}
