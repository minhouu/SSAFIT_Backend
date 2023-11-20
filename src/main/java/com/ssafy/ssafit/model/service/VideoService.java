package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {
	List<Video> getVideoList();

	Video getVideo(int id);
	
	void insertVideo(Video video);
	
	void updateVideo(Video video);
	
	void deleteVideo(int videoId);

}
