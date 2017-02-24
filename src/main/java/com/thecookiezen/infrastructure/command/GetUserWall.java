package com.thecookiezen.infrastructure.command;

import com.thecookiezen.bussiness.boundary.Printable;
import com.thecookiezen.bussiness.boundary.Printer;
import com.thecookiezen.bussiness.boundary.Storage;

public class GetUserWall implements Printable {

    public static final String HANDLER_KEY = "wall";

    private final String userName;

    public GetUserWall(String userName) {
        this.userName = userName;
    }

    @Override
    public void execute(Storage store, Printer printer) {
        printer.printMultipleUsersTweets(store.getUserAndAllFollowingTweets(userName));
    }
}
