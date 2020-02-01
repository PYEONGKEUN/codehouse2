package com.itbuddy.codehouse.service;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.itbuddy.codehouse.DTO.Member;

@Service
public class MyPageService implements IMyPageService{
	
	@Override
	public Member getMyInfo(HttpSession session) {
		
		Member member = null;
		
		if(session.getAttribute("memberInfo") != null)
			member = (Member)session.getAttribute("memberInfo");
		
		return member;
	}
}
