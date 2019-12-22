package com.itbuddy.codehouse.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.lang.Nullable;

import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.VO.BoardVO;

public interface IBoardService {

	public List<Article> getArticles(int start, int count, String sortParam);
	public int getArticlesCount(@Nullable Article whereParam, @Nullable Article likeParam);
	public BoardVO pagination(int totArticlesCnt, int curPage, String sortParam, @Nullable Article whereParam, @Nullable Article likeParam);
	//		boardVO.setArticles(boardService.getArticles(start, PAGE_SIZE, "art_create_time"));
}
