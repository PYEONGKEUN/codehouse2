package com.itbuddy.codehouse.service;

import com.itbuddy.codehouse.DTO.Member;
import javax.servlet.http.HttpSession;

/**
 * ITopNavService
 */
public interface IMemberService {
    public boolean login(Member member, HttpSession session);
    public boolean logout(HttpSession session);
    public boolean isLogin(HttpSession session);
    public boolean isExist(Member member);
}