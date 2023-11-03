package com.ssafy.ssafit.model.dto;

public class UserArticle {
	private int articleId;
	private int writerSeq;
	private String title;
	private String content;
	private int viewCnt;
	private String createdAt;
	private int isEdited;

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

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getIsEdited() {
		return isEdited;
	}

	public void setIsEdited(int isEdited) {
		this.isEdited = isEdited;
	}

	@Override
	public String toString() {
		return "UserArticle [articleId=" + articleId + ", writerSeq=" + writerSeq + ", title=" + title + ", content="
				+ content + ", viewCnt=" + viewCnt + ", createdAt=" + createdAt + "]";
	}
}
