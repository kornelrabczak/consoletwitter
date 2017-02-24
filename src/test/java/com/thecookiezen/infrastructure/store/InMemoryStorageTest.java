package com.thecookiezen.infrastructure.store;

import com.thecookiezen.bussiness.boundary.Storage;
import com.thecookiezen.bussiness.entity.Tweet;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryStorageTest {

    private final Storage store = new InMemoryStorage();

    @Test
    public void should_print_users_tweets() {
        // given
        final Tweet bob = new Tweet("Bob", "It's my first tweet");
        store.storeTweet(bob);
        final Tweet alice = new Tweet("Alice", "I love the weather today");
        store.storeTweet(alice);
        final Tweet john = new Tweet("John", "Good game though.");
        store.storeTweet(john);

        store.follow("Bob", "Alice");
        store.follow("Bob", "John");

        // when
        final List<Tweet> bobWallTweets = store.getUserAndAllFollowingTweets("Bob");

        // then
        assertThat(bobWallTweets).contains(bob, alice, john);
    }

}