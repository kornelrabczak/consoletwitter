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
        if (between.getSeconds() > 59) {
            return " (" + between.toMinutes() + " minutes ago)";
        }
        return " (" + between.getSeconds() + " seconds ago)";
    }
}
