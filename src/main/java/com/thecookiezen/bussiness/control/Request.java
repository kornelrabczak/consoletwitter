package com.thecookiezen.bussiness.control;

public class Request {

    public static final Request EMPTY_REQUEST = new Request("", "", "");

    private final String userName;
    private final String command;
    private final String additionalParameter;

    public Request(String userName, String command, String additionalParameter) {
        this.userName = userName;
        this.command = command;
        this.additionalParameter = additionalParameter;
    }

    public String getUserName() {
        return userName;
    }

    public String getCommand() {
        return command;
    }

    public String getAdditionalParameter() {
        return additionalParameter;
    }
}
