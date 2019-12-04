package com.itbuddy.codehouse.service;

import java.util.List;

import com.itbuddy.codehouse.DAO.IMemberDAO;
import com.itbuddy.codehouse.DTO.Member;
import javax.servlet.http.HttpSession;

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
    public boolean login(Member member, HttpSession session) {
        // TODO Auto-generated method stub
        
        boolean result = false;
        Member input = new Member();


        if(member.getMem_id() == null || member.getMem_pw() == null){


        }else{
            input.setMem_id(member.getMem_id());
            input.setMem_pw(member.getMem_pw());
            
            List<Member> output =  memberDAO.select(input);
            // 아이디와 비밀번호를 
            if(output.size() > 0){
                logger.info(input.getMem_id() +" logged in");
                session.setAttribute("memberInfo", output);
                result = true;
            }

        }


        return result;
    }

    @Override
    public boolean logout(HttpSession session) {
        // TODO Auto-generated method stub
        boolean result = false;
        //session.removeAttribute("memberInfo");
        try{
            session.invalidate();
            result = true;
        }catch (Exception e){
            logger.info(e.toString());
        }
        
        return result;
    }

     




    
}