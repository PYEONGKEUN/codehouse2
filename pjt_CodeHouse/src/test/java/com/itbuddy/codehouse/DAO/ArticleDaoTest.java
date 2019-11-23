package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.config.DBConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ArticleDaoTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {DBConfig.class})
public class ArticleDaoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoTest.class);

    @Autowired
    private IArticleDAO ArticleDAO;
    
    @Test
    public void testSelectArticleListOrderByParmDesc(){
        List<Article> articles = ArticleDAO.selectArticleListOrderByParmDesc(0, 10, "art_create_time");

        for(Article artcle : articles){
            LOGGER.info(artcle.toString());
        }
        

    }
    
    
}