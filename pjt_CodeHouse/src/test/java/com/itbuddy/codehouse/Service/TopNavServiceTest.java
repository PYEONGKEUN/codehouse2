package com.itbuddy.codehouse.Service;


import com.itbuddy.codehouse.service.IMemberService;
import com.itbuddy.codehouse.config.RootConfig;

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
public class TopNavServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopNavServiceTest.class);

    @Autowired
    private IMemberService TopNavService;

    
    @Test
    public void loginTest(){
//        Member input = new Member();
//        HttpSession session = new HttpSession();
//        input.setMem_id("billip");
//        input.setMem_pw("1234");
//        boolean login = TopNavService.login(input, session);
//
//        if(login){
//            LOGGER.info("로그인 완료");
//        }else{
//            LOGGER.info("로그인 실패");
//        }


        

    }
    
}