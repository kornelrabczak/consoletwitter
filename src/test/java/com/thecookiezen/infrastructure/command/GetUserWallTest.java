package com.thecookiezen.infrastructure.command;

import com.google.common.collect.Lists;
import com.thecookiezen.bussiness.boundary.Storage;
import com.thecookiezen.bussiness.entity.Tweet;
import com.thecookiezen.infrastructure.printer.SystemOutPrinter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetUserWallTest {

    private final Storage store = mock(Storage.class);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void should_print_user_wall() {
        // given
        when(store.getUserAndAllFollowingTweets("Bob")).thenReturn(Lists.newArrayList(
                new Tweet("Bob", "It's my first tweet"),
                new Tweet("Alice", "I love the weather today"),
                new Tweet("John", "Good game though.")
        ));

        // when
        new GetUserWall("Bob").execute(store, new SystemOutPrinter());

        // then
        assertThat(outContent.toString()).contains("Bob - It's my first tweet (0 second ago)",
                "Alice - I love the weather today (0 second ago)", "John - Good game though. (0 second ago)");
    }

}