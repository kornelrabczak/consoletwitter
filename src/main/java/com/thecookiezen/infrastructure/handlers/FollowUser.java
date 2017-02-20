package com.thecookiezen.infrastructure.handlers;

import com.thecookiezen.bussiness.boundary.RequestHandler;
import com.thecookiezen.bussiness.boundary.TweetsStore;
import com.thecookiezen.bussiness.control.Request;

public class FollowUser implements RequestHandler {

    public static final String HANDLER_KEY = "follows";

    private final TweetsStore store;

    public FollowUser(TweetsStore store) {
        this.store = store;
    }

    @Override
    public void execute(Request request) {
        store.follow(request.getUserName(), request.getCommandParameter().get());
    }
}
