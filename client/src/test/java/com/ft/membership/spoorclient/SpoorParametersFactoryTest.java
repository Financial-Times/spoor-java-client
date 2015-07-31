package com.ft.membership.spoorclient;

import org.junit.Test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class SpoorParametersFactoryTest {
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
        when(request.getRequestURL()).thenReturn(new StringBuffer("http://appserver-not-approot/contextpath"));
        when(request.getQueryString()).thenReturn("query=param");


        SpoorParametersFactory trackingParametersFactory = new SpoorParametersFactory(
                "anApiKey",
                "https://approot.com",
                "aProduct");

        SpoorParameters trackingParameters = trackingParametersFactory.fromRequest(request, Optional.of("aRootId"));

        assertThat(trackingParameters.getAction()).isEqualTo("view");
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
        when(request.getRequestURL()).thenReturn(new StringBuffer("http://appserver-not-approot/contextpath"));

        SpoorParametersFactory trackingParametersFactory = new SpoorParametersFactory("", "", "");

        SpoorParameters trackingParameters = trackingParametersFactory.fromRequest(request, Optional.empty());

        assertThat(trackingParameters.getContext().getId()).isNotEmpty();
        assertThat(trackingParameters.getContext().getRootId()).isNotEmpty();
        assertThat(trackingParameters.getDevice().getSpoorId()).isEqualTo(Optional.empty());
        assertThat(trackingParameters.getDevice().getSpoorSession()).isEqualTo(Optional.empty());
        assertThat(trackingParameters.getDevice().getUserAgent()).isEqualTo(Optional.empty());

    }
}