package com.ssafy.ssafit.model.dto;

public class User {
	private int userSeq;
	private String id;
	private String password;
	private String nickname;
	private int userType;

	public User() {
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
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

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userSeq=" + userSeq + ", id=" + id + ", password=" + password + ", nickname=" + nickname
				+ ", userType=" + userType + "]";
	}

}
