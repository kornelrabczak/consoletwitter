package com.thecookiezen.bussiness;

import com.thecookiezen.bussiness.boundary.RequestFactory;
import com.thecookiezen.bussiness.control.Request;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RequestFactoryTest {

    private RequestFactory sut = new RequestFactory();

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_empty_request() {
        // given
        String emptyRequest = "";

        // when
        sut.createRequestFromString(emptyRequest);
    }

    @Test
    public void should_create_query_request_for_user_tweet_list() {
        // given
        String request = "Bob";

        // when
        final Request actual = sut.createRequestFromString(request);

        // then
        assertThat(actual.getUserName()).isEqualTo("Bob");
        assertThat(actual.getCommandKey()).isEmpty();
        assertThat(actual.getCommandParameter()).isEmpty();
    }

    @Test
    public void should_create_query_request_for_user_wall() {
        // given
        String request = "Bob wall";

        // when
        final Request actual = sut.createRequestFromString(request);

        // then
        assertThat(actual.getUserName()).isEqualTo("Bob");
        assertThat(actual.getCommandKey()).isEqualTo("wall");
        assertThat(actual.getCommandParameter()).isEmpty();
    }

    @Test
    public void should_create_command_request_for_new_tweet() {
        // given
        String request = "Bob -> Some tweet";

        // when
        final Request actual = sut.createRequestFromString(request);

        // then
        assertThat(actual.getUserName()).isEqualTo("Bob");
        assertThat(actual.getCommandKey()).isEqualTo("->");
        assertThat(actual.getCommandParameter()).isEqualTo("Some tweet");
    }

    @Test
    public void should_create_command_request_for_following_user() {
        // given
        String request = "Bob follows John";

        // when
        final Request actual = sut.createRequestFromString(request);

        // then
        assertThat(actual.getUserName()).isEqualTo("Bob");
        assertThat(actual.getCommandKey()).isEqualTo("follows");
        assertThat(actual.getCommandParameter()).isEqualTo("John");
    }

}