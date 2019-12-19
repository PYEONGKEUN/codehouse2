package com.itbuddy.codehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbuddy.codehouse.DAO.IArticleDAO;
import com.itbuddy.codehouse.DTO.Article;
@Service
public class BoardService implements IBoardService{
	
	@Autowired
	private IArticleDAO articleDAO;

	@Override
	public List<Article> getArticles(int start, int count, String sortParm) {
		// TODO Auto-generated method stub
		List<Article> result;
		result = articleDAO.select_start_count_sortParm(sortParm, start, count);
		
		return result;
	}
	
	@Override
	public int getArticlesCount(){
		int result = 0;
		result = articleDAO.selectArticlesCount();
		
		return result;
	}

}
