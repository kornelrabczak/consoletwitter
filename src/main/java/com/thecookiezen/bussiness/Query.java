package com.thecookiezen.bussiness;

import java.util.Optional;

public class Query implements Request {

    private final String userName;
    private final String command;

    public Query(String userName, String command) {
        this.userName = userName;
        this.command = command;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public Optional<String> getCommandParameter() {
        return Optional.empty();
    }
}
