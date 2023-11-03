package com.ssafy.ssafit.model.dto;

public class UserArticleComment {
	private int commentId;
	private int articleId;
	private int userSeq;
	private String createdAt;
	private String title;
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

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "UserArticleComment [commentId=" + commentId + ", articleId=" + articleId + ", userSeq=" + userSeq
				+ ", createdAt=" + createdAt + ", title=" + title + ", content=" + content + "]";
	}

}
