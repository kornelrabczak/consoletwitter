package com.thecookiezen.bussiness.boundary;

import com.google.common.collect.ImmutableMap;
import com.thecookiezen.bussiness.control.Request;
import com.thecookiezen.infrastructure.handlers.CreateNewTweet;
import com.thecookiezen.infrastructure.handlers.FollowUser;
import com.thecookiezen.infrastructure.handlers.GetUserTweets;
import com.thecookiezen.infrastructure.handlers.GetUserWall;

import java.util.Map;
import java.util.function.Consumer;

public class CommandHandler {

    private final Map<String, Consumer<Request>> executables;

    public CommandHandler(TweetsStore store, Printer printer) {
        executables = ImmutableMap.<String, Consumer<Request>>builder()
                .put(GetUserTweets.HANDLER_KEY, request -> new GetUserTweets(request.getUserName()).execute(store, printer))
                .put(GetUserWall.HANDLER_KEY, request -> new GetUserWall(request.getUserName()).execute(store, printer))
                .put(CreateNewTweet.HANDLER_KEY, request -> new CreateNewTweet(request.getUserName(), request.getCommandParameter()).execute(store))
                .put(FollowUser.HANDLER_KEY, request -> new FollowUser(request.getUserName(), request.getCommandParameter()).execute(store))
                .build();
    }

    public void handle(Request request) {
        executables.get(request.getCommandKey()).accept(request);
    }
}
