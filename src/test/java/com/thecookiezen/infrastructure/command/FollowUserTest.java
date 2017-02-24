package com.thecookiezen.infrastructure.command;

import com.thecookiezen.bussiness.boundary.Storage;
import com.thecookiezen.infrastructure.store.InMemoryStorage;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FollowUserTest {

    private Storage store = new InMemoryStorage();

    @Test
    public void should_return_empty_list_for_no_followings() {
        // when & then
        assertThat(store.getFollowing("Bob")).isEmpty();
    }
    
    @Test
    public void should_return_all_following_users_without_duplications_and_himself() {
        // when
        new FollowUser("Bob", "Alice").execute(store);
        new FollowUser("Bob", "John").execute(store);
        new FollowUser("Bob", "Mike").execute(store);
        new FollowUser("Bob", "Mike").execute(store);
        new FollowUser("Bob", "Bob").execute(store);

        // then
        assertThat(store.getFollowing("Bob")).contains("Alice", "John", "Mike");
    }
}