package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Member;

public interface IMemberDAO {

    //회원 가져오기
    public List<Member> select(Member member);

    //회원가입
    public Member insert(Member member);
    
    //mybatis의 trim을 사용한 udpate 문
    public int update(Member member);



    
}
