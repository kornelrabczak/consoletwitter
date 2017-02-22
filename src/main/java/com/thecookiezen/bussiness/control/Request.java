package com.thecookiezen.bussiness.control;

public class Request {

    private final String userName;
    private final String commandKey;
    private final String commandParameter;

    public Request(String userName, String commandKey, String commandParameter) {
        this.userName = userName;
        this.commandKey = commandKey;
        this.commandParameter = commandParameter;
    }

    public String getUserName() {
        return userName;
    }

    public String getCommandKey() {
        return commandKey;
    }

    public String getCommandParameter() {
        return commandParameter;
    }
}
