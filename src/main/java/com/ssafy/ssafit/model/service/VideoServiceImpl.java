package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.VideoDao;
import com.ssafy.ssafit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoDao videoDao;

	@Override
	public List<Video> getVideoList() {
		return videoDao.selectAll();

	}

	@Override
	public Video getVideo(int id) {
		return videoDao.selectOne(id);
	}

	@Override
	public void insertVideo(Video video) {
		videoDao.insertOne(video);
	}

	@Override
	public void updateVideo(Video video) {
		videoDao.updateOne(video);
	}

	@Override
	public void deleteVideo(int videoId) {
		videoDao.deleteOne(videoId);
	}

	@Override
	public void increaseViewCnt(int videoId) {
		videoDao.increaseViewCnt(videoId);
	}
	
	
}
