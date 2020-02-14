package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Comment;
import com.itbuddy.codehouse.util.TimeLib;
import com.itbuddy.codehouse.config.RootConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Art_fileTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
public class CommentTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentTest.class);

    @Autowired
    private ICommentDAO commentDAO;

    @Test
    public void selectTest(){
        Comment input = new Comment();
        input.setCmt_content("테스트");
        List<Comment> output = commentDAO.select(input);


        for(Comment comment : output){
            LOGGER.info(comment.toString());
        }
    }

    @Test
    public void updateTest(){
        Comment input = new Comment();
        input.setCmt_no(11);
        input.setCmt_modify_time(TimeLib.getCurrDateTime());

        commentDAO.update(input);
        List<Comment> output = commentDAO.select(input);


        for(Comment comment : output){
            LOGGER.info(comment.toString());
        }


        
    }

    @Test
    public void insertTest(){

        Comment input = new Comment();
        
        input.setArt_no(13);
        input.setCmt_title("테스트");
        input.setCmt_content("테스트"); 
        input.setCmt_create_time(TimeLib.getCurrDateTime());
        input.setCmt_modify_time(TimeLib.getCurrDateTime());
        input.setMem_id("skvudrms54");

        int num = commentDAO.insert(input);       
           
        LOGGER.info("성공한 ? : " + num +" - "+input.toString());


        
    }
    
}