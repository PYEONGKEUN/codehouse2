package com.itbuddy.codehouse.Service;

import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.DTO.Comment;
import com.itbuddy.codehouse.VO.CommentsVO;
import com.itbuddy.codehouse.config.RootConfig;
import com.itbuddy.codehouse.service.IBoardService;
import com.itbuddy.codehouse.service.ICommentService;

import java.util.List;

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
public class CommentServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceTest.class);

    @Autowired
    private ICommentService commentService;
    
    @Autowired
    private IBoardService boardService;
    
    @Test
    public void loginTest(){
    	List<Article> articles = boardService.getArticles( 0, 10,"art_create_time");

    	for(Article article : articles) {
    		LOGGER.info(article.toString());
    	}
        

    }
    @Test
    public void paginationTest(){
    	int commentTotalCnt = commentService.getCommentsCount(null,null);
    	Comment whereParam = new Comment();
    	
    	whereParam.setMem_id("skvudrms54");
    	CommentsVO commentsVO = commentService.pagination(commentTotalCnt, Integer.parseInt("2"), "cmt_create_time",whereParam,null);

    	for(Comment comment : commentsVO.getComments()) {
    		LOGGER.info(comment.toString());
    	}

        

    }
    
}