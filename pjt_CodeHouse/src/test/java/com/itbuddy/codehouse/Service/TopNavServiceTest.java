package com.itbuddy.codehouse.Service;


import com.itbuddy.codehouse.service.IMemberService;
import com.itbuddy.codehouse.DTO.Member;
import com.itbuddy.codehouse.config.RootConfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
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
    private MockHttpSession session;
    protected MockHttpServletRequest request;
    
    @Before
    public void setUp() throws Exception{
        Member input = new Member();
        
        input.setMem_id("billip");
        input.setMem_pw("1234");
        session = new MockHttpSession();
        boolean login = TopNavService.login(input, session);
        
        request.setSession(session);
        
        if(login){
            LOGGER.info("로그인 완료");
        }else{
            LOGGER.info("로그인 실패");
        }


        

    }
    
    @After
    public void clear(){
        session.clearAttributes();
        session = null;
    }
    public void loginTest(){
    	

    	boolean islogin = TopNavService.isLogin(session);
    	
        if(islogin){
            LOGGER.info("로그인 중");
        }else{
            LOGGER.info("로그아웃중 ");
        }
    }
    
}