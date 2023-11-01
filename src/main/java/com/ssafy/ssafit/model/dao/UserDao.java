package com.ssafy.ssafit.model.dao;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao {

	void insertUser(User user);
	
	User getUser(User user);
	
}
