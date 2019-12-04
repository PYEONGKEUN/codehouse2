package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Cmt_file;
import com.itbuddy.codehouse.config.DBConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Cmt_fileTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DBConfig.class})
public class Cmt_fileTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(Cmt_fileTest.class);

    @Autowired
    private ICmt_fileDAO cmt_fileDAO;

    @Test
    public void selectTest(){
        Cmt_file input = new Cmt_file();
        input.setCmt_no(11);

        List<Cmt_file> output = cmt_fileDAO.select(input);

        for(Cmt_file Cmt_file : output){
            LOGGER.info(Cmt_file.toString());
        }


    }
    @Test
    public void updateTest(){


        Cmt_file input = new Cmt_file();
        input.setCmt_no(11);
        input.setCmt_fil_url("./noImage");

        List<Cmt_file> output = cmt_fileDAO.select(input);

        for(Cmt_file Cmt_file : output){
            LOGGER.info(Cmt_file.toString());
        }

    }
    @Test
    public void insertTest(){

        Cmt_file input = new Cmt_file();
        input.setCmt_no(11);
        input.setCmt_fil_url("./noImage");

        int num = cmt_fileDAO.insert(input);       
           
        LOGGER.info("성공한 갯수 : " + num +" - "+input.toString());



    }
    
}