package com.twitter.request;

import java.time.LocalDateTime;

public class TweetReplyRequest {
	
	private String content;
	private Long tweetId;
	private LocalDateTime createdAt;
	private String image;
	public TweetReplyRequest() {
		super();
	}
	public TweetReplyRequest(String content, Long tweetId, LocalDateTime createdAt, String image) {
		super();
		this.content = content;
		this.tweetId = tweetId;
		this.createdAt = createdAt;
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getTweetId() {
		return tweetId;
	}
	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
