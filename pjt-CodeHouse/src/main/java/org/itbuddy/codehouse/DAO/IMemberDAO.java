package org.itbuddy.codehouse.DAO;

import java.util.List;

import org.itbuddy.codehouse.DTO.Member;





public interface IMemberDAO {

   
   
    public List<Member> select(Member member);

    
    public int insert(Member member);
    
    
    public int update(Member member);



    
}
