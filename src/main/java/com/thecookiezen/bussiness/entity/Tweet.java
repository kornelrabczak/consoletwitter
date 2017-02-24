package com.thecookiezen.bussiness.entity;

import java.time.Duration;
import java.time.Instant;

public class Tweet {

    private final String userName;
    private final String message;
    private final Instant createdAt = Instant.now();

    public Tweet(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return message + stringifyDuration();
    }

    private String stringifyDuration() {
        final Duration between = Duration.between(createdAt, Instant.now());
        final long seconds = between.getSeconds();
        if (seconds > 59) {
            final long minutes = between.toMinutes();
            return " (" + minutes + " minute" + ((minutes > 1) ? "s" : "") + " ago)";
        }
        return " (" + seconds + " second" + ((seconds > 1) ? "s" : "") + " ago)";
    }
}
