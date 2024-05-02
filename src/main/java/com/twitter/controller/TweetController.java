package com.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.dto.TweetDto;
import com.twitter.dto.mapper.TweetDtoMapper;
import com.twitter.exception.TweetException;
import com.twitter.exception.UserException;
import com.twitter.model.Tweet;
import com.twitter.model.User;
import com.twitter.request.TweetReplyRequest;
import com.twitter.responce.ApiResponce;

import com.twitter.service.TweetService;
import com.twitter.service.UserService;

@RestController
@RequestMapping("api/tweets")
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<TweetDto> createTweet(@RequestBody Tweet req, 
			@RequestHeader("Authorization") String jwt ) throws UserException, TweetException {
		
		User user = userService.findUserProfileByJwt(jwt);
		
		Tweet tweet = tweetService.createTweet(req, user);
		
		TweetDto tweetDto = TweetDtoMapper.toTweetDto(tweet, user);
		
		
		return new ResponseEntity<>(tweetDto, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/reply")
	public ResponseEntity<TweetDto> replyTweet(@RequestBody TweetReplyRequest req, 
			@RequestHeader("Authorization") String jwt ) throws UserException, TweetException {
		
		User user = userService.findUserProfileByJwt(jwt);
		Tweet tweet = tweetService.createReply(req, user);		
		TweetDto tweetDto = TweetDtoMapper.toTweetDto(tweet, user);
		
		return new ResponseEntity<>(tweetDto, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{tweetId}/retweet")
	public ResponseEntity<TweetDto> reTweet(@PathVariable Long tweetId, 
			@RequestHeader("Authorization") String jwt ) throws UserException, TweetException {
		
		User user = userService.findUserProfileByJwt(jwt);		
		Tweet tweet = tweetService.retweet(tweetId, user);		
		TweetDto tweetDto = TweetDtoMapper.toTweetDto(tweet, user);
		
		return new ResponseEntity<TweetDto>(tweetDto, HttpStatus.OK);
		
	}
	
	@GetMapping("/{tweetId}")
	public ResponseEntity<TweetDto> fingTweetById(@PathVariable Long tweetId, 
			@RequestHeader("Authorization") String jwt ) throws UserException, TweetException {
		
		User user = userService.findUserProfileByJwt(jwt);		
		Tweet tweet = tweetService.findById(tweetId);		
		TweetDto tweetDto = TweetDtoMapper.toTweetDto(tweet, user);
		
		return new ResponseEntity<TweetDto>(tweetDto, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{tweetId}")
	public ResponseEntity<ApiResponce> deleteTweet(@PathVariable Long tweetId, 
			@RequestHeader("Authorization") String jwt ) throws UserException, TweetException {
		
		User user = userService.findUserProfileByJwt(jwt);		
		tweetService.deleteTweetById(tweetId, user.getId());
		
		ApiResponce res = new ApiResponce("Tweet deleted Successfully.", true);
		
		return new ResponseEntity<ApiResponce>(res, HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<TweetDto>> getAllTweets(@RequestHeader("Authorization") String jwt ) 
			throws UserException, TweetException {
		
		User user = userService.findUserProfileByJwt(jwt);		
		List<Tweet> tweet = tweetService.findAllTweet();		
		List<TweetDto> tweetDto = TweetDtoMapper.toTweetDtos(tweet, user);
		
		return new ResponseEntity<List<TweetDto>>(tweetDto, HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<TweetDto>> getUsersAllTweets(@PathVariable Long userId,
			@RequestHeader("Authorization") String jwt ) throws UserException, TweetException {
		
		User user = userService.findUserProfileByJwt(jwt);		
		List<Tweet> tweet = tweetService.getUserTweet(user);		
		List<TweetDto> tweetDto = TweetDtoMapper.toTweetDtos(tweet, user);
		
		return new ResponseEntity<List<TweetDto>>(tweetDto, HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{userId}/likes")
	public ResponseEntity<List<TweetDto>> findTweetByLikesContainsUser(@PathVariable Long userId,
			@RequestHeader("Authorization") String jwt ) throws UserException, TweetException {
		
		User user = userService.findUserProfileByJwt(jwt);		
		List<Tweet> tweet = tweetService.findByLikesContainsUser(user);		
		List<TweetDto> tweetDto = TweetDtoMapper.toTweetDtos(tweet, user);
		
		return new ResponseEntity<List<TweetDto>>(tweetDto, HttpStatus.OK);
		
	}
	
	

}
