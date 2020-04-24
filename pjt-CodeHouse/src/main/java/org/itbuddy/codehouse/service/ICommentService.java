package org.itbuddy.codehouse.service;

import org.itbuddy.codehouse.DTO.Comment;
import org.itbuddy.codehouse.VO.CommentsVO;
import org.springframework.lang.Nullable;

public interface ICommentService {

	public CommentsVO pagination(int totCommentsCnt, int curPage, String sortParam, @Nullable Comment whereParam, @Nullable Comment likeParam);
	public int getCommentsCount(@Nullable Comment whereParam, @Nullable Comment likeParam);
}
