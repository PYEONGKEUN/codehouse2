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

     public boolean login(Member input){

        boolean bResult = false;
        Member tempMember = new Member();

        tempMember.setMem_id(input.getMem_id());
        tempMember.setMem_pw(input.getMem_pw());

        if(memberDAO.select(tempMember,"mem_id",true).size() == 1){
            bResult = true;
            
        }
        logger.info("bResult : "+ bResult);
        return bResult;
     }

    @Override
    public boolean logout() {
        // TODO Auto-generated method stub
        return false;
    }

    
}