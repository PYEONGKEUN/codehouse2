package com.itbuddy.codehouse.DAO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Art_file;

public interface IArt_fileDAO {
	public List<Art_file> select(Art_file art_file);

    
    public int insert(Art_file art_file);
    
    
    public int update(Art_file art_file);
	
}
