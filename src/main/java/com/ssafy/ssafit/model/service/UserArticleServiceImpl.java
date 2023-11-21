package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserArticleDao;
import com.ssafy.ssafit.model.dto.UserArticle;

@Service
public class UserArticleServiceImpl implements UserArticleService {

	@Autowired
	private UserArticleDao articleDao;

	@Override
	public List<UserArticle> getArticleList(int offset) {
		return articleDao.selectAll(offset);
	}

	@Override
	public UserArticle getArticle(int articleId) {
		return articleDao.selectOne(articleId);
	}

	@Override
	public void increaseViewCnt(int articleId) {
		articleDao.increaseViewCnt(articleId);
	}

	@Override
	public void addArticle(UserArticle article) {
		articleDao.insertArticle(article);
	}

	@Override
	public void updateArticle(UserArticle article) {
		articleDao.updateArticle(article);
	}

	@Override
	public void deleteArticle(int articleId) {
		articleDao.deleteArticle(articleId);

	}

	@Override
	public int selectCount() {
		return articleDao.selectCount();
	}

}
