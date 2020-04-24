package org.itbuddy.codehouse.service;


import javax.servlet.http.HttpSession;

import org.itbuddy.codehouse.DTO.Member;

public interface IMyPageService {
	
	public Member getMyInfo(HttpSession session);
}
