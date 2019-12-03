package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Member;

import org.apache.ibatis.annotations.Param;



public interface IMemberDAO {

   
   
    public List<Member> select(Member member, @Param("order")String order, @Param("asc")Boolean asc);

    
    public Member insert(Member member);
    
    
    public String update(Member member);



    
}
