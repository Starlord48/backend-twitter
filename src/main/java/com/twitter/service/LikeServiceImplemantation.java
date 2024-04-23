package com.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.exception.TweetException;
import com.twitter.exception.UserException;
import com.twitter.model.Like;
import com.twitter.model.Tweet;
import com.twitter.model.User;
import com.twitter.repository.LikeRepository;
import com.twitter.repository.TweetRepository;

@Service
public class LikeServiceImplemantation implements LikeService{
	
	@Autowired
	private LikeRepository likeRepository;
	@Autowired
	private TweetRepository tweetRepository;
	@Autowired
	private TweetService tweetService;

	@Override
	public Like likeTweet(Long tweetId, User user) throws UserException, TweetException {

		Like isLikeExist = likeRepository.isLikeExist(user.getId(), tweetId);
		
		if(isLikeExist != null) {
			likeRepository.deleteById(isLikeExist.getId());
			return isLikeExist;
		}
		
		Tweet tweet = tweetService.findById(tweetId);
		
		Like like = new Like();
		like.setTweet(tweet);
		like.setUser(user);
		
		Like savedLike = likeRepository.save(like);
		
		tweet.getLikes().add(savedLike);
		tweetRepository.save(tweet);
		
		return savedLike;
	}

	@Override
	public List<Like> getAllLikes(Long tweetId) throws TweetException {
		
		Tweet tweet = tweetService.findById(tweetId);
		
		List<Like> likes = likeRepository.findByTweetId(tweetId);
		return likes;
	}

}
