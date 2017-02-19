package com.thecookiezen.infrastructure.handlers;

import com.thecookiezen.bussiness.boundary.TweetsStore;
import com.thecookiezen.bussiness.control.Command;
import com.thecookiezen.bussiness.control.Request;
import org.junit.Test;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateNewTweetTest {

    private final TweetsStore store = mock(TweetsStore.class);

    private CreateNewTweet sut = new CreateNewTweet(store);

    @Test
    public void should_add_new_tweet_from_request_to_storage() {
        // given
        final Request request = new Command("Alice", "->", "Some tweet message :)");

        // when
        sut.execute(request);

        // then
        verify(store, times(1)).storeTweet(anyObject());
    }
}