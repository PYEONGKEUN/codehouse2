package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Comment;

import org.apache.ibatis.annotations.Param;

public interface ICommentDAO {

    public List<Comment> select(@Param("comment") Comment member, @Param("order")String order, @Param("asc")Boolean asc);

    
    public Comment insert(Comment member);
    
    
    public String update(Comment member);
}
