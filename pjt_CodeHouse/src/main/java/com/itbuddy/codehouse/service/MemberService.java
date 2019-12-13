package com.itbuddy.codehouse.service;

import java.util.List;

import com.itbuddy.codehouse.DAO.IMemberDAO;
import com.itbuddy.codehouse.DTO.Member;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LoginService
 */
@Service
public class MemberService implements IMemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	@Autowired
	private IMemberDAO memberDAO;

	@Override
	public boolean login(Member member, HttpSession session) {
		// TODO Auto-generated method stub

		boolean result = false;


		if(member.getMem_id() == null || member.getMem_pw() == null){

		}else{

			List<Member> output =  memberDAO.select(member);
			// 아이디와 비밀번호를 
			if(output.size() > 0){
				logger.info(member.getMem_id() +" logged in");
				session.setAttribute("memberInfo", output);
				session.setAttribute("status", "login");
				result = true;
			}else {
				logger.info(member.getMem_id() +"Password or Id is not correct");
			}

		}


		return result;
	}
	//세션에서 로그인 정보를 삭제
	@Override
	public boolean logout(HttpSession session) {
		// TODO Auto-generated method stub
		boolean result = false;
		//session.removeAttribute("memberInfo");
		try{
			session.invalidate();
			result = true;
		}catch (Exception e){
			logger.info(e.toString());
		}

		return result;
	}
	// session에서 로그인 정보를 확인
	@Override
	public boolean isLogin(HttpSession session) {
		// TODO Auto-generated method stub
		boolean result = false;
		// 세션에 멤버 정보가 있다면 로그인 상태
		// 아니라면 로그아웃 상태
		
		if(session.getAttribute("memberInfo")!=null) {
			return true;
		}else {
			return false;
		}


	}







}