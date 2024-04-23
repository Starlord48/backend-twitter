package com.twitter.service;

import java.util.List;

import com.twitter.exception.TweetException;
import com.twitter.exception.UserException;
import com.twitter.model.Like;
import com.twitter.model.User;

public interface LikeService {
	
	public Like likeTweet(Long tweetId, User user) throws UserException, TweetException;
	
	public List<Like> getAllLikes(Long tweetId) throws TweetException;

}
