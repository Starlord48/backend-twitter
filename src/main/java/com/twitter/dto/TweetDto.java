package com.twitter.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TweetDto {
	
	private Long id;
	private String content;
	private String image;
	private String video;
	private UserDto user;
	private LocalDateTime createdAt;
	private int totalLikes;
	private int totalReplies;
	private int totalReTweets;
	private boolean isLiked;
	private boolean isReTweet;
	private List<Long> reTweetUsersId;
	private List<TweetDto> replyTweets;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public int getTotalLikes() {
		return totalLikes;
	}
	public void setTotalLikes(int totalLikes) {
		this.totalLikes = totalLikes;
	}
	public int getTotalReplies() {
		return totalReplies;
	}
	public void setTotalReplies(int totalReplies) {
		this.totalReplies = totalReplies;
	}
	public int getTotalReTweets() {
		return totalReTweets;
	}
	public void setTotalReTweets(int totalReTweets) {
		this.totalReTweets = totalReTweets;
	}
	public boolean isLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	public boolean isReTweet() {
		return isReTweet;
	}
	public void setReTweet(boolean isReTweet) {
		this.isReTweet = isReTweet;
	}
	public List<Long> getReTweetUsersId() {
		return reTweetUsersId;
	}
	public void setReTweetUsersId(List<Long> reTweetUsersId) {
		this.reTweetUsersId = reTweetUsersId;
	}
	public List<TweetDto> getReplyTweets() {
		return replyTweets;
	}
	public void setReplyTweets(List<TweetDto> replyTweets) {
		this.replyTweets = replyTweets;
	}

}
