package com.itbuddy.codehouse.service;

import com.itbuddy.codehouse.DAO.IMemberDAO;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * LoginService
 */
public class LoginService {
    @Autowired
    private IMemberDAO memberDAO;
    
}