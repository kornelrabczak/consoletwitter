package com.thecookiezen.infrastructure.handlers;

import com.thecookiezen.bussiness.boundary.RequestHandler;
import com.thecookiezen.bussiness.boundary.TweetsStore;
import com.thecookiezen.bussiness.control.Request;
import com.thecookiezen.bussiness.entity.Tweet;

public class CreateNewTweet implements RequestHandler {

    private final TweetsStore store;

    public CreateNewTweet(TweetsStore store) {
        this.store = store;
    }

    @Override
    public void execute(Request request) {
        System.out.println(request);
        store.storeTweet(new Tweet(request.getUserName(), request.getCommandParameter().get()));
    }
}
