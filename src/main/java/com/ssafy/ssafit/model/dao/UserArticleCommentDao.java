package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.UserArticleComment;

public interface UserArticleCommentDao {
	List<UserArticleComment> selectAll(int articleId);
	
//	UserArticleComment selectOne(int commentId);

	void insertComment(UserArticleComment comment);
	
	void updateComment(UserArticleComment comment);
	
	void deleteComment(int commentId);
}
