package com.twitter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.twitter.exception.TweetException;
import com.twitter.exception.UserException;
import com.twitter.model.Tweet;
import com.twitter.model.User;
import com.twitter.request.TweetReplyRequest;

public interface TweetService {
	
	public Tweet createTweet(Tweet req, User user) throws UserException;
	public List<Tweet> findAllTweet();
	public Tweet retweet(Long tweetId, User user) throws UserException, TweetException;
	public Tweet findById(Long tweetId) throws TweetException;
	
	public void deleteTweetById(Long tweetId, Long UserId) throws TweetException, UserException;
	
	public Tweet removeFromRetwit(Long tweetId, User user) throws TweetException, UserException;
	
	public Tweet createReply(TweetReplyRequest req, User user) throws TweetException;
	
	public List<Tweet> getUserTweet(User user);
	
	public List<Tweet> findByLikesContainsUser(User user);
	

}
