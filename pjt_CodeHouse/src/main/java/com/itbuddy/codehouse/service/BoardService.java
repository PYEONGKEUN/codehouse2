package com.itbuddy.codehouse.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbuddy.codehouse.DAO.IArticleDAO;
import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.controller.BoardController;
@Service
public class BoardService implements IBoardService{

	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private IArticleDAO articleDAO;
	
	@Override
	public List<Article> getArticles(String parm,int start, int count) {
		// TODO Auto-generated method stub
		List<Article> articles = null;
		
		articles = articleDAO.select_orderByParm_start_count(parm, start, count);
		
		return articles;
	}

}
