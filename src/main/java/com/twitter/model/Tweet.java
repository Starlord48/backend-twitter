package com.twitter.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tweet")
public class Tweet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private User user;
	
	private String content;
	
	private String image;
	
	private String video;
	
	@OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
	private List<Like> likes = new ArrayList<>();
	
	@OneToMany
	private List<Tweet> replyTweets = new ArrayList<>();
	
	@ManyToMany
	private List<User> reTweetUser = new ArrayList<>();
	
	public Tweet(Long id, User user, String content, String image, String video, List<Like> likes, List<Tweet> replyTweets, List<User> reTweetUser,
			Tweet replyFor, boolean isReply, boolean isTweet,LocalDateTime createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.image = image;
		this.video = video;
		this.likes = likes;
		this.replyTweets = replyTweets;
		this.reTweetUser = reTweetUser;
		this.replyFor = replyFor;
		this.isReply = isReply;
		this.isTweet = isTweet;
		this.createdAt = createdAt;
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
	public Tweet() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Like> getLikes() {
		return likes;
	}
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	public List<Tweet> getReplyTweets() {
		return replyTweets;
	}
	public void setReplyTweets(List<Tweet> replyTweets) {
		this.replyTweets = replyTweets;
	}
	public List<User> getReTweetUser() {
		return reTweetUser;
	}
	public void setReTweetUser(List<User> reTweetUser) {
		this.reTweetUser = reTweetUser;
	}
	public Tweet getReplyFor() {
		return replyFor;
	}
	public void setReplyFor(Tweet replyFor) {
		this.replyFor = replyFor;
	}
	public boolean isReply() {
		return isReply;
	}
	public void setReply(boolean isReply) {
		this.isReply = isReply;
	}
	public boolean isTweet() {
		return isTweet;
	}
	public void setTweet(boolean isTweet) {
		this.isTweet = isTweet;
	}
	@ManyToOne
	private Tweet replyFor;
	
	private boolean isReply;
	private boolean isTweet;
	
	private LocalDateTime createdAt;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
