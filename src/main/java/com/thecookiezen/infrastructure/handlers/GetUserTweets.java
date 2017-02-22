package com.thecookiezen.infrastructure.handlers;

import com.thecookiezen.bussiness.boundary.Printable;
import com.thecookiezen.bussiness.boundary.Printer;
import com.thecookiezen.bussiness.boundary.TweetsStore;

public class GetUserTweets implements Printable {

    public static final String HANDLER_KEY = "";

    private final String userName;

    public GetUserTweets(String userName) {
        this.userName = userName;
    }

    @Override
    public void execute(TweetsStore store, Printer printer) {
        printer.print(store.getTweetsByUserName(userName));
    }
}
