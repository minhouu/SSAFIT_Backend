package com.ssafy.ssafit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/review")
@Api(tags="리뷰 컨트롤러")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping
	@ApiOperation(value="리뷰 추가", notes="새로운 리뷰를 추가합니다.")
	public Review addReview(@RequestBody Review review) {
		reviewService.addReview(review);
		return review;
	}

	@GetMapping("/{videoId}")
	@ApiOperation(value="리뷰 전체 가져오기", notes="리뷰 전체를 가져옵니다.")
	public List<Review> getReviews(@PathVariable int videoId) {
		return reviewService.getReviewList(videoId);
	}

	@GetMapping("/detail/{reviewId}")
	@ApiOperation(value="리뷰 1개 가져오기", notes="리뷰 1개를 가져옵니다.")
	public Review getReview(@PathVariable int reviewId) {
		return reviewService.getReview(reviewId);
	}

	@PutMapping("/detail/{reviewId}")
	@ApiOperation(value="리뷰 업데이트", notes="기존 리뷰를 업데이트합니다.")
	public void updateReview(@RequestBody Review review) {
		reviewService.updateReview(review);
	}

	@DeleteMapping("/delete/{reviewId}")
	@ApiOperation(value="리뷰 삭제", notes="리뷰를 삭제합니다.")
	public void deleteReview(@PathVariable int reviewId) {
		reviewService.deleteReview(reviewId);
	}
}
