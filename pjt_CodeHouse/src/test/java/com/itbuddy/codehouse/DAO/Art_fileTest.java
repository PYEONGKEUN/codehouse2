package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Art_file;
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
public class Art_fileTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(Art_fileTest.class);

    @Autowired
    private IArt_fileDAO art_fileDAO;

    @Test
    public void selectTest(){
        Art_file input = new Art_file();
        input.setArt_no(11);

        List<Art_file> output = art_fileDAO.select(input);

        for(Art_file art_file : output){
            LOGGER.info(art_file.toString());
        }


    }
    @Test
    public void updateTest(){


        Art_file input = new Art_file();
        input.setArt_no(11);
        input.setArt_fil_url("./noImage");

        List<Art_file> output = art_fileDAO.select(input);

        for(Art_file art_file : output){
            LOGGER.info(art_file.toString());
        }

    }
    @Test
    public void insertTest(){

        Art_file input = new Art_file();
        input.setArt_no(11);
        input.setArt_fil_url("./noImage");

        int num = art_fileDAO.insert(input);       
           
        LOGGER.info("성공한 갯수 : " + num +" - "+input.toString());

        List<Art_file> output = art_fileDAO.select(input);

        for(Art_file art_file : output){
            LOGGER.info(art_file.toString());
        }

    }
    
}