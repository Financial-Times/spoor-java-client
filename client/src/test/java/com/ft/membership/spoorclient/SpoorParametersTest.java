package com.ft.membership.spoorclient;

import org.junit.Test;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.StrictAssertions.assertThat;

public class SpoorParametersTest {
    @Test
    public void shouldReturnParametersAsJsonObject() {
        DefaultSpoorParameters trackingParameters = new DefaultSpoorParameters(new SpoorSystem("a", "b", "c"), new SpoorContext("d", of("e"), "f", "g", empty()), new SpoorDevice(of("h"), of("i"), of("j")), new SpoorUser(of("session"), of("passport")), "k", "l");

        String trackingParams = trackingParameters.getJson();

        assertThat(trackingParams).isExactlyInstanceOf(String.class);
        assertThat(trackingParams).isEqualTo("{\"system\":{\"version\":\"b\",\"source\":\"c\",\"api_key\":\"a\"},\"context\":{\"id\":\"d\",\"product\":\"f\",\"url\":\"g\",\"root_id\":\"e\"},\"device\":{\"spoor_session\":\"h\",\"spoor_id\":\"i\",\"user_agent\":\"j\"},\"user\":{\"ft_session\":\"session\",\"passport_id\":\"passport\"},\"category\":\"k\",\"action\":\"l\"}");
    }

    @Test
    public void shouldParseJson() {
        DefaultSpoorParameters trackingParameters = new DefaultSpoorParameters(new SpoorSystem("x", "x", "x"), new SpoorContext("x", of("x"), "x", "x", empty()), new SpoorDevice(of("x"), of("x"), of("x")), new SpoorUser(of("session"), of("passport")), "x", "x");

        DefaultSpoorParameters parsedParameters = SpoorParameters.fromJsonString(trackingParameters.getJson(), DefaultSpoorParameters.class);

        assertThat(parsedParameters).isEqualToComparingFieldByField(trackingParameters);
    }
}
