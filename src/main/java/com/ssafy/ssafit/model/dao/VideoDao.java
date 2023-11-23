package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {
	public List<Video> selectAll(int offset);
	
	List<Video> selectBySearch(int offset, String searchType, String searchKeyword);
	
	public Video selectOne(int videoId);
	
	public void insertOne(Video video);
	
	public void updateOne(Video video);
	
	public void deleteOne(int videoId);
	
	void increaseViewCnt(int videoId);
	
	int selectCount(String searchType, String searchKeyword);
}
