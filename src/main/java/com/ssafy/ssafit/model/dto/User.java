package com.ssafy.ssafit.model.dto;

public class User {
	private int user_seq;
	private String id;
	private String password;
	private String nickname;

	public User() {
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "User [user_seq=" + user_seq + ", id=" + id + ", password=" + password + ", nickname=" + nickname + "]";
	}
}
