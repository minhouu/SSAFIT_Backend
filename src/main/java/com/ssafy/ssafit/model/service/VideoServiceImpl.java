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
		System.out.println("비디오 다 가져와");
		return videoDao.selectAll();
	}

	@Override
	public Video getVideo(int id) {
		return videoDao.selectOne(id);
	}

	@Override
	public void addVideo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateVideo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVideo() {
		// TODO Auto-generated method stub

	}

}
