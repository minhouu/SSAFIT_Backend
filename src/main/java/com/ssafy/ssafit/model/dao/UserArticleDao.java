package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.UserArticle;

public interface UserArticleDao {
	List<UserArticle> selectAll();

	UserArticle selectOne(int articleId);

	void insertArticle(UserArticle article);

	void updateArticle(UserArticle article);

	void deleteArticle(int articleId);
}
