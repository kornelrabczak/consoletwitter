package com.thecookiezen.infrastructure.store;

import com.google.common.collect.ArrayListMultimap;
import com.thecookiezen.bussiness.boundary.TweetsStore;
import com.thecookiezen.bussiness.entity.Tweet;

import java.util.List;

public class InMemoryTweets implements TweetsStore {

    private final ArrayListMultimap<String, Tweet> tweets = ArrayListMultimap.create();

    private final ArrayListMultimap<String, String> followers = ArrayListMultimap.create();

    @Override
    public void storeTweet(Tweet tweet) {
        tweets.put(tweet.getUserName(), tweet);
    }

    @Override
    public List<Tweet> getTweetsByUserName(String userName) {
        return tweets.get(userName);
    }

}
