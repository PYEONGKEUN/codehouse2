package com.itbuddy.codehouse.service;

import org.springframework.lang.Nullable;

import com.itbuddy.codehouse.DTO.Article;
import com.itbuddy.codehouse.DTO.Comment;
import com.itbuddy.codehouse.VO.CommentsVO;

public interface ICommentService {

	public CommentsVO pagination(int totCommentsCnt, int curPage, String sortParam, @Nullable Comment whereParam, @Nullable Comment likeParam);
}
