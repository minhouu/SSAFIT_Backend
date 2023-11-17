package com.ssafy.ssafit.model.dto;

public class UserArticleComment {
	private int commentId;
	private int articleId;
	private int writerSeq;
	private String nickname;
	private String createdAt;
	private String content;
	private int isEdited;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
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
}
