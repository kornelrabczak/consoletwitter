package com.thecookiezen.infrastructure;

import com.google.common.collect.ImmutableMap;
import com.thecookiezen.bussiness.boundary.Printer;
import com.thecookiezen.bussiness.boundary.Storage;
import com.thecookiezen.bussiness.control.Request;
import com.thecookiezen.infrastructure.command.CreateNewTweet;
import com.thecookiezen.infrastructure.command.FollowUser;
import com.thecookiezen.infrastructure.command.GetUserTweets;
import com.thecookiezen.infrastructure.command.GetUserWall;

import java.util.Map;
import java.util.function.Consumer;

public class CommandHandler {

    private final Map<String, Consumer<Request>> executables;

    private final static Consumer<Request> NO_OP = req -> {};

    public CommandHandler(Storage store, Printer printer) {
        executables = ImmutableMap.<String, Consumer<Request>>builder()
                .put(GetUserTweets.HANDLER_KEY, request -> new GetUserTweets(request.getUserName()).execute(store, printer))
                .put(GetUserWall.HANDLER_KEY, request -> new GetUserWall(request.getUserName()).execute(store, printer))
                .put(CreateNewTweet.HANDLER_KEY, request -> new CreateNewTweet(request.getUserName(), request.getAdditionalParameter()).execute(store))
                .put(FollowUser.HANDLER_KEY, request -> new FollowUser(request.getUserName(), request.getAdditionalParameter()).execute(store))
                .build();
    }

    public void handle(Request request) {
        executables.getOrDefault(request.getCommand(), NO_OP).accept(request);
    }
}
