package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.config.RootConfig;
import com.itbuddy.codehouse.util.TimeLib;

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
@ContextConfiguration(classes= {RootConfig.class})
public class ArticleDaoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoTest.class);

    @Autowired
    private IArticleDAO articleDAO;
    
//    @Test
//    public void selectTest(){
//        Article input = new Article();
//        input.setArt_content("테스트");
//        List<Article> output = articleDAO.select(input);
//
//
//        for(Article comment : output){
//            LOGGER.info(comment.toString());
//        }
//    }
    
//    @Test
//    public void selectArticlesCountTest() {
//    	int result = articleDAO.selectArticlesCount();
//    	LOGGER.info(result + "");
//    }

//    @Test
//    public void updateTest(){
//        Article input = new Article();
//        input.setArt_no(3);
//        input.setArt_modify_time(TimeLib.getCurrDateTime());
//
//        articleDAO.update(input);
//        List<Article> output = articleDAO.select(input);
//
//
//        for(Article comment : output){
//            LOGGER.info(comment.toString());
//        }
//
//
//    }
//
    @Test
    public void insertTest(){

        Article input = new Article();
        
        
        input.setArt_title("테스트");
        input.setArt_content("테스트"); 
        input.setArt_create_time(TimeLib.getCurrDateTime());
        input.setArt_modify_time(TimeLib.getCurrDateTime());
        input.setMem_id("skvudrms54");

        int num = articleDAO.insert(input);       
           
        LOGGER.info("성공한 갯수 : " + num +" - "+input.toString());


        
    }
    
}