package com.itbuddy.codehouse.Service;

import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.VO.BoardVO;
import com.itbuddy.codehouse.service.IBoardService;
import com.itbuddy.codehouse.service.ICommentService;
import com.itbuddy.codehouse.util.CheckString;
import com.itbuddy.codehouse.config.RootConfig;

import java.util.Scanner;

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
    
    @Test
    public void fiboTest(){
    	for(int i=1;i<=20;i++) {
    		LOGGER.info((i)+" : "+fibo(i)+"");
    	}
    	for(int i=1;i<=20;i++) {
    		LOGGER.info((i)+" : "+fiboFaster(i)+"");
    	}
    	LOGGER.info("10 : "+fiboFaster(10)+"");

        
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        
        // n <= 90
    	
    	long a = 0, b=1, c=1;
    	

    	long result = 0;
        if(input == 0){
            result = 0;
        }else if(input == 1){
            result = 1;
        }else{
        	for(int i =2 ;i < input; i++) {
        		a = b;
        		b = c;
        		c = a+b;
        	}
        	result = c;
        }
    	
    	 
        
        System.out.println(result);
        
    	

    }
    
    public int fibo(int num){
        if(num == 0){
            return 0;
        }else if(num == 1){
            return 1;
        }else{
            return fibo(num-1) + fibo(num-2);
        }
    }
    public int fiboFaster(int num){
    	// n <= 90
    	
    	int[] arrFibo = new int[90];
    	arrFibo[0] = 0;
    	arrFibo[1] = 1;
    	
    	for(int i = 2;i<arrFibo.length;i++) {
    		arrFibo[i] = arrFibo[i-1] + arrFibo[i-2];
    	}
    	
    	
    	
        if(num == 0){
            return 0;
        }else if(num == 1){
            return 1;
        }else{
        	return arrFibo[num];
        }
    	
    	
        
    }
    
    
}