package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {
	public List<Video> selectAll();
	
	public Video selectOne(int id);
}
