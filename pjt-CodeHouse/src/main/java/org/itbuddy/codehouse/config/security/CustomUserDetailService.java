package org.itbuddy.codehouse.config.security;

import java.util.List;

import org.itbuddy.codehouse.DAO.IMemberDAO;
import org.itbuddy.codehouse.DTO.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailService implements UserDetailsService{

	
	@Autowired
	IMemberDAO memberDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		Member inputMember = new Member();
		//username은 사용자 이름이 아닌 아이디를 의미
		inputMember.setMem_id(username);
		
		List<Member> outputMembers = memberDAO.select(inputMember);
		
		return outputMembers.isEmpty() ? null : new CustomUser(outputMembers.get(0));
		
		
		
	}
	
	

}
