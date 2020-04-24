package com.itbuddy.codehouse.config.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.itbuddy.codehouse.DTO.Member;

public class CustomUser extends User{
	
	private static final long serialVersionUID = 1L;
	
	private Member member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);		
	}
	
	public CustomUser(Member member) {
		// 사용자가 정의한 Member 타입을 스프링t 시큐리티 UserDetails타입으로 변호나 한다.
		
		super(member.getMem_id(), member.getMem_pw(), member.getMem_typ_type()
				.stream().map(
						auth -> new SimpleGrantedAuthority(auth.getAuthority())).collect(Collectors.toList())
				);
	}
	
	public Member member(){
		return member;
	}

	
}
