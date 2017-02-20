package com.thecookiezen.infrastructure.store;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.thecookiezen.bussiness.boundary.TweetsStore;
import com.thecookiezen.bussiness.entity.Tweet;

import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTweets implements TweetsStore {

    private final ArrayListMultimap<String, Tweet> tweets = ArrayListMultimap.create();

    private final SetMultimap<String, String> following = HashMultimap.create();

    @Override
    public void storeTweet(Tweet tweet) {
        tweets.put(tweet.getUserName(), tweet);
    }

    @Override
    public List<Tweet> getTweetsByUserName(String userName) {
        return tweets.get(userName);
    }

    @Override
    public void follow(String userName, String follow) {
        following.put(userName, follow);
    }

    @Override
    public List<String> getFollowing(String userName) {
        return Lists.newArrayList(following.get(userName));
    }

    @Override
    public List<Tweet> getUserAndAllFollowingTweets(String userName) {
        final List<String> following = getFollowing(userName);
        following.add(userName);

        return following.stream()
                .flatMap(user -> tweets.get(user).stream())
                .collect(Collectors.toList());
    }
}
