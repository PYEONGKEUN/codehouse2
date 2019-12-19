package com.itbuddy.codehouse.Service;

import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.DTO.Member;
import com.itbuddy.codehouse.config.RootConfig;
import com.itbuddy.codehouse.service.IBoardService;
import com.itbuddy.codehouse.service.IMemberService;

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

    
    @Test
    public void loginTest(){
    	List<Article> articles = boardService.getArticles("art_create_time", 0, 10);

    	for(Article article : articles) {
    		LOGGER.info(article.toString());
    	}
        

    }
    
}