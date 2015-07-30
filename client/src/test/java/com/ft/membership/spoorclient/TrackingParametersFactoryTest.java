package com.ft.membership.spoorclient;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class TrackingParametersFactoryTest {
    @Test
    public void shouldParseParametersFromRequest() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getCookies())
                .thenReturn(
                        new Cookie[]{
                                new Cookie("FTSession", "aFTSessionCookie"),
                                new Cookie("spoor-id", "aSpoorIdCookie"),
                        }
                );

        when(request.getHeader("User-Agent")).thenReturn("aUserAgentHeader");
        when(request.getRequestURI()).thenReturn("http://appserver-not-approot/contextpath?query=param");


        TrackingParametersFactory trackingParametersFactory = new TrackingParametersFactory(
                "anApiKey",
                "https://approot.com",
                "aProduct");

        TrackingParameters trackingParameters = trackingParametersFactory.fromRequest(request, Optional.of("aRootId"));

        assertThat(trackingParameters.getAction()).isEqualTo("action???");
        assertThat(trackingParameters.getCategory()).isEqualTo("page");
        assertThat(trackingParameters.getContext().getId()).isNotEmpty();
        assertThat(trackingParameters.getContext().getProduct()).isEqualTo("aProduct");
        assertThat(trackingParameters.getContext().getRootId()).isEqualTo("aRootId");
        assertThat(trackingParameters.getContext().getUrl()).isEqualTo("https://approot.com/contextpath?query=param");
        assertThat(trackingParameters.getDevice().getSpoorId()).isEqualTo(Optional.of("aSpoorIdCookie"));
        assertThat(trackingParameters.getDevice().getSpoorSession()).isEqualTo(Optional.of("aFTSessionCookie"));
        assertThat(trackingParameters.getDevice().getUserAgent()).isEqualTo(Optional.of("aUserAgentHeader"));
    }

    @Test
    public void shouldHandleMissingValues() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getCookies()).thenReturn(new Cookie[]{});
        when(request.getRequestURI()).thenReturn("http://appserver-not-approot/contextpath?query=param");

        TrackingParametersFactory trackingParametersFactory = new TrackingParametersFactory("", "", "");

        TrackingParameters trackingParameters = trackingParametersFactory.fromRequest(request, Optional.empty());

        assertThat(trackingParameters.getContext().getId()).isNotEmpty();
        assertThat(trackingParameters.getContext().getRootId()).isNotEmpty();
        assertThat(trackingParameters.getDevice().getSpoorId()).isEqualTo(Optional.empty());
        assertThat(trackingParameters.getDevice().getSpoorSession()).isEqualTo(Optional.empty());
        assertThat(trackingParameters.getDevice().getUserAgent()).isEqualTo(Optional.empty());

    }
}