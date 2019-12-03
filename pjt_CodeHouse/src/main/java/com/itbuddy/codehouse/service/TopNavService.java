package com.itbuddy.codehouse.service;

import com.itbuddy.codehouse.DAO.IMemberDAO;
import com.itbuddy.codehouse.DTO.Member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LoginService
 */
@Service
public class TopNavService implements ITopNavService{
    private static final Logger logger = LoggerFactory.getLogger(TopNavService.class);

     @Autowired
     private IMemberDAO memberDAO;

    @Override
    public boolean login(Member member) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean logout() {
        // TODO Auto-generated method stub
        return false;
    }

     




    
}