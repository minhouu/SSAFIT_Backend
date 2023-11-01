package com.ssafy.ssafit.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public int logIn(User user) {
		User dbUser = userDao.getUser(user);
		if (user.getId().equals(dbUser.getId()) && user.getPassword().equals(dbUser.getPassword())) {
			return 1;
		}
		return 0;
	}

}
