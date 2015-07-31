package com.ft.membership.spoorclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpoorParametersTest {
    @Test
    public void shouldReturnParametersAsJsonObject() {
        SpoorParameters trackingParameters = new SpoorParameters(new SpoorSystem("", "", ""), new SpoorContext("", "", "", ""), new SpoorDevice(Optional.empty(), Optional.empty(), Optional.empty()), "", "");

        String trackingParams = trackingParameters.toJSON();

        assertThat(trackingParams).isExactlyInstanceOf(String.class);
        assertThat(trackingParams).isEqualTo("{\"system\":{\"apiKey\":\"\",\"version\":\"\",\"source\":\"\"},\"context\":{\"id\":\"\",\"rootId\":\"\",\"product\":\"\",\"url\":\"\"},\"device\":{\"spoorSession\":null,\"spoorId\":null,\"userAgent\":null},\"category\":\"\",\"action\":\"\"}");
    }
}
