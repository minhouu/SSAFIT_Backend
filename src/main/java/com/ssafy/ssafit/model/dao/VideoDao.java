package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {
	public List<Video> selectAll();
	
	public Video selectOne(int videoId);
	
	public void insertOne(Video video);
	
	public void updateOne(Video video);
	
	public void deleteOne(int videoId);
}
