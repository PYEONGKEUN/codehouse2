package com.itbuddy.codehouse.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.itbuddy.codehouse.DAO.IArticleDAO;
import com.itbuddy.codehouse.DTO.Article;


@Service
public class ArticleEditService implements IArticleEditService{
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleEditService.class);

	@Autowired
	private IArticleDAO articleDAO;

	@Override
	public int insertArticle(Article article) {
		// TODO Auto-generated method stub		
		articleDAO.insert(article);
		int num = article.getArt_no();
		LOGGER.info("Inserted articles number is : "+num );
		return num;
	}

	@Override
	public int updateArticle(Article article) {
		// TODO Auto-generated method stub
		
		int num = articleDAO.update(article);
		LOGGER.info("Updated articles count is : "+num );
		return num;

	}




}
