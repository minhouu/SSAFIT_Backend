package com.ssafy.ssafit.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.UserArticle;
import com.ssafy.ssafit.model.service.UserArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/board")
@Api(tags = "게시글 컨트롤러")
@CrossOrigin("*")
public class UserArticleController {

	@Autowired
	private UserArticleService articleService;

	@PostMapping
	@ApiOperation(value = "게시글 추가", notes = "새로운 게시글을 추가합니다.")
	public UserArticle addArticle(@RequestBody UserArticle article) {
		System.out.println(article);
		articleService.addArticle(article);
		return article;
	}

	@GetMapping
	@ApiOperation(value = "게시글 전체 가져오기", notes = "게시글 전체를 가져옵니다. \n\n * URL Parameter { article-id : articleId }\nRequest : none\nResponse : List<UserArticle>, UserArticle 중 content 제외한 데이터")
	public List<UserArticle> getArticles() {
		return articleService.getArticleList();
	}

	@GetMapping("/{articleId}")
	@ApiOperation(value = "게시글 1개 가져오기", notes = "게시글 1개의 상세 정보를 가져옵니다.")
	public UserArticle getArticle(@PathVariable int articleId) {
		return articleService.getArticle(articleId);
	}

	@PutMapping("/{articleId}")
	@ApiOperation(value = "게시글 업데이트", notes = "기존 게시글을 업데이트합니다. request로 article의 온전한 객체를 보내줍니다.")
	public ResponseEntity<String> updateArticle(@RequestBody UserArticle article) {
		article.setIsEdited(1);
		articleService.updateArticle(article);
		return new ResponseEntity<String>("Update Success", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{articleId}")
	@ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제합니다.")
	public ResponseEntity<String> deleteArticle(@PathVariable int articleId, HttpSession session) {
		
//		더 좋은 방법이 있을지도
//		
//		int reqWriterId = articleService.getArticle(articleId).getWriterSeq();
//		if (session.getAttribute("user_seq") == null) {
//			return new ResponseEntity<String>("Not logged in", HttpStatus.UNAUTHORIZED);
//		}
//		int dbWriterId = (int) session.getAttribute("user_seq");
//		System.out.println(reqWriterId);
//		System.out.println(dbWriterId);
//		if (reqWriterId == dbWriterId) {
//			articleService.deleteArticle(articleId);
//			return new ResponseEntity<String>("Delete Success", HttpStatus.ACCEPTED);
//		} else {
//			return new ResponseEntity<String>("Delete Failed : Only the writer can delete the article",
//					HttpStatus.UNAUTHORIZED);
//		}
		
		articleService.deleteArticle(articleId);
		return new ResponseEntity<String>("Delete Success", HttpStatus.ACCEPTED);
	}
}
