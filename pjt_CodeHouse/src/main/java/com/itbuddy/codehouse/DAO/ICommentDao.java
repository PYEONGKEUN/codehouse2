package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Comment;



public interface ICommentDAO {

    public List<Comment> select(Comment comment);

    
    public Comment insert(Comment comment);
    
    
    public Comment update(Comment comment);
}
