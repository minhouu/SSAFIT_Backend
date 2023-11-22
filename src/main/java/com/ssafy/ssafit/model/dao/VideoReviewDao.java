package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.UserArticleComment;
import com.ssafy.ssafit.model.dto.VideoReview;

public interface VideoReviewDao {
	List<VideoReview> selectAll(int videoId);
	
	VideoReview selectOne(int reviewId);

	void insertOne(VideoReview review);
	
	void updateOne(VideoReview review);
	
	void deleteOne(int reviewId);
	
	void increaseViewCnt(int reviewId);
}
