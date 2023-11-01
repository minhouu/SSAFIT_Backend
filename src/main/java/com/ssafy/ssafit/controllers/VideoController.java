package com.ssafy.ssafit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/video")
@Api(tags="비디오 컨트롤러")
public class VideoController {
	
	@Autowired
	private VideoService videoService;

	@GetMapping
	@ApiOperation(value="전체 비디오 가져오기", notes="비디오 전체를 가져옵니다.")
	public List<Video> getVideos() {
		List<Video> data = videoService.getVideoList();
		return data;
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="비디오 가져오기", notes="비디오 1개를 가져옵니다.")
	public Video getVideo(@PathVariable int id) {
		System.out.println("가보자");
		return videoService.getVideo(id);
	}

	@PostMapping
	@ApiOperation(value="비디오 추가하기", notes="비디오를 1개 추가합니다.")
	public String addVideo(@RequestBody Video video) {
		return video.toString();
	}
}
