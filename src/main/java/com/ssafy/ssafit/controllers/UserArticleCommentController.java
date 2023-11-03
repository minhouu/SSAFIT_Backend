package com.ssafy.ssafit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
import com.ssafy.ssafit.model.service.UserArticleCommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/comment")
@Api(tags = "댓글 컨트롤러")
public class UserArticleCommentController {

	@Autowired
	private UserArticleCommentService commentService;

	@PostMapping
	@ApiOperation(value = "댓글 추가", notes = "새로운 댓글을 추가합니다.\nParameter { article-id : articleId }")
	public ResponseEntity<String> addComment(@RequestBody UserArticleComment comment) {
		commentService.addComment(comment);
		return new ResponseEntity<String>("Comment Added", HttpStatus.ACCEPTED);
	}

	@GetMapping
	@ApiOperation(value = "댓글 전체 가져오기", notes = "댓글 전체를 가져옵니다.\\nParameter { article-id : articleId }")
	public ResponseEntity<List<UserArticleComment>> getComments(@RequestParam("article-id") int articleId) {
		List<UserArticleComment> data = commentService.getCommentList(articleId);
		return new ResponseEntity<List<UserArticleComment>>(data, HttpStatus.OK);
	}

//	@GetMapping("/{commentId}")
//	@ApiOperation(value="댓글 1개 가져오기", notes="댓글 1개를 가져옵니다.")
//	public UserArticleComment getcomment(@PathVariable int commentId) {
//		return commentService.getcomment(commentId);
//	}

	@PutMapping("/{commentId}")
	@ApiOperation(value = "댓글 업데이트", notes = "기존 댓글을 업데이트합니다. request로 comment의 온전한 객체를 보내줍니다.")
	public ResponseEntity<String> updateComment(@RequestBody UserArticleComment comment) {
		comment.setIsEdited(1);
		commentService.updateComment(comment);
		return new ResponseEntity<String>("Update Success", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{commentId}")
	@ApiOperation(value = "댓글 삭제", notes = "댓글을 삭제합니다.")
	public ResponseEntity<String> deleteComment(@PathVariable int commentId) {
		commentService.deleteComment(commentId);
		return new ResponseEntity<String>("Delete Success", HttpStatus.ACCEPTED);
	}
}
