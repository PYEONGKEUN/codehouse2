package com.itbuddy.codehouse.DAO;

import com.itbuddy.codehouse.config.DBConfig;

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
@ContextConfiguration(classes={DBConfig.class})
public class Art_fileTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(Art_fileTest.class);

    @Autowired
    private IArt_fileDAO art_fileDAO;

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