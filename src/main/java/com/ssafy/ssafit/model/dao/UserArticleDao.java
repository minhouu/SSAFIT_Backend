package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.UserArticle;

public interface UserArticleDao {
	List<UserArticle> selectAll(int offset);
	
	List<UserArticle> selectBySearch(int offset, String searchType, String searchKeyword);
	
	UserArticle selectOne(int articleId);
	
	void increaseViewCnt(int articleId);

	void insertArticle(UserArticle article);

	void updateArticle(UserArticle article);

	void deleteArticle(int articleId);
	
	int selectCount(String searchType, String searchKeyword);
}
