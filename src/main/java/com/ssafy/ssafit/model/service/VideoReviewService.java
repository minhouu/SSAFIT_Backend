package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.UserArticleComment;
import com.ssafy.ssafit.model.dto.VideoReview;

public interface VideoReviewService {
	List<VideoReview> getReviewList(int videoId);
	
	VideoReview getReview(int reviewId);

	void addReview(VideoReview review);

	void updateReview(VideoReview review);

	void deleteReview(int reviewId);

	void increaseViewCnt(int reviewId);
}
