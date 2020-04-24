package org.itbuddy.codehouse.service;

import javax.servlet.http.HttpSession;

import org.itbuddy.codehouse.DTO.Member;

/**
 * ITopNavService
 */
public interface IMemberService {
    public boolean login(Member member, HttpSession session);
    public boolean logout(HttpSession session);
    public boolean isLogin(HttpSession session);
    public boolean idIsExist(Member member);
    public boolean signUp(Member member);
}
