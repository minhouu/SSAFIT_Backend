package com.ssafy.ssafit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ssafy.ssafit.model.dto.UserArticle;
import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/video")
@Api(tags = "비디오 컨트롤러")
@CrossOrigin("*")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@PostMapping
	@ApiOperation(value = "비디오 추가하기", notes = "비디오를 1개 추가합니다.")
	public void addVideo(@RequestBody Video video) {
		videoService.insertVideo(video);
	}

	@GetMapping
	@ApiOperation(value = "전체 비디오 가져오기", notes = "비디오 전체를 가져옵니다.")
	public List<Video> getVideos(@RequestParam("page") int pageNum) {
		int offset = (pageNum - 1) * 6;
		return videoService.getVideoList(offset);
	}

	@GetMapping("search")
	@ApiOperation(value = "게시물 검색")
	public List<Video> getArticleListBySearch(@RequestParam("page") int pageNum,
			@RequestParam("type") String searchType, @RequestParam("keyword") String searchKeyword) {
		int offset = (pageNum - 1) * 10;
		return videoService.getVideoListBySearch(offset, searchType, searchKeyword);
	}

	
	@GetMapping("/{id}")
	@ApiOperation(value = "비디오 가져오기", notes = "비디오 1개를 가져옵니다.")
	public Video getVideo(@PathVariable int id) {
		return videoService.getVideo(id);
	}

	@GetMapping("/count")
	@ApiOperation(value = "비디오 개수 가져오기")
	public int getCount(@RequestParam(required = false, name = "type") String searchType,
			@RequestParam(required = false, name = "keyword") String searchKeyword) {
		return videoService.selectCount(searchType, searchKeyword);
	}

	@GetMapping("/{videoId}/view-cnt")
	@ApiOperation(value = "조회수 증가", notes = "본인 게시물이 아닌 경우 video의 viewCnt++")
	public void viewCntUpdate(@PathVariable int videoId) {
		videoService.increaseViewCnt(videoId);
	}

	@PutMapping
	@ApiOperation(value = "비디오 업데이트", notes = "비디오 정보를 업데이트합니다.")
	public void updateVideo(@RequestBody Video video) {
		System.out.println(video);
		video.setIsEdited(1);
		videoService.updateVideo(video);
	}

	@DeleteMapping("/{videoId}")
	@ApiOperation(value = "비디오 삭제", notes = "비디오 정보를 삭제합니다.")
	public void deleteVideo(@PathVariable int videoId) {
		videoService.deleteVideo(videoId);
	}

}
