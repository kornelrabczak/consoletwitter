package com.thecookiezen.infrastructure.handlers;

import com.thecookiezen.bussiness.boundary.Printable;
import com.thecookiezen.bussiness.boundary.Printer;
import com.thecookiezen.bussiness.boundary.TweetsStore;

public class GetUserWall implements Printable {

    public static final String HANDLER_KEY = "wall";

    private final String userName;

    public GetUserWall(String userName) {
        this.userName = userName;
    }

    @Override
    public void execute(TweetsStore store, Printer printer) {
        printer.printMultipleUsersTweets(store.getUserAndAllFollowingTweets(userName));
    }
}
