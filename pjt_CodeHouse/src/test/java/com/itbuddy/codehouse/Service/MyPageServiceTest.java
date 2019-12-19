package com.itbuddy.codehouse.Service;

import java.util.List;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itbuddy.codehouse.DAO.IMemberDAO;
import com.itbuddy.codehouse.DTO.Member;
import com.itbuddy.codehouse.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class MyPageServiceTest{
	private static final Logger LOGGER = LoggerFactory.getLogger(MyPageServiceTest.class);
	protected MockHttpSession session;
	protected MockHttpServletRequest request;
	Member member;
	@Before
	public void setUp() throws Exception{
		member = new Member();
		member.setMem_id("skvudrms54");
		member.setMem_img("");
		member.setMem_nickname("빌리풍");
		member.setMem_email("");
	    
	    session = new MockHttpSession();
	    session.setAttribute("memberInfo", member);
	        
	    request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}
	
	@After
	public void clear() {
		session.clearAttributes();
		session = null;
	}
	
	
	@Test
	public void getMyInfo() {
		
		if(session.getAttribute("memberInfo") != null) {
			member = (Member)session.getAttribute("memberInfo");
		}else {
			member = new Member();
		}
			
		
		LOGGER.info(member.toString());
	}
}
