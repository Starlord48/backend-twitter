package com.twitter.dto;

public class LikeDto {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public TweetDto getTweet() {
		return tweet;
	}
	public void setTweet(TweetDto tweet) {
		this.tweet = tweet;
	}
	private Long id;
	private UserDto user;
	private TweetDto tweet;

}
