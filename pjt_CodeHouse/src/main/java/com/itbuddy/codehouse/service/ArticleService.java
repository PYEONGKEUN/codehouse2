package com.itbuddy.codehouse.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbuddy.codehouse.DAO.IArticleDAO;
import com.itbuddy.codehouse.DTO.Article;
@Service
public class ArticleService implements IArticleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private IArticleDAO articleDAO;
	
	@Override
	public Article getArticle(int art_no) {
		// TODO Auto-generated method stub
		
		Article input = new Article();
		List<Article> output = new ArrayList<Article>();
		Article result = new Article();
		
		input.setArt_no(art_no);		
		output = articleDAO.select(input);		
		result = (Article)output.get(0);		
		
		
		if(result != null) {
			return result;
		}else {
			return null;
		}
	}

}
