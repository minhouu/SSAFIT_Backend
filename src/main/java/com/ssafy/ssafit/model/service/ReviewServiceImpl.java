package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ReviewDao;
import com.ssafy.ssafit.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Override
	public List<Review> getReviewList(int videoId) {
		return reviewDao.selectAll(videoId);
	}
	
	public Review getReview(int reviewId) {
		return reviewDao.selectOne(reviewId);
	}

	@Override
	public void addReview(Review review) {
		reviewDao.insertReview(review);
		return;
	}

	@Override
	public void updateReview(Review review) {
		reviewDao.updateReview(review);
	}
	
	@Override
	public void deleteReview(int reviewId) {
		reviewDao.deleteReview(reviewId);
	}

}
