package com.ssafy.ssafit.model.dto;

public class Video {
	private String id;
	private String title;
	private String part;
	private String channelName;
	private String url;
	private String created_at;
	private int view_cnt;

	public Video() {
	}
	
	public Video(String id, String title, String part, String channelName, String url) {
		super();
		this.id = id;
		this.title = title;
		this.part = part;
		this.channelName = channelName;
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", part=" + part + ", channelName=" + channelName + ", url="
				+ url + ", created_at=" + created_at + ", view_cnt=" + view_cnt + "]";
	}
}
