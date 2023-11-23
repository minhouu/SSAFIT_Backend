package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.UserArticle;

public interface UserArticleService {
	List<UserArticle> getArticleList(int offset);
	
	List<UserArticle> getArticleListBySearch(int offset, String searchType, String searchKeyword);
	
	UserArticle getArticle(int articleId);
	
	void increaseViewCnt(int articleId);

	void addArticle(UserArticle article);	

	void updateArticle(UserArticle article);

	void deleteArticle(int articleId);
	
	int selectCount(String searchType, String searchKeyword);
}
