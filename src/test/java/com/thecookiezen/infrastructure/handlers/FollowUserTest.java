package com.thecookiezen.infrastructure.handlers;

import com.thecookiezen.bussiness.boundary.TweetsStore;
import com.thecookiezen.infrastructure.store.InMemoryTweets;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FollowUserTest {

    private TweetsStore store = new InMemoryTweets();

    @Test
    public void should_return_empty_list_for_no_followings() {
        // when & then
        assertThat(store.getFollowing("Bob")).isEmpty();
    }
    
    @Test
    public void should_return_all_following_users_without_duplications() {
        // when
        new FollowUser("Bob", "Alice").execute(store);
        new FollowUser("Bob", "John").execute(store);
        new FollowUser("Bob", "Mike").execute(store);
        new FollowUser("Bob", "Mike").execute(store);

        // then
        assertThat(store.getFollowing("Bob")).contains("Alice", "John", "Mike");
    }
}