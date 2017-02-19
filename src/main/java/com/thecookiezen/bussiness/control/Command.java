package com.thecookiezen.bussiness.control;

import java.util.Optional;

public class Command implements Request {

    private final String userName;
    private final String command;
    private final String commandParameter;

    public Command(String userName, String command, String commandParameter) {
        this.userName = userName;
        this.command = command;
        this.commandParameter = commandParameter;
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
        return Optional.of(commandParameter);
    }
}
