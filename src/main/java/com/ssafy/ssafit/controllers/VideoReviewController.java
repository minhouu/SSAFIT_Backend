package com.ssafy.ssafit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.UserArticleComment;
import com.ssafy.ssafit.model.dto.VideoReview;
import com.ssafy.ssafit.model.service.VideoReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/review")
@Api(tags = "비디오 리뷰 컨트롤러")
@CrossOrigin("*")
public class VideoReviewController {

	@Autowired
	private VideoReviewService reviewService;

	@PostMapping
	@ApiOperation(value = "리뷰 추가", notes = "새로운 댓글을 추가합니다.\nParameter { video-id : videoId }")
	public ResponseEntity<String> addReview(@RequestBody VideoReview review) {
		reviewService.addReview(review);
		return new ResponseEntity<String>("Comment Added", HttpStatus.ACCEPTED);
	}

	@GetMapping
	@ApiOperation(value = "리뷰 전체 가져오기", notes = "댓글 전체를 가져옵니다.\\nParameter { video-id : videoId }")
	public ResponseEntity<List<VideoReview>> getReviews(@RequestParam("video-id") int videoId) {
		List<VideoReview> data = reviewService.getReviewList(videoId);
		return new ResponseEntity<List<VideoReview>>(data, HttpStatus.OK);
	}

	@GetMapping("/{reviewId}")
	@ApiOperation(value="리뷰 1개 가져오기", notes="리뷰 1개를 가져옵니다.")
	public VideoReview getReview(@PathVariable int reviewId) {
		return reviewService.getReview(reviewId);
	}

	@PutMapping
	@ApiOperation(value = "리뷰 업데이트", notes = "기존 리뷰를 업데이트합니다. request로 VideoReview의 온전한 객체를 보내줍니다.")
	public ResponseEntity<String> updateComment(@RequestBody VideoReview review) {
		review.setIsEdited(1);
		reviewService.updateReview(review);
		return new ResponseEntity<String>("Update Success", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{reviewId}")
	@ApiOperation(value = "리뷰 삭제", notes = "리뷰를 삭제합니다.")
	public ResponseEntity<String> deleteComment(@PathVariable int reviewId) {
		reviewService.deleteReview(reviewId);
		return new ResponseEntity<String>("Delete Success", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{reviewId}/view-cnt")
	@ApiOperation(value = "조회수 증가", notes = "본인 게시물이 아닌 경우 videoReview의 viewCnt++")
	public void viewCntUpdate(@PathVariable int reviewId) {
		reviewService.increaseViewCnt(reviewId);
	}
}
