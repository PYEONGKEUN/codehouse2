package com.itbuddy.codehouse.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.itbuddy.codehouse.DTO.Member;

public interface IMyPageService {
	
	public Member getMyInfo(HttpSession session);
}
