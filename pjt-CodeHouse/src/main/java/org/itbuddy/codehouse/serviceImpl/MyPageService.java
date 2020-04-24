package org.itbuddy.codehouse.serviceImpl;



import javax.servlet.http.HttpSession;

import org.itbuddy.codehouse.DTO.Member;
import org.itbuddy.codehouse.service.IMyPageService;
import org.springframework.stereotype.Service;

@Service
public class MyPageService implements IMyPageService{
	//
	@Override
	public Member getMyInfo(HttpSession session) {
		
		Member member = null;
		
		if(session.getAttribute("memberInfo") != null)
			member = (Member)session.getAttribute("memberInfo");
		
		return member;
	}
}
