package com.itbuddy.codehouse.DAO;

import java.util.List;


import com.itbuddy.codehouse.DTO.Member;
import com.itbuddy.codehouse.config.DBConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * MemberDaoTest
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {DBConfig.class})
public class MemberDaoTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberDaoTest.class);

    @Autowired
    private IMemberDAO MemberDAO;
    
    @Test
    public void selectTest(){
        Member input = new Member();
        input.setMem_id("billip");
        input.setMem_pw("1234");
        List<Member> members = MemberDAO.select(input);

        for(Member member : members){
            LOGGER.info(member.toString());
        }
        

    }

    @Test
    public void updateTest(){
        Member input = new Member();
        input.setMem_id("billip");
        input.setMem_nickname("빌리빌리퐁");
        MemberDAO.update(input);

        

    }
    
}