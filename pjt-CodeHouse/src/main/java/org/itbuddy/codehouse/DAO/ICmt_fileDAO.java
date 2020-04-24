package org.itbuddy.codehouse.DAO;

import java.util.List;

import org.itbuddy.codehouse.DTO.Cmt_file;

public interface ICmt_fileDAO {

    public List<Cmt_file> select(Cmt_file cmt_file);

    
    public int insert(Cmt_file cmt_file);
    
    
    public int update(Cmt_file cmt_file);
}
