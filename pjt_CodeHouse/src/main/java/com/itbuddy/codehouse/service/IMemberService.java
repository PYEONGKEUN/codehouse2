package com.itbuddy.codehouse.service;

import com.itbuddy.codehouse.DTO.Member;
import javax.servlet.http.HttpSession;

/**
 * ITopNavService
 */
public interface ITopNavService {
    public boolean login(Member member, HttpSession session);
    public boolean logout(HttpSession session);
    
}