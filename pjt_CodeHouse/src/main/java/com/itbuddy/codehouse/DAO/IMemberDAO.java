package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Member;





public interface IMemberDAO {

   
   
    public List<Member> select(Member member);

    
    public int insert(Member member);
    
    
    public int update(Member member);



    
}
