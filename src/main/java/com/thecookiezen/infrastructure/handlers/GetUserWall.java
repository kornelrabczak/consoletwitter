package com.thecookiezen.infrastructure.handlers;

import com.thecookiezen.bussiness.boundary.RequestHandler;
import com.thecookiezen.bussiness.boundary.TweetsStore;
import com.thecookiezen.bussiness.control.Request;
import com.thecookiezen.bussiness.entity.Tweet;

import java.util.List;
import java.util.function.Consumer;

public class GetUserWall implements RequestHandler {

    public static final String HANDLER_KEY = "wall";

    private final TweetsStore store;
    private final Consumer<List<Tweet>> printer;

    public GetUserWall(TweetsStore store, Consumer<List<Tweet>> printer) {
        this.store = store;
        this.printer = printer;
    }

    @Override
    public void execute(Request request) {
        printer.accept(store.getUserAndAllFollowingTweets(request.getUserName()));
    }
}
