package com.thecookiezen.bussiness.boundary;

import com.thecookiezen.bussiness.control.Request;
import com.thecookiezen.bussiness.control.Command;
import com.thecookiezen.bussiness.control.Query;

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
            return buildRequest(requestMatcher.group(USER_NAME), requestMatcher.group(COMMAND), requestMatcher.group(PARAMETER));
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
