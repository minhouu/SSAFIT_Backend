package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {

	void addUser(User user);
	
	int logIn(User user);
	
	User getUser(String userId);

}
