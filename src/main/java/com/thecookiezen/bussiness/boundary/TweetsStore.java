package com.thecookiezen.bussiness.boundary;

import com.thecookiezen.bussiness.entity.Tweet;

import java.util.List;

public interface TweetsStore {

    void storeTweet(Tweet tweet);

    List<Tweet> getTweetsByUserName(String userName);

    void follow(String userName, String follow);

    List<String> getFollowing(String userName);

    List<Tweet> getUserAndAllFollowingTweets(String userName);
}
