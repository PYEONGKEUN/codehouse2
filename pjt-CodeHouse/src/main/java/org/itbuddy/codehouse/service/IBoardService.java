package org.itbuddy.codehouse.service;


import java.util.List;

import org.itbuddy.codehouse.DTO.Article;
import org.itbuddy.codehouse.VO.BoardVO;
import org.springframework.lang.Nullable;

public interface IBoardService {

	public List<Article> getArticles(int start, int count, String sortParam);
	public int getArticlesCount(@Nullable Article whereParam, @Nullable Article likeParam);
	public BoardVO pagination(int totArticlesCnt, int curPage, String sortParam, @Nullable Article whereParam, @Nullable Article likeParam);
	//		boardVO.setArticles(boardService.getArticles(start, PAGE_SIZE, "art_create_time"));
}
