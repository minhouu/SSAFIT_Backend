package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewDao {
	List<Review> selectAll(int videoId);
	
	Review selectOne(int reviewId);

	void insertReview(Review review);
	
	void updateReview(Review review);
	
	void deleteReview(int reviewId);
}
