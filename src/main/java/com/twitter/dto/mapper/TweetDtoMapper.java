package com.twitter.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.twitter.dto.TweetDto;
import com.twitter.dto.UserDto;
import com.twitter.dto.util.TweetUtil;
import com.twitter.model.Tweet;
import com.twitter.model.User;

public class TweetDtoMapper {

	public static TweetDto toTweetDto(Tweet tweet, User reqUser) {
		
		UserDto user = UserDtoMapper.toUserDto(tweet.getUser());
		
		boolean isLiked = TweetUtil.isLikedByReqUser(reqUser, tweet);
		
		boolean isReTweeted = TweetUtil.isRetweetedByReqUser(reqUser, tweet);
		
		List<Long> reTweetUserId = new ArrayList<>();
		
		for(User user1 : tweet.getReTweetUser()) {
			reTweetUserId.add(user1.getId());
		}
		
		TweetDto tweetDto = new TweetDto();
		tweetDto.setId(tweet.getId());
		tweetDto.setContent(tweet.getContent());
		tweetDto.setCreatedAt(tweet.getCreatedAt());
		tweetDto.setImage(tweet.getImage());
		tweetDto.setTotalLikes(tweet.getLikes().size());
		tweetDto.setTotalReplies(tweet.getReplyTweets().size());
		tweetDto.setTotalReTweets(tweet.getReTweetUser().size());
		tweetDto.setUser(user);
		tweetDto.setLiked(isLiked);
		tweetDto.setReTweet(isReTweeted);
		tweetDto.setReTweetUsersId(reTweetUserId);
		tweetDto.setReplyTweets(toTweetDtos(tweet.getReplyTweets(), reqUser));
		tweetDto.setVideo(tweet.getVideo());
		
		return tweetDto;
		
	}
	
	public static List<TweetDto> toTweetDtos(List<Tweet> tweets, User reqUser) {
		List<TweetDto> tweetDtos = new  ArrayList<>();
		
		for(Tweet tweet : tweets) {
			TweetDto tweetDto  = toReplyTweetDto(tweet, reqUser);
			tweetDtos.add(tweetDto);
		}
		return tweetDtos;
	}

	private static TweetDto toReplyTweetDto(Tweet tweet, User reqUser) {
UserDto user = UserDtoMapper.toUserDto(tweet.getUser());
		
		boolean isLiked = TweetUtil.isLikedByReqUser(reqUser, tweet);
		
		boolean isReTweeted = TweetUtil.isRetweetedByReqUser(reqUser, tweet);
		
		List<Long> reTweetUserId = new ArrayList<>();
		
		for(User user1 : tweet.getReTweetUser()) {
			reTweetUserId.add(user1.getId());
		}
		
		TweetDto tweetDto = new TweetDto();
		tweetDto.setId(tweet.getId());
		tweetDto.setContent(tweet.getContent());
		tweetDto.setCreatedAt(tweet.getCreatedAt());
		tweetDto.setImage(tweet.getImage());
		tweetDto.setTotalLikes(tweet.getLikes().size());
		tweetDto.setTotalReplies(tweet.getReplyTweets().size());
		tweetDto.setTotalReTweets(tweet.getReTweetUser().size());
		tweetDto.setUser(user);
		tweetDto.setLiked(isLiked);
		tweetDto.setReTweet(isReTweeted);
		tweetDto.setReTweetUsersId(reTweetUserId);
		tweetDto.setVideo(tweet.getVideo());
		
		return tweetDto;
	}
	
}