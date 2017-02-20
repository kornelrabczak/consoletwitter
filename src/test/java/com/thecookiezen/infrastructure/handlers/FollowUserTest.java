package com.thecookiezen.infrastructure.handlers;

import com.thecookiezen.bussiness.boundary.TweetsStore;
import com.thecookiezen.bussiness.control.Command;
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
        // given
        String userName = "Bob";

        // when
        new FollowUser(store).execute(new Command(userName, "", "Alice"));
        new FollowUser(store).execute(new Command(userName, "", "John"));
        new FollowUser(store).execute(new Command(userName, "", "Mike"));
        new FollowUser(store).execute(new Command(userName, "", "Mike"));

        // then
        assertThat(store.getFollowing(userName)).contains("Alice", "John", "Mike");
    }
}