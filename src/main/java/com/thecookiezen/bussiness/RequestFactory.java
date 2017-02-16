package com.thecookiezen.bussiness;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestFactory {

    private static final String USER_NAME = "userName";
    private static final String COMMAND = "command";
    private static final String PARAMETER = "parameter";
    private static final Pattern REQUEST_PATTERN = Pattern.compile("^(?<" + USER_NAME + ">\\w+)\\s?(?<" + COMMAND +
            ">\\S*)\\s?(?<" + PARAMETER + ">.*)$");

    public Request createRequestFromString(String requestStringify) {
        final Matcher requestMatcher = REQUEST_PATTERN.matcher(requestStringify);
        if (requestMatcher.find()) {
            final String userName = requestMatcher.group(USER_NAME);
            final String command = requestMatcher.group(COMMAND);
            final String commandParameter = requestMatcher.group(PARAMETER);

            return buildRequest(userName, command, commandParameter);
        }
        throw new IllegalArgumentException("CHANGE ME!");
    }

    private Request buildRequest(String userName, String command, String commandParameter) {
        if (commandParameter.isEmpty()) {
            return new Query(userName, command);
        }
        return new Command(userName, command, commandParameter);
    }
}
