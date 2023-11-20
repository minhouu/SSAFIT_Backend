package com.ssafy.ssafit.model.dto;

public class VideoReview {
	private int reviewId;
	private int videoId;
	private int writerSeq;
	private String nickname;
	private String createdAt;
	private int viewCnt;
	private String title;
	private String content;
	private int isEdited;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public int getWriterSeq() {
		return writerSeq;
	}

	public void setWriterSeq(int writerSeq) {
		this.writerSeq = writerSeq;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIsEdited() {
		return isEdited;
	}

	public void setIsEdited(int isEdited) {
		this.isEdited = isEdited;
	}

	@Override
	public String toString() {
		return "VideoReview [reviewId=" + reviewId + ", videoId=" + videoId + ", writerSeq=" + writerSeq + ", nickname="
				+ nickname + ", createdAt=" + createdAt + ", content=" + content + ", isEdited=" + isEdited + "]";
	}
}
