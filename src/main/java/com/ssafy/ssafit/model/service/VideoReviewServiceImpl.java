package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.VideoReviewDao;
import com.ssafy.ssafit.model.dto.UserArticleComment;
import com.ssafy.ssafit.model.dto.VideoReview;

@Service
public class VideoReviewServiceImpl implements VideoReviewService {
	@Autowired
	private VideoReviewDao reviewDao;

	@Override
	public List<VideoReview> getReviewList(int videoId) {
		return reviewDao.selectAll(videoId);
	}

	@Override
	public VideoReview getReview(int reviewId) {
		return reviewDao.selectOne(reviewId);
	}

	@Override
	public void addReview(VideoReview review) {
		reviewDao.insertOne(review);
	}

	@Override
	public void updateReview(VideoReview review) {
		reviewDao.updateOne(review);
	}

	@Override
	public void deleteReview(int reviewId) {
		reviewDao.deleteOne(reviewId);
	}

	@Override
	public void increaseViewCnt(int reviewId) {
		reviewDao.increaseViewCnt(reviewId);
	}

}
