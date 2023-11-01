package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewService {
	List<Review> getReviewList(int videoId);
	
	Review getReview(int reviewId);

	void addReview(Review review);

	void updateReview(Review review);

	void deleteReview(int reviewId);

}
