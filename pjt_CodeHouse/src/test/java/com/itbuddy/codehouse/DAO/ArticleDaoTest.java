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
    public void selectTest(){

    }
    @Test
    public void updateTest(){

    }
    @Test
    public void insertTest(){

    }
    
}