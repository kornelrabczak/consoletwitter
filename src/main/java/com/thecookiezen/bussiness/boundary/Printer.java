package com.thecookiezen.bussiness.boundary;

import com.thecookiezen.bussiness.entity.Tweet;

import java.util.List;

public interface Printer {

    void print(List<Tweet> tweet);

    void printMultipleUsersTweets(List<Tweet> tweets);
}
