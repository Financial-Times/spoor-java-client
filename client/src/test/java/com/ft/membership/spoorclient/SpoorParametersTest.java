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
        DefaultSpoorParameters trackingParameters = new DefaultSpoorParameters(new SpoorSystem("", "", ""), new SpoorContext("", "", "", ""), new SpoorDevice(Optional.empty(), Optional.empty(), Optional.empty()), "", "");

        String trackingParams = trackingParameters.getJson();

        assertThat(trackingParams).isExactlyInstanceOf(String.class);
        assertThat(trackingParams).isEqualTo("{\"system\":{\"version\":\"\",\"source\":\"\",\"api_key\":\"\"},\"context\":{\"id\":\"\",\"product\":\"\",\"url\":\"\",\"root_id\":\"\"},\"device\":{\"spoor_session\":null,\"spoor_id\":null,\"user_agent\":null},\"category\":\"\",\"action\":\"\"}");
    }

    @Test
    public void shouldParseJson() {
        DefaultSpoorParameters trackingParameters = new DefaultSpoorParameters(new SpoorSystem("", "", ""), new SpoorContext("", "", "", ""), new SpoorDevice(Optional.empty(), Optional.empty(), Optional.empty()), "", "");

        DefaultSpoorParameters parsedParameters = SpoorParameters.fromJsonString(trackingParameters.getJson(), DefaultSpoorParameters.class);

        assertThat(parsedParameters).isEqualToComparingFieldByField(trackingParameters);
    }
}
