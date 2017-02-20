package com.thecookiezen.infrastructure.handlers;

import com.thecookiezen.bussiness.boundary.RequestHandler;
import com.thecookiezen.bussiness.boundary.TweetsStore;
import com.thecookiezen.bussiness.control.Request;
import com.thecookiezen.bussiness.entity.Tweet;

import java.util.List;
import java.util.function.Consumer;

public class GetUserTweets implements RequestHandler {

    public static final String HANDLER_KEY = "";

    private final TweetsStore store;
    private final Consumer<List<Tweet>> printer;

    public GetUserTweets(TweetsStore store, Consumer<List<Tweet>> printer) {
        this.store = store;
        this.printer = printer;
    }

    @Override
    public void execute(Request query) {
        final List<Tweet> tweetsByUserName = store.getTweetsByUserName(query.getUserName());
        printer.accept(tweetsByUserName);
    }
}
