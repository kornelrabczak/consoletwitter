package com.thecookiezen.bussiness;

import com.thecookiezen.infrastructure.RequestFactory;
import com.thecookiezen.bussiness.control.Request;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RequestFactoryTest {

    private RequestFactory sut = new RequestFactory();

    @Test
    public void should_return_empty_request_for_empty_string() {
        // given
        String emptyRequest = "";

        // when
        final Request actual = sut.createRequestFromString(emptyRequest);

        // then
        assertThat(actual).isEqualTo(Request.EMPTY_REQUEST);
    }

    @Test
    public void should_create_query_request_for_user_tweet_list() {
        // given
        String request = "Bob";

        // when
        final Request actual = sut.createRequestFromString(request);

        // then
        assertThat(actual.getUserName()).isEqualTo("Bob");
        assertThat(actual.getCommand()).isEmpty();
        assertThat(actual.getAdditionalParameter()).isEmpty();
    }

    @Test
    public void should_create_query_request_for_user_wall() {
        // given
        String request = "Bob wall";

        // when
        final Request actual = sut.createRequestFromString(request);

        // then
        assertThat(actual.getUserName()).isEqualTo("Bob");
        assertThat(actual.getCommand()).isEqualTo("wall");
        assertThat(actual.getAdditionalParameter()).isEmpty();
    }

    @Test
    public void should_create_command_request_for_new_tweet() {
        // given
        String request = "Bob -> Some tweet";

        // when
        final Request actual = sut.createRequestFromString(request);

        // then
        assertThat(actual.getUserName()).isEqualTo("Bob");
        assertThat(actual.getCommand()).isEqualTo("->");
        assertThat(actual.getAdditionalParameter()).isEqualTo("Some tweet");
    }

    @Test
    public void should_create_command_request_for_following_user() {
        // given
        String request = "Bob follows John";

        // when
        final Request actual = sut.createRequestFromString(request);

        // then
        assertThat(actual.getUserName()).isEqualTo("Bob");
        assertThat(actual.getCommand()).isEqualTo("follows");
        assertThat(actual.getAdditionalParameter()).isEqualTo("John");
    }

}