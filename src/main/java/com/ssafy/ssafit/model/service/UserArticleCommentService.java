package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.UserArticleComment;

public interface UserArticleCommentService {
	List<UserArticleComment> getCommentList(int articleId);
	
//	UserArticleComment getComment(int commentId);

	void addComment(UserArticleComment comment);

	void updateComment(UserArticleComment comment);

	void deleteComment(int commentId);

}
