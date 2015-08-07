package com.ft.membership.spoorclient;

import org.junit.Test;

import java.util.Optional;

import static java.util.Optional.of;
import static org.assertj.core.api.StrictAssertions.assertThat;

public class SpoorParametersTest {
    @Test
    public void shouldReturnParametersAsJsonObject() {
        DefaultSpoorParameters trackingParameters = new DefaultSpoorParameters(new SpoorSystem("", "", ""), new SpoorContext("", "", "", ""), new SpoorDevice(Optional.empty(), Optional.empty(), Optional.empty()), new SpoorUser(of("session"), "passport"), "", "");

        String trackingParams = trackingParameters.getJson();

        assertThat(trackingParams).isExactlyInstanceOf(String.class);
        assertThat(trackingParams).isEqualTo("{\"system\":{\"version\":\"\",\"source\":\"\",\"api_key\":\"\"},\"context\":{\"id\":\"\",\"product\":\"\",\"url\":\"\",\"root_id\":\"\"},\"device\":{\"spoor_session\":null,\"spoor_id\":null,\"user_agent\":null},\"user\":{\"ft_session\":\"session\",\"passport_id\":\"passport\"},\"category\":\"\",\"action\":\"\"}");
    }

    @Test
    public void shouldParseJson() {
        DefaultSpoorParameters trackingParameters = new DefaultSpoorParameters(new SpoorSystem("", "", ""), new SpoorContext("", "", "", ""), new SpoorDevice(Optional.empty(), Optional.empty(), Optional.empty()), new SpoorUser(of("session"), "passport"), "", "");

        DefaultSpoorParameters parsedParameters = SpoorParameters.fromJsonString(trackingParameters.getJson(), DefaultSpoorParameters.class);

        assertThat(parsedParameters).isEqualToComparingFieldByField(trackingParameters);
    }
}
