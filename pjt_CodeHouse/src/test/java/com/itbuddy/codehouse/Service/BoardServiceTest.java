package com.itbuddy.codehouse.Service;

import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.DTO.Member;
import com.itbuddy.codehouse.VO.BoardVO;
import com.itbuddy.codehouse.config.RootConfig;
import com.itbuddy.codehouse.service.IBoardService;
import com.itbuddy.codehouse.service.IMemberService;
import com.itbuddy.codehouse.util.CheckString;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TopNavServiceTest
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class BoardServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BoardServiceTest.class);

    @Autowired
    private IBoardService boardService;

    
//    @Test
//    public void loginTest(){
//    	List<Article> articles = boardService.getArticles( 0, 10,"art_create_time");
//
//    	for(Article article : articles) {
//    		LOGGER.info(article.toString());
//    	}
//        
//
//    }
    @Test
    public void paginationTest(){
    	int articleTotalCnt = boardService.getArticlesCount(null,null);
    	Article whereParam = new Article();
    	
    	whereParam.setMem_id("skvudrms54");
    	BoardVO boardVO = boardService.pagination(articleTotalCnt, Integer.parseInt("1"), "art_create_time",whereParam,null);

    	for(Article article : boardVO.getArticles()) {
    		LOGGER.info(article.toString());
    	}
    	if(CheckString.isNumber("1a")) {
    		LOGGER.info("true");
    	}else {
    		LOGGER.info("false");
    	}
    	
        

    }
    
}