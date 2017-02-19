package com.thecookiezen.bussiness.boundary;

import com.thecookiezen.bussiness.entity.Tweet;

import java.util.List;

public interface TweetsStore {

    void storeTweet(Tweet tweet);

    List<Tweet> getTweetsByUserName(String userName);

}
