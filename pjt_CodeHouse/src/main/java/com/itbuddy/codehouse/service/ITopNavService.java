package com.itbuddy.codehouse.service;

import com.itbuddy.codehouse.DTO.Member;

/**
 * ITopNavService
 */
public interface ITopNavService {
    public boolean login(Member member);
    public boolean logout();
    
}