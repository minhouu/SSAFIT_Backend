package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserArticleCommentDao;
import com.ssafy.ssafit.model.dto.UserArticleComment;

@Service
public class UserArticleCommentServiceImpl implements UserArticleCommentService {

	@Autowired
	private UserArticleCommentDao commentDao;

	@Override
	public List<UserArticleComment> getCommentList(int articleId) {
		return commentDao.selectAll(articleId);
	
	}

//	@Override
//	public UserArticleComment getComment(int commentId) {
//		return commentDao.selectOne(commentId);
//	}

	@Override
	public void addComment(UserArticleComment comment) {
		System.out.println(comment);
		commentDao.insertComment(comment);
	}

	@Override
	public void updateComment(UserArticleComment comment) {
		commentDao.updateComment(comment);
	}

	@Override
	public void deleteComment(int commentId) {
		commentDao.deleteComment(commentId);
	}

}
