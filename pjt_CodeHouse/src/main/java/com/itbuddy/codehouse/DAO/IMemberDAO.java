package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Member;





public interface IMemberDAO {

   
   
    public List<Member> select(Member member);

    
    public Member insert(Member member);
    
    
    public void update(Member member);



    
}
